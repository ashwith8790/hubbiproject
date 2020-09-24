package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.StrategyDaoImpl;
import com.hubster.model.SecondInitiativeModel;
import com.hubster.request.Request;
import com.hubster.response.SecondInitiativeResponse;

public class StrategySecondHandler implements RequestHandler<Request, SecondInitiativeResponse> {

	private final StrategyDaoImpl strategysecondService = StrategyDaoImpl.instance;

	private SecondInitiativeResponse getResponse() {
		return new SecondInitiativeResponse();
	}

	@Override
	public SecondInitiativeResponse handleRequest(Request input, Context context) {
		List<SecondInitiativeModel> secondlist = strategysecondService.getsecondactivepriority(input);

		SecondInitiativeResponse res = getResponse();
		if (!secondlist.isEmpty()) {

			// res.setResCode(CommonContants.SUCCESS_CODE);
			// res.setResDesc(CommonContants.SUCCSS_DESC);
			res.setGetinitiatives(secondlist);

		} else {
			// res.setResCode(CommonContants.FAIL_CODE);
			// res.setResDesc(CommonContants.FAIL_DESC);
		}

		return res;
	}

}
