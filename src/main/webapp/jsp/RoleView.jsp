<%@page import="in.co.online.Controller.RoleCtl"%>
<%@page import="in.co.online.Utility.DataUtility"%>
<%@page import="in.co.online.Utility.ServletUtility"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Role</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<br>
	<div class="container">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-8">
	
	<nav style="-bs-breadcrumb-divider: '&gt;';" aria-label="breadcrumb">
		<ol class="breadcrumb" style="background-color: silver;">
			<li class="breadcrumb-item"><a href="<%=EM_View.WELCOME_CTL%>">Home</a></li>
			<li class="breadcrumb-item active" aria-current="page">Role
				Registration</li>
		</ol>
	</nav>
	<h2 style="background-color: gray;;">Role Registration</h2>
	<h6 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h6>
	<h6 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h6>
	<hr>
	<form action="<%=EM_View.ROLE_CTL%>" method="post">
		

					<jsp:useBean id="bean" scope="request"
						class="in.co.online.Bean.RoleBean" />

					<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
						type="hidden" name="createdBy" value="<%=bean.getCreatedby()%>">
					<input type="hidden" name="modifiedBy"
						value="<%=bean.getModifiedby()%>"> <input type="hidden"
						name="createdDatetime" value="<%=bean.getCreateddatetime()%>">
					<input type="hidden" name="modifiedDateTime"
						value="<%=bean.getModifieddatetime()%>">

					<div class="mb-3">
						<label class="form-label">Role Name</label> <input type="text"
							class="form-control" name="rolename"
							placeholder="Enter Role Name here..."
							value="<%=DataUtility.getStringData(bean.getRolename())%>">

						<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("rolename", request)%></div>
					</div>

					<div class="mb-3">
						<label class="form-label">Password</label> <input type="password"
							class="form-control" name="password"
							placeholder="Enter Password here..."
							value="<%=DataUtility.getStringData(bean.getPassword())%>">

						<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("password", request)%></div>
					</div>


					<input type="submit" class="btn btn-primary" name="operation"
						value="<%=RoleCtl.OP_SAVE%>">
						</form>
				</div>
				<div class="col-2"></div>
			</div>
		</div>
	<br>
	<%@include file="Footer.jsp"%>
</body>
</html>