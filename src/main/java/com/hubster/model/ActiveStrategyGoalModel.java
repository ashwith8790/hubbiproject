package com.hubster.model;

import java.util.List;

public class ActiveStrategyGoalModel {
	
	@Override
	public String toString() {
		return " " + category + "";
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	private String category;
	
	public List<ActiveStrategyGoalModel> getGetmodel() {
		return getmodel;
	}

	public void setGetmodel(List<ActiveStrategyGoalModel> getmodel) {
		this.getmodel = getmodel;
	}

	List<ActiveStrategyGoalModel> getmodel;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int id;
	

}
