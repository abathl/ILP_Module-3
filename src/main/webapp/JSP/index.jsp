<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import = "com.PolicyInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="/ClaimProcessing/CSS/index.css">

<%@ include file="/JSP/header.jsp"%>
<body>
	<%@ include file="sidebar.jsp"%>

	<div id="content-container">
		<div class="header">
			<div class="row">
				<div id="col collapse-button-container">
					<button type="button" id="sidebarCollapse" class="navbar-btn">
						<span></span> <span></span> <span></span>
					</button>
				</div>
				<div class="col">
					<h2>
						Claim <b>Requests</b>
					</h2>
				</div>

			</div>
		</div>
		<%@ include file="/JSP/policy-table.jsp"%>
	</div>
	<%@ include file="/JSP/footer.jsp"%>
</body>

</html>