package com.hubster.model;

import java.util.Date;

public class ActionModel {

	private int chid;
	private int total;
	private String actionItem;
	private Date chresolveDate;
	public String getChstatus() {
		return chstatus;
	}

	public void setChstatus(String chstatus) {
		this.chstatus = chstatus;
	}

	private String chstatus;
	




	public Date getChresolveDate() {
		return chresolveDate;
	}

	public void setChresolveDate(Date chresolveDate) {
		this.chresolveDate = chresolveDate;
	}



	public String getActionItem() {
		return actionItem;
	}

	public void setActionItem(String actionItem) {
		this.actionItem = actionItem;
	}

	public int getChid() {
		return chid;
	}

	public void setChid(int chid) {
		this.chid = chid;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
