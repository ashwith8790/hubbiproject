package com.hubster.dao;

/**
 * 
 * @author ashwi
 *
 */
public interface QueryConstants {

//	public String get_action_item = "select chid,chresolveDate,actionItem from challenge where staffe_id = ?  order by chresolveDate";

//	public String get_action_item ="select chid,chresolveDate,actionItem  from challenge where staffe_id = ?  and actionItem IS NOT NULL  order by chresolveDate";

	// adding the not equal to status to archive and complete
//	public String get_action_item = "select chid,chresolveDate,actionItem  from challenge where staffe_id = ? and chstatus != 3  and actionItem IS NOT NULL  order by chresolveDate"; 

//	public String get_action_item = "select chid,chresolveDate,actionItem,chstatus  from challenge where staffe_id = ? and chstatus != 3 and chstatus != 5  and actionItem IS NOT NULL  order by chresolveDate";

	public String get_action_item = "select chid,chresolveDate,actionItem,chstatus from challenge where staffe_id = ? and chstatus != 3 and chstatus != 5 and actionItem IS NOT NULL and chresolveDate IS NOT NULL and chresolveDate != '0000-00-00' order by chresolveDate";

	public String update_action_item = "update challenge set chresolveDate =? where chid=?";

	public String delete_action_item = "delete from challenge  where chid =?";

	public String action_item_due_today = "select count(*) as total From challenge where staffe_id=? && chresolveDate=?";

	public String update_action_item_status = "update challenge set chstatus = ? where chid=?";

	public String getfullinfoactionitem = "select chid,chresolveDate,chstatus,actionItem from challenge where actionItem = ?";


	public String getgoals = "select distinct corpgroup.goal_group from corpgoals inner join corpgroup on corpgoals.cgoalgroup=corpgroup.id";

//	public String cgoals_getting = "select corpgoals.cgoal_id,corpgoals.cgoals from corpgoals inner join corpgroup on corpgoals.cgoalgroup=corpgroup.id where corpgroup.goal_group = ?";

	public String cgoals_getting = "select corpgoals.cgoal_id,corpgoals.cgoals from corpgoals inner join corpgroup on corpgoals.cgoalgroup=corpgroup.id where corpgroup.goal_group = ? order by cgoal_id";

//	public String singlegoal = "select cgoal_id,cgoals from corpgoals where cgoal_id= ?";

	public String singlegoal = "select cgoal_id,cgoals from corpgoals where cgoals= ?";

	public String updategoaldate = "update corpgoals set duedate= ? where cgoal_id = ?";

	public String updatestatusgoal = "update corpgoals set cstatus = ? where cgoal_id =?";

	public String goalsonhold = "select cgoal_id,cgoals from corpgoals where cstatus = 3 && ccreatedby = ?";

	public String goalsunderreview = "select cgoal_id,cgoals from corpgoals where cstatus = 4 && ccreatedby = ?";

