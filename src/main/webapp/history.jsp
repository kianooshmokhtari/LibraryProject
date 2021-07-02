<%@ include file= "header.jsp" %>

<div class="container">

	<h1>History</h1>
	<br>
	<br>
	
	<table class="table table-striped">
		
		<thead>
			<tr>
				<th>#</th>
				<th>ISBN</th>
				<th>Title</th>
				<th>Description</th>
				<th>Rented</th>
				<th>Available</th>
			</tr>
		</thead>
		
		<tbody>
		
			<c:forEach var="book" items="${allBooks}">
				<tr>
					<td>
						<c:out value="${ book.ISBN }" />
					</td>
					<td>
						<c:out value="${ book.title }" />
					</td>
					<td>
						<c:out value="${ description }" />
					</td>
					<td>
					<c:if test="${!isRented }">
						<c:out value="${ isRented } " />
					</c:if>
					</td>
					<td>
						<c:out value="${ add_To_Library }" />
					</td>
				</tr>
			</c:forEach>
		
		</tbody>
	
	</table>

</div>

<%@ include file= "footer.jsp" %>