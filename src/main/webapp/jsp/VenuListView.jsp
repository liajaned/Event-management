<%@page import="in.co.online.Bean.VenueBean"%>
<%@page import="in.co.online.Utility.ServletUtility"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Venue List</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br>
	<h2 align="center">Venue List</h2>
	<hr>
	<br>
	<h4 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h4>
	<h4 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h4>

	<table class="table table-warning table-striped">
		<tr>
			<th scope="col" style="color: blue">ID</th>
			<th scope="col" style="color: blue">Image</th>
			<th scope="col" style="color: blue">Location</th>
				<th scope="col" style="color: blue">Capacity</th>
			<th scope="col" style="color: blue">Cost</th>
			<th scope="col" style="color: blue">Contact</th>
			<th scope="col" style="color: blue">Date</th>
			<th scope="col" style="color: blue">EventType</th>
			<th scope="col" style="color: blue">Action</th>
		</tr>
		<%
			int index = 1;
			List list = ServletUtility.getList(request);
			Iterator it = list.iterator();
			while (it.hasNext()) {
				VenueBean bean = (VenueBean) it.next();
		%>
		<tr style="">

			<th scope="row" style="color: blue"><%=index++%></th>
			<td><img alt=""
				src="/Event_Management/image?id=<%=bean.getId()%>"
				class="figure-img img-fluid rounded" alt="..." width="300"
				height="500"></td>
				<td><%=bean.getLocation()%></td>
			<td><%=bean.getCapacity()%></td>
			<td><%=bean.getCost()%></td>
			<td><%=bean.getContact()%></td>
			<td><%=bean.getDate()%></td>
			<td><%=bean.getEventtype()%></td>
			<td><a class="btn btn-info"
				href="<%=EM_View.PAYMENT_CTL%>">Book&
					Pay</a></td>

		</tr>
		<%
			}
		%>
		</tbody>
	</table>









	<%@include file="Footer.jsp"%>
</body>
</html>