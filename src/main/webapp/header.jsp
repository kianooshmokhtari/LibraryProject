<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>&#x1F4DA Library Catalog</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<style>
footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	text-align: center;
}
</style>
</head>

<body>

	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="<%= request.getContextPath() %>/login">&#x1F4DA Library
				Catalog</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">

				<ul class="navbar-nav">

					<li class="nav-item"><a class="nav-link"
						href="<%= request.getContextPath() %>/return-book">Return Book</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%= request.getContextPath() %>/History">History</a></li>
					
				</ul>
				<ul class = "navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link"
						href="<%= request.getContextPath() %>/logout">Logout</a></li>
				
				</ul>

			</div>
		</nav>
	</header>