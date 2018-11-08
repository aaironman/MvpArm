package com.ironman.mvparm.mvp.delegate;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ironman.mvparm.mvp.presenters.MvpPresenter;
import com.ironman.mvparm.mvp.views.MvpView;


/**
 * Created by 冯浩 on 2016/12/6.
 */
public interface FragmentMvpDelegate<V extends MvpView, P extends MvpPresenter<V>> {

    public void onCreate(Bundle saved);


    public void onDestroy();


    public void onViewCreated(View view, @Nullable Bundle savedInstanceState);


    public void onDestroyView();


    public void onPause();


    public void onResume();


    public void onStart();


    public void onStop();


    public void onActivityCreated(Bundle savedInstanceState);


    public void onAttach(Context context);


    public void onDetach();


}
