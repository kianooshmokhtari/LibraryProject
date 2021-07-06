<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.not-allowed {
	cursor: not-allowed;
}
</style>

<div class="container">

	<h1>Book List</h1>
	<br> <br>

	<table class="table table-striped">

		<thead>
			<tr>
				<th>ISBN</th>
				<th>Title</th>
				<th>Description</th>
				<th>Date Added</th>
				<th>Available</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="book" items="${allBooks}">
				<tr>
					<td><c:out value="${ book.ISBN }" /></td>
					<td><c:out value="${ book.title }" /></td>
					<td><c:out value="${ book.description }" /></td>
					<td><c:out value="${ book.added_To_Library }" /></td>
					<td><c:choose>
							<c:when test="${ not book.isRented() }">
								<a href="rent?isbn=<c:out value='${ book.ISBN }' />">
									<button class="btn btn-primary">Rent</button>
								</a>
								<br />
							</c:when>
							<c:otherwise>
								<button class="btn btn-primary not-allowed" disabled>Rent</button>
								<br />
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

</div>

<%@ include file="footer.jsp"%>