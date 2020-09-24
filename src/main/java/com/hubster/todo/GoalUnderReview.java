package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.TodoDaoImpl;
import com.hubster.model.HubbiOnHold;
import com.hubster.request.Request;

public class GoalUnderReview implements RequestHandler<Request, String> {

	private final TodoDaoImpl underreviewService = TodoDaoImpl.instance;

	private HubbiOnHold getResponse() {
		return new HubbiOnHold();
	}

	@Override
	public String handleRequest(Request input, Context context) {
		List<HubbiOnHold> underreview = underreviewService.getGoalsUnderReview(input);

		HubbiOnHold res = getResponse();
		if (!underreview.isEmpty()) {

			// res.setResCode(CommonContants.SUCCESS_CODE);
			// res.setResDesc(CommonContants.SUCCSS_DESC);
			res.setHgonholdmodel(underreview);

		} else {
			// res.setResCode(CommonContants.FAIL_CODE);
			// res.setResDesc(CommonContants.FAIL_DESC);
		}

		return underreview.toString();

	}

}
