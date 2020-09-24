package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.TodoDaoImpl;
import com.hubster.model.ScheduleMeetingModel;
import com.hubster.request.Request;

public class ScheduleMeetingHandler implements RequestHandler<Request, String>{
	
	private final TodoDaoImpl scheduleService = TodoDaoImpl.instance;

	@Override
	public String handleRequest(Request input, Context context) {
		String smlist = scheduleService.getmeeting(input);
		return smlist;
	}

}
