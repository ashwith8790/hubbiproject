package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.StrategyDaoImpl;
import com.hubster.model.ChangeDueDateInitiativeModel;
import com.hubster.request.Request;
import com.hubster.response.ChangeDueDateInResponse;

public class ChangeDueDateInitiative implements RequestHandler<Request, ChangeDueDateInResponse> {

	private final StrategyDaoImpl strategyService = StrategyDaoImpl.instance;

	private ChangeDueDateInResponse getResponse() {
		return new ChangeDueDateInResponse();
	}

	@Override
	public ChangeDueDateInResponse handleRequest(Request input, Context context) {

		List<ChangeDueDateInitiativeModel> changeduedate = strategyService.changeduedateinitiative(input);

		ChangeDueDateInResponse res = getResponse();
		if (!changeduedate.isEmpty()) {

			res.setGetchangeDate(changeduedate);

		} else {
		}

		return res;
	}

}
