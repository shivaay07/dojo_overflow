<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Question Dashboard</h1>
	<table>
		<thead>
			<tr>
				<th>Questions</th>
				<th>Tags</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${showQuestions}" var="sQ">
			<tr>
				<td><c:out value="${sQ.question}"/></td>
				<td><c:forEach items="${sQ.tags}" var="sQT" varStatus="loop">
					<c:out value="${sQT.subject}"/><c:if test="${!loop.last}"><span>,</span></c:if>
				</c:forEach></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>