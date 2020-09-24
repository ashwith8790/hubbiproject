package com.hubster.todo;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hubster.dao.TodoDaoImpl;
import com.hubster.model.LoginModel;
import com.hubster.request.Request;

public class LoginHandler implements RequestHandler<Request, List<LoginModel>> {

	private final TodoDaoImpl todoService = TodoDaoImpl.instance;

//	private LoginResponse getResponse() {
//		return new LoginResponse();
//	}

	@Override
	public List<LoginModel> handleRequest(Request input, Context context) {
//	public String handleRequest(Request input, Context context) {

		List<LoginModel> loginlist = todoService.getusername(input);
//		LoginResponse res = getResponse();
//		if (!loginlist.isEmpty()) {

		// res.setResCode(CommonContants.SUCCESS_CODE);
//			res.setLoginsucess(CommonContants.LOGIN_SUCCESS);
		// res.setResDesc(CommonContants.SUCCSS_DESC);
//			res.setGetloginmodel(loginlist);

//		} else //{
		// res.setResCode(CommonContants.FAIL_CODE);
		// res.setResDesc(CommonContants.FAIL_DESC);
//			res.setLoginfail(CommonContants.LOGIN_FAIL);
		// }
		System.out.println(loginlist);
//		return lm.toString();
//		return "Successfully Login";
		return loginlist;
	}
	
	
	

}
