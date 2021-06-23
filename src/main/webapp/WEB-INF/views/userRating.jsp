<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Rating</title>
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
          
           cursor:pointer;
        }
        
        .btn:hover
        {
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
  		
 <form action="movieDetailsRegisteredUser"	>	
   <input type="hidden" name="movieName" value="${mname}" /> 
  <button type="submit" style="background-color:black; border: 0; "> <img src="/resources/images/back.png" width="63" height="63"></button>

  </form>>
  </div>

<form action="save_Rating">
    <table align="center" class="main-input" >
       <caption style="color: #fff; font-size: 30px; background-color: #bd0000"><strong>Rating Section</strong></caption>
        <tr>
          <td>
            
            <h1 style="margin:5px;color:#fff;" align="center" >Rate This Movie: ${mname}</h1><br><br><br>
            <div align="center">
            <label>Rating</label>
            <input type="hidden" value="${mname}" name="mname">
            <input style="padding: 5px; width:100px;" type="Number" id="rating" required name="rating" min="0" max="10" placeholder="Rate out of 10" /><br><br>
            <textarea  rows="5" cols="100" style="padding: 5px;"  id="comment" name="comment"  required placeholder="Enter Comments" ></textarea><br>
           <input class="btn" style="color: white;padding: 10px; " type="submit" name="submit" value="Submit">
            </div>
            <br>
            
            </td>
        	</tr>
         </table>
         <div class="c-btn">
 
</div>
         
</form>



    
</body>
</html>