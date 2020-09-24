package com.hubster.response;

import java.util.HashMap;
import java.util.Map;

public class LexResponse {

	private DialogAction dialogAction;

	private Message aa;

	public Message getMessage() {
		return aa;
	}

	public void setMessage(Message aa) {
		this.aa = aa;
	}

	Map<String, String> sessionAttributes;

	public LexResponse() {
	}

	public LexResponse(Message aa) {
		this.aa = aa;
	}

	public LexResponse(Message aa, DialogAction dialogAction,Map<String, String> sessionAttributes) {

//		this(dialogAction);
		this.dialogAction = dialogAction;
//		this(message);
		this.aa = aa;
		this.sessionAttributes = sessionAttributes;
	}

	public DialogAction getDialogAction() {
		return dialogAction;
	}

	public void setDialogAction(DialogAction dialogAction) {
		this.dialogAction = dialogAction;
	}

	public Map<String, String> getSessionAttributes() {
		return sessionAttributes;
	}

	public void setSessionAttributes(Map<String, String> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}

	public void addAttribute(String k, String v) {
		if (sessionAttributes == null) {
			sessionAttributes = new HashMap<String, String>();
		}

		sessionAttributes.put(k, v);
	}

	public void clearAttributes() {
		if (sessionAttributes != null) {
			sessionAttributes.clear();
		}
	}
}
