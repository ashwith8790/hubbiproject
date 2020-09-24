package com.hubster.model;

import java.util.List;

public class SecondInitiativeModel {

	private int id;
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
	public List<SecondInitiativeModel> getGetinitiatives() {
		return getinitiatives;
	}
	public void setGetinitiatives(List<SecondInitiativeModel> getinitiatives) {
		this.getinitiatives = getinitiatives;
	}
	private String initiative;
	private List<SecondInitiativeModel> getinitiatives;

	
}
