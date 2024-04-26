<%@page import="in.co.online.Controller.LoginCtl"%>
<%@page import="in.co.online.Utility.DataUtility"%>
<%@page import="in.co.online.Utility.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8">
				<h4 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h4>
				<h4 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h4>
			
				<form action="<%=EM_View.LOGIN_CTL%>" method="post">

					<jsp:useBean id="bean" scope="request"
						class="in.co.online.Bean.UserBean" />

					<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
						type="hidden" name="createdBy" value="<%=bean.getCreatedby()%>">
					<input type="hidden" name="modifiedBy"
						value="<%=bean.getModifiedby()%>"> <input type="hidden"
						name="createdDatetime" value="<%=bean.getCreateddatetime()%>">
					<input type="hidden" name="modifiedDateTime"
						value="<%=bean.getModifieddatetime()%>">

					<h3 class="mb-5">Sign in</h3>
	<hr>
					<div class="form-outline mb-4">
						<label class="form-label" for="typeEmailX-2">Email</label> <input
							type="email" id="typeEmailX-2" name="email"
							value="<%=DataUtility.getStringData(bean.getEmail())%>"
							class="form-control form-control-lg" />
						<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("email", request)%></div>
					</div>

					<div class="form-outline mb-4">
						<label class="form-label" for="typePasswordX-2">Password</label> <input
							type="password" id="typePasswordX-2" name="password"
							value="<%=DataUtility.getStringData(bean.getPassword())%>"
							class="form-control form-control-lg" />
						<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("password", request)%></div>
					</div>


					<br> <input type="submit" class="btn btn-primary"
						name="operation" value="<%=LoginCtl.OP_SINGIN%>">

					<%-- <hr class="my-4">
					<a href="<%=EM_View.ROLE_CTL%>">
						<button class="btn btn-lg btn-block btn-primary"
							style="background-color: #dd4b39;" type="submit">
							<i class="fab fa-google me-2"></i>ROLE Registration
						</button>
					</a>&nbsp; <a href="<%=EM_View.REGISTRATION_CTL%>">
						<button class="btn btn-lg btn-block btn-primary mb-2"
							style="background-color: #3b5998;" type="submit">
							<i class="fab fa-facebook-f me-2"></i>USER Registration
						</button>
					</a> --%>

				</form>
			</div>
			<div class="col-2"></div>
		</div>
	</div>
	<br>
	<div style="margin-top: 7%;">
		<%@include file="Footer.jsp"%>
	</div>
</body>
</html>