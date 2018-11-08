package com.ironman.mvparm;

import com.ironman.mvparm.model.AppConfigResultModel;
import com.ironman.mvparm.mvp.presenters.MvpRxPresenter;
import com.ironman.mvparm.net.ExceptionHandle;
import com.ironman.mvparm.utils.L;
import com.ironman.mvparm.utils.RxUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 作者: miaocong
 * 时间: 2018/11/7
 * 描述:
 */
public class MainPresenter extends MvpRxPresenter<MainView> {

	public void getData(){
		getView().showProgress("加载中...");
		 RxUtils.toObservable(mApi.getConfig("1.0")).subscribe(new Observer<AppConfigResultModel>() {
			 @Override
			 public void onSubscribe(Disposable d) {
				 addSubscription(d);
			 }

			 @Override
			 public void onNext(AppConfigResultModel appConfigResultModel) {
			 	if (appConfigResultModel.getResultCode() == 0){
			 		getView().getAPIError(appConfigResultModel.getMsg());
				}else {
					getView().getConfigSuccess(appConfigResultModel);
				}

			 }

			 @Override
			 public void onError(Throwable e) {
				 ExceptionHandle.ResponeThrowable responseThrowable = ExceptionHandle.handleException(e);
				 L.v("mickey","---onError:" + responseThrowable.code);
				 getView().getConfigError(responseThrowable.code,e.toString());
				getView().hideProgress();
			 }

			 @Override
			 public void onComplete() {
				 getView().hideProgress();
			 }
		 });
	}
}
