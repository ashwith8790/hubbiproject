package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.StrategyDaoImpl;
import com.hubster.model.ThirdInitiativeModel;
import com.hubster.request.Request;
import com.hubster.response.ThirdInitiativeResponse;

public class StrategyThirdHandler implements RequestHandler<Request, ThirdInitiativeResponse> {

	private final StrategyDaoImpl strategysecondService = StrategyDaoImpl.instance;

	private ThirdInitiativeResponse getResponse() {
		return new ThirdInitiativeResponse();
	}

	@Override

	public ThirdInitiativeResponse handleRequest(Request input, Context context) {
		List<ThirdInitiativeModel> thirdlist = strategysecondService.getthirdactivepriority(input);

		ThirdInitiativeResponse res = getResponse();
		if (!thirdlist.isEmpty()) {

			// res.setResCode(CommonContants.SUCCESS_CODE);
			// res.setResDesc(CommonContants.SUCCSS_DESC);
			res.setGetinitiatives(thirdlist);

		} else {
			// res.setResCode(CommonContants.FAIL_CODE);
			// res.setResDesc(CommonContants.FAIL_DESC);
		}

		return res;

	}

}
