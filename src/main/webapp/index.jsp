<%@ include file="header.jsp"%>

<div class="container">

	<h1>Welcome to out Library!!</h1>

	<br />
	<h4>Please login with your username and password</h4>

	<%@ include file="login.jsp"%>
	
	<%String error = (String) request.getAttribute("LoginError"); %>
        <%if(error != null) { %>
        	<p><%= error %></p>
        	
		<% }%>

</div>

<%@ include file="footer.jsp"%>
