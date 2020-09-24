package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.StrategyDaoImpl;
import com.hubster.model.ChangeInitiativeStatusModel;
import com.hubster.request.Request;
import com.hubster.response.ChangeInitiativeStatusResponse;

public class ChangeInitiativeStatus implements RequestHandler<Request, ChangeInitiativeStatusResponse> {

	private final StrategyDaoImpl strategyService = StrategyDaoImpl.instance;

	private ChangeInitiativeStatusResponse getResponse() {
		return new ChangeInitiativeStatusResponse();
	}

	@Override
	public ChangeInitiativeStatusResponse handleRequest(Request input, Context context) {

		List<ChangeInitiativeStatusModel> changestatus = strategyService.getchangeinitiative(input);

		ChangeInitiativeStatusResponse res = getResponse();
		if (!changestatus.isEmpty()) {

			res.setGetchange(changestatus);

		} else {
		}

		return res;
	}

}
