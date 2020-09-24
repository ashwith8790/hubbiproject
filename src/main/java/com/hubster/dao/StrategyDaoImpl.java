package com.hubster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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

public enum StrategyDaoImpl implements StrategyDao {
	instance;

	@Override
	public List<FirstInitiativeModel> getfirstactivepriority(Request activepriority) {
		List<FirstInitiativeModel> firstlist = new ArrayList<FirstInitiativeModel>();

		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.priority_one_initiative)) {
			ps.setString(1, activepriority.getAssignoto());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				FirstInitiativeModel sc = new FirstInitiativeModel();
				sc.setId(rs.getInt("id"));
				sc.setInitiative(rs.getString("initiative"));
				sc.setDuedate(rs.getDate("duedate"));

				String InitiativeDate = rs.getString("duedate");

				System.out.println(InitiativeDate);

				Collections.sort(firstlist);

				firstlist.add(sc);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return firstlist;

	}

	@Override
	public List<SecondInitiativeModel> getsecondactivepriority(Request secondactivepriority) {
		List<SecondInitiativeModel> secondlist = new ArrayList<SecondInitiativeModel>();
		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.priority_two_initiative)) {
			ps.setString(1, secondactivepriority.getAssignoto());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				SecondInitiativeModel sc = new SecondInitiativeModel();
				sc.setInitiative(rs.getString("initiative"));
				sc.setId(rs.getInt("id"));

				secondlist.add(sc);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return secondlist;
	}

	@Override
	public List<ThirdInitiativeModel> getthirdactivepriority(Request thirdactivepriority) {
		List<ThirdInitiativeModel> thirdlist = new ArrayList<ThirdInitiativeModel>();
		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.priority_three_initiative)) {
			ps.setString(1, thirdactivepriority.getAssignoto());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ThirdInitiativeModel sc = new ThirdInitiativeModel();
				sc.setId(rs.getInt("id"));
				sc.setInitiative(rs.getString("initiative"));

				thirdlist.add(sc);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return thirdlist;

	}

	@Override
	public List<PastDueInitiativeModel> getdueinitiatives(Request dueinitiatives) {
		List<PastDueInitiativeModel> duelist = new ArrayList<PastDueInitiativeModel>();
		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.due_initiatives)) {

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String currentdate = formatter.format(date);
			System.out.println(formatter.format(date));

			ps.setString(1, currentdate);
			ps.setString(2, dueinitiatives.getAssignoto());

			System.out.println(currentdate);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				PastDueInitiativeModel sc = new PastDueInitiativeModel();
				sc.setInitiative(rs.getString("initiative"));
				sc.setId(rs.getInt("id"));

				duelist.add(sc);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return duelist;
	}

	@Override
	public List<ActiveStrategyModel> activestrategygoals(Request activegoals) {
		List<ActiveStrategyModel> activelist = new ArrayList<ActiveStrategyModel>();
		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.active_strategies_goal)) {
			ps.setInt(1, activegoals.getGoal());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ActiveStrategyModel sc = new ActiveStrategyModel();
				sc.setId(rs.getInt("id"));
				sc.setCategory(rs.getString("category"));
				activelist.add(sc);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return activelist;
	}

	@Override
	public List<ChangeDueDateInitiativeModel> changeduedateinitiative(Request changedueinitiative) {
		List<ChangeDueDateInitiativeModel> duedateinitiative = new ArrayList<ChangeDueDateInitiativeModel>();
		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.change_due_date_initiative)) {

			ps.setString(1, changedueinitiative.getDuedatee());
			ps.setInt(2, changedueinitiative.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return duedateinitiative;
	}

	@Override
	public List<OneInitiativeModel> getoneinitiative(Request oneinitiative) {
		List<OneInitiativeModel> onelist = new ArrayList<OneInitiativeModel>();
		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.getting_one_initiative)) {
//			ps.setInt(1, oneinitiative.getId());
			ps.setString(1, oneinitiative.getInitiative());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OneInitiativeModel oi = new OneInitiativeModel();
				oi.setInitiative(rs.getString("initiative"));
				oi.setId(rs.getInt("id"));
				onelist.add(oi);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return onelist;
	}

	@Override
	public List<ChangeInitiativeStatusModel> getchangeinitiative(Request changeinitiative) {
		List<ChangeInitiativeStatusModel> changelist = new ArrayList<ChangeInitiativeStatusModel>();
		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.change_initiative_status)) {
			ps.setString(1, changeinitiative.getInitiativestatusid());
			ps.setInt(2, changeinitiative.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return changelist;

	}

	@Override
	public List<InitiativeModel> getinitiative(Request reiniti) {
		List<InitiativeModel> initiatives = new ArrayList<InitiativeModel>();
		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.past_get_initiative)) {
			ps.setInt(1, reiniti.getInitiativeid());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				InitiativeModel im = new InitiativeModel();
				im.setInitiative(rs.getString("initiative"));
				initiatives.add(im);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return initiatives;
	}

	@Override
	public List<CgoalModel> getsinglecgoal(Request cgoaldata) {
		List<CgoalModel> li = new ArrayList<CgoalModel>();
		try (Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.cgoals_getting)) {
			ps.setInt(1, cgoaldata.getCgoal_id());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CgoalModel cg = new CgoalModel();
				cg.setCgoals(rs.getString("cgoals"));
				cg.setCgoal_id(rs.getInt("cgoal_id"));
				li.add(cg);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<ActiveStrategyInitiativeModel> activestrategyinitiatives(Request activeinitiatives) {
		List<ActiveStrategyInitiativeModel> li = new ArrayList<ActiveStrategyInitiativeModel>();
		try(Connection conn = com.hubster.config.Database.connection();
				PreparedStatement ps = conn.prepareStatement(QueryConstants.activeinitiative_forstrategy))
		{
			ps.setString(1, activeinitiatives.getCategory());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ActiveStrategyInitiativeModel asi = new ActiveStrategyInitiativeModel();
				asi.setInitiative(rs.getString("initiative"));
				
				li.add(asi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
								return li;
	}
}
