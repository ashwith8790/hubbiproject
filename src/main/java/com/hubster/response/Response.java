package com.hubster.response;

import java.util.List;

import com.hubster.model.HubbiGoals;
import com.hubster.model.TodoModel;

public class Response {

	private String resCode;

	@Override
	public String toString() {
		return "Response [resCode=" + resCode + ", resDesc=" + resDesc + ", model=" + model + "]";
	}

	private String resDesc;
	private List<TodoModel> model;
	
	public List<HubbiGoals> getHgmodel() {
		return hgmodel;
	}

	public void setHgmodel(List<HubbiGoals> hgmodel) {
		this.hgmodel = hgmodel;
	}

	private List<HubbiGoals> hgmodel;

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public String getResDesc() {
		return resDesc;
	}

	public void setResDesc(String resDesc) {
		this.resDesc = resDesc;
	}

	public List<TodoModel> getModel() {
		return model;
	}

	public void setModel(List<TodoModel> model) {
		this.model = model;
	}

}
