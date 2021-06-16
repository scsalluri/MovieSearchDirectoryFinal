<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %> 
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    
    
    
    <style>
        body {
            
          background-image: url('/resources/images/back2.png');
            

  background-attachment: fixed;
  background-size: 100% 100%;
    font-family: "Poppins", sans-serif;
}
        
        label{
                display: inline-block;
                width: 160px;
                text-align: left;
            color: #bd0000;
      } 
      
        .table-1{
            
            width: 50%;
            
            
        }
        .row2{
        width:50%;
        text-align:center;
        margin:auto;
        padding-top:10px;
        padding-bottom:10px;
        }
        .table-2{
        width:100%;
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
.topright {
    
  position: absolute;
  top: 58px;
  left: 80px;
  font-size: 25px;
}
       
    </style>
    
</head>
<body>
<div class="topright"  > 
  		
  <a href="/reports">
  <img src="/resources/images/back.png" width="63" height="63">
  </a>
  </div>
    
<table align="center"  style="margin-top: 30px; color: #000000" class="table-1">
            <caption style="padding:20px;color: #fff; font-size: 25px; background-color: #000; opacity:70%;"><strong>Search According to ${type}</strong></caption>

      </table>
    <div  class="row2" align="center" style="background-color: #000000; opacity:70%;">
  <form action="reportChange">
    <label style="margin-left: 10px;" name ="reportType" id="reportType" ><b>Select ${category}</b></label>
       <select id="category" name="category" style="margin-top: 10px;width: 5cm;padding:5px;" onchange="submit()">
       <option>Select from Below</option>
        <c:forEach var="item" items="${item}">
	         	 <option value="${item}">${item}</option>
	          	 </c:forEach>
       </select>
      </form> 
        </div>
      
    
    <table style="margin-top: 50px; color: #ffffff" class="table-2">
            
            
            <tr style="color: #fff;">
              <c:forEach var="heads" items="${heading}">
             <th>${heads}</th>
                 </c:forEach>
            </tr>
         <c:forEach var="item" items="${moviedetails}">
	         	 <tr class="trow" style="color: #bd0000;text-align:center;">
                <td>${item.movieName}</td>
                <td>${item.tagline}</td>
                <td>${item.release_date}</td>
                <td>${item.runtime}</td>
                <td>${item.user_rating}</td>
                <td>${item.genre}</td>
                <td>${item.cast}</td>
                <td>${item.producer}</td>
                <td>${item.director}</td>
                <td>${item.company}</td>
            </tr>
	          	 </c:forEach>

    </table>
    <h2 align="center" " style="color: white;">${h2} </h2>
     

</body>
</html>