<%@page import="in.co.online.Bean.PaymentBean"%>
<%@page import="in.co.online.Utility.ServletUtility"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>History</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br>

	<%
		UserBean bean2 = (UserBean) session.getAttribute("user");
	%>

	<div class="container">
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8">
				<br>
				<h4 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h4>
				<h4 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h4>

				<div class="container">
					<div class="row">
						<div
							class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6"></div>
								<div class="col-xs-6 col-sm-6 col-md-6 text-right"></div>
							</div>
							<div class="row">
								<div class="text-center">
									<h1>History</h1>
								</div>
								<table class="table table-hover">
									<thead>
										<tr>
											<th class="col-md-7">ID</th>
											<th class="col-md-7">PersonName</th>
											<th class="col-md-7">CardNumber</th>
											<th  class="col-md-7">Expire</th>
											<th  class="col-md-7">CVV</th>
											<th></th>
										</tr>
									</thead>

									<%
										int index = 1;
										List list = ServletUtility.getList(request);
										Iterator it = list.iterator();
										while (it.hasNext()) {
											PaymentBean bean = (PaymentBean) it.next();
									%>
									<tbody>
										<tr>
									
									
												<tr>
											<th scope="row" style="color: blue"><%=index++%></th>
											<td class="col-md-9"><%=bean.getPersonname()%></td>
											<td class="col-md-1" style="text-align: center"><%=bean.getCardnumber()%>
											</td>
											<td class="col-md-1 text-center"><%=bean.getExpire()%></td>
											<td class="col-md-1 text-center"><%=bean.getCvv()%></td>
											<td><button type="button"
													class="btn btn-success btn-sm btn-block">
													Payment Success<span
														class="glyphicon glyphicon-chevron-right"></span>
												</button></td>
										</tr>
										
									
										<%
											}
										%>

										<!-- <tr>
											<td> </td>
											<td> </td>
											<td class="text-right"><h4>
													<strong>Total:</strong>
												</h4></td>
											<td class="text-center text-danger"><h4>
													<strong>500</strong>
												</h4></td>
										</tr> -->
									</tbody>
								</table>


							</div>
						</div>
					</div>


				</div>
				<div class="col-2"></div>
			</div>
		</div>





		<br>
	</div>

	<%@include file="Footer.jsp"%>
</body>
</html>