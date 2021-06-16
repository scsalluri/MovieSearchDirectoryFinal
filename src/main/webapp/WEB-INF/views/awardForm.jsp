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
            
          background-image: url('/resources/images/background3.png');
  background-attachment: fixed;
  background-size: 100% 100%;
    font-family: "Poppins", sans-serif;
}
        
        label{
                display: inline-block;
                width: 160px;
                text-align: left;
            color: #fff;
      } 
        .main-input{
            background-color: #000000;
            padding: 60px;
            opacity: 90%;
            margin-top: 100px;
            font-size: 20px;
        }
        .table-2{
            background: #000;
            width: 70%;
            text-align: center;
        }
        .c-btn{
        text-align: center;
        	margin-top:20px;
        }
        .btn{
          background-color: #bd0000;
          border: 0 ; 
          color: #ffffff;
          margin-top:50px;
          font-size: 20px;
          display: inline-block;
          width:100px;
         
           cursor:pointer;
        }
        
        .btn:hover
        {
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
          color:white;
          background-color: transparent;
          text-decoration: none;
        }
    </style>
    
</head>
<body>
  
  <form action="saveAwardForm">  
    <table align="center" class="main-input" >
       <caption style="color: #fff; font-size: 30px; background-color: #bd0000"><strong>Award Details</strong></caption>
        <tr>
          <td>
            
            <label for="movie-name">Movie Name</label>
            <Select required style="padding: 5px;" name="movieNames" id="movieNames" type="text">
             <c:forEach var="item" items="${movieNames}">
	         	 <option value="${item.movieName}">${item.movieName}</option>
	          	 </c:forEach>
            </Select>>
            <br>
            </td>
        </tr>
        
        <tr>
          <td style="padding-top: 15px">
            <label for="award-name">Award Name</label>
           <Select required style="padding: 5px;" name="awardNames" id="awardNames" type="text">
             <c:forEach var="item" items="${awardNames}">
	         	 <option value="${item.awardName}">${item.awardName}</option>
	          	 </c:forEach>
            </Select>>
            <br>
              
             
            
            
            </tr>
     
          <td style="padding-top: 15px">
            
            <label for="category">Category</label>
            <input required style="padding: 5px;" name="Category" id="Category" type="text" placeholder="Enter Category"/>
            <br>
            
             <div class="c-btn">
 <input class="btn" style="color: white;padding: 10px;" type="submit" name="submit" value="Submit">
<button value="Back" class="btn" style=";color: white;padding: 10px;"><a href="adminPage">Back</a></button>
</div>
            </td>


    </table>
    </form>
    
   
 
</body>
</html>