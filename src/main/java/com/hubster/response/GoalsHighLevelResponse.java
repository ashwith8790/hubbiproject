package com.hubster.response;

import java.util.List;

import com.hubster.model.GoalsHighLevelModel;

public class GoalsHighLevelResponse {
	
	public List<GoalsHighLevelModel> getGhmodel() {
		return ghmodel;
	}

	public void setGhmodel(List<GoalsHighLevelModel> ghmodel) {
		this.ghmodel = ghmodel;
	}

	@Override
	public String toString() {
		return "GoalsHighLevelResponse [ghmodel=" + ghmodel + "]";
	}

	private List<GoalsHighLevelModel> ghmodel;


}
