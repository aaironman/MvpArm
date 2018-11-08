package com.ironman.mvparm.ui.fragment;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ironman.mvparm.utils.SystemBarHelper;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseFragment extends Fragment {

	private CompositeDisposable mCompositeDisposable;
	protected ProgressDialog pg = null;


	public void addSubscription(Disposable s) {
		if (this.mCompositeDisposable == null) {
			this.mCompositeDisposable = new CompositeDisposable();
		}

		this.mCompositeDisposable.add(s);
	}


	public void initToolbar(Toolbar toolbar, boolean isShowBackIcon) {
		AppCompatActivity mAppCompatActivity = (AppCompatActivity) getActivity();
		mAppCompatActivity.setSupportActionBar(toolbar);
		ActionBar actionBar = mAppCompatActivity.getSupportActionBar();
		if (actionBar != null) {
			actionBar.setDisplayShowTitleEnabled(false);
			actionBar.setDisplayHomeAsUpEnabled(isShowBackIcon);
		}
	}
	
	protected void initTopBar(){
		SystemBarHelper.setTranslucentForImageViewInFragment(getActivity(), 0, null);
	}
	
	protected void initTopBar(View topBar) {
		SystemBarHelper.setTranslucentForImageViewInFragment(getActivity(), 0, topBar);
	}

	public ProgressDialog getProgressDialog() {
		if (pg == null) {
			pg = new ProgressDialog(getContext());
		}
		return pg;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		if (this.mCompositeDisposable != null) {
			this.mCompositeDisposable.dispose();
		}
	}

}
