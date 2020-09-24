package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.TodoDaoImpl;
import com.hubster.model.ActionModel;
import com.hubster.request.Request;
import com.hubster.response.ActionResponse;

public class ActionUpdateHandler implements RequestHandler<Request, ActionResponse> {

	private final TodoDaoImpl actionUpdateService = TodoDaoImpl.instance;

	private ActionResponse getActionResponse() {

		return new ActionResponse();
	}

	@Override
	public ActionResponse handleRequest(Request input, Context context) {
		List<ActionModel> updateactionlist = actionUpdateService.updateActionItem(input);
		ActionResponse ar = getActionResponse();

		if (!updateactionlist.isEmpty()) {

			ar.setAcmodel(updateactionlist);

		} else {
			// res.setResCode(CommonContants.FAIL_CODE);
			// res.setResDesc(CommonContants.FAIL_DESC);
		}

		return ar;
	}

}
