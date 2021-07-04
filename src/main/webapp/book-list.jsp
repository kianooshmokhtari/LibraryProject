<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">

	<h1>Book List</h1>
	<br>
	<br>
	
	<table class="table table-striped">
		
		<thead>
			<tr>
				<th>Title</th>
				<th>Description</th>
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
						<c:out value="${ book.title }" />
					</td>
					<td>
						<c:out value="${ book.description }" />
					</td>
					<td>
					<c:if test="${ not book.isRented() }">
						<a href="rent?isbn=<c:out value='${ book.ISBN }' />">
							<button class="btn btn-primary">Rent</button>
						</a>
					</c:if>
					<c:if test = "${book.isRented() }">
						<h4>Not Available </h4>
					</c:if>
					</td>
				</tr>
			</c:forEach>
		
		</tbody>
	
	</table>

</div>

<%@ include file= "footer.jsp" %>