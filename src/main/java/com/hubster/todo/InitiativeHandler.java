package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.StrategyDaoImpl;
import com.hubster.model.InitiativeModel;
import com.hubster.request.Request;
import com.hubster.response.InitiativeResponse;

public class InitiativeHandler implements RequestHandler<Request, InitiativeResponse> {

	private final StrategyDaoImpl strategyService = StrategyDaoImpl.instance;

	private InitiativeResponse getResponse() {
		return new InitiativeResponse();
	}

	@Override
//	public LexResponse handleRequest(Request input, Context context) {

	public InitiativeResponse handleRequest(Request input, Context context) {

		List<InitiativeModel> inlist = strategyService.getinitiative(input);
		InitiativeResponse res = getResponse();
		if (!inlist.isEmpty()) {

			// res.setResCode(CommonContants.SUCCESS_CODE);
			// res.setResDesc(CommonContants.SUCCSS_DESC);
			res.setGetinitiative(inlist);

		} else {
			// res.setResCode(CommonContants.FAIL_CODE);
			// res.setResDesc(CommonContants.FAIL_DESC);
		}
//		Message message = new Message("PlainText", inlist.toString());
//		DialogAction dialogueAction = new DialogAction("Close", "Fulfilled", message);
//
//		return new LexResponse(dialogueAction);

		return res;
	}

}
