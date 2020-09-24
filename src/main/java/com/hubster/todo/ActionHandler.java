package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.TodoDaoImpl;
import com.hubster.model.ActionModel;
import com.hubster.request.Request;
import com.hubster.response.ActionResponse;

public class ActionHandler implements RequestHandler<Request, ActionResponse> {

	private final TodoDaoImpl todoService = TodoDaoImpl.instance;

	private ActionResponse getActionResponse() {

		return new ActionResponse();
	}

	@Override
	public ActionResponse handleRequest(Request input, Context context) {
		List<ActionModel> actionlist = todoService.getActionItem(input);

		ActionResponse res = getActionResponse();
		if (!actionlist.isEmpty()) {
			res.setAcmodel(actionlist);

		} else {

		}
		return res;

	}

}
