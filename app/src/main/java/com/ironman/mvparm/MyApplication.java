package com.ironman.mvparm;

import android.support.multidex.MultiDexApplication;

/**
 * 作者: miaocong
 * 时间: 2018/11/5
 * 描述:
 */
public class MyApplication extends MultiDexApplication {

	private static final String TAG = "MyApplication";
	private static MyApplication instance = null;

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
	}

	public static synchronized MyApplication getInstance() {
		return instance;
	}

}
