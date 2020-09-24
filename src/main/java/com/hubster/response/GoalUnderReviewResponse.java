package com.hubster.response;

import java.util.List;

import com.hubster.model.HubbiGoals;

public class GoalUnderReviewResponse {
	
	private String cgoals;
	
	@Override
	public String toString() {
		return " [" + cgoals + "]";
	}

	private List<HubbiGoals> hgmodel;
	
	public List<HubbiGoals> getHgmodel() {
		return hgmodel;
	}

	public void setHgmodel(List<HubbiGoals> hgmodel) {
		this.hgmodel = hgmodel;
	}

	public String getCgoals() {
		return cgoals;
	}

	public void setCgoals(String cgoals) {
		this.cgoals = cgoals;
	}
	

}