	public String goalshighlevel = "SELECT /*PARALLEL(32)*/ distinct corpgoals.cgoal_id,corpgroup.goal_group ,staff.staff_name, corpgoals.cgoals,corpgoals.duedate as 'corp_duedate',strategy.duedate as 'strat_duedate', strategycategory.duedate as 'category_duedate', challenge.chresolveDate,\r\n"
			+ "CASE\r\n"
			+ "WHEN strategycategory.duedate is null and strategy.duedate is not null and corpgoals.duedate is not null and challenge.chresolveDate is not null\r\n"
			+ "THEN\r\n" + "    CASE\r\n"
			+ "        WHEN (corpgoals.duedate > curdate() and strategy.duedate > curdate())\r\n"
			+ "            THEN 'on track'\r\n" + "            ELSE 'not on track'\r\n" + "        END\r\n"
			+ "WHEN strategycategory.duedate is not null and strategy.duedate is null and corpgoals.duedate is not null and challenge.chresolveDate is not null\r\n"
			+ "THEN\r\n" + "        CASE\r\n" + "                WHEN (corpgoals.duedate > curdate())\r\n"
			+ "                THEN 'on track'\r\n" + "                ELSE 'not on track'\r\n" + "        END\r\n"
			+ "WHEN strategycategory.duedate is not null and strategy.duedate is not null and corpgoals.duedate is null and challenge.chresolveDate is not null\r\n"
			+ "THEN\r\n" + "        CASE\r\n"
			+ "            WHEN (strategy.duedate > curdate() and challenge.chresolveDate > curdate() and strategycategory.duedate > curdate())\r\n"
			+ "            THEN 'on track'\r\n" + "            ELSE 'not on track'\r\n" + "        END\r\n"
			+ "WHEN strategycategory.duedate is not null and strategy.duedate is not null and corpgoals.duedate is not null and challenge.chresolveDate is null\r\n"
			+ "    THEN\r\n" + "        CASE\r\n"
			+ "            WHEN (strategy.duedate > curdate() and corpgoals.duedate > curdate() and strategycategory.duedate > curdate())\r\n"
			+ "            THEN 'on track'\r\n" + "            ELSE 'not on track'\r\n" + "        END\r\n"
			+ "WHEN strategycategory.duedate is not null and strategy.duedate is not null and corpgoals.duedate is not null and challenge.chresolveDate is not null\r\n"
			+ "    THEN\r\n" + "        CASE\r\n"
			+ "            WHEN (corpgoals.duedate > curdate() and challenge.chresolveDate > curdate() and strategy.duedate > curdate() and strategycategory.duedate > curdate())\r\n"
			+ "            THEN 'on track'\r\n" + "            ELSE 'not on track'\r\n" + "        END\r\n"
			+ "    ELSE\r\n" + "        CASE\r\n" + "        WHEN (corpgoals.duedate > curdate())\r\n"
			+ "            THEN 'on track'\r\n" + "            ELSE 'not on track'\r\n" + "        END\r\n"
			+ "END AS tracker,\r\n" + "CASE WHEN corpgoals.cstatus = 1 THEN 'active'\r\n"
			+ "WHEN corpgoals.cstatus = 2 THEN 'on hold'\r\n" + "WHEN corpgoals.cstatus = 3 THEN 'Complete'\r\n"
			+ "WHEN corpgoals.cstatus = 4 THEN 'under review'\r\n" + "WHEN corpgoals.cstatus = 5 THEN 'archieved'\r\n"
			+ "WHEN corpgoals.cstatus = 6 THEN 'Cancelled'\r\n" + "ELSE 'not '\r\n" + "END AS status\r\n"
			+ "FROM   corpgoals\r\n"
			+ "left JOIN   (Select csuitegoal, min(chresolveDate) chresolveDate From challenge group by csuitegoal ) challenge ON corpgoals.cgoal_id = challenge.csuitegoal\r\n"
			+ "left join  (Select goal, min(duedate) duedate From strategy group by goal )strategy on strategy.goal = corpgoals.cgoal_id\r\n"
			+ "left join (Select goal, min(duedate) duedate From strategycategory group by goal )strategycategory on strategycategory.goal =  corpgoals.cgoal_id\r\n"
			+ "left join corpgroup on corpgoals.cgoalgroup = corpgroup.id\r\n"
			+ "left join staff on corpgoals.ccreatedby = staff.staff_id where corpgoals.cgoals =?";

	public String priority_one_initiative = "select id,initiative,duedate from strategycategory where ini_level=\"1\" && status != \"3\" && assignoto = ? order by duedate";

	public String priority_two_initiative = "select id,initiative from strategycategory where ini_level= \"2\" && status != \"3\" && assignoto = ? order by duedate";

	public String priority_three_initiative = "select id,initiative  from strategycategory where ini_level=\"3\" && status != \"3\" && assignoto = ? order by duedate";

	public String due_initiatives = "select id,Initiative from strategycategory where  duedate< ? && assignoto = ? && status != 3";

	public String change_due_date_initiative = "update strategycategory set duedate =? where ID=?";

//	public String active_strategies_goal = "select * from strategy where goal=? and status != 3";

	public String active_strategies_goal = "select id,category from strategy where goal=? and status != 3";

//	public String single_strategy_active_goal = "select id,category from strategy where id=?";

	public String single_strategy_active_goal = "select id,category from strategy where category = ?";

//	public String getting_one_initiative = "select * from strategycategory where id=?";

	public String getting_one_initiative = "select id,initiative from strategycategory where initiative= ?";

	public String change_initiative_status = "update strategycategory set status =? where id =?";

