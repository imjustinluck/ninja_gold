<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>Insert title here</title>
</head>
	<body>
	<div class="container">
		<div style="display:flex">
			<h1>Your Gold: </h1>
			<h1 style="border: 1px solid black; width:60px">
			<c:out value="${gold }"></c:out>
			</h1>
		</div>
	
		<div style="display:flex">
			<form action="/farm" method="POST">
				<div>
					<h1>Farm</h1>
					<h3>(earns 10-20 gold)</h3>
					<button>Find Gold!</button>
				</div>			
			</form>
			<form action="/cave" method="POST">
				<div>
					<h1>Cave</h1>
					<h3>(earns 5-10 gold)</h3>
					<button>Find Gold!</button>
				</div>
			</form>
			<form action="/house" method="POST">
				<div>
					<h1>House</h1>
					<h3>(earns 2-5 gold)</h3>
					<button>Find Gold!</button>
				</div>
			</form>
			<form action="/casino" method="POST">
				<div>
					<h1>Casino</h1>
					<h3>(earns/takes 0-50 gold)</h3>
					<button>Find Gold!</button>
				</div>
			</form>
		</div>
		
		<h1>Activities:</h1>
		<c:forEach var="item" items="${activities}">
            <p><c:out value="${item}"></c:out></p>
        </c:forEach>
	
	</div>
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>