<%@page import="in.co.online.Controller.PaymentCtl"%>
<%@page import="in.co.online.Utility.ServletUtility"%>
<%@page import="in.co.online.Utility.DataUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8">
				<form action="<%=EM_View.PAYMENT_CTL%>" method="post">

					<h6 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h6>
					<h6 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h6>
					<jsp:useBean id="bean" scope="request"
						class="in.co.online.Bean.PaymentBean" />

					<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
						type="hidden" name="createdby" value="<%=bean.getCreatedby()%>">
					<input type="hidden" name="modifiedby"
						value="<%=bean.getModifiedby()%>"> <input type="hidden"
						name="createdDatetime" value="<%=bean.getCreateddatetime()%>">
					<input type="hidden" name="modifiedDateTime"
						value="<%=bean.getModifieddatetime()%>">


					<div class="container p-0">
						<div class="card px-4">
							<p class="h8 py-3">Payment Details</p>
							<div class="row gx-3">
								<div class="col-12">
									<div class="d-flex flex-column">
										<p class="text mb-1">Person Name</p>
										<input class="form-control mb-3" type="text" name="personname"
											placeholder="Name"
							 value="<%=DataUtility.getStringData(bean.getPersonname())%>">
									</div>
									<font color="red"><%=ServletUtility.getErrorMessage("personname", request)%></font>
								</div>
								<div class="col-12">
									<div class="d-flex flex-column">
										<p class="text mb-1">Card Number</p>
										<input class="form-control mb-3" type="text" name="cardnumber"
											placeholder="1234 5678 435678"
					value="<%=DataUtility.getStringData(bean.getCardnumber()) %>">
									</div>
		<font color="red"><%=ServletUtility.getErrorMessage("cardnumber", request)%></font>								
								</div>
								<div class="col-6">
									<div class="d-flex flex-column">
										<p class="text mb-1">Expiry</p>
										<input class="form-control mb-3" type="text" name="expire"
											placeholder="MM/YYYY"
				value="<%=DataUtility.getStringData(bean.getExpire())%>">
									</div>
		<font color="red"><%=ServletUtility.getErrorMessage("expire", request)%></font>								
								</div>
								<div class="col-6">
									<div class="d-flex flex-column">
										<p class="text mb-1">CVV/CVC</p>
										<input class="form-control mb-3 pt-2 " type="password" name="cvv"
											placeholder="***"
								value="<%=DataUtility.getStringData(bean.getCvv())%>">
									</div>
										<font color="red"><%=ServletUtility.getErrorMessage("cvv", request)%></font>
								</div>
								<div class="col-12">
								<input type="submit" class="btn btn-primary"
						name="operation" style="margin-left: 330px;"
						value="<%=PaymentCtl.OP_PAY%>">
									
									</div>
								</div>
							</div>
						</div>











				</form>
			</div>
			<div class="col-2"></div>
		</div>
	</div>
	<br>
	<%@include file="Footer.jsp"%>
</body>
</html>