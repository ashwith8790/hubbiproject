package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.TodoDaoImpl;
import com.hubster.model.GoalModel;
import com.hubster.request.Request;

public class GoalHandler implements RequestHandler<Request, String> {

	private final TodoDaoImpl todoService = TodoDaoImpl.instance;

	public String handleRequest(Request input, Context context) {

		List<GoalModel> goallist = todoService.getAllGoals(input);

		return goallist.toString();

	}

}
