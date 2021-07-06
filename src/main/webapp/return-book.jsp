<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="header.jsp"%>

<div class="container">
	<br>
	<br>

	<h1>Books Checked Out</h1>
	
	<table class="table table-striped">
		
		<thead>
			<tr>
				
				<th>Title</th>
				<th>Description</th>
				<th>Checked out Date</th>
				<th>Due Date</th>
				<th>Return</th>
				
			</tr>
		</thead>
		
		<tbody>
			
			<c:forEach var="book" items="${allBooksRented}">
				<c:if test = "${empty book.getReturned_date() }">
				<tr>
					<td>
						<c:out value="${ book.getBook().getTitle() }" />
					</td>
					<td>
						<c:out value="${ book.getBook().getDescription() }" />
					</td>
					<td>
						<c:out value="${ book.getCheckout_date() }" />
					</td>
					<td class="bg-danger text-white">
						<c:out value="${ book.getDue_date() }" />
					</td>
					<td>
					<c:if test = "${empty book.getReturned_date() }">					
						<a href="return?isbn=<c:out value = '${book.getBook().getISBN()}'/>">
							<button class="btn btn-primary">Return</button>
						</a>
					</c:if>	
					</td>
					<%-- <td>
						<a href="return?id=<c:out value='${ book.ISBN }' />">
							<button class="btn btn-primary">Return</button>
						</a>
					</td> --%>
				</tr>
				</c:if>
			</c:forEach>
		
		</tbody>
	
	</table>
	<br>
	<br>
	
	<h1>History</h1>
	
	<table class="table table-striped">
		
		<thead>
			<tr>
				
				<th>Title</th>
				<th>Description</th>
				<th>Checked out Date</th>
				<th>Due Date</th>
				<th>Returned Date</th>
			</tr>
		</thead>
		
		<tbody>
			
			<c:forEach var="book" items="${allBooksRented}">
				<c:if test = "${not empty book.getReturned_date() }">
				<tr>
					<td>
						<c:out value="${ book.getBook().getTitle() }" />
					</td>
					<td>
						<c:out value="${ book.getBook().getDescription() }" />
					</td>
					<td>
						<c:out value="${ book.getCheckout_date() }" />
					</td>
					<td class="bg-danger text-white">
						<c:out value="${ book.getDue_date() }" />
					</td>
					<td>
					<c:out value = "${book.getReturned_date() }"/>
					</td>
					<%-- <td>
						<a href="return?id=<c:out value='${ book.ISBN }' />">
							<button class="btn btn-primary">Return</button>
						</a>
					</td> --%>
				</tr>
				</c:if>
			</c:forEach>
		
		</tbody>
	
	</table>

</div>

<%@ include file= "footer.jsp" %>