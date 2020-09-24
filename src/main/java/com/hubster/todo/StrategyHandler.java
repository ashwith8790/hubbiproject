package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.StrategyDaoImpl;
import com.hubster.model.FirstInitiativeModel;
import com.hubster.request.Request;
import com.hubster.response.FirstInitiativeResponse;

public class StrategyHandler implements RequestHandler<Request, FirstInitiativeResponse> {

	private final StrategyDaoImpl strategyService = StrategyDaoImpl.instance;

	private FirstInitiativeResponse getResponse() {
		return new FirstInitiativeResponse();
	}

	@Override
	public FirstInitiativeResponse handleRequest(Request input, Context context) {

		List<FirstInitiativeModel> firstlist = strategyService.getfirstactivepriority(input);

		FirstInitiativeResponse res = getResponse();
		if (!firstlist.isEmpty()) {

			res.setGetinitiatives(firstlist);

		} else {
		}

		return res;
	}

}
