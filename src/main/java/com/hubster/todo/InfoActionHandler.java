package com.hubster.todo;

import java.util.List;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.TodoDaoImpl;
import com.hubster.model.ActionModel;
import com.hubster.request.Request;
import com.hubster.response.ActionResponse;
import com.hubster.response.ActionResponses;

public class InfoActionHandler implements RequestHandler<Request, ActionResponses> {

	private final TodoDaoImpl actionService = TodoDaoImpl.instance;

	private ActionResponses getactionresponse() {
		return new ActionResponses();
	}

	@Override
	public ActionResponses handleRequest(Request input, Context context) {

		List<ActionModel> actionlist = actionService.getinfoactionitem(input);
		ActionResponses res = getactionresponse();
		if (!actionlist.isEmpty()) {
			res.setGetactioninfo(actionlist);

		} else {

		}

//		return goallist.toString();
		return res;
	}

}
