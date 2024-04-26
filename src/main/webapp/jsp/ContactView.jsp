<%@page import="in.co.online.Controller.ContactCtl"%>
<%@page import="in.co.online.Utility.DataUtility"%>
<%@page import="in.co.online.Utility.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact</title>
</head>
<body>
<%@ include file="Header.jsp"%>
<br>
	<div class="container">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-8" style="margin-top: 1%; background-color: maroon;"> 

<form action="<%=EM_View.CONTACT_CTL%>" method="post">
		
		<h3 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h3>

<jsp:useBean id="bean" scope="request"
						class="in.co.online.Bean.ContactBean" />

					<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
						type="hidden" name="createdBy" value="<%=bean.getCreatedby()%>">
					<input type="hidden" name="modifiedBy"
						value="<%=bean.getModifiedby()%>"> <input type="hidden"
						name="createdDatetime" value="<%=bean.getCreateddatetime()%>">
					<input type="hidden" name="modifiedDateTime"
						value="<%=bean.getModifieddatetime()%>">

  <div class="container">
    <div class="row justify-content-center">
        <h1 class="text-center font-weight-bold text-primary"  style="background-color: black;">Contact Us</h1>
        <hr class="bg-light">
         <label class="form-label">Name:</label>
          <div class="form-group input-group">
            <div class="input-group-prepend">
            </div>
            <input type="text" name="name" class="form-control" placeholder="Enter your name"
            value="<%=DataUtility.getStringData(bean.getName())%>">
         <div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("name", request)%></div>
          </div>
          
 <label class="form-label">Email:</label>          
          <div class="form-group input-group">
            <div class="input-group-prepend">
            </div>
            <input type="email" name="email" class="form-control" placeholder="Enter your email" 
            value="<%=DataUtility.getStringData(bean.getEmail())%>">
                  <div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("email", request)%></div>
                        </div>
          </div>
          
           <label class="form-label">Subject:</label>
          <div class="form-group input-group">  
            <div class="input-group-prepend">
            </div>
            <input type="text" name="subject" class="form-control" placeholder="Enter subject"
            value="<%=DataUtility.getStringData(bean.getSubject())%>">
               <div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("subject", request)%></div>
          </div>
          
           <label class="form-label">Message:</label>
          <div class="form-group input-group">
            <div class="input-group-prepend">
            </div>
            <textarea name="message" id="msg" class="form-control" placeholder="Write your message" cols="30" rows="4" 
            value="<%=DataUtility.getStringData(bean.getMessage())%>"></textarea>
   <div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("message", request)%></div>
            
          </div>
          </div>
      
          <br>
          
          <div class="form-group">
            <input type="submit" class="btn btn-primary"  name="operation" value="<%=ContactCtl.OP_SEND%>">
          </div>
        </form>
      </div>
          
  
  				<div class="col-2"></div>
            </div>
    </div>
  
  
  <br>
  	<div style="margin-top: 4%;">
  <%@ include file="Footer.jsp"%>
</div>
</body>
</html>