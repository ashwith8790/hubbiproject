package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.TodoDaoImpl;
import com.hubster.model.ReassignLoginModel;
import com.hubster.request.Request;

public class ReassignLogin implements RequestHandler<Request, List<ReassignLoginModel>> {
	
	private final TodoDaoImpl loginService = TodoDaoImpl.instance;

	@Override
	public List<ReassignLoginModel> handleRequest(Request input, Context context) {
		List<ReassignLoginModel> reassignloginlist = loginService.getreassignlogin(input);
		return reassignloginlist;
	}

}
