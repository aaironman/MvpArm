package com.ironman.mvparm.net;

/**
 * 作者: miaocong
 * 时间: 2018/11/5
 * 描述:
 */
public class ApiFactory {

	private static final String TAG = "ApiFactory";

	protected static final Object o = new Object();
	public static HttpApi sHttpApiSingleton = null;


	public static HttpApi getHttpApiSingleton() {
		synchronized (o) {
			if (sHttpApiSingleton == null) {
				sHttpApiSingleton = new ApiRetrofit().getHttpApi();
			}
			return sHttpApiSingleton;
		}
	}
}
