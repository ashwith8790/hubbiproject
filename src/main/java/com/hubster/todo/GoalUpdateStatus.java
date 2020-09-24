package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.config.CommonContants;
import com.hubster.dao.TodoDaoImpl;
import com.hubster.model.HubbiGoals;
import com.hubster.request.Request;
import com.hubster.response.Response;

public class GoalUpdateStatus implements RequestHandler<Request, Response> {

	private final TodoDaoImpl updategoalService = TodoDaoImpl.instance;

	private Response getResponse() {
		return new Response();
	}

	@Override
	public Response handleRequest(Request input, Context context) {

		List<HubbiGoals> updatelist = updategoalService.updatestatusgoal(input);
		Response res = getResponse();
		if (!updatelist.isEmpty()) {

			res.setResCode(CommonContants.SUCCESS_CODE);
			res.setResDesc(CommonContants.SUCCSS_DESC);
			res.setHgmodel(updatelist);

		} else {
			// res.setResCode(CommonContants.FAIL_CODE);
			// res.setResDesc(CommonContants.FAIL_DESC);
		}

		// Message message = new Message("PlainText", updatelist.toString());
		// DialogAction dialogueAction = new DialogAction("Close", "Fulfilled",
		// message);

		// return new LexResponse(dialogueAction);

		return res;

	}

}
