package com.hubster.model;

import java.util.Date;
import java.util.List;

public class FirstInitiativeModel implements Comparable<FirstInitiativeModel> {

	private int id;
	private String initiative;
	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	private Date duedate;


	private List<FirstInitiativeModel> getinitiatives;

	public List<FirstInitiativeModel> getGetinitiatives() {
		return getinitiatives;
	}

	public void setGetinitiatives(List<FirstInitiativeModel> getinitiatives) {
		this.getinitiatives = getinitiatives;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInitiative() {
		return initiative;
	}

	public void setInitiative(String initiative) {
		this.initiative = initiative;
	}

	@Override
	public int compareTo(FirstInitiativeModel o) {
		// TODO Auto-generated method stub
		return getDuedate().compareTo(o.getDuedate());
	}

}
