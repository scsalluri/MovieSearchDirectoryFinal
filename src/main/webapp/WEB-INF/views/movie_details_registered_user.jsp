<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
    body{
                background-image: url('/resources/images/background16.png');
                background-size: cover;
                background-attachment: fixed;
    }
    * {
    box-sizing: border-box;
    
    }
    /* Create three equal columns that floats next to each other */
    .column {
    float: left;
    width: 27%;
    padding: 10px;
    height: 600px; /* Should be removed. Only for demonstration */
    
    
    }

    /* Clear floats after the columns */
    .row:after {
    content: "";
    display: table;
    clear: both;
    
    
    }
   div.row {
        position: relative;
        left: 160px;
        top: 80px;
        
      
  
    }

    /* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
    @media screen and (max-width: 600px) {
    .column {
        width: 100%;
        
    }
    }
    h2{
            text-align: left;
            
            border-left: 5px solid red;
            padding-left: 10px;
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
        	width:200px;
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
</head>
<body>
<div class="topright"  > 
  		
  <a href="registeredUser">
  <img src="/resources/images/back.png" width="63" height="63">
  </a>
  </div>

<div class="row" >
  <div class="column" style="background-color:black ; opacity: 80%;" >

    <h2 style="color: white;">${mdetails.movieName} </h2>>
    <img src="${img}" height="200" width="150" />
   
    <p style="color: white;">User Rating: ${mdetails.user_rating} <span style="font-size:300%;color:yellow;">&starf;</span></p><br>
    
    <a href="${mdetails.trailer}" target="_blank"><button value="trailer">Watch Trailer</button></a><br><br>
       <form action="viewComments">
        <button value="${mdetails.movieName}" name="movieName">View Comments</button> <br><br>  
        </form>
   		<form action="ratingPage">
       <button value="${mdetails.movieName}" name="mname" id="mname" type="submit">Rate This Movie</button><br><br>
    </form>
  </div>
  <div class="column" style="background-color:black  ; opacity: 80%;">
     <h2 style="color: white;margin-left: -1.3cm;">Movie Details</h2><br>
    <p style="color: white;margin-left: -1.3cm;">Plot : ${mdetails.plot}<p>
   <p style="color: white;margin-left: -1.3cm;">Tagline : ${mdetails.tagline}</p>
    <p style="color: white;margin-left: -1.3cm;">Director & Writer : ${mdetails.director}</p>
    <p style="color: white;margin-left: -1.3cm;">Producer : ${mdetails.producer}</p>
    <p style="color: white;margin-left: -1.3cm;">Company : ${mdetails.company}</p>
    <p style="color: white;margin-left: -1.3cm;">Release Date : ${mdetails.release_date}</p>
    <p style="color: white;margin-left: -1.3cm;">Runtime : ${mdetails.runtime}</p>
    <p style="color: white;margin-left: -1.3cm;">Language : ${mdetails.language}</p>
    <p style="color: white;margin-left: -1.3cm;">Genre : ${mdetails.genre}</p>
    <p style="color: white;margin-left: -1.3cm;">Awards : ${mdetails.awards}</p>

   
  </div>
  <div class="column" style="background-color:black ; opacity: 80%;">
    <h2 style="color: white;">CAST</h2>
   
    <marquee direction="up" height="400">
    <c:set var="count" value="0" scope="page"></c:set>
    
    <c:forEach var="img" items="${imgList}">
      
        <div style="width:170px; display: inline-block">                    
            <img src="${img}" width="170px" height="220px" border="5"/>
            <div style="color:white;width:200px;margin-left:5px;" >${nameList[count]}</div>
        </div>&nbsp;&nbsp;
        <c:set var="count" value="${count + 1}" scope="page"></c:set>
        </c:forEach>
</marquee>>
  </div>
  
</div>

</body>
</html>