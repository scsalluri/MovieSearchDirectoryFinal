<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-// W3C// DTD HTML 4.01 
 Transitional// EN" "http:// www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; 
 charset=ISO-8859-1">
  <style>
body {
	background-image: url('/resources/images/error.png');
	background-size: cover;
	background-position: center;
}

p {
	color: white;
	text-align: center;
	padding-top: 200px;
	font-size: 90px;
}

.btn {
	background-color: #bd0000;
	border: 0;
	color: #ffffff;
	margin-top: 50px;
	font-size: 20px;
	display: inline-block;
	width: 100px;
	cursor: pointer;
}

.btn:hover {
	background-color: #4CAF50;
	color: white;
}

a:link {
	color: white;
	background-color: transparent;
	text-decoration: none;
}

a:visited {
	color: white;
	background-color: transparent;
	text-decoration: none;
}

a:hover {
	color: white;
	background-color: transparent;
	text-decoration: none;
}

a:active {
	color: white;
	background-color: transparent;
	text-decoration: none;
}
</style>
</head>
<body>
<p><b>${msg}</b></p>
<center><button value="Back" class="btn" style="color: white;padding: 10px;"><a href="${back}">Back</a></button></center>
</body>
</html>