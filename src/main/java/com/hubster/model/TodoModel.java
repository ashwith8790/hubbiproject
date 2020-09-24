package com.hubster.model;

public class TodoModel {

	// private int chid;
	// private Date followup;
	// private Date chmeetdate;
	// private String cheKP;
	// private Date chstatusdate;
	// private int priority;
	private String challenge;

	@Override
	public String toString() {
		return " [challenge=" + challenge + "]";
	}

	public String getChallenge() {
		return challenge;
	}

	public void setChallenge(String challenge) {
		this.challenge = challenge;
	}

}