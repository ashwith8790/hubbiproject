package com.hubster.dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import com.mysql.cj.Query;

public enum TodoDaoImpl implements TodoDao {
	instance;

	Logger logger = LoggerFactory.getLogger(TodoDaoImpl.class);

	@Override
	public List<ActionModel> getActionItem(Request requests) {

		List<ActionModel> actionlist = new ArrayList<ActionModel>();

		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps5 = conn.prepareStatement(QueryConstants.get_action_item)) {
//			ps5.setString(1, requests.getChassignid());
			
			ps5.setString(1, requests.getStaffe_id());

			ResultSet rs = ps5.executeQuery();

			while (rs.next()) {

				ActionModel em = new ActionModel();

				em.setActionItem(rs.getString("actionItem"));
				
				em.setChid(rs.getInt("chid"));
				em.setChresolveDate(rs.getDate("chresolveDate"));


				System.out.println(em);

				actionlist.add(em);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actionlist;
	}

	@Override
	public List<ActionModel> updateActionItem(Request re) {
		List<ActionModel> updatedata = new ArrayList<ActionModel>();
		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement psupdate = conn.prepareStatement(QueryConstants.update_action_item)) {

			psupdate.setString(1, re.getDuedatee());
			// psupdate.setInt(2, re.getActionid());
			psupdate.setInt(2, re.getChidd());
			psupdate.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return updatedata;
	}

	@Override
	public List<ActionModel> deleteActionItem(Request reqs) {
		List<ActionModel> deletedata = new ArrayList<ActionModel>();
		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement psdelete = conn.prepareStatement(QueryConstants.delete_action_item)) {
			// psdelete.setInt(1, reqs.getActionid());
			psdelete.setInt(1, reqs.getChidd());
			psdelete.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deletedata;

	}

	@Override
	public List<ActionsModel> actionItemDueDate(Request reqduedate) {
		List<ActionsModel> duedatedata = new ArrayList<ActionsModel>();
		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement psduedate = conn.prepareStatement(QueryConstants.action_item_due_today)) {

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();

			String currentdate = formatter.format(date);

			psduedate.setString(2, currentdate);

			System.out.println(currentdate);

			psduedate.setString(1, reqduedate.getStaffe_id());

			ResultSet rs = psduedate.executeQuery();

			while (rs.next()) {

				ActionsModel am = new ActionsModel();

				am.setTotal(rs.getInt("total"));
				duedatedata.add(am);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return duedatedata;
	}

	@Override
	public List<GoalModel> getAllGoals(Request getgoal) {

		List<GoalModel> goallist = new ArrayList<GoalModel>();

		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.getgoals)) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				GoalModel hgl = new GoalModel();
//				hgl.setCgoalgroup(rs.getString("cgoalgroup"));
				hgl.setGoal_group(rs.getString("goal_group"));


				System.out.println(hgl.getCgoal_id());

				goallist.add(hgl);

				System.out.println("java object******** " + goallist);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return goallist;
	}

	@Override
	public List<HubbiGoals> updatestatusgoal(Request updategoal) {
		List<HubbiGoals> updategoallist = new ArrayList<HubbiGoals>();
		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.updatestatusgoal)) {
			ps.setString(1, updategoal.getCorpgoalstatus());
			ps.setInt(2, updategoal.getCgoal_id());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return updategoallist;
	}

	@Override
	public List<HubbiOnHold> getGoalsOnHold(Request getonhold) {
		List<HubbiOnHold> getgoalsonhold = new ArrayList<HubbiOnHold>();
		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.goalsonhold)) {
			ps.setString(1, getonhold.getCcreatedby());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				HubbiOnHold hg = new HubbiOnHold();
				hg.setCgoals(rs.getString("cgoals"));
				hg.setCgoal_id(rs.getInt("cgoal_id"));
				getgoalsonhold.add(hg);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getgoalsonhold;
	}

	@Override
	public List<HubbiOnHold> getGoalsUnderReview(Request getunderreview) {
		List<HubbiOnHold> underreview = new ArrayList<HubbiOnHold>();
		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.goalsunderreview)) {
			ps.setString(1, getunderreview.getCcreatedby());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HubbiOnHold hgs = new HubbiOnHold();
				hgs.setCgoals(rs.getString("cgoals"));
				hgs.setCgoal_id(rs.getInt("cgoal_id"));
				underreview.add(hgs);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return underreview;
	}

	@Override
	public List<CgoalModel> getcgoals(Request cgoals) {
		List<CgoalModel> getcgoals = new ArrayList<CgoalModel>();
		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.cgoals_getting)) {
			ps.setString(1, cgoals.getGoal_group());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CgoalModel hg = new CgoalModel();
				hg.setCgoals(rs.getString("cgoals"));
				hg.setCgoal_id(rs.getInt("cgoal_id"));
				getcgoals.add(hg);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getcgoals;
	}

//	@Override
//	public List<HubbiGoals> reassign_goal(Request regoal) {
//		List<HubbiGoals> reassign = new ArrayList<HubbiGoals>();
//		try (Connection conn = com.hubster.config.Database.connection();
//				PreparedStatement ps = conn.prepareStatement(QueryConstants.reassign_goal)) {
//			ps.setString(1, regoal.getCcreatedby());
//			ps.setInt(2, regoal.getCgoal_id());
//			ps.executeUpdate();
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return reassign;
//
//	}

	@Override
	public List<CgoalModel> getsingelgoal(Request singlegoal) {
		List<CgoalModel> getcgoals = new ArrayList<CgoalModel>();
		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.singlegoal)) {
			// ps.setString(1, cgoals.getUser_goal_id());
//			ps.setInt(1, singlegoal.getCgoal_id());
//			ps.setString(1,singlegoal.getCgoals());
			// ps.setString(1, cgoals.getCgoalgroup());
			ps.setString(1, singlegoal.getCgoals());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CgoalModel hg = new CgoalModel();
				hg.setCgoals(rs.getString("cgoals"));
				hg.setCgoal_id(rs.getInt("cgoal_id"));
				getcgoals.add(hg);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getcgoals;

	}

	@Override
	public List<ActiveStrategyGoalModel> getactivestrategygoal(Request singleactivegoal) {
		List<ActiveStrategyGoalModel> li = new ArrayList<ActiveStrategyGoalModel>();
		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.single_strategy_active_goal)) {
//			ps.setInt(1, singleactivegoal.getId());
			ps.setString(1, singleactivegoal.getCategory());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ActiveStrategyGoalModel am = new ActiveStrategyGoalModel();
				am.setId(rs.getInt("id"));
				am.setCategory(rs.getString("category"));
				li.add(am);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;

	}

	@Override
	public List<LoginModel> getusername(Request loginname) {
		List<LoginModel> loginlist = new ArrayList<LoginModel>();

		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.login)) {

			String user_name = loginname.getLoginuser();

			ps.setString(1, user_name);
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] hashInBytes = md.digest(loginname.getPassword().getBytes(StandardCharsets.UTF_8));

			StringBuilder sb = new StringBuilder();
			for (byte b : hashInBytes) {
				sb.append(String.format("%02x", b));
			}

			String password1 = sb.toString();
			System.out.println(password1);

			ps.setString(2, password1);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				LoginModel loginmodel = new LoginModel();
				loginmodel.setLogin(rs.getString("login"));
				loginmodel.setPswd(rs.getString("pswd"));
				loginmodel.setLogin_id(rs.getInt("login_id"));

				String username = rs.getString("login");
				String password = rs.getString("pswd");
				int loginid = rs.getInt("login_id");

				System.out.println(loginid);
				if ((user_name.equals(username)) && (password1.equals(password))) {

					System.out.println("Username and Password exist");

				} else {
					System.out.println("Please Check Username and Password");

				}

				loginlist.add(loginmodel);
				System.out.println(username);
				System.out.println(password);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginlist;
	}

	@Override
	public List<ActionModel> updatestatusactionitem(Request req) {
		List<ActionModel> li = new ArrayList<ActionModel>();
		try(Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.update_action_item_status)){
					ps.setString(1, req.getChstatus());
					ps.setInt(2,req.getChidd());
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		return li;
	}

	@Override
	public List<ReassignLoginModel> getreassignlogin(Request reassignname) {
		List<ReassignLoginModel> rl = new ArrayList<ReassignLoginModel>();
		int loginidvalue = 0;

		try(Connection conn = com.hubster.config.Database.connection();
			PreparedStatement ps = conn.prepareStatement(QueryConstants.reassignlogin)){
			ps.setString(1, reassignname.getLoginuser());
			System.out.println(reassignname.getLoginuser());
				
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
//				ReassignLoginModel rlm = new ReassignLoginModel();
//				rlm.setLogin(rs.getString("login"));
//				rlm.setPassword(rs.getString("pswd"));
//				rlm.setLoginid(rs.getInt("login_id"));
				loginidvalue = rs.getInt("login_id");
				System.out.println("loginidvalue:"+loginidvalue);

//				rl.add(rlm);
//				System.out.println("relogin info"+rl);
}
			
			PreparedStatement ps1 = conn.prepareStatement(QueryConstants.reassignstaffid);{
				ps1.setInt(1, loginidvalue);
				ps1.setInt(2, reassignname.getChidd());
			    ps1.executeUpdate();
			}
						

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rl;
	}

	@Override
	public List<HubbiGoals> updatedategoal(Request updatedate) {
		List<HubbiGoals> hg = new ArrayList<HubbiGoals>();
		try(Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.updategoaldate)){
			ps.setString(1, updatedate.getDuedatee());
			ps.setInt(2, updatedate.getCgoal_id());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hg;
	}

	@Override
	public List<ActionModel> getinfoactionitem(Request getactiondata) {
		ArrayList<ActionModel> li = new ArrayList<ActionModel>();
		try(Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.getfullinfoactionitem)){
			ps.setString(1, getactiondata.getActionItem());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ActionModel am = new ActionModel();
				am.setChid(rs.getInt("chid"));
				am.setActionItem(rs.getString("actionitem"));
				am.setChresolveDate(rs.getDate("chresolveDate"));
				am.setChstatus(rs.getString("chstatus"));
				li.add(am);
				
				
				
			}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return li;
	}

