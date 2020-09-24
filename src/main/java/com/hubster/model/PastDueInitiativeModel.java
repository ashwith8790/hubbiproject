package com.hubster.model;

import java.util.List;

public class PastDueInitiativeModel {

	private String currentdate;
//	@Override
//	public String toString() {
//		return " " + id + "." + initiative + "";
//	}

	private int id;
	private String initiative;

	public List<PastDueInitiativeModel> getGetinitiatives() {
		return getinitiatives;
	}

	public void setGetinitiatives(List<PastDueInitiativeModel> getinitiatives) {
		this.getinitiatives = getinitiatives;
	}

	private List<PastDueInitiativeModel> getinitiatives;

	public String getCurrentdate() {
		return currentdate;
	}

	public void setCurrentdate(String currentdate) {
		this.currentdate = currentdate;
	}

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

}
