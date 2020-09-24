package com.hubster.response;

import java.util.List;

import com.hubster.model.PastDueInitiativeModel;

public class PastDueInitiativeResponse {

	public List<PastDueInitiativeModel> getGetinitiatives() {
		return getinitiatives;
	}

	public void setGetinitiatives(List<PastDueInitiativeModel> getinitiatives) {
		this.getinitiatives = getinitiatives;
	}

	private List<PastDueInitiativeModel> getinitiatives;

}
