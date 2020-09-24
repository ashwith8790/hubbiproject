package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.StrategyDaoImpl;
import com.hubster.model.OneInitiativeModel;
import com.hubster.request.Request;
import com.hubster.response.OneInitiativeResponse;

public class OneInitiativeHandler implements RequestHandler<Request, OneInitiativeResponse> {

	private final StrategyDaoImpl cgoalService = StrategyDaoImpl.instance;

	private OneInitiativeResponse getcgoal() {
		return new OneInitiativeResponse();
	}

	@Override
	public OneInitiativeResponse handleRequest(Request input, Context context) {
		List<OneInitiativeModel> cgoallist = cgoalService.getoneinitiative(input);

		OneInitiativeResponse res = getcgoal();
		if (!cgoallist.isEmpty()) {

			// res.setResCode(CommonContants.SUCCESS_CODE);
			// res.setResDesc(CommonContants.SUCCSS_DESC);
			res.setGetInitiative(cgoallist);

		} else {
			// res.setResCode(CommonContants.FAIL_CODE);
			// res.setResDesc(CommonContants.FAIL_DESC);
		}

		return res;
	}

}
