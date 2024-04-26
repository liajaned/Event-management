<%@page import="in.co.online.Controller.EventTypeCtl"%>
<%@page import="javax.naming.event.EventContext"%>
<%@page import="in.co.online.Utility.DataUtility"%>
<%@page import="in.co.online.Utility.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Event Type</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8"  style="margin-top: 7%; background-color: yellow;">
				<form action="<%=EM_View.EVENT_TYPE_CTL%>" method="post">
					<h3 align="center" style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h3>

					<jsp:useBean id="bean" scope="request"
						class="in.co.online.Bean.EventTypeBean" />

					<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
						type="hidden" name="createdby" value="<%=bean.getCreatedby()%>">
					<input type="hidden" name="modifiedby"
						value="<%=bean.getModifiedby()%>"> <input type="hidden"
						name="createdDatetime" value="<%=bean.getCreateddatetime()%>">
					<input type="hidden" name="modifiedDateTime"
						value="<%=bean.getModifieddatetime()%>">
					<h2 align="center" style="background-color: pink;">Add Event
						Type</h2>
					<br>

					<h6 style="margin-left: 270px;">Event Name :</h6>
					<input type="text" name="eventname"
						value="<%=DataUtility.getStringData(bean.getEventname())%>"
						placeholder="Enter Event Name" style="margin-left: 270px;">

					<div class="form-text" style="color: red; margin-left: 270px;"><%=ServletUtility.getErrorMessage("eventname", request)%></div>
			<br>
			<h6 style="margin-left: 270px;">Description :</h6>
			<textarea name="description" class="form-Center"
				style="margin-left: 270px;" placeholder="Write your Description"
				cols="30" rows="3"
				value="<%=DataUtility.getStringData(bean.getDescription())%>"></textarea>
			<div class="form-text" style="color: red; margin-left: 270px;"><%=ServletUtility.getErrorMessage("description", request)%></div>
<br>

			<input type="submit" class="btn btn-primary" name="operation"
				value="<%=EventTypeCtl.OP_SUBMIT%>" style="margin-left: 270px;">


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