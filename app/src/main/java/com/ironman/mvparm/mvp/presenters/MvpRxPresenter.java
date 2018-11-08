package com.ironman.mvparm.mvp.presenters;

import android.support.annotation.NonNull;

import com.ironman.mvparm.mvp.views.MvpView;
import com.ironman.mvparm.net.ApiFactory;
import com.ironman.mvparm.net.HttpApi;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


public abstract class MvpRxPresenter<V extends MvpView> implements MvpPresenter<V> {


	public static final HttpApi mApi = ApiFactory.getHttpApiSingleton();

	private CompositeDisposable mCompositeDisposable;

	private V view;

	@Override
	public void attachView(V view) {
		this.view = view;
	}

	public void addSubscription(Disposable s) {
		if (this.mCompositeDisposable == null) {
			this.mCompositeDisposable = new CompositeDisposable();
		}
		this.mCompositeDisposable.add(s);
	}

	@NonNull
	public V getView() {
		return view;
	}

	@Override
	public void detachView() {
		if (this.mCompositeDisposable != null) {
			this.mCompositeDisposable.dispose();
		}
	}
	
	
	
}
