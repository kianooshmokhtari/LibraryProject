<%@ include file= "header.jsp" %>

<div class="container">

	<h1>Book List</h1>
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
			
			<c:forEach var="product" items="${allBooks}">
				<tr>
					<td>
						<c:out value="${ ISBN }" />
					</td>
					<td>
						<c:out value="${ title }" />
					</td>
					<td>
						<c:out value="${ description }" />
					</td>
					<td>
						<c:out value="${ isRented }" />
					</td>
					<td>
						<c:out value="${ add_To_Library }" />
					</td>
					<td>
						<a href="edit?id=<c:out value='${ ISBN }' />">
							<button class="btn btn-primary">Edit</button>
						</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="delete?id=<c:out value='${ title }' />">
							<button class="btn btn-danger">Delete</button>
						</a>
					</td>
				</tr>
			</c:forEach>
		
		</tbody>
	
	</table>

</div>

<%@ include file= "footer.jsp" %>