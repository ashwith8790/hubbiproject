package com.hubster.response;

import java.util.List;

import com.hubster.model.LoginModel;

public class LoginResponse {
	
	private String loginsucess;
	private String loginfail;
	public List<LoginModel> getGetloginmodel() {
		return getloginmodel;
	}
	public void setGetloginmodel(List<LoginModel> getloginmodel) {
		this.getloginmodel = getloginmodel;
	}
	private List<LoginModel> getloginmodel;
	
	public String getLoginsucess() {
		return loginsucess;
	}
	public void setLoginsucess(String loginsucess) {
		this.loginsucess = loginsucess;
	}
	public String getLoginfail() {
		return loginfail;
	}
	public void setLoginfail(String loginfail) {
		this.loginfail = loginfail;
	}

}
