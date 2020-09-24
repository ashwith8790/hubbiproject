package com.hubster.model;

import java.util.List;

public class HubbiOnHold {
	
	@Override
	public String toString() {
		return " " + cgoal_id + "." + cgoals + "";
	}

	private int cgoal_id;
	private String cgoals;
	
	public int getCgoal_id() {
		return cgoal_id;
	}

	public void setCgoal_id(int cgoal_id) {
		this.cgoal_id = cgoal_id;
	}

	private List<HubbiOnHold> hgonholdmodel;

	public List<HubbiOnHold> getHgonholdmodel() {
		return hgonholdmodel;
	}

	public void setHgonholdmodel(List<HubbiOnHold> hgonholdmodel) {
		this.hgonholdmodel = hgonholdmodel;
	}

	public String getCgoals() {
		return cgoals;
	}

	public void setCgoals(String cgoals) {
		this.cgoals = cgoals;
	}

//	@Override
//	public String toString() {
//		return "["+ cgoals +"]";
//	}

}
