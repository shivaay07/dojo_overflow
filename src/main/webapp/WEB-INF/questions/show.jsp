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
	<h1>What is your Question</h1>
	<form action="/questions/new" method="post">
		<p>
			<label>Question:<input name="questionAtt"></input></label>
		</p>
		<p>
			<label> Tags:<textarea name="tagAtt" rows="4" cols="50"></textarea></label>
		</p>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>