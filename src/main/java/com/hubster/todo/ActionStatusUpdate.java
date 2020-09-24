package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.TodoDaoImpl;
import com.hubster.model.ActionModel;
import com.hubster.request.Request;
import com.hubster.response.ActionResponse;

public class ActionStatusUpdate implements RequestHandler<Request, ActionResponse>{
	
	private final TodoDaoImpl updateActionstatus = TodoDaoImpl.instance;
	

	private ActionResponse getActionResponse() {

		return new ActionResponse();
	}

	@Override
	public ActionResponse handleRequest(Request input, Context context) {
		List<ActionModel> actionitemlist = updateActionstatus.updatestatusactionitem(input);
		ActionResponse ar = getActionResponse();

		if (!actionitemlist.isEmpty()) {

			ar.setAcmodel(actionitemlist);

		} else {
			// res.setResCode(CommonContants.FAIL_CODE);
			// res.setResDesc(CommonContants.FAIL_DESC);
		}

		return ar;
	}


}
