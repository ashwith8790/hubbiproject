package com.hubster.model;

import java.util.List;

public class CgoalModel {

	private List<CgoalModel> goalmodel;

	public int getCgoal_id() {
		return cgoal_id;
	}

	public void setCgoal_id(int cgoal_id) {
		this.cgoal_id = cgoal_id;
	}

//	@Override
//	public String toString() {
//		return " " + cgoal_id + "." + cgoals + "";
//	}

	private int cgoal_id;
	@Override
	public String toString() {
		return "CgoalModel [cgoal_id=" + cgoal_id + ", cgoals=" + cgoals + "]";
	}

	private String cgoals;


	public List<CgoalModel> getGoalmodel() {
		return goalmodel;
	}

	public void setGoalmodel(List<CgoalModel> goalmodel) {
		this.goalmodel = goalmodel;
	}

	public String getCgoals() {
		return cgoals;
	}

	public void setCgoals(String cgoals) {
		this.cgoals = cgoals;
	}


}
