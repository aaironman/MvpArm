package com.ironman.mvparm.mvp.delegate;


import android.support.annotation.NonNull;

import com.ironman.mvparm.mvp.presenters.MvpPresenter;
import com.ironman.mvparm.mvp.views.MvpView;


public interface MvpDelegateCallback<V extends MvpView, P extends MvpPresenter<V>> {

    /**
     * 创建 Presenter
     */
    @NonNull
    public P createPresenter();

    /**
     * 返回MVP Presenter
     */
    public P getPresenter();

    /**
     * 设置 Presenter
     */
    public void setPresenter(P presenter);

    /**
     * 返回MVP 中的View
     */
    public V getMvpView();


}