	public String past_get_initiative = "select initiative from strategycategory where id= ?";

	public String activeinitiative_forstrategy = "select initiative from strategycategory where category = ? and  status = 1";

	public String login = "select * from sec35_users where login=? and pswd=?";

	public String reassignlogin = "select login,pswd,login_id from sec35_users where login=?";

	public String reassignstaffid = "update challenge set staffe_id  = ? where chid = ?";

	public String view = "SELECT distinct corpgoals.cgoal_id, corpgoals.cgoalgroup, staff.staff_name, corpgoals.cgoals,corpgoals.duedate as 'corp_duedate',\r\n"
			+ " CASE WHEN challenge.chresolveDate > curdate() and strategy.duedate > curdate() and strategycategory.duedate > curdate() and  corpgoals.duedate > curdate() THEN 'on track'\r\n"
			+ "       ELSE 'not on track'\r\n" + "       END AS tracker,\r\n"
			+ "   CASE WHEN corpgoals.cstatus = 1 THEN 'active'\r\n"
			+ "      WHEN corpgoals.cstatus = 2 THEN 'on hold'\r\n"
			+ "      WHEN corpgoals.cstatus = 3 THEN 'Complete'\r\n"
			+ "      WHEN corpgoals.cstatus = 4 THEN 'under review'\r\n"
			+ "      WHEN corpgoals.cstatus = 5 THEN 'archived'\r\n"
			+ "      WHEN corpgoals.cstatus = 6 THEN 'Cancelled'\r\n" + "       ELSE 'not '\r\n"
			+ "       END AS status\r\n" + "FROM   corpgoals\r\n"
			+ "left JOIN   challenge ON corpgoals.cgoal_id = challenge.csuitegoal\r\n"
			+ "left join  strategy on strategy.goal = corpgoals.cgoal_id\r\n"
			+ "left join strategycategory on strategycategory.goal =  corpgoals.cgoal_id\r\n"
			+ "left join staff on corpgoals.ccreatedby = staff.staff_id";

//	public String getstaffid ="select staff_id from staff where staff_name =?";


	public String eventexistornot = "SELECT event,start_time,followup FROM caleventdetails WHERE start_time LIKE '%?%' AND followup LIKE '%?%'";

	public String geteventid = "select id from caleventdetails where event = ?";


	public String goaldropdown = "select cgoals from corpgoals";

