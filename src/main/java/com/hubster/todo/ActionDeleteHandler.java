package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.TodoDaoImpl;
import com.hubster.model.ActionModel;
import com.hubster.request.Request;
import com.hubster.response.ActionResponse;

public class ActionDeleteHandler implements RequestHandler<Request, ActionResponse> {

	private final TodoDaoImpl actionDeleteService = TodoDaoImpl.instance;

	private ActionResponse getActionRespone() {
		return new ActionResponse();
	}

	@Override
	public ActionResponse handleRequest(Request input, Context context) {

		List<ActionModel> actiondeletelist = actionDeleteService.deleteActionItem(input);

		ActionResponse actionresponse = getActionRespone();

		if (!actiondeletelist.isEmpty()) {

			actionresponse.setAcmodel(actiondeletelist);

		} else {
			// response.setResCode(CommonContants.FAIL_CODE);
			// response.setResDesc(CommonContants.FAIL_DESC);
		}
		return actionresponse;
	}
}
