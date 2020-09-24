package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.StrategyDaoImpl;
import com.hubster.model.ActiveStrategyModel;
import com.hubster.request.Request;
import com.hubster.response.ActiveStrategyResponse;

public class ActiveStrategiesHandler implements RequestHandler<Request, ActiveStrategyResponse> {

	private final StrategyDaoImpl activestrategiesService = StrategyDaoImpl.instance;

	private ActiveStrategyResponse getResponse() {
		return new ActiveStrategyResponse();
	}

	@Override
	public ActiveStrategyResponse handleRequest(Request input, Context context) {

		List<ActiveStrategyModel> activelist = activestrategiesService.activestrategygoals(input);

		ActiveStrategyResponse res = getResponse();
		if (!activelist.isEmpty()) {
			res.setGetactiveStratagies(activelist);

		} else {
		}
//		 DialogAction dialogueAction = new DialogAction(message);

//		 return new LexResponse(message);
//		return res;

		return res;
	}

}
