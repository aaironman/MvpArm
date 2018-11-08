package com.ironman.mvparm;

import com.ironman.mvparm.model.AppConfigResultModel;
import com.ironman.mvparm.mvp.views.MvpView;

/**
 * 作者: miaocong
 * 时间: 2018/11/7
 * 描述:
 */
public interface MainView extends MvpView {

	void getConfigSuccess(AppConfigResultModel appConfigResultModel);

	void getAPIError(String msg);

	void getConfigError(int code, String msg);

	void showProgress(String msg);

	void hideProgress();

}
