package com.hubster.model;

import java.util.List;

public class HubbiGoals {
	
	@Override
	public String toString() {
		return "HubbiGoals [user_goal_id=" + user_goal_id + ", cgoalgroup=" + cgoalgroup + "]";
	}
	private String user_goal_id;
	private String cgoalgroup;
	private String ccreatedby;
	private String cstatus;
	private int cgoal_id;
	private String cgoals;
	private List<HubbiGoals> hgmodel;


	public String getUser_goal_id() {
		return user_goal_id;
	}
	public void setUser_goal_id(String user_goal_id) {
		this.user_goal_id = user_goal_id;
	}
	public String getCgoalgroup() {
		return cgoalgroup;
	}
	public void setCgoalgroup(String cgoalgroup) {
		this.cgoalgroup = cgoalgroup;
	}
	public String getCcreatedby() {
		return ccreatedby;
	}
	public void setCcreatedby(String ccreatedby) {
		this.ccreatedby = ccreatedby;
	}
	public String getCstatus() {
		return cstatus;
	}
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}
	public int getCgoal_id() {
		return cgoal_id;
	}
	public void setCgoal_id(int cgoal_id) {
		this.cgoal_id = cgoal_id;
	}
	public List<HubbiGoals> getHgmodel() {
		return hgmodel;
	}
	public void setHgmodel(List<HubbiGoals> hgmodel) {
		this.hgmodel = hgmodel;
	}
	public String getCgoals() {
		return cgoals;
	}
	public void setCgoals(String cgoals) {
		this.cgoals = cgoals;
	}
	
	
	

}
