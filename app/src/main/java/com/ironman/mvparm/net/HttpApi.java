package com.ironman.mvparm.net;


import com.ironman.mvparm.model.AppConfigResultModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 作者: miaocong
 * 时间: 2018/11/5
 * 描述:
 */
public interface HttpApi {

	/**
	 * 获取选项配置信息
	 *
	 * @return
	 */
	@FormUrlEncoded
	@POST("api/api/layout")
	Observable<AppConfigResultModel> getConfig(@Field("version") String version);
}
