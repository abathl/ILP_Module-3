package com;

public class ClaimInfo {
	private int claimID;
	private String policyName;
	private double sumAssured;
	private String claimDate;

	public ClaimInfo(int claimID, String policyName, double sumAssured, String claimDate) {
		super();
		this.claimID = claimID;
		this.policyName = policyName;
		this.sumAssured = sumAssured;
		this.claimDate = claimDate;
	}

	public int getClaimID() {
		return claimID;
	}

	public void setClaimID(int claimID) {
		this.claimID = claimID;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public double getSumAssured() {
		return sumAssured;
	}

	public void setSumAssured(double sumAssured) {
		this.sumAssured = sumAssured;
	}

	public String getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}
	
	
}
