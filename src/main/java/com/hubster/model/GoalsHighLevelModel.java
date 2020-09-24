package com.hubster.model;

public class GoalsHighLevelModel {
	
	public int getCgoal_id() {
		return cgoal_id;
	}
	public void setCgoal_id(int cgoal_id) {
		this.cgoal_id = cgoal_id;
	}
	public String getGoal_group() {
		return goal_group;
	}
	public void setGoal_group(String goal_group) {
		this.goal_group = goal_group;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getCgoals() {
		return cgoals;
	}
	public void setCgoals(String cgoals) {
		this.cgoals = cgoals;
	}
	public String getCorp_duedate() {
		return corp_duedate;
	}
	public void setCorp_duedate(String corp_duedate) {
		this.corp_duedate = corp_duedate;
	}
	public String getStrat_duedate() {
		return strat_duedate;
	}
	public void setStrat_duedate(String strat_duedate) {
		this.strat_duedate = strat_duedate;
	}
	public String getCategory_duedate() {
		return category_duedate;
	}
	public void setCategory_duedate(String category_duedate) {
		this.category_duedate = category_duedate;
	}
	public String getChresolveDate() {
		return chresolveDate;
	}
	public void setChresolveDate(String chresolveDate) {
		this.chresolveDate = chresolveDate;
	}
	public String getTracker() {
		return tracker;
	}
	public void setTracker(String tracker) {
		this.tracker = tracker;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
//	@Override
//	public String toString() {
//		return "This is " + tracker + "Due " + corp_duedate + "Current Status " + status
//				+ "Assigned to " + staff_name + ", " + goal_group + ", " + cgoal_id + "," + cgoals + "";
//	}
	private int cgoal_id;
	private String goal_group;
	private String staff_name;
	private String cgoals;
	private String corp_duedate;
	private String strat_duedate;
	private String category_duedate;
	private String chresolveDate;
	private String tracker;
	private String status;
	

}
