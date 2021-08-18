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
	${questionWithId.tags.size()}
	<h1><c:out value="${questionWithId.question}"/>?</h1>
	<h3><c:forEach items="${questionWithId.tags}" var="idTag">
		<c:out value="${idTag.subject}"/>
	</c:forEach></h3>
	<p>Add your answer:</p>
	<form action="/questions/${questionWithId.id}" method="post">
		<label>Answer:</label>
		<textarea name="answer" rows="4" cols="50"></textarea>	
		<input type="submit" value="Answer It"/>
	</form>
	
	<c:forEach items="${questionWithId.getAnswers()}" var="gA">
		<li><c:out value= "${gA.answer}"/></li>
	</c:forEach>
	
</body>
</html>