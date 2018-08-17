<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.ArrayList, java.util.Iterator, com.ClaimInfo"%>

<div id="claims-table-container">
	<!-- Custom CSS -->
	<link rel="stylesheet" href="/ClaimProcessing/CSS/claim-table.css">

	<table class="table table-striped table-hover">
		<div class="table-header">
			<div class="row">
				<h2>
					Claim <b>Requests</b>
				</h2>
			</div>
		</div>
		<thead>
			<tr>
				<th>Claim ID</th>
				<th>Policy Name</th>
				<th>Sum Assured</th>
				<th>Claim Date</th>
			</tr>
		</thead>
		<tbody>
			<%
			ArrayList<ClaimInfo> claimsList = new ArrayList<ClaimInfo>();
			claimsList.add(new ClaimInfo(1, "Policy Name 1", 10000.00, "January 1st, 2018"));
			claimsList.add(new ClaimInfo(2, "Policy Name 2", 20000.00, "February 1st, 2018"));
			claimsList.add(new ClaimInfo(3, "Policy Name 3", 30000.00, "March 1st, 2018"));
			claimsList.add(new ClaimInfo(4, "Policy Name 4", 40000.00, "April 1st, 2018"));
			claimsList.add(new ClaimInfo(5, "Policy Name 5", 50000.00, "May 1st, 2018"));

			// ArrayList<ClaimInfo> claimsList = (ArrayList) request.getAttribute("claimsList");
			Iterator it = claimsList.iterator();
			while (it.hasNext()) {
				ClaimInfo c = (ClaimInfo) it.next();
		%>
			<tr>
				<td><%=c.getClaimID()%></td>
				<td><%=c.getPolicyName()%></td>
				<td><%=c.getSumAssured()%></td>
				<td><%=c.getClaimDate()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<div class="clearfix">
		<div class="hint-text">
			Showing <b>5</b> out of <b>25</b> entries
		</div>
		<ul class="pagination">
			<li class="page-item disabled"><a href="#">Previous</a></li>
			<li class="page-item active"><a href="#" class="page-link">1</a></li>
			<li class="page-item"><a href="#" class="page-link">2</a></li>
			<li class="page-item"><a href="#" class="page-link">3</a></li>
			<li class="page-item"><a href="#" class="page-link">4</a></li>
			<li class="page-item"><a href="#" class="page-link">5</a></li>
			<li class="page-item"><a href="#" class="page-link">Next</a></li>
		</ul>
	</div>
</div>