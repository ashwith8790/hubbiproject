package com.hubster.model;

import java.util.List;

public class InitiativeModel {

	@Override
	public String toString() {
		return " [" + id + "." + initiative + "]";
	}

	private int id;
	private String initiative;
	public List<InitiativeModel> getGetinitiative() {
		return getinitiative;
	}

	public void setGetinitiative(List<InitiativeModel> getinitiative) {
		this.getinitiative = getinitiative;
	}

	private List<InitiativeModel> getinitiative;

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
