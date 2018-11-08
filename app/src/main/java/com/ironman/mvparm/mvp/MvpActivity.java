package com.ironman.mvparm.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.ironman.mvparm.mvp.delegate.ActivityMvpDelegate;
import com.ironman.mvparm.mvp.delegate.ActivityMvpDelegateImpl;
import com.ironman.mvparm.mvp.delegate.MvpDelegateCallback;
import com.ironman.mvparm.mvp.presenters.MvpPresenter;
import com.ironman.mvparm.mvp.views.MvpView;
import com.ironman.mvparm.ui.activity.BaseActivity;


/**
 * Description:mvp activity基类
 */
public abstract class MvpActivity<V extends MvpView, P extends MvpPresenter<V>>
        extends BaseActivity implements MvpDelegateCallback<V, P> {

    protected ActivityMvpDelegate mvpDelegate;
    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getMvpDelegate().onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        getMvpDelegate().onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getMvpDelegate().onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getMvpDelegate().onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        getMvpDelegate().onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getMvpDelegate().onRestart();
    }


    @NonNull
    public abstract P createPresenter();


    @NonNull
    protected ActivityMvpDelegate<V, P> getMvpDelegate() {
        if (mvpDelegate == null) {
            mvpDelegate = new ActivityMvpDelegateImpl(this);
        }

        return mvpDelegate;
    }

    @NonNull
    @Override
    public P getPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(@NonNull P presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public V getMvpView() {
        return (V) this;
    }

}
