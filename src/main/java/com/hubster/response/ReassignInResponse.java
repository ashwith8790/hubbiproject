package com.hubster.response;

import java.util.List;

import com.hubster.model.ReassignInitiativeModel;

public class ReassignInResponse {
	
	public List<ReassignInitiativeModel> getGetreassign() {
		return getreassign;
	}

	public void setGetreassign(List<ReassignInitiativeModel> getreassign) {
		this.getreassign = getreassign;
	}

	private List<ReassignInitiativeModel> getreassign;

}
