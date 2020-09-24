package com.hubster.response;

import java.util.List;

import com.hubster.model.ActionModel;

public class ActionResponses {

	private List<ActionModel> acmodel;

	public List<ActionModel> getAcmodel() {
		return acmodel;
	}

	public void setAcmodel(List<ActionModel> acmodel) {
		this.acmodel = acmodel;
	}

	public List<ActionModel> getGetactioninfo() {
		return getactioninfo;
	}

	public void setGetactioninfo(List<ActionModel> getactioninfo) {
		this.getactioninfo = getactioninfo;
	}

	private List<ActionModel> getactioninfo;

}
