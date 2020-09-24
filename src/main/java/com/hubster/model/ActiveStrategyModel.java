package com.hubster.model;

import java.util.List;

public class ActiveStrategyModel {

	private int goal;
	private String status;

	private int id;
	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}



	public List<ActiveStrategyModel> getGetactiveStratagies() {
		return getactiveStratagies;
	}

	public void setGetactiveStratagies(List<ActiveStrategyModel> getactiveStratagies) {
		this.getactiveStratagies = getactiveStratagies;
	}

	private List<ActiveStrategyModel> getactiveStratagies;

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
