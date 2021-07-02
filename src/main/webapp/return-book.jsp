<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">

	<h1>Return Book</h1>
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
		
		<%-- <%ArrayList<Book> bk = 
            (ArrayList<Book>)request.getAttribute("allBooks");
        for(Book b:bk){%>
        Arranging data in tabular form
			<tr>
				<td><%=b.getISBN()%></td>
				<td><%=b.getTitle()%></td>
				<td><%=b.getDescription()%></td>
				<td><%=if(b.isRented()) { %>
					<%}%>
				</td>
			</tr>
			<%}%> --%>
			
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
						<c:out value="${ isRented }" />
					</td>
					<td>
						<c:out value="${ add_To_Library }" />
					</td>
					<td>
						<a href="return?id=<c:out value='${ book.ISBN }' />">
							<button class="btn btn-primary">Return</button>
						</a>
					</td>
				</tr>
			</c:forEach>
		
		</tbody>
	
	</table>

</div>

<%@ include file= "footer.jsp" %>