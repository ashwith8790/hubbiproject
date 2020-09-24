package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.TodoDaoImpl;
import com.hubster.model.ActiveStrategyGoalModel;
import com.hubster.request.Request;
import com.hubster.response.SingleStrategyActiveGoalsResponse;

public class SingleActiveStrategyGoal implements RequestHandler<Request, SingleStrategyActiveGoalsResponse> {

	private final TodoDaoImpl activestratgygoalService = TodoDaoImpl.instance;

	private SingleStrategyActiveGoalsResponse getcgoal() {
		return new SingleStrategyActiveGoalsResponse();
	}

	@Override
	public SingleStrategyActiveGoalsResponse handleRequest(Request input, Context context) {

		List<ActiveStrategyGoalModel> li = activestratgygoalService.getactivestrategygoal(input);

		SingleStrategyActiveGoalsResponse res = getcgoal();
		if (!li.isEmpty()) {

			// res.setResCode(CommonContants.SUCCESS_CODE);
			// res.setResDesc(CommonContants.SUCCSS_DESC);
			res.setGetmodel(li);
			;

		} else {
			// res.setResCode(CommonContants.FAIL_CODE);
			// res.setResDesc(CommonContants.FAIL_DESC);
		}

		return res;

	}

}
