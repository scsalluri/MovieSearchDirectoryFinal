<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style >
          body{
                background-image: url('/resources/images/background8.png');
                background-size: cover;

            }
           
           
            .logout a{
             color: #bd0000;
             
            }
             .rec{
                font-family: "Poppins", sans-serif;
                text-align:center;
                color:aliceblue;
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
        	height:50px;
        	cursor: pointer;
        	transition-duration: 0.3s;
        	white-space: normal;
			word-wrap: break-word;
        }
        button:hover{
        background-color: #4CAF50;
  color: white;
        }
            #form{
             
                font-family: "Poppins", sans-serif;
                position:relative;
                z-index: 1;
                background: #000000;
               width: 80%;
                margin-top: 5cm ;
                margin-left: 2cm;
                padding: 40px;
                text-align: center;
                opacity: 90%;
                
                size: 30cm;
                
            }
            .topnav{

  position:absolute;
  top: 18px;
  right: 50px;
  font-size: 28px;
}
        

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="topnav">
  <a href="registeredUser">
  <img src="/resources/images/back.png" width="60" height="60">
  </a>
  </div>
  <div >
        <h2 style="color: white;margin-left: 1cm;">Welcome ${username}</h2>
    </div>
        <div class="logout">
            <a href="login"><h3 style="float:right;margin-right: 3cm;margin-top: -3cm;">Logout</h3></a>
        </div>
        
        
      
    <div id="form">

        <div class="rec">
            <h2><em>Recommended Movies</em></h2>
        </div>
        <form action="/movieDetailsRegisteredUser">
           <marquee  direction="left" >&nbsp;&nbsp;
        <c:set var="count" value="0" scope="page"></c:set>
	          	  <c:forEach var="item" items="${mname}">
     
            <div style="width:120px; display: inline-block; margin-left:20px " >                    
                <img src="${img[count]}" width="150px" height="150px" />
                <div style="color:white" align="middle"><button name="movieName" value="${item.movieName}">${item.movieName}</button></div>
         <div style="color:white ;align-content: center; "><span style="font-size:300%;color:yellow;">&starf;</span>${item.user_rating}</div>
            </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      
            <c:set var="count" value="${count + 1}" scope="page"></c:set>
            </c:forEach>
              </marquee>
</form>

      </div>
</body>
</html>