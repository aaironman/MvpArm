package com.ironman.mvparm.model;

import java.util.Map;

/**
 * 作者: miaocong
 * 时间: 2018/11/7
 * 描述:
 */
public class AppConfigModel {
	/**
	 * 产品类型
	 */
	private Map<String, String> loan_status;
	/***
	 * 好分期贷款类型
	 */
	private Map<String,String> channel_loan_status;
	/**
	 * 居住时长
	 */
	private Map<String, String> user_info_stay_months;
	/**
	 * 联系人关系1
	 */
	private Map<String, String> user_info_linkman1_type;
	/**
	 * 联系人关系2
	 */
	private Map<String, String> user_info_linkman2_type;
	/**
	 * 婚姻状态
	 */
	private Map<String, String> user_info_is_marry;
	/**
	 * 是否有信用卡
	 */
	private Map<String, String> user_info_has_credit;
	/**
	 * 户口类型
	 */
	private Map<String, String> user_info_account_type;
	/**
	 * 居住方式
	 */
	private Map<String, String> user_info_home_type;


	public Map<String, String> getLoan_status() {
		return loan_status;
	}

	public void setLoan_status(Map<String, String> loan_status) {
		this.loan_status = loan_status;
	}


	public Map<String, String> getUser_info_stay_months() {
		return user_info_stay_months;
	}

	public void setUser_info_stay_months(Map<String, String> user_info_stay_months) {
		this.user_info_stay_months = user_info_stay_months;
	}

	public Map<String, String> getUser_info_linkman1_type() {
		return user_info_linkman1_type;
	}

	public void setUser_info_linkman1_type(Map<String, String> user_info_linkman1_type) {
		this.user_info_linkman1_type = user_info_linkman1_type;
	}

	public Map<String, String> getUser_info_linkman2_type() {
		return user_info_linkman2_type;
	}

	public void setUser_info_linkman2_type(Map<String, String> user_info_linkman2_type) {
		this.user_info_linkman2_type = user_info_linkman2_type;
	}

	public Map<String, String> getUser_info_is_marry() {
		return user_info_is_marry;
	}

	public void setUser_info_is_marry(Map<String, String> user_info_is_marry) {
		this.user_info_is_marry = user_info_is_marry;
	}

	public Map<String, String> getUser_info_has_credit() {
		return user_info_has_credit;
	}

	public void setUser_info_has_credit(Map<String, String> user_info_has_credit) {
		this.user_info_has_credit = user_info_has_credit;
	}

	public Map<String, String> getUser_info_account_type() {
		return user_info_account_type;
	}

	public void setUser_info_account_type(Map<String, String> user_info_account_type) {
		this.user_info_account_type = user_info_account_type;
	}

	public Map<String, String> getUser_info_home_type() {
		return user_info_home_type;
	}

	public void setUser_info_home_type(Map<String, String> user_info_home_type) {
		this.user_info_home_type = user_info_home_type;
	}

	public Map<String, String> getChannel_loan_status() {
		return channel_loan_status;
	}

	public void setChannel_loan_status(Map<String, String> channel_loan_status) {
		this.channel_loan_status = channel_loan_status;
	}

}
