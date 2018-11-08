package com.ironman.mvparm.net;

import com.google.gson.annotations.SerializedName;

/**
 * 作者: miaocong
 * 时间: 2018/11/6
 * 描述:
 */
public class BaseResponse<T> {
	@SerializedName("ret")
	private int resultCode;
	private String msg;
	private T data;


	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
}
