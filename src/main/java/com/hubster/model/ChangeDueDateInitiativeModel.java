package com.hubster.model;

import java.util.List;

public class ChangeDueDateInitiativeModel {
	
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<ChangeDueDateInitiativeModel> getGetchangeDate() {
		return getchangeDate;
	}
	public void setGetchangeDate(List<ChangeDueDateInitiativeModel> getchangeDate) {
		this.getchangeDate = getchangeDate;
	}
	private String duedate;
	private int id;
	private List<ChangeDueDateInitiativeModel> getchangeDate;


}
