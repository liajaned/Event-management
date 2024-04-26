<%@page import="in.co.online.Controller.RegistrationCtl"%>
<%@page import="in.co.online.Controller.RoleCtl"%>
<%@page import="in.co.online.Utility.DataUtility"%>
<%@page import="in.co.online.Utility.ServletUtility"%>
<%@page import="in.co.online.Utility.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="in.co.online.Utility.JDBCDataSource"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8">

<h2>Registration</h2>
				<h6 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h6>
				<h6 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h6>
				<hr>
				<form action="<%=EM_View.REGISTRATION_CTL%>" method="post">
					<jsp:useBean id="bean" scope="request"
						class="in.co.online.Bean.UserBean" />

					<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
						type="hidden" name="createdBy" value="<%=bean.getCreatedby()%>">
					<input type="hidden" name="modifiedBy"
						value="<%=bean.getModifiedby()%>"> <input type="hidden"
						name="createdDatetime" value="<%=bean.getCreateddatetime()%>">
					<input type="hidden" name="modifiedDateTime"
						value="<%=bean.getModifieddatetime()%>">

					
					<div class="form-group">
						<label for="firstName" class="col-sm-3 control-label">First
							Name</label>
						<div class="col-sm-9">
							<input type="text" name="firstName" placeholder="First Name"
								class="form-control"
								value="<%=DataUtility.getStringData(bean.getFirstName())%>">
						</div>
					</div>
					<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("firstName", request)%></div>

					<div class="form-group">
						<label for="lastName" class="col-sm-3 control-label">Last
							Name</label>
						<div class="col-sm-9">
							<input type="text" name="lastName" placeholder="Last Name"
								class="form-control" value="">
						</div>
					</div>
					<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("lastname", request)%></div>

					<div class="form-group">
						<label for="email" class="col-sm-3 control-label">Email* </label>
						<div class="col-sm-9">
							<input type="email" name="email" placeholder="Email"
								class="form-control"
								value="<%=DataUtility.getStringData(bean.getEmail())%>">
						</div>
					</div>
					<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("email", request)%></div>

					<div class="form-group">
						<label for="password" class="col-sm-3 control-label">Password*</label>
						<div class="col-sm-9">
							<input type="password" name="password" placeholder="Password"
								class="form-control"
								value="<%=DataUtility.getStringData(bean.getPassword())%>">
						</div>
					</div>
					<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("password", request)%></div>

					<%
						HashMap<String, String> map = new HashMap<String, String>();
						map.put("Male", "Male");
						map.put("Female", "Female");
					%>

					<div class="mb-3" style="width:75%">
						<label class="form-label">Gender:</label>
						<%=HTMLUtility.getlist("gender", String.valueOf(bean.getGender()), map)%>
						<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("gender", request)%></div>
					</div>


					
						<%-- <label for="exampleInputPassword1">Role:</label>
						<div class="form-group">
							<select class="custom-select" name=rolename  style="width:75%; height: 35px;">
								<%
									Connection con = JDBCDataSource.getconnection();
									String sql = "SELECT * FROM role";
									PreparedStatement ps = con.prepareStatement(sql);
									ResultSet rs = ps.executeQuery();
									while (rs.next()) {
								%>

								<option value="--------Select--------"></option>
								<option value="<%=rs.getLong(1)%>"><%=rs.getString(2)%></option>

								<%
									}
								%>
							</select>
				<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("rolename", request)%></div>
						</div> --%>
						<input type="submit" class="btn btn-primary" name="operation"
							value="<%=RegistrationCtl.OP_SUBMIT%>">
					</div>
				</form>
			</div>
			<div class="col-2"></div>
		</div>
	<br>
	<div style="margin-top: 2%;">
		<%@include file="Footer.jsp"%>
	</div>
</body>
</html>