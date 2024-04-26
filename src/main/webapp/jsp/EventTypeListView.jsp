<%@page import="in.co.online.Bean.EventTypeBean"%>
<%@page import="in.co.online.Utility.ServletUtility"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Event Type List</title>
</head>
<body>
<%@include file="Header.jsp"%>
	<br>
<h2 align="center">Event Type List</h2>
	<br>
	
	<table class="table table-dark table-striped">
			<tr >
				<th scope="col" style="color: blue">ID</th>
				<th scope="col"  style="color: blue">Event Name</th>
				<th scope="col"style="color: blue">Description</th>
			</tr>
			<%
				int index = 1;
				List list = ServletUtility.getList(request);
				Iterator it = list.iterator();
				while (it.hasNext()) {
					EventTypeBean bean = (EventTypeBean) it.next();
			%>
			<tr>
				<th scope="row" style="color: blue"><%=index++%></th>
				<td><%=bean.getEventname()%></td>
				<td><%=bean.getDescription()%></td>
			</tr>
			<%
				}
			%>
			</tbody>
		</table>
		<br>
<%@include file="Footer.jsp"%>
</body>
</html>