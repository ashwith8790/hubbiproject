package com.hubster.dao;

import java.util.List;

import com.hubster.model.ActiveStrategyInitiativeModel;
import com.hubster.model.ActiveStrategyModel;
import com.hubster.model.CgoalModel;
import com.hubster.model.ChangeDueDateInitiativeModel;
import com.hubster.model.ChangeInitiativeStatusModel;
import com.hubster.model.FirstInitiativeModel;
import com.hubster.model.InitiativeModel;
import com.hubster.model.OneInitiativeModel;
import com.hubster.model.PastDueInitiativeModel;
import com.hubster.model.SecondInitiativeModel;
import com.hubster.model.ThirdInitiativeModel;
import com.hubster.request.Request;

public interface StrategyDao {

	List<FirstInitiativeModel> getfirstactivepriority(Request activepriority);

	List<SecondInitiativeModel> getsecondactivepriority(Request secondactivepriority);

	List<ThirdInitiativeModel> getthirdactivepriority(Request thirdactivepriority);

	List<PastDueInitiativeModel> getdueinitiatives(Request dueinitiatives);

	List<ActiveStrategyModel> activestrategygoals(Request activegoals);
	
	List<ActiveStrategyInitiativeModel> activestrategyinitiatives(Request activeinitiatives);
 
	List<ChangeDueDateInitiativeModel> changeduedateinitiative(Request changedueinitiative);

	List<OneInitiativeModel> getoneinitiative(Request oneinitiative);

	List<ChangeInitiativeStatusModel> getchangeinitiative(Request changeinitiative);

	List<InitiativeModel> getinitiative(Request reiniti);

	List<CgoalModel> getsinglecgoal(Request cgoaldata);

}
