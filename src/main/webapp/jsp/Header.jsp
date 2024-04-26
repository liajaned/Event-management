<%@page import="in.co.online.Controller.MyProfileCtl"%>
<%@page import="in.co.online.Controller.LoginCtl"%>
<%@page import="in.co.online.Bean.UserBean"%>
<%@page import="in.co.online.Controller.EM_View"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>


</head>
<body>
	<%
		UserBean userBean = (UserBean) session.getAttribute("user");
	%>
	<%
		boolean userLoggedIn = userBean != null;
		String welcomeMsg = "Hello, ";
		if (userLoggedIn) {
			String role = (String) session.getAttribute("role");
			welcomeMsg += userBean.getFirstName() + "(" + role + ")";
		} else {
			welcomeMsg += "Guest";
		}
	%>





	<nav class="navbar bg-light">
		<span class="navbar-brand mb-0 h1"
			style="color: teal;">Event Management !! <a style="margin-left: 1180px; color: orange;"><%=welcomeMsg%></a>
		</span>
	</nav>
	<nav class="navbar bg-dark">
		<ul class="nav nav-pills">
			<li class="nav-item"><a class="nav-link active"
				style="font-family: cursive;" aria-current="page"
				href="<%=EM_View.WELCOME_CTL%>"> Home</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<%=EM_View.ABOUT_CTL%>" style="font-family: cursive;">About</a></li>

			<%
				if (userBean != null) {
			%>
			<%
				if (userBean.getRoleid() == 1) {
			%>




			<!--  <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Payment</a>
    <ul class="dropdown-menu">
      <li><a class="dropdown-item" href="#">Make Payment</a></li>
      <li><a class="dropdown-item" href="#">Check Payment</a></li>
    </ul>
  </li> -->
			<li class="nav-item"><a class="nav-link"
				href="<%=EM_View.USERLIST_CTL%>" style="font-family: cursive;">UserList</a></li>

		
			<%-- <li class="nav-item dropdown" style="font-family: cursive;"><a
				class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
				role="button" aria-expanded="false">Booking</a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="<%=EM_View.BOOKING_CTL%>">View</a></li>
				</ul></li> --%>

<li class="nav-item"><a class="nav-link"
				href="<%=EM_View.PAYMENT_LIST_CTL%>" style="font-family: cursive;">Booking History</a></li>


			<li class="nav-item dropdown" style="font-family: cursive;"><a
				class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
				role="button" aria-expanded="false">Event Type</a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item"
						href="<%=EM_View.EVENT_TYPE_CTL%>">ADD</a></li>
					<li><a class="dropdown-item"
						href="<%=EM_View.EVENT_LIST_CTL%>">List</a></li>
				</ul></li>

			<li class="nav-item"><a class="nav-link"
				href="<%=EM_View.VENUE_CTL%>" style="font-family: cursive;">Venue</a></li>

			<li class="nav-item"><a class="nav-link"
				href="<%=EM_View.CONTACT_CTL%>" style="font-family: cursive;">Contact</a></li>
			<%
				} else if (userBean.getRoleid() == 2) {
			%>


			<li class="nav-item"><a class="nav-link"
				href="<%=EM_View.VENUE_LIST_CTL%>" style="font-family: cursive;">Book</a></li>
				
					<%-- <li class="nav-item"><a class="nav-link"
				href="<%=EM_View.BOOKING_CTL%>" style="font-family: cursive;">Book</a></li> --%>
				
			

			<li class="nav-item"><a class="nav-link"
				href="<%=EM_View.PAYMENT_LIST_CTL%>" style="font-family: cursive;">Booking Histroy</a></li>


			<li class="nav-item"><a class="nav-link"
				href="<%=EM_View.CONTACT_CTL%>" style="font-family: cursive;">Contact</a></li>
			<%
				}
			%>
			<%
				}
			%>
		</ul>

		<%
			if (userBean == null) {
		%>
		<ul class="nav justify-content-end" style="font-family: cursive;">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
				role="button" aria-expanded="false" style="margin-left: 10px;">Guest</a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="<%=EM_View.LOGIN_CTL%>">SingIn</a></li>
					<li><a class="dropdown-item"
						href="<%=EM_View.REGISTRATION_CTL%>">SingUp</a></li>
					<li><a class="dropdown-item" href="#"></a></li>
				</ul></li>
		</ul>
		<%
			} else {
		%>
		<ul class="nav justify-content-end" style="font-family: cursive;">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
				role="button" aria-expanded="false" style="margin-left: 10px;">Guest</a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item"
						href="<%=EM_View.MYPROFILE_CTL%>?operation=<%=MyProfileCtl.OP_MYPROFILE%>">MyProfile</a></li>
				
					<li><a class="dropdown-item"
						href="<%=EM_View.LOGIN_CTL%>?operation=<%=LoginCtl.OP_LOGOUT%>">Logout</a></li>
				</ul></li>
		</ul>

		<%
			}
		%>
	</nav>



</body>
</html>