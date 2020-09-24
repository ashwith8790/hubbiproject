package com.hubster.model;

import java.util.List;

public class ThirdInitiativeModel {
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInitiative() {
		return initiative;
	}
	public void setInitiative(String initiative) {
		this.initiative = initiative;
	}
	public List<ThirdInitiativeModel> getGetinitiatives() {
		return getinitiatives;
	}
	public void setGetinitiatives(List<ThirdInitiativeModel> getinitiatives) {
		this.getinitiatives = getinitiatives;
	}
	private int id;
	private String initiative;
	private List<ThirdInitiativeModel> getinitiatives;


}
