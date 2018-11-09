package com.ironman.mvparm.utils;


import com.ironman.mvparm.net.BaseResponse;
import com.ironman.mvparm.net.ExceptionHandle;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者: miaocong
 * 时间: 2017/9/29
 * 描述: rxJava 工具类
 */
public class RxUtils {

	private static ErrorTransformer transformer = new ErrorTransformer();

	//处理错误的变换
	private static class ErrorTransformer<T> implements ObservableTransformer {

		@Override
		public ObservableSource apply(Observable upstream) {
			//onErrorResumeNext当发生错误的时候，由另外一个Observable来代替当前的Observable并继续发射数据
//			return (Observable<T>) upstream.map(new HandleFuc<T>()).onErrorResumeNext(new HttpResponseFunc<T>());
//			return (Observable<T>) upstream.onErrorResumeNext(new HttpResponseFunc<T>());
			return (Observable<T>) upstream.map(new HandleFuc()).onErrorResumeNext(new HttpResponseFunc<T>());
		}
	}

	public static class HttpResponseFunc<T> implements Function<Throwable, Observable<T>> {
		@Override
		public Observable<T> apply(Throwable throwable) throws Exception {
//			return Observable.error(ExceptionHandle.handleException(throwable));
			return Observable.error(throwable);
		}
	}

//	public static class HandleFuc<T> implements Function<BaseResponse<T>, T> {
//		@Override
//		public T apply(BaseResponse<T> response) throws Exception {
//			//response中code码为0 出现错误
//			if (response.getResultCode() == 0)
//				throw new ExceptionHandle.ServerException(response.getResultCode(),response.getMsg());
//			return response.getData();
//		}
//	}

//	public static class HandleFuc<T> implements Function<BaseResponse<T>, BaseResponse<T>> {
//
//		@Override
//		public BaseResponse<T> apply(BaseResponse<T> tBaseResponse) throws Exception {
//			if (tBaseResponse.getResultCode() == 0){
//				throw new ExceptionHandle.ServerException(tBaseResponse.getResultCode(),tBaseResponse.getMsg());
//			}
//			return tBaseResponse;
//		}
//	}

	public static class HandleFuc implements Function<BaseResponse<T>, BaseResponse<T>> {

		@Override
		public BaseResponse<T> apply(BaseResponse<T> tBaseResponse) throws Exception {
			if (tBaseResponse.getResultCode() == 0){//这里只是个举例，code可能是其他错误码，例如会话过期需要重新登录，抛出异常,在异常处理中可以清除用户登录信息等
				throw new ExceptionHandle.ServerException(tBaseResponse.getResultCode(),tBaseResponse.getMsg());
			}
			return tBaseResponse;
		}
	}

	/**
	 * 封装Observable 1.observable错误处理  2.线程调度
	 * @param observable observable
	 * @param <T> HttpResult
	 * @return 返回 Observable
	 */
	public static <T> Observable<T> toObservable(Observable<T> observable) {
		return observable.compose(transformer)
				.compose(applySchedulers());
	}

	/**
	 * 线程调度
	 * @param <T>
	 * @return
	 */
	public static  <T> ObservableTransformer<T, T> applySchedulers() {
		return observable -> observable.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread());
	}

}
