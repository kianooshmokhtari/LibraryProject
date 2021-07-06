<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>

<%@ include file="header-logged-out.jsp" %>
<div class="container">
<form action="<%=request.getContextPath()%>/create-account-db" method="post">

	<div class="mb-3">
		<label for="firstName" class="form-label">First Name</label>
		<input type="text" class="form-control" id="exampleFirstName" name="firstName">
	</div>
	<div class="mb-3">
		<label for="lastName" class="form-label">Last Name</label>
		<input type="text" class="form-control" id="exampleLastName" name="lastName">
	</div>
	<div class="mb-3">
		<label for="inputUsername" class="form-label">Username </label> <input
			type="text" class="form-control" id="exampleInputEmail1"
			aria-describedby="emailHelp" name="username">
	</div>
	<div class="mb-3">
		<label for="exampleInputPassword1" class="form-label">Password</label>
		<input type="password" class="form-control" id="exampleInputPassword1" name="pass">
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
</form>

<%String error = (String) request.getAttribute("AccountError"); %>
        <%if(error != null) { %>
        	<p classname="mb-3"><%= error %></p>
        	
		<% }%>
		
	</div>
<%@ include file="footer.jsp" %>
