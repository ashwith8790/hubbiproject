package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.TodoDaoImpl;
import com.hubster.model.GoalsHighLevelModel;
import com.hubster.request.Request;
import com.hubster.response.GoalsHighLevelResponse;

public class GoalsHighLevelInfo implements RequestHandler<Request, GoalsHighLevelResponse> {
	
	private final TodoDaoImpl goalLevelService = TodoDaoImpl.instance;

	private GoalsHighLevelResponse getResponse() {

		return new GoalsHighLevelResponse();
	}

	@Override
	public GoalsHighLevelResponse handleRequest(Request input, Context context) {
	
//	public String handleRequest(Request input, Context context) {

		
		List<GoalsHighLevelModel> goallist = goalLevelService.getalldata(input);

		GoalsHighLevelResponse res = getResponse();
		if (!goallist.isEmpty()) {
			res.setGhmodel(goallist);
			

		} else {

		}

		
//		return goallist.toString();
		return res;
	}


}
