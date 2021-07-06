<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<div class="container">
	<h4>Please enter your first name, last name, username, and
		password to continue</h4>
	<hr />
	<form action="<%=request.getContextPath()%>/create-account-db"
		method="post">

		<div class="mb-3">
			<label for="firstName" class="form-label">First Name</label> <input
				type="text" class="form-control" id="exampleFirstName"
				name="firstName">
		</div>
		<div class="mb-3">
			<label for="lastName" class="form-label">Last Name</label> <input
				type="text" class="form-control" id="exampleLastName"
				name="lastName">
		</div>
		<div class="mb-3">
			<label for="inputUsername" class="form-label">Username </label> <input
				type="text" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" name="username">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Password</label>
			<input type="password" class="form-control"
				id="exampleInputPassword1" name="pass">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

	<%
	String error = (String) request.getAttribute("AccountError");
	%>
	<%
	if (error != null) {
	%>
	<p><%=error%></p>

	<%
	}
	%>
</div>
<%@ include file="footer.jsp"%>
