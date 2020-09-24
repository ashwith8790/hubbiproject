package com.hubster.response;

import java.util.List;

import com.hubster.model.InitiativeModel;

public class InitiativeResponse {
	
	public List<InitiativeModel> getGetinitiative() {
		return getinitiative;
	}

	public void setGetinitiative(List<InitiativeModel> getinitiative) {
		this.getinitiative = getinitiative;
	}

	private List<InitiativeModel> getinitiative;

}
