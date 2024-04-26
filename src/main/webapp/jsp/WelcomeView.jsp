<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%@include file="Header.jsp"%>
<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="false">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="/Event_Management/image/EM1.jpeg" class="d-block w-100" alt="..."  width="400" height="700">
      <div class="carousel-caption d-none d-md-block">
        <h5> A guest speaker event</h5>
        <p>A speaker presentation is one of the most common forms of B2B event marketing..</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="/Event_Management/image/Em2.jpeg" class="d-block w-100" alt="..."  width="400" height="700">
      <div class="carousel-caption d-none d-md-block">
        <h5> A seminar or half day event</h5>
        <p>Instead of a full conference, some businesses may choose to host a half day event.</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="/Event_Management/image/Em3.jpeg" class="d-block w-100" alt="..."  width="400" height="700">
      <div class="carousel-caption d-none d-md-block">
        <h5>A VIP experiences: From dinner events to indoor skydaiving</h5>
        <p>A VIP event is highly targeted on a company decision-makers.</p>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>

<%@include file="Footer.jsp"%>
</body>
</html>