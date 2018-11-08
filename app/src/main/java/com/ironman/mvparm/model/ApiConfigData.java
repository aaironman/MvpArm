package com.ironman.mvparm.model;


public class ApiConfigData {

	private String version;

	private AppConfigModel config;

	private AppLayoutModel layout;

	public AppLayoutModel getLayout() {
		return layout;
	}

	public void setLayout(AppLayoutModel layout) {
		this.layout = layout;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public AppConfigModel getConfig() {
		return config;
	}

	public void setConfig(AppConfigModel config) {
		this.config = config;
	}
}
