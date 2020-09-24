package com.hubster.model;

public class ActiveStrategyInitiativeModel {



	@Override
	public String toString() {
		return "" + initiative + "";
	}

	private String initiative;
	private String category;
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getInitiative() {
		return initiative;
	}

	public void setInitiative(String initiative) {
		this.initiative = initiative;
	}

}
