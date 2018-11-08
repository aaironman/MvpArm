package com.ironman.mvparm.utils;


import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;


public class RxBus {

	private static final String TAG = RxBus.class.getSimpleName();

	private static volatile RxBus defaultInstance;

	private Subject<Object> rxBus;

	private RxBus() {
		rxBus = PublishSubject.create().toSerialized();
	}

	public static synchronized RxBus getInstance() {
		if (defaultInstance == null) {
			synchronized (RxBus.class) {
				if (defaultInstance == null) {
					defaultInstance = new RxBus();
				}
			}
		}
		return defaultInstance;
	}

	/**
	 * 将数据添加到订阅
	 * 这个地方是再添加订阅的地方。最好创建一个新的类用于数据的传递
	 */
	public void postEvent(@NonNull Object event) {
		if (this.hasObservers()) {//判断当前是否已经添加订阅
			rxBus.onNext(event);
		}
	}

	private boolean hasObservers() {
		return rxBus.hasObservers();
	}

	/**这个是传递集合如果有需要的话你也可以进行更改*/
	public void post(@NonNull List<Object> obj) {
		if (rxBus.hasObservers()) {//判断当前是否已经添加订阅
			rxBus.onNext(obj);
		}
	}
	/**
	 * 注册，传递tClass的时候最好创建一个封装的类。这对数据的传递作用
	 *新更改仅仅抛出生成类和解析
	 */
	public <T> Disposable register(Class<T> tClass, Consumer<T> consumer) {
		return rxBus.ofType(tClass)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(consumer);
	}

	/**
	 * 保存订阅后的disposable
	 * @param o
	 * @param disposable
	 */
	private HashMap<String, CompositeDisposable> mSubscriptionMap;
	public void addSubscription(Object o, Disposable disposable) {
		if (mSubscriptionMap == null) {
			mSubscriptionMap = new HashMap<>();
		}
		String key = o.getClass().getName();
		if (mSubscriptionMap.get(key) != null) {
			mSubscriptionMap.get(key).add(disposable);
		} else {
			//一次性容器,可以持有多个并提供 添加和移除。
			CompositeDisposable disposables = new CompositeDisposable();
			disposables.add(disposable);
			mSubscriptionMap.put(key, disposables);
		}
	}

	/**
	 * 取消订阅
	 * @param o 这个是你添加到订阅的的对象
	 */
	public void unSubscribe(Object o) {
		if (mSubscriptionMap == null) {
			return;
		}

		String key = o.getClass().getName();
		if (!mSubscriptionMap.containsKey(key)){
			return;
		}
		if (mSubscriptionMap.get(key) != null) {
			mSubscriptionMap.get(key).dispose();
		}

		mSubscriptionMap.remove(key);
	}

}
