<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<hr />

<form action="<%=request.getContextPath()%>/login" method="post">

	<div class="mb-3">
		<label for="inputUsername" class="form-label">Username </label> <input
			type="userName" class="form-control" id="exampleInputEmail1"
			aria-describedby="emailHelp" name="username">
	</div>
	<div class="mb-3">
		<label for="exampleInputPassword1" class="form-label">Password</label>
		<input type="password" class="form-control" id="exampleInputPassword1"
			name="pass">
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>

</form>
<br />

<form action="<%=request.getContextPath()%>/create-account-page"
	method="post">
	<input type="submit" class="btn btn-secondary" value="Create Account" />
</form>