//	@Override
//	public List<ScheduleMeetingModel> getmeeting(Request getmeetingRequest) {
//		List<ScheduleMeetingModel> sm = new ArrayList<ScheduleMeetingModel>();
//		int s1 = 0;
//		int s2 = 0;
//		try (Connection conn = com.hubster.config.Database.connection();
//				PreparedStatement ps = conn.prepareStatement(QueryConstants.getstaffid)) {
//			ps.setString(1, getmeetingRequest.getEventattendees());
//			System.out.println("********"+getmeetingRequest.getEventattendees());
//			ResultSet rs = ps.executeQuery();
//			
//			while (rs.next()) {
////				ScheduleMeetingModel smm = new ScheduleMeetingModel();
////				smm.setStaff_id(rs.getInt("staff_id"));
//				s1 = rs.getInt("staff_id");
//				System.out.println("staffid data"+s1);
////				sm.add(smm);
//			}
//			PreparedStatement ps1 = conn.prepareStatement(QueryConstants.Schedulemeeting);{
//				ps1.setInt(1, getmeetingRequest.getCreatedby());
//				ps1.setString(2, getmeetingRequest.getEvent());
//				ps1.setString(3, getmeetingRequest.getFollowup());
//				ps1.setString(4, getmeetingRequest.getStarttime());
//				ps1.setString(5, getmeetingRequest.getEndtime());
////				ps1.setString(4, getmeetingRequest.getAgenda());
//				ps1.setInt(6, s1);
//			    ps1.executeUpdate();
//			}
//			
//			PreparedStatement ps5 =  conn.prepareStatement(QueryConstants.eventexistornot);{
//				ps5.setString(1, getmeetingRequest.getStarttime());
//				ps5.setString(2, getmeetingRequest.getFollowup());
//			    ps5.executeQuery();
//			    System.out.println(ps5.executeQuery());
//			    
//
//
//			}
//			
//			PreparedStatement ps2 = conn.prepareStatement(QueryConstants.geteventid);{
//				ps2.setString(1, getmeetingRequest.getEvent());
//				System.out.println("passing event value-------"+getmeetingRequest.getEvent());
//				ResultSet rs2 = ps2.executeQuery();
//				while (rs2.next()) {
//
//				s2 = rs2.getInt("id");
//				System.out.println("s2 value"+s2);
////				System.out.println("-----------"+rs2.getInt("id"));
////				while (rs2.next()) {
////					s2 = rs2.getInt("id");
////					s3 = rs2.getInt("createdby");
//
////					ScheduleMeetingModel sm2 = new ScheduleMeetingModel();
////					eventid = sm2.getEventid();
////					System.out.println("==========="+s2);
//					//createduser = sm2.get
//					
//				}
//
//			}
//			PreparedStatement ps3 = conn.prepareStatement(QueryConstants.setcalprivatenote);{
//				ps3.setInt(1, s2);
//				ps3.setInt(2,  getmeetingRequest.getCreatedby());
//				ps3.executeUpdate();
//			}
//			
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return sm;
//	}
//	
//	@Override
//	public List<GoalsHighLevelModel> getalldata(Request getdata) {
//		List<GoalsHighLevelModel> gl = new ArrayList<GoalsHighLevelModel>();
//		try (Connection conn = com.hubster.config.Database.connection();
//				PreparedStatement ps = conn.prepareStatement(QueryConstants.goalshighlevel)) {
//			ps.setString(1, getdata.getCgoals());
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				GoalsHighLevelModel gh = new GoalsHighLevelModel();
//				gh.setCgoal_id(rs.getInt("cgoal_id"));
//				gh.setGoal_group(rs.getString("goal_group"));
//				gh.setStaff_name(rs.getString("staff_name"));
//				gh.setCgoals(rs.getString("cgoals"));
//				gh.setCorp_duedate(rs.getString("corp_duedate"));
//				gh.setStrat_duedate(rs.getString("strat_duedate"));
//				gh.setCategory_duedate(rs.getString("category_duedate"));
//				gh.setChresolveDate(rs.getString("chresolveDate"));
//				gh.setTracker(rs.getString("tracker"));
//				gh.setStatus(rs.getString("status"));
//
//				gl.add(gh);
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return gl;
//	}


	@Override
	public String getmeeting(Request getmeetingRequest) {
//		List<ScheduleMeetingModel> sm = new ArrayList<ScheduleMeetingModel>();
		String sm = "";

		String finalvalue = null;
		int s1 = 0;
		int s2 = 0;
		String excreatedvalue = null;
		String exeventvalue;
		String exstartdate = null;
		String exendtime = null;
		String exstartvaluetime = null;

		String dbcreatedby = null;
		String dbstart_time = null;
		String dbevent = null;
		String dbfollowup = null;
		String firststart_time = null;
		String firstendtime = null;
		String dbeventattendees = null;
		String dbendtime = null;
		String exattendees = null;
		int staffid = 0;
		// Anu Test
		String time1 = "";
		String time2 = "";
		String time3 = "";
		String newtime = "04:00:00";
		String[] a = new String[5];
		String IMPID = null;

		// Anu Test
		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement psattend = conn.prepareStatement(QueryConstants.getstaffid)) {

			String abc = getmeetingRequest.getEventattendees();
			
			System.out.println("abc value is:"+abc);
			
			String idds ="";

			if (abc.charAt(0) == '@') {
				String str[] = abc.split("@");
				for (int j = 1; j < str.length; j++) {
					finalvalue = "'" + StringUtils.join(str, "','") + "'";
					finalvalue = finalvalue.substring(3, finalvalue.length());
					psattend.setString(1, str[j]);
					ResultSet rsone = psattend.executeQuery();
					while (rsone.next()) {

						staffid = rsone.getInt("staff_id");
						idds += staffid + ";";
					}

					System.out.println("if block attendee:"+finalvalue);
				}

			}
			else {
//				String z = abc.replaceAll("\\s", "");
				String str[] = abc.split(" next attendee ");
				for (int j = 0; j < str.length; j++) {
					finalvalue = "'" + StringUtils.join(str, "','") + "'";
					finalvalue = finalvalue.substring(0, finalvalue.length());
					psattend.setString(1, str[j]);
					ResultSet rsone = psattend.executeQuery();
					while (rsone.next()) {
						staffid = rsone.getInt("staff_id");
						idds += staffid + ";";
					}

					System.out.println("else block attendee:"+finalvalue);			
					}

			}

			
			
			 
			
			
			idds = idds.substring(0, idds.length() - 1);
			
			System.out.println("after last"+idds);

			PreparedStatement ps4 = conn.prepareStatement(QueryConstants.getcaleventdetails);
			{
				ResultSet rs4 = ps4.executeQuery();
				int extracted_attendess_availability = 0;
				int db_attendess_availability = 0;
				int cannot_create_variable = 0;

				excreatedvalue = getmeetingRequest.getCreatedby();
				
				System.out.println("excreatedvalue:"+excreatedvalue);
				
				exeventvalue = getmeetingRequest.getEvent();
				exstartdate = getmeetingRequest.getFollowup();
				
				System.out.println("exstartdate:"+exstartdate);

				
				firststart_time = getmeetingRequest.getStarttime();

				String strDate = firststart_time;
				SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
				SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
				Date date = sdf2.parse(strDate);
				exstartvaluetime = sdf1.format(date);
				
				System.out.println("exstartvaluetime:"+exstartvaluetime);

				System.out.println("starttime we enter=============" + exstartvaluetime);

				firstendtime = getmeetingRequest.getEndtime();

				String strDateone = firstendtime;
				SimpleDateFormat sdf11 = new SimpleDateFormat("HH:mm:ss");
				SimpleDateFormat sdf22 = new SimpleDateFormat("HH:mm");
				Date dateone = sdf22.parse(strDateone);
				exendtime = sdf11.format(dateone);
				System.out.println("endtime we enter=============" + exendtime);
				System.out.println("idds:" + idds);

				exattendees = idds;
				

				while (rs4.next()) {
					
					dbcreatedby = rs4.getString("createdby");
					dbfollowup = rs4.getString("followup");
					dbstart_time = rs4.getString("start_time");
					dbevent = rs4.getString("event");
					dbendtime = rs4.getString("end_time");
					dbeventattendees = rs4.getString("eventattendees");

					ScheduleMeetingModel sc = new ScheduleMeetingModel();
					sc.setCreatedby(rs4.getString("createdby"));
					dbcreatedby = rs4.getString("createdby");
					System.out.println("dbcreatedby:"+dbcreatedby);
					

					sc.setFollowup(rs4.getString("followup"));
					dbfollowup = rs4.getString("followup");
					

					sc.setStart_time(rs4.getString("start_time"));
					dbstart_time = rs4.getString("start_time");
					
					System.out.println("dbstart_time:"+dbstart_time);


					sc.setEvent(rs4.getString("event"));
					dbevent = rs4.getString("event");

					sc.setEnd_time(rs4.getString("end_time"));
					dbendtime = rs4.getString("end_time");

					sc.setEventattendees(rs4.getString("eventattendees"));
					dbeventattendees = rs4.getString("eventattendees");

					try {
						if (dbfollowup.equals(exstartdate) && dbstart_time.equals(exstartvaluetime)) {
							if (dbcreatedby.equals(excreatedvalue)) {
								cannot_create_variable = 1;
								break;

							} else {
							}

						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

				if (cannot_create_variable == 1) {
					System.out.println("can't create a value");
					sm = "can't create a value";

					// --------------------ANu Test-----------------------------------

					String StartTime = "";
					String xyz = idds;// 23;34;35
					System.out.println("xyz value" + xyz);
					String str1[] = xyz.split(";");
					PreparedStatement ps5 = conn.prepareStatement(QueryConstants.getstarttimes);
					{
						for (int i = 0; i < str1.length; i++) {

							int inum = Integer.parseInt(str1[i]);
							ps5.setInt(1, inum);
							ps5.setString(2, getmeetingRequest.getFollowup());
							ResultSet rs = ps5.executeQuery();
							while (rs.next()) {
								StartTime = rs.getString("start_time");
							}

							a[i] = StartTime;

						}
					}

					try {
						SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
						timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

						Date newdate = timeFormat.parse(newtime);

						int k = 0;
						Date[] date11 = new Date[100];
						int zx = 0;
						for (k = 0; k < a.length; k++) {
							if (a[k] != null) {
//				        		System.out.println("---above---");
								date11[k] = timeFormat.parse(a[k]);
//				             System.out.println(date11[k]);
								zx++;
							}
						}
//				        System.out.println("--------hi anu------------");
						Date daa = getLargest(date11, zx);
						long sum = daa.getTime() + newdate.getTime();
						String newavailabletime = timeFormat.format(new Date(sum));
//				        System.out.println("--------hi anu1------------");
						Date daa1 = getSmallest(date11, zx);
						long sum1 = daa1.getTime() - newdate.getTime();
						String newavailabletime1 = timeFormat.format(new Date(sum1));
//				        System.out.println("--------hi anu2------------");
						System.out.println("New Available Time After: " + newavailabletime);
						System.out.println("New Available Time Before: " + newavailabletime1);
						sm += "New Available Time Before: " + newavailabletime1;
						sm += " New Available Time After: " + newavailabletime;
//				        System.out.println("--------hi anu3------------");
//						---------------mmmmm

					} catch (Exception e) {
						// The handling for the code
					}

					// --------------------ANu Test-----------------------------------

				} else {
					if (extracted_attendess_availability == 1 || db_attendess_availability == 1) {
						System.out.println("can't create a event attendess not available");
						sm = "can't create a event attendess not available";

						// --------------------ANu Test-----------------------------------

						String StartTime = "";
						String xyz = idds;// 23;34;35
						String str1[] = xyz.split(";");
						PreparedStatement ps5 = conn.prepareStatement(QueryConstants.getstarttimes);
						{
							for (int i = 0; i < str1.length; i++) {

								int inum = Integer.parseInt(str1[i]);
								ps5.setInt(1, inum);
								ps5.setString(2, getmeetingRequest.getFollowup());
								ResultSet rs = ps5.executeQuery();
								while (rs.next()) {
									StartTime = rs.getString("start_time");
								}

								a[i] = StartTime;

							}
						}

						try {
							SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
							timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

							Date newdate = timeFormat.parse(newtime);
							System.out.println("--------hi anu------------");
//							---------------mmmmm
							int k = 0;
							Date[] date11 = new Date[100];
							// Date anewdate = timeFormat.parse(newtime);
							int zx = 0;
							for (k = 0; k < a.length; k++) {
								if (a[k] != null) {
//					        		System.out.println("---above---");
									date11[k] = timeFormat.parse(a[k]);
//					             System.out.println(date11[k]);
									zx++;
								}
							}
							Date daa = getLargest(date11, zx);
							long sum = daa.getTime() + newdate.getTime();
							String newavailabletime = timeFormat.format(new Date(sum));

							Date daa1 = getSmallest(date11, zx);
							long sum1 = daa1.getTime() - newdate.getTime();
							String newavailabletime1 = timeFormat.format(new Date(sum1));

							System.out.println("New Available Time After: " + newavailabletime);
							System.out.println("New Available Time Before: " + newavailabletime1);
							sm += "New Available Time Before: " + newavailabletime1;
							sm += " New Available Time After: " + newavailabletime;
//							---------------mmmmm							

						} catch (Exception e) {
							// The handling for the code
						}

						// --------------------ANu Test-----------------------------------
					} else {
						System.out.println("createeee an event");
						sm = "createeee an event";

						PreparedStatement ps1 = conn.prepareStatement(QueryConstants.Schedulemeeting);
						{
							ps1.setString(1, getmeetingRequest.getCreatedby());
							excreatedvalue = getmeetingRequest.getCreatedby();
//							System.out.println(excreatedvalue + "-----excreatedvalue------------");

							ps1.setString(2, getmeetingRequest.getEvent());
							exeventvalue = getmeetingRequest.getEvent();
//							System.out.println(exeventvalue + "-------exeventvalue-----------------");

							ps1.setString(3, getmeetingRequest.getFollowup());
							exstartdate = getmeetingRequest.getFollowup();
//							System.out.println(exstartdate + "--------exstartdate----------------");

							ps1.setString(4, getmeetingRequest.getStarttime());
							exstartvaluetime = getmeetingRequest.getStarttime();
//							System.out.println(exstartvaluetime + "---------exstartvaluetime------------------");

							ps1.setString(5, getmeetingRequest.getEndtime());
							exendtime = getmeetingRequest.getEndtime();
//							System.out.println(exendtime + "--------------exendtime------------");

							ps1.setString(6, idds);
//							System.out.println("--------idds------" + idds);
							exattendees = idds;
//							System.out.println(exattendees + "----------exattendees------------");
							ps1.executeUpdate();
						}

					}
				}
			}

			PreparedStatement ps3 = conn.prepareStatement(QueryConstants.setcalprivatenote);
			{
				ps3.setInt(1, s2);
				ps3.setString(2, getmeetingRequest.getCreatedby());
				ps3.executeUpdate();
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return sm;
	}

	public static Date getLargest(Date[] a, int total) {
		Date temp;
		for (int i = 0; i <= total; i++) {
			for (int j = i + 1; j < total; j++) {
				if (a[i].getTime() > a[j].getTime()) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a[total - 1];
	}

	public static Date getSmallest(Date[] a, int total) {
		Date temp;
		for (int i = 0; i <= total; i++) {
			for (int j = i + 1; j < total; j++) {
				if (a[i].getTime() > a[j].getTime()) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a[0];
	}

	@Override
	public List<GoalsHighLevelModel> getalldata(Request getdata) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<FlashModel> getflashdata(Request flash) {
//		
//		List<FlashModel> fm = new ArrayList<FlashModel>();
//		
//		int loginid=0;
//		String chduedate = null;
//		String currentdate = null;
//		
//		try(Connection conn = com.hubster.config.Database.connection();
//				PreparedStatement ps = conn.prepareStatement(QueryConstants.flash)){
//			 
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//			Date date = new Date();
//			currentdate = formatter.format(date);
//
//			System.out.println("---currentdate---flash----"+currentdate);
//
//			loginid = flash.getStaffe_id();
////			chduedate = flash.getChresolveDate();
//			ps.setInt(1, loginid);
//			ps.setString(2, currentdate);
//			ps.setInt(3, loginid);
//			ps.setString(4, currentdate);
//			ps.setInt(5, loginid);
//			ps.setString(6, currentdate);
//
//
//			
////			ps.setString(2, flash.getChresolveDate());
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				FlashModel hg = new FlashModel();
//				
//				hg.setActionitemtotal(rs.getInt("Actionitemtotal"));
//				hg.setGoalstotal(rs.getInt("goalstotal"));
//				hg.setStrategycategorytotal(rs.getInt("strategycategorytotal"));
//				fm.add(hg);
//			}
//			
//
//			
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		
//		return fm;
//	}

	
}