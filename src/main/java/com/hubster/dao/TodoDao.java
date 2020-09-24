package com.hubster.dao;

import java.util.List;

import com.hubster.model.ActionModel;
import com.hubster.model.ActionsModel;
import com.hubster.model.ActiveStrategyGoalModel;
import com.hubster.model.CgoalModel;
import com.hubster.model.GoalModel;
import com.hubster.model.GoalsHighLevelModel;
import com.hubster.model.HubbiGoals;
import com.hubster.model.HubbiOnHold;
import com.hubster.model.LoginModel;
import com.hubster.model.ReassignLoginModel;
import com.hubster.model.ScheduleMeetingModel;
import com.hubster.request.Request;

public interface TodoDao {

	List<ActionModel> getActionItem(Request requests);

	List<ActionModel> updateActionItem(Request re);
	
	List<ActionModel> updatestatusactionitem(Request statusaction);

	List<ActionsModel> actionItemDueDate(Request reqduedate);

	List<ActionModel> deleteActionItem(Request reqs);

	List<GoalModel> getAllGoals(Request getgoal);

	List<HubbiOnHold> getGoalsOnHold(Request getonhold);

	List<HubbiOnHold> getGoalsUnderReview(Request getunderreview);

	List<HubbiGoals> updatestatusgoal(Request updategoal);
	
	List <HubbiGoals> updatedategoal(Request updatedate);

	List<CgoalModel> getcgoals(Request cgoals);

	List<CgoalModel> getsingelgoal(Request singlegoal);

	List<ActiveStrategyGoalModel> getactivestrategygoal(Request singleactivegoal);

	List<LoginModel> getusername(Request loginname);
	
	List<ReassignLoginModel> getreassignlogin(Request reassignname);
	
	List<ActionModel> getinfoactionitem(Request getactiondata);
	
	String getmeeting(Request getmeetingRequest);
	
	List<GoalsHighLevelModel> getalldata(Request getdata);




}
