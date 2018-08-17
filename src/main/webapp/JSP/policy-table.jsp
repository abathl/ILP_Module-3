<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.ArrayList, java.util.Iterator, com.PolicyInfo"%>

<div id="policies-table-container">
	<!-- Custom CSS -->

	<link rel="stylesheet" href="/ClaimProcessing/CSS/claim-table.css">

	<table class="table table-striped table-hover">
		<div class="table-header">
			<div class="row">
				<h2>
					Policy <b>Requests</b>
				</h2>
			</div>
		</div>
		<thead>
			<tr>
				<th>Policy ID</th>
				<th>Policy Name</th>
				<th>Status</th>
				<th>Agent Name</th>
			</tr>
		</thead>
		<tbody>
			<%
			ArrayList<PolicyInfo> claimsList = new ArrayList<PolicyInfo>();
			//claimsList.add(new PolicyInfo(1, "Policy Name 1", "Pending", "Bruce Wayne"));
			//claimsList.add(new PolicyInfo(2, "Policy Name 2", "Approved", "Clark Kent"));
			//claimsList.add(new PolicyInfo(3, "Policy Name 3", "Rejected", "Naruto Uzumaki"));
			//claimsList.add(new PolicyInfo(4, "Policy Name 4", "Pending", "John Hancock"));
			//claimsList.add(new PolicyInfo(5, "Policy Name 5", "Approved", "Sum Ting Wong"));

			// ArrayList<ClaimInfo> claimsList = (ArrayList) request.getAttribute("claimsList");
			Iterator it = claimsList.iterator();
			while (it.hasNext()) {
				PolicyInfo c = (PolicyInfo) it.next();
		%>
			<tr>
				<td><%=c.getPolicyID()%></td>
				<td><%=c.getPolicyName()%></td>
				<td><%=c.getStatus()%></td>
				<td><%=c.getAgentName()%></td>
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