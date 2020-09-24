package com.hubster.response;

import java.util.List;

import com.hubster.model.CgoalModel;

public class CgoalsResponse {

	private String cgoals;
	private List<CgoalModel> cgoalmodel;

	public List<CgoalModel> getCgoalmodel() {
		return cgoalmodel;
	}

	public void setCgoalmodel(List<CgoalModel> cgoalmodel) {
		this.cgoalmodel = cgoalmodel;
	}

	public String getCgoals() {
		return cgoals;
	}

	public void setCgoals(String cgoals) {
		this.cgoals = cgoals;
	}

	@Override
	public String toString() {
		return " [" + cgoals + "]";
	}

}
