package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.StrategyDaoImpl;
import com.hubster.model.ActiveStrategyInitiativeModel;
import com.hubster.request.Request;
import com.hubster.response.SingleActiveStrategyInitiativeResponse;

public class SingleActiveStrategyInitiative implements RequestHandler<Request, String> {

	private final StrategyDaoImpl activestratgyInitiativeService = StrategyDaoImpl.instance;

//	private SingleActiveStrategyInitiativeResponse getactiveinitiativeStratagies() {
//		return new SingleActiveStrategyInitiativeResponse();
//	}

	@Override
	public String handleRequest(Request input, Context context) {
		List<ActiveStrategyInitiativeModel> li = activestratgyInitiativeService.activestrategyinitiatives(input);

//		SingleActiveStrategyInitiativeResponse res = getactiveinitiativeStratagies();
//		if (!li.isEmpty()) {
//
//			res.setGetactiveinitiativemodel(li);
//
//		} else {
//
//		}

		return li.toString();
	}

}
