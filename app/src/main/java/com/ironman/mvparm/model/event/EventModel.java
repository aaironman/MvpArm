package com.ironman.mvparm.model.event;

/**
 * 描述: RxBus
 */
public class EventModel {
	
	/**
	 * 退出app
	 */
	public static final String EVENT_EXIT_APP="event_exit_app";
	/**
	 * 登录成功
	 */
	public static final String EVENT_LOGIN_SUCCESS = "event_login_success";
	/**
	 * 注册成功
	 */
	public static final String EVENT_REGISTER_SUCCESS = "event_register_success";

	/**
	 * 退出登录
	 */
	public static final String EVENT_LOGOUT = "event_logout";

	private String event;

	private String flag;
	
	public EventModel(String event) {
		this.event = event;
	}
	
	public String getEvent() {
		return event;
	}
	
	public void setEvent(String event) {
		this.event = event;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
