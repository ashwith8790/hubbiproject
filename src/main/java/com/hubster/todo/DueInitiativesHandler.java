package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.StrategyDaoImpl;
import com.hubster.model.PastDueInitiativeModel;
import com.hubster.request.Request;

public class DueInitiativesHandler implements RequestHandler<Request, List<PastDueInitiativeModel>> {

	private final StrategyDaoImpl dueInitiativeService = StrategyDaoImpl.instance;

//	private PastDueInitiativeModel getResponse() {
//		return new PastDueInitiativeModel(); 
//	}

	@Override
	public List<PastDueInitiativeModel> handleRequest(Request input, Context context) {

//	public PastDueInitiativeResponse handleRequest(Request input, Context context) {

//	public LexResponse handleRequest(Request input, Context context) {

		List<PastDueInitiativeModel> duelist = dueInitiativeService.getdueinitiatives(input);

//		PastDueInitiativeResponse res = getResponse();
//		PastDueInitiativeModel res = getResponse();
//		if (!duelist.isEmpty()) {

		// res.setResCode(CommonContants.SUCCESS_CODE);
		// res.setResDesc(CommonContants.SUCCSS_DESC);
//			res.setGetinitiatives(duelist);

//		} else {
		// res.setResCode(CommonContants.FAIL_CODE);
		// res.setResDesc(CommonContants.FAIL_DESC);
//		}

//		Message message = new Message(duelist.toString());
//		DialogAction dialogueAction = new DialogAction(message);

//		return new LexResponse(message);

//		 return duelist.toString();

//		return res;

		return duelist;

	}
}
