package com.hubster.model;

import java.util.List;

public class GoalModel {

	private List<GoalModel> goalModel;

	private int cgoal_id;

	public int getCgoal_id() {
		return cgoal_id;
	}

	public void setCgoal_id(int cgoal_id) {
		this.cgoal_id = cgoal_id;
	}

	public List<GoalModel> getGoalModel() {
		return goalModel;
	}

	public void setGoalModel(List<GoalModel> goalModel) {
		this.goalModel = goalModel;
	}

	public String getGoal_group() {
		return goal_group;
	}

	public void setGoal_group(String goal_group) {
		this.goal_group = goal_group;
	}

	@Override
	public String toString() {
		return "" + goal_group + "";
	}

	private String goal_group;
	
}
