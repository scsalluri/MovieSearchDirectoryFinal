<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-// W3C// DTD HTML 4.01 
 Transitional// EN" "http:// www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; 
 charset=ISO-8859-1">
<title>Start Spring MVC</title>

</head>
  <style>
    body{
     background-image: url('/resources/images/showresults_image.png');
    background-attachment: fixed;
 
    background-position: center;
    background-size: 100%;
}

td{
padding-left: 50px;
}
table {
  margin-left: auto;
  margin-right: auto;
}
.text
{
color: white;
text-align: center;
font-family	: bold;
}
h1{
color: white;
text-align: center;
font-size: 70px;
}
button{
        	background-color:#bd0000;
        	border: none;
  			color: white;
 			padding: 5px;
  			text-align: center;
  			text-decoration: none;
  			display: inline-block;
  			font-size: 16px;
        	width:150px;
        	cursor: pointer;
        	transition-duration: 0.3s;
        }
        button:hover{
        background-color: #4CAF50;
  		color: white;
        }
        .topright {
			position: absolute;
			top: 58px;
			left: 50px;
			font-size: 25px;
		}
</style>
<body>
 <div class="topright"  > 
  		
  <a href="registeredUser">
  <img src="/resources/images/back.png" width="63" height="63">
  </a>
  </div>
<form action="movieDetailsRegisteredUser">
<h1>Search Results</h1>
  <table>
  <tr>
  <c:set var="count" value="0" scope="page"></c:set>
        <c:forEach var="movies" items="${moviesList.movies}">
      
        <c:if test = "${(count mod 5 == 0) }">
        <tr style="margin-top: 30px;">
        </c:if>
                <td height="210">  
                        
                <img src="${moviesList.imgs[count]}"  width="150" height="150"><br />
                <button type="submit" id="movieName" name="movieName" value="${movies.movieName}">${movies.movieName}</button>
            	</td>    
                <c:set var="count" value="${count + 1}" scope="page"></c:set>
                    </c:forEach>
                    </table>
</form>
</body>
</html>