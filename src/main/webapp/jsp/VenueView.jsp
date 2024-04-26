<%@page import="in.co.online.Bean.VenueBean"%>
<%@page import="in.co.online.Controller.VenueCtl"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="in.co.online.Utility.JDBCDataSource"%>
<%@page import="java.sql.Connection"%>
<%@page import="in.co.online.Utility.ServletUtility"%>
<%@page import="in.co.online.Utility.DataUtility"%>
<%@page import="java.util.Iterator"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
	$('.datepicker').datepicker();
</script>
<meta charset="ISO-8859-1">
<title>Venue</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8"   style="background-color: orange;">
				<form action="<%=EM_View.VENUE_CTL%>" method="post"
					enctype="multipart/form-data">


					<h2>VENUE</h2>
					<hr class="border border-primary border-3 opacity-75">
					<h6 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h6>
					<h6 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h6>
					<jsp:useBean id="bean" scope="request"
						class="in.co.online.Bean.VenueBean" />

					<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
						type="hidden" name="createdby" value="<%=bean.getCreatedby()%>">
					<input type="hidden" name="modifiedby"
						value="<%=bean.getModifiedby()%>"> <input type="hidden"
						name="createdDatetime" value="<%=bean.getCreateddatetime()%>">
					<input type="hidden" name="modifiedDateTime"
						value="<%=bean.getModifieddatetime()%>">

					<div class="container">
						<div class="col-md-12">
							<label for="exampleInputPassword1" style="font-family: cursive;">Event
								Type:</label>
						<div class="form-group">
							<select class="custom-select" name=eventtypeid>
								<%
									Connection con = JDBCDataSource.getconnection();
									String sql = "SELECT * FROM eventtype";
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
							<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("eventtypeid", request)%></div>
						</div>
					</div>

					<div class="col-12">
						<label for="inputAddress" class="form-label">Capacity:</label> <input
							type="text" class="form-control"
							name="capacity" placeholder="Enter here..."
							value="<%=DataUtility.getStringData(bean.getCapacity())%>">
					</div>
					<font color="red"><%=ServletUtility.getErrorMessage("capacity", request)%></font>

					<div class="col-12">
						<label for="inputAddress" class="form-label">Cost:</label> <input
							type="text" class="form-control"  name="cost"
							placeholder="Enter here..."
							value="<%=DataUtility.getStringData(bean.getCost())%>">
					</div>
					<font color="red"><%=ServletUtility.getErrorMessage("cost", request)%></font>


					<div class="col-12">
						<label for="inputAddress" class="form-label">Location</label> <input
							type="text" class="form-control" id="inputAddress"
							name="location" placeholder="Enter here..."
							value="<%=DataUtility.getStringData(bean.getLocation())%>">
					</div>
					<font color="red"><%=ServletUtility.getErrorMessage("location", request)%></font>

<div class="col-md-12">
						<label for="form_message">Contact:</label> <input
							class="form-control" type="text" name="contact"
							placeholder="Enter here....."
							value="<%=DataUtility.getStringData(bean.getContact())%>">
					</div>
					<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("contact", request)%></div>
				
<div class="col-md-12">

					<label for="form_message">Date:</label>

					<div class="form-group">
						<input type="text" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" name="date" id="datepicker"
							data-provide="datepicker"
							value="<%=DataUtility.getStringData(bean.getDate())%>"
							placeholder="date Enter Here"> <font color="red"><%=ServletUtility.getErrorMessage("date", request)%></font>
					</div>
</div>
					
					
					
				<div class="col-md-12">
						<label for="exampleFormControlInput1" class="form-label">Event
							Photo:</label> <br><input type="file" id="exampleFormControlInput1"
							name="image">
					</div>
					
					<br>
					 <input type="submit" class="btn btn-primary"
						name="operation" style="margin-left: 130px;"
						value="<%=VenueCtl.OP_SUBMIT%>">
</div>
				</form>
			</div>
		</div>
	</div>


	<div style="margin-top: 2%;">
		<%@include file="Footer.jsp"%>
	</div>
</body>
</html>