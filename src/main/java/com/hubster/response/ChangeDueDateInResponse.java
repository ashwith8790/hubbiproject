package com.hubster.response;

import java.util.List;

import com.hubster.model.ChangeDueDateInitiativeModel;

public class ChangeDueDateInResponse {
	
	public List<ChangeDueDateInitiativeModel> getGetchangeDate() {
		return getchangeDate;
	}

	public void setGetchangeDate(List<ChangeDueDateInitiativeModel> getchangeDate) {
		this.getchangeDate = getchangeDate;
	}

	private List<ChangeDueDateInitiativeModel> getchangeDate;

}
