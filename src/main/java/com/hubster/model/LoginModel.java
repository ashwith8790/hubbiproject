package com.hubster.model;

import java.util.List;

public class LoginModel {
	
	@Override
	public String toString() {
		return "" + login + "," + pswd + "," + login_id + "";
	}
	private String login;
	private String pswd;
	private int login_id;

	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	
	public List<LoginModel> getGetlogin() {
		return getlogin;
	}
	public void setGetlogin(List<LoginModel> getlogin) {
		this.getlogin = getlogin;
	}
	private   List<LoginModel> getlogin;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	

}
