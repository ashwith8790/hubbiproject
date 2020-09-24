package com.hubster.model;

public class ReassignLoginModel {
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "ReassignLoginModel [loginid=" + loginid + ", login=" + login + ", password=" + password + "]";
	}


	private int loginid;
	private String login;
	private String password;

	public int getLoginid() {
		return loginid;
	}
	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}
	

}
