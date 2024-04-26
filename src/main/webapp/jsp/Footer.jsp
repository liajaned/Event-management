<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.footer {
   position: relative;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: ;
   color: white;
   text-align: center;
}
</style>
<title></title>
</head>
<body>
<div class="footer">
<footer class="bg-light text-center text-lg-start">
  <!-- Copyright -->
  <div class="text-center p-3" style="background-color: #03a9f4;">
    © <%=Calendar.getInstance().get(Calendar.YEAR)%> Copyright:
    <a class="text-dark" href="#">Event Management System</a>
  </div>
  <!-- Copyright -->
</footer>
</div>
</body>
</html>