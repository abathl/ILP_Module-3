package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class PolicyController {
	private Connector db;
	private Connection con;
	private ResultSet rs; private ResultSet rs2;//2 result sets for when using queries on the results of a parent query
	private PreparedStatement ps;
	private Map<String, String> queries = new HashMap<String, String>();

	private Gson gson;

	//get database instance and set up the queries that will be used by this class
	public PolicyController() throws SQLException{
		db = Connector.getInstance();
		//needs input for managerID
		queries.put("get max amount for manager by id and designation",
					"SELECT maximum_claim_approval_amount FROM managers M, designations D WHERE M.manager_id = ? AND D.designation_id = M.designation_id"
		);
		//needs inputs sum_assured, managerID
		queries.put("get policies for managers without nominees",
					"SELECT PM.policy_map_id, P.policy_ID, P.policy_name, P.policy_type, P.sum_assured, P.tenure, PM.approved, C.customer_ID, C.firstname || ' ' || (CASE WHEN C.middlename IS NULL THEN '' ELSE (C.middlename || ' ') END) || C.lastname AS c_fullname, C.email AS c_email, A.agent_id, A.firstname || ' ' || (CASE WHEN A.middlename IS NULL THEN '' ELSE (A.middlename || ' ') END) || A.lastname AS A_fullname, A.email AS A_email, PM.start_date " +
					"FROM POLICIES P, CUSTOMERS C, AGENTS A, POLICYMAP PM, MANAGERS M " +
					"WHERE P.sum_assured <= ? " +
					"AND M.manager_ID = ? " +
					"AND P.policy_ID = PM.policy_ID " +
					"AND C.customer_ID = PM.customer_ID " +
					"AND A.agent_ID = PM.agent_ID"
		);
		//needs input for policy map ID, returns all nominees for that particular policy
		queries.put("get nominees for a single policy",
					"SELECT N.nominee_id, N.name , N.relationship_to_customer " +
					"FROM NOMINEES N, NOMINEEMAP NM, POLICYMAP PM " +
					"WHERE PM.policy_map_id = ?" +
					"AND NM.policy_map_id = PM.policy_map_id " +
					"AND NM.nominee_id = N.nominee_id"
		);

	}

	//gets all policies for a manager based on designation GIVEN managerID from serve-let
	public String getPoliciesForManager(int managerID) throws SQLException {
		con = db.getConnection();
		ArrayList<PolicyInfo> policies = new ArrayList<PolicyInfo>();//list of policies to be returned


		//get MAX CLAIM APPROVAL AMOUNT for the given manager based on their designation, and store it into a variable
		ps = con.prepareStatement(queries.get("get max amount for manager by id and designation"));
		ps.setInt(1, managerID);
		rs = ps.executeQuery();

		int maxApprovalAmountForManager = 0;
		while(rs.next()) {
			maxApprovalAmountForManager = rs.getInt(1);
		}
		//if the max approval amount is 0, this means that the value in db is NULL -> which means this manager can see all policies of any amount
		if(maxApprovalAmountForManager == 0) maxApprovalAmountForManager = Integer.MAX_VALUE;

		//get all the policyInfo for all policies that can be approved/rejected by this Manager -> this query does not get nominees for that particular policy
		ps = con.prepareStatement(queries.get("get policies for managers without nominees"));
		ps.setInt(1, maxApprovalAmountForManager);
		ps.setInt(2, managerID);
		rs = ps.executeQuery();

		//for each row of the table returned, put the values into a new policyInfo object,
		//and for each policyInfo object, load the nominee using a separate query
		int policyMapID = 0; PolicyInfo p; String approvedStatus;
		while(rs.next()) {
			policyMapID = rs.getInt(1);

			//IF status of policyMapping is null -> pending, if 1 then approved, if 0 then rejected
			if(rs.getObject(7) == null) approvedStatus = "Pending";
			else {
				if(rs.getInt(7) == 1) approvedStatus = "Approved";
				else approvedStatus = "Rejected";
			}

			//create new custom object to hold all policy details for the row using its constructor (note: use approvedStatus string created above)
			p = new PolicyInfo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), approvedStatus, rs.getInt(8),
					rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(12), rs.getString(13), new java.util.Date(rs.getDate(14).getTime()));
			//GET ALL NOMINEES for this particular policy by using the policyMapID
			ps = con.prepareStatement(queries.get("get nominees for a single policy"));
			ps.setInt(1, policyMapID);
			rs2 = ps.executeQuery();
			//put each nomineeID, nomineeName and relation into the custom policyInfo object's hashmap
			while(rs2.next()) {
				p.putNominee(rs2.getInt(1), rs2.getString(2) + "," + rs2.getString(3));
			}

			//add the newly created policyInfo object into the list that should be returned
			policies.add(p);
		}

		rs.close();
		rs2.close();
		ps.close();
		con.close();
		
		//convert arrayList of policies into a JSON string and return it
		gson = new Gson();
		String returnData = "{ data: " + gson.toJson(policies) + " }";
		
		return returnData;//return list of policies
	}


	public static void main(String[] args) {
		try {
			PolicyController pc = new PolicyController();
			String policies = pc.getPoliciesForManager(3);
			System.out.println(policies);

		} catch (SQLException e) {
			//err
			e.printStackTrace();
		}

	}

}
