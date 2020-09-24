package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.TodoDaoImpl;
import com.hubster.model.CgoalModel;
import com.hubster.request.Request;
import com.hubster.response.CgoalsResponse;

public class CGoalHanlder implements RequestHandler<Request, CgoalsResponse> {

	private final TodoDaoImpl cgoalService = TodoDaoImpl.instance;

	private CgoalsResponse getcgoal() {
		return new CgoalsResponse();
	}

	@Override

	public CgoalsResponse handleRequest(Request input, Context context) {
		List<CgoalModel> cgoallist = cgoalService.getcgoals(input);

		CgoalsResponse res = getcgoal();
		if (!cgoallist.isEmpty()) {

			// res.setResCode(CommonContants.SUCCESS_CODE);
			// res.setResDesc(CommonContants.SUCCSS_DESC);
			res.setCgoalmodel(cgoallist);

		} else {
			// res.setResCode(CommonContants.FAIL_CODE);
			// res.setResDesc(CommonContants.FAIL_DESC);
		}

		// return res;


		return res;
	}

}
