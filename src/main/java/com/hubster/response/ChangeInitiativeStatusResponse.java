package com.hubster.response;

import java.util.List;

import com.hubster.model.ChangeInitiativeStatusModel;

public class ChangeInitiativeStatusResponse {
	

	public List<ChangeInitiativeStatusModel> getGetchange() {
		return getchange;
	}

	public void setGetchange(List<ChangeInitiativeStatusModel> getchange) {
		this.getchange = getchange;
	}

	private List<ChangeInitiativeStatusModel> getchange;

}
