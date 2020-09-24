package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.TodoDaoImpl;
import com.hubster.model.ActionsModel;
import com.hubster.request.Request;
import com.hubster.response.ActionDueDateResponse;

public class ActionItemDueToday implements RequestHandler<Request, ActionDueDateResponse> {

	private final TodoDaoImpl todoService = TodoDaoImpl.instance;

	private ActionDueDateResponse getActionResponse() {

		return new ActionDueDateResponse();
	}

	@Override
	public ActionDueDateResponse handleRequest(Request input, Context context) {

		List<ActionsModel> duedatedata = todoService.actionItemDueDate(input);

		ActionDueDateResponse res = getActionResponse();
		if (!duedatedata.isEmpty()) {
			res.setModel(duedatedata);

		} else {

		}
		return res;

	}
}
