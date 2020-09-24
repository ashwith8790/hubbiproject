package com.hubster.model;

public class ActionsModel {

	@Override
	public String toString() {
		return " [" + total + "]";
	}

	private int total;
	private String chresolveDate;
	private String currentdate;
	public String getCheassign() {
		return cheassign;
	}

	public void setCheassign(String cheassign) {
		this.cheassign = cheassign;
	}

	private String cheassign;
	

	public String getChresolveDate() {
		return chresolveDate;
	}

	public void setChresolveDate(String chresolveDate) {
		this.chresolveDate = chresolveDate;
	}

	public String getCurrentdate() {
		return currentdate;
	}

	public void setCurrentdate(String currentdate) {
		this.currentdate = currentdate;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
