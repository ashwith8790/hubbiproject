package com.hubster.model;

import java.util.List;

public class OneInitiativeModel {

	public int id;
	private String initiative;


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


	public List<OneInitiativeModel> getOneinitiative() {
		return oneinitiative;
	}

	public void setOneinitiative(List<OneInitiativeModel> oneinitiative) {
		this.oneinitiative = oneinitiative;
	}


	private List<OneInitiativeModel> oneinitiative;

	
	
}
