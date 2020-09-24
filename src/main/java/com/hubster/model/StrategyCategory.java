package com.hubster.model;

import java.util.List;

public class StrategyCategory {

	private String ini_level;
	private String status;
	private String currentdate;
	private int goal;
	private int id;
	private String initiative;
	private String assignoto;
	private String duedate;
	private String category;
	private List<StrategyCategory> scmodel;

	public String getDuedate() {
		return duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public String getAssignoto() {
		return assignoto;
	}

	public void setAssignoto(String assignoto) {
		this.assignoto = assignoto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public String getInitiative() {
		return initiative;
	}

	public void setInitiative(String initiative) {
		this.initiative = initiative;
	}

	public String getCurrentdate() {
		return currentdate;
	}

	public void setCurrentdate(String currentdate) {
		this.currentdate = currentdate;
	}

	public List<StrategyCategory> getScmodel() {
		return scmodel;
	}

	public void setScmodel(List<StrategyCategory> scmodel) {
		this.scmodel = scmodel;
	}

	public String getIni_level() {
		return ini_level;
	}

	public void setIni_level(String ini_level) {
		this.ini_level = ini_level;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
