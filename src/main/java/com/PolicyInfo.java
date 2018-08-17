package com;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class PolicyInfo {
	private int policyMapID;
	private int policyID;
	private String policyName;
	private String policyType;

	private double sumAssured;
	private double tenure;//in months
	private String status;//"pending", "approved", or "rejected"

	private int customerID;
	private String customerName;//full name
	private String customerEmail;
	private int agentID;
	private String agentName;//full name
	private String agentEmail;
	private Date startDate;//start date of policy
	private HashMap<Integer, String> nomineesAndRelationships;//stores <id, "name-->relationship"> for all nominees mapped to this policyMap


	public PolicyInfo(int policyMapID, int policyID, String policyName, String policyType, double sumAssured, double tenure, String status, int customerID,
			String customerName, String customerEmail, int agentID, String agentName, String agentEmail,
			Date startDate) {
		super();
		this.setPolicyMapID(policyMapID);
		this.policyID = policyID;
		this.policyName = policyName;
		this.policyType = policyType;
		this.sumAssured = sumAssured;
		this.tenure = tenure;
		this.status = status;
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.agentID = agentID;
		this.agentName = agentName;
		this.agentEmail = agentEmail;
		this.startDate = startDate;
		this.nomineesAndRelationships = new HashMap<Integer, String>();
	}

	//simple print for testing values are accurate
	public String toString() {
		String strRepresentation =  ("mapID: " + this.policyMapID + ", policyID: " + policyID + ", policyName: " + policyName + ", policyType: " + policyType +
				", sum assured: " + sumAssured + ", tenure: " + tenure + ", status: " + status + ", customerID: " + customerID + ", customerName: " + customerName
				+ ", customerEmail: " + customerEmail + "agentID: " + agentID + ", agentName: " + agentName + ", agentEmail: " + agentEmail + ", startDate: " + startDate.toString());
		strRepresentation += "\nNOMINEES:\n";

		Iterator<Entry<Integer, String>> it = nomineesAndRelationships.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry pair = (Map.Entry)it.next();
			strRepresentation += pair.getKey() + ", " + pair.getValue() + "\n";
		}

		strRepresentation += "\n\n\n";

		return strRepresentation;
	}

	//nominee map methods
	public void clearNominees() {
		this.nomineesAndRelationships.clear();
	}

	public void putNominee(int nomineeID, String nameAndRelation) {
		this.nomineesAndRelationships.put(nomineeID, nameAndRelation);
	}

	public HashMap<Integer, String> getNominees(){
		return this.nomineesAndRelationships;
	}


	//regular getters/setters
	public int getPolicyMapID() {
		return policyMapID;
	}

	public int getPolicyID() {
		return policyID;
	}

	public String getPolicyName() {
		return policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public double getSumAssured() {
		return sumAssured;
	}

	public double getTenure() {
		return tenure;
	}

	public String getStatus() {
		return status;
	}

	public int getCustomerID() {
		return customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public int getAgentID() {
		return agentID;
	}

	public String getAgentName() {
		return agentName;
	}

	public String getAgentEmail() {
		return agentEmail;
	}

	public Date getStartDate() {
		return startDate;
	}
	public void setPolicyMapID(int policyMapID) {
		this.policyMapID = policyMapID;
	}
	public void setPolicyID(int policyID) {
		this.policyID = policyID;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public void setSumAssured(double sumAssured) {
		this.sumAssured = sumAssured;
	}

	public void setTenure(double tenure) {
		this.tenure = tenure;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public void setAgentEmail(String agentEmail) {
		this.agentEmail = agentEmail;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



}