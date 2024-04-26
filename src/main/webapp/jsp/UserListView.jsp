<%@page import="in.co.online.Utility.ServletUtility"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br>
	<h2 align="center">User List</h2>
	<br>
	<h4 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h4>
	<h4 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h4>

	<table class="table table-warning table-striped">
			<tr >
				
				<th scope="col" style="color: blue">ID</th>
				<th scope="col"  style="color: blue">FirstName</th>
				<th scope="col"style="color: blue">LastName</th>
				<th scope="col"style="color: blue">Email</th>
				<th scope="col"style="color: blue">Gender</th>
				<th scope="col"style="color: blue">Action</th>
					<th scope="col"></th>
			</tr>
			<%
			
				int index = 1;
				List list = ServletUtility.getList(request);
				Iterator it = list.iterator();
				while (it.hasNext()) {
					UserBean bean = (UserBean) it.next();
			%>
			<tr>
				
				<th scope="row" style="color: blue"><%=index++%></th>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getEmail()%></td>
				<td><%=bean.getGender()%></td>
				<td><a class="btn btn-danger" href="<%=EM_View.USERLIST_CTL%>?id=<%=bean.getId()%>">Delete</a></td>
			</tr>
			<%
				}
			%>
			</tbody>
		</table>



	<%@include file="Footer.jsp"%>
</body>
</html>