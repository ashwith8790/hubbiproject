package com.hubster.model;

import java.util.List;

public class ReassignInitiativeModel {
	
	private String assignoto;
	public String getAssignoto() {
		return assignoto;
	}
	public void setAssignoto(String assignoto) {
		this.assignoto = assignoto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int id;
	public List<ReassignInitiativeModel> getGetreassign() {
		return getreassign;
	}
	public void setGetreassign(List<ReassignInitiativeModel> getreassign) {
		this.getreassign = getreassign;
	}
	private List<ReassignInitiativeModel> getreassign;


}
