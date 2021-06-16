<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Language</title>
    <style>
   body {
       
       font-family: "Poppins", sans-serif;
   background-image: url('/resources/images/backdrop.png');
   background-repeat: no-repeat;
   background-attachment: fixed;
   background-size: cover;
 }
 .main-input{
            background-color: #000000;
            padding: 60px;
            opacity: 90%;
            margin-top: 10%;
            font-size: 20px;
        }
        label{
                display: inline-block;
                width: 160px;
                text-align: left;
            color: #fff;
      } 
         .btn{
          background-color: #bd0000;
          border: 0 ; 
          color: #ffffff;
          margin-top:50px;
          font-size: 20px;
          display: inline-block;
          width:100px;
          margin-left:45%;
           cursor:pointer;
        }
        
        .btn:hover
        {
        background-color: #4CAF50;
  color: white;
        }
         .table-2{
         margin-left:150px;
        width:80%;
        border-collapse: collapse;
        border-color:#fff;
        }
        .table-2 th{
        background-color:#bd0000;
        padding:5px;
        }
        .table-2 td, th {
			  border: 1px solid #ddd;
			  padding: 8px;
			}
			
			.table-2 tr:nth-child(even){
			background-color: #fff;
			}
			.table-2 tr:nth-child(odd){
			background-color: #f2f2f2;
			}
			.table-2 tr:hover {background-color: #ddd;}
			h3{
			text-color:white;}
			
			img{
			margin-left:680px;
			margin-top:50px;
			}
			h1{
			margin-left:600px;
			margin-top:50px;
			}
			.topright {
				position: absolute;
				top: 30px;
				right:1430px;
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

<h1 style="color:white">COMMENTS SECTION</h1>
<img src="${img}"  width="150" height="200">

   
    	

        <table style="margin-top: 50px; color: #ffffff" class="table-2">
        <caption style="color: #fff; font-size: 30px; background-color: #bd0000"><strong>${moviename}</strong></caption>
            
            
           
         
	         	 <tr class="trow" style="color: #bd0000;text-align:center;">
                <td>Serial no.</td>
                <td>User Name</td>
                <td>Rating</td>
                <td>Comment</td>
            </tr>
            <c:set var="count" value="0" scope="page"></c:set>
	          	  <c:forEach var="item" items="${user}">
 				<tr  style="color: #bd0000;text-align:center;">
                <td>${count+1}</td>
                <td>${item}</td>
                <td>${Rating[count]}</td>
                <td>${Comment[count]}</td>
            </tr>
            <c:set var="count" value="${count + 1}" scope="page"></c:set>
            </c:forEach>
    </table>



    
</body>
</html>