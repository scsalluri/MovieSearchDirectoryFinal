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
    <title>Company</title>
    <style>
   body {
       
       font-family: "Poppins", sans-serif;
   background-image: url('/resources/images/background3.png');
   background-repeat: no-repeat;
   background-attachment: fixed;
   background-size: cover;
 }
 .main-input{
            background-color: #000000;
            padding: 40px;
            opacity: 90%;
            margin-top: 10%;
            font-size: 20px;
            
            
        }
        label{
                display: inline-block;
                width: 160px;
                text-align: center;
            color: #fff;
      } 
         .btn{
          background-color: #bd0000;
          border: 0 ; 
          color: #ffffff;
          margin-top:50px;
          font-size: 20px;
          
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

<form action="save_Company">
    <table align="center" class="main-input" >
       <caption style="color: #fff; font-size: 30px; background-color: #bd0000"><strong>COMPANY FORM</strong></caption>
        <tr>
          <td>
            
            <label  style="margin:5px; color:#fff" for="Company">Company</label>
             <input   style="padding: 5px;" type="text" id="company" name="company" placeholder="Enter Company"><br>
          
             <input class="btn" style="color: white;padding: 10px; margin-left:80px" type="submit" name="submit" value="Submit">
            <button value="Back" class="btn" style=";color: white;padding: 10px;"><a href="adminPage">Back</a></button>
            </td>
        	</tr>
         </table>
         <div class="c-btn">

</div>
         
</form>



    
</body>
</html>