	public String guidacent360view = "SELECT distinct corpgoals.cgoal_id,corpgroup.goal_group ,staff.staff_name, corpgoals.cgoals,corpgoals.duedate as corp_duedate,strategy.duedate as strat_duedate, strategycategory.duedate as category_duedate, challenge.chresolveDate,\r\n"
			+ "CASE\r\n"
			+ "WHEN strategycategory.duedate is null and strategy.duedate is not null and corpgoals.duedate is not null and challenge.chresolveDate is not null\r\n"
			+ " THEN\r\n" + "     CASE\r\n"
			+ "         WHEN (corpgoals.duedate > curdate() and strategy.duedate > curdate())\r\n"
			+ "             THEN 'on track'\r\n" + "             ELSE 'not on track'\r\n" + "         END\r\n"
			+ "WHEN strategycategory.duedate is not null and strategy.duedate is null and corpgoals.duedate is not null and challenge.chresolveDate is not null\r\n"
			+ " THEN\r\n" + "         CASE\r\n" + "                 WHEN (corpgoals.duedate > curdate())\r\n"
			+ "                 THEN 'on track'\r\n" + "                 ELSE 'not on track'\r\n" + "         END\r\n"
			+ "WHEN strategycategory.duedate is not null and strategy.duedate is not null and corpgoals.duedate is null and challenge.chresolveDate is not null\r\n"
			+ " THEN\r\n" + "         CASE\r\n"
			+ "             WHEN (strategy.duedate > curdate() and challenge.chresolveDate > curdate() and strategycategory.duedate > curdate())\r\n"
			+ "             THEN 'on track'\r\n" + "             ELSE 'not on track'\r\n" + "         END\r\n"
			+ "WHEN strategycategory.duedate is not null and strategy.duedate is not null and corpgoals.duedate is not null and challenge.chresolveDate is null\r\n"
			+ "     THEN\r\n" + "         CASE\r\n"
			+ "             WHEN (strategy.duedate > curdate() and corpgoals.duedate > curdate() and strategycategory.duedate >curdate())\r\n"
			+ "             THEN 'on track'\r\n" + "             ELSE 'not on track'\r\n" + "         END\r\n"
			+ "WHEN strategycategory.duedate is not null and strategy.duedate is not null and corpgoals.duedate is not null and challenge.chresolveDate is not null\r\n"
			+ "     THEN\r\n" + "         CASE\r\n"
			+ "             WHEN (corpgoals.duedate > curdate() and challenge.chresolveDate > curdate() and strategy.duedate >curdate() and strategycategory.duedate >curdate())\r\n"
			+ "             THEN 'on track'\r\n" + "             ELSE 'not on track'\r\n" + "         END\r\n"
			+ "     ELSE\r\n" + "         CASE\r\n" + "         WHEN (corpgoals.duedate > curdate())\r\n"
			+ "             THEN 'on track'\r\n" + "             ELSE 'not on track'\r\n" + "         END\r\n"
			+ "END AS tracker,\r\n" + " CASE\r\n"
			+ "         WHEN (select count(challenge.actionitem) from challenge where csuitegoal = corpgoals.cgoal_id AND challenge.chresolveDate < curdate() ) * 100 / (select count(challenge.actionitem)\r\n"
			+ "from challenge\r\n" + "where csuitegoal = corpgoals.cgoal_id) < '25%'\r\n"
			+ "             THEN 'Green'\r\n"
			+ "          WHEN (select count(challenge.actionitem) from challenge where csuitegoal = corpgoals.cgoal_id AND challenge.chresolveDate < curdate() ) * 100 / (select count(challenge.actionitem)\r\n"
			+ "from challenge\r\n"
			+ "where csuitegoal = corpgoals.cgoal_id) >= '25%' && (select count(challenge.actionitem) from challenge where csuitegoal = corpgoals.cgoal_id AND challenge.chresolveDate < curdate() ) * 100 / (select count(challenge.actionitem)\r\n"
			+ "from challenge\r\n" + "where csuitegoal = corpgoals.cgoal_id) < '50%'\r\n"
			+ "             THEN 'Yellow'\r\n" + "             ELSE 'Red'\r\n" + "         END AS Color,\r\n"
			+ "CASE WHEN corpgoals.cstatus = '1' THEN 'active'\r\n"
			+ "         WHEN corpgoals.cstatus = '2' THEN 'on hold'\r\n"
			+ "         WHEN corpgoals.cstatus = '3' THEN 'Complete'\r\n"
			+ "         WHEN corpgoals.cstatus = '4' THEN 'under review'\r\n"
			+ "         WHEN corpgoals.cstatus = '5' THEN 'archieved'\r\n"
			+ "         WHEN corpgoals.cstatus = '6' THEN 'Cancelled'\r\n" + "          ELSE 'not '\r\n"
			+ "          END AS status\r\n" + "FROM  corpgoals\r\n"
			+ "left JOIN (Select csuitegoal, min(chresolveDate) chresolveDate From challenge group by csuitegoal ) challenge ON corpgoals.cgoal_id = challenge.csuitegoal\r\n"
			+ "left join (Select goal, min(duedate) duedate From strategy group by goal ) strategy on strategy.goal = corpgoals.cgoal_id\r\n"
			+ "left join (Select goal, min(duedate) duedate From strategycategory group by goal ) strategycategory on strategycategory.goal = corpgoals.cgoal_id\r\n"
			+ "left join corpgroup on corpgoals.cgoalgroup = corpgroup.id\r\n"
			+ "left join staff on corpgoals.ccreatedby = staff.staff_id\r\n";
	
	
	
	
	//for the schedule meeting
	public String getstaffid = "select staff_id from staff where sec35_users_login  IN (?)";

	public String getcaleventdetails = "select * from caleventdetails";
	
	public String getstarttimes ="select start_time from caleventdetails where eventattendees LIKE CONCAT('%',?,'%') and followup =?";

	public String Schedulemeeting = "INSERT INTO caleventdetails(createdby,event,followup,start_time,end_time,eventattendees) VALUES (?,?,?,?,?,?)";

	public String setcalprivatenote = "insert into calprivatenote(event_id,createdby) values(?,?)";


}
