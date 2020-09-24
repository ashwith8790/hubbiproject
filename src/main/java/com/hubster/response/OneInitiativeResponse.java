package com.hubster.response;

import java.util.List;

import com.hubster.model.OneInitiativeModel;


public class OneInitiativeResponse {
	
	
	public List<OneInitiativeModel> getGetInitiative() {
		return getInitiative;
	}
	public void setGetInitiative(List<OneInitiativeModel> getInitiative) {
		this.getInitiative = getInitiative;
	}
	private List<OneInitiativeModel> getInitiative;



}
