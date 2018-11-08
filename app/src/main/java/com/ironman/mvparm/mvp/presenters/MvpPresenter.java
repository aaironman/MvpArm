package com.ironman.mvparm.mvp.presenters;


import com.ironman.mvparm.mvp.views.MvpView;

/**
 * Description:MVP 中Presenter的基本接口
 *
 */
public interface MvpPresenter<V extends MvpView> {

    /**
     * 绑定View到Presenter
     */
    void attachView(V view);

    /**
     * 解绑View
     */
    void detachView();

}
