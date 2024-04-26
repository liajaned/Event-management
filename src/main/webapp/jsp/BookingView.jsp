<%@page import="in.co.online.Utility.ServletUtility"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.online.Bean.VenueBean"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.card-columns {
	column-count: 2;
}
</style>
<meta charset="ISO-8859-1">
<title>Booking</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br>
	<%
		UserBean bean2 = (UserBean) session.getAttribute("user");
	%>
	<div class="container text-center" style="font: italic;">
		<ul class="list-unstyled card-columns">
			<li>
				<%
					int index = 1;
					List list = ServletUtility.getList(request);
					Iterator it = list.iterator();
					while (it.hasNext()) {
						VenueBean bean = (VenueBean) it.next();
				%> <img alt="" src="/Event_Management/image?id=<%=bean.getId()%>"
				class="figure-img img-fluid rounded" alt="..." width="300"
				height="500"><br>Event Type :<%=bean.getEventtype()%> <br> Loction: <%=bean.getLocation()%><br>
				CapaCity: <%=bean.getCapacity()%><br>
				Cost :<%=bean.getCost()%><br> Date :<%=bean.getDate()%><br>
				Contact :<%=bean.getContact()%><br>
				 <%
 	if (bean2.getRoleid() == 1) {
 %>

				<button type="button" class="btn btn-success">Confirm</button> <a
				class="btn btn-info" href="<%=EM_View.PAYMENT_LIST_CTL%>">Check
					Payment</a>
				 <br> <%
 	} else {
 %> <%
 	if (bean2.getRoleid() == 2) {
 %> <a class="btn btn-info" href="<%=EM_View.PAYMENT_CTL%>">Book&
					Pay</a>
				<br> <%
 	}
 		}
 %> <br> <%
 	}
 %> <br>
			</li>
		</ul>
	</div>


	<%@include file="Footer.jsp"%>
</body>
</html>