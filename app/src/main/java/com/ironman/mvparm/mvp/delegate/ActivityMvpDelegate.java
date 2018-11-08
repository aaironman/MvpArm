package com.ironman.mvparm.mvp.delegate;

import android.os.Bundle;

import com.ironman.mvparm.mvp.presenters.MvpPresenter;
import com.ironman.mvparm.mvp.views.MvpView;


public interface ActivityMvpDelegate<V extends MvpView, P extends MvpPresenter<V>> {


    void onCreate(Bundle bundle);


    void onDestroy();


    void onPause();


    void onResume();


    void onStart();


    void onStop();


    void onRestart();

}
