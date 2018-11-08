package com.ironman.mvparm.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.ironman.mvparm.BuildConfig;
import com.ironman.mvparm.Constant;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者: miaocong
 * 时间: 2018/11/5
 * 描述:
 */
public class ApiRetrofit {

	private static final String TAG = "ApiRetrofit";

	private static final int CONNECT_TIMEOUT = 20;
	private static final int WRITE_TIMEOUT = 60;
	private static final int READ_TIMEOUT = 60;
	private static final String FORMAT = "json";

	HttpApi httpApi;

	public ApiRetrofit() {

		/**
		 * 配置api统一上传请求参数
		 */
//		Interceptor mInterceptor = chain -> {
//
//			Request originalRequest = chain.request();
//
//			String ssid = PreferencesUtils.getString(MyApplication.getInstance().getApplicationContext(),
//					Constant
//							.AppConfigInfo.SSID);
//
//			if (!TextUtils.isEmpty(ssid)) {
//
//				HttpUrl originalHttpUrl = originalRequest.url();
//				HttpUrl newHttpUrl = originalHttpUrl.newBuilder()
//						.setQueryParameter("ssid", ssid)
//						.setQueryParameter("format", FORMAT)
//						.setQueryParameter("client", StringUtils.getClient(MyApplication.getInstance()))
//						.build();
//
//				Request newRequest = originalRequest.newBuilder()
//						.url(newHttpUrl)
//						.build();
//
//				Response newResponse = chain.proceed(newRequest);
//
//				return newResponse;
//			} else {
//				HttpUrl originalHttpUrl = originalRequest.url();
//				HttpUrl newHttpUrl = originalHttpUrl.newBuilder()
//						.setQueryParameter("format", FORMAT)
//						.setQueryParameter("client", StringUtils.getClient(MyApplication.getInstance()))
//						.build();
//
//				Request newRequest = originalRequest.newBuilder()
//						.url(newHttpUrl)
//						.build();
//
//				Response newResponse = chain.proceed(newRequest);
//
//				return newResponse;
//			}
//		};

		/**
		 * http log 打印
		 */
		HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
		if (BuildConfig.DEBUG) {
			logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		} else {
			logInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
		}

		OkHttpClient client = new OkHttpClient.Builder()
//				.addInterceptor(mInterceptor)
				.addInterceptor(logInterceptor)
				.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
				.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
				.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
				.build();

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(Constant.BASEURL)
				.client(client)
				.addConverterFactory(GsonConverterFactory.create(getGson()))
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.build();

		httpApi = retrofit.create(HttpApi.class);
	}

	public HttpApi getHttpApi() {
		return httpApi;
	}



	public Gson getGson() {
		return new GsonBuilder()
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//				.serializeNulls()
				.registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory())
				.create();
	}

	public static class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {
		public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {

			Class<T> rawType = (Class<T>) type.getRawType();
			if (rawType != String.class) {
				return null;
			}
			return (TypeAdapter<T>) new StringAdapter();
		}
	}

	public static class StringAdapter extends TypeAdapter<String> {
		public String read(JsonReader reader) throws IOException {

			if (reader.peek() == JsonToken.NULL) {
				reader.nextNull();
				return "";
			}
			return reader.nextString();
		}

		public void write(JsonWriter writer, String value) throws IOException {
			if (value == null) {
				writer.nullValue();
				return;
			}
			writer.value(value);
		}
	}

}
