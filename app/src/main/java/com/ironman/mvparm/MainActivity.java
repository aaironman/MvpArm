package com.ironman.mvparm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ironman.mvparm.model.AppConfigResultModel;
import com.ironman.mvparm.mvp.MvpActivity;
import com.ironman.mvparm.utils.T;
import com.ironman.mvparm.utils.UIUtils;
import com.ironman.mvparm.widget.MultiStateView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView {

	@BindView(R.id.btn_get_data)
	Button btnGetData;
	@BindView(R.id.tv_content)
	TextView tvContent;
	@BindView(R.id.mv_state)
	MultiStateView mvState;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
	}

	@OnClick({R.id.btn_get_data})
	public void onClick(View view){
		switch (view.getId()){
			case R.id.btn_get_data:
				presenter.getData();
				break;
		}
	}

	@NonNull
	@Override
	public MainPresenter createPresenter() {
		return new MainPresenter();
	}

	@Override
	public void getConfigSuccess(AppConfigResultModel appConfigResultModel) {

	}

	@Override
	public void getAPIError(String msg) {
		T.showShort(this, msg);
	}

	@Override
	public void getConfigError(int code, String msg) {
		UIUtils.handleErrorLayout(mvState,code,msg);
	}


	@Override
	public void showProgress(String msg) {
		getProgressDialog().show();
	}

	@Override
	public void hideProgress() {
		getProgressDialog().dismiss();
	}
}
