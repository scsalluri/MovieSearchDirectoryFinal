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
    <title>Genre</title>
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
            padding: 60px;
            opacity: 90%;
            margin-top: 10%;
            font-size: 20px;
            
        }
         label{
                display: inline-block;
                width: 100px;
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

<form action ="save_Genre">
    <table align="center" class="main-input" >
       <caption style="color: #fff; font-size: 30px; background-color: #bd0000"><strong>GENRE FORM</strong></caption>
        <tr>
          <td>
            
            <label style="margin:5px;color:#fff;" for="genre">Genre</label>
            <input style="padding: 5px;" type="text" id="genre" name="genre" required="required" placeholder="Enter Genre">
            <br>
            <br>
            <div class="c-btn">
 <input class="btn" style="color: white;padding: 10px;margin-left:50px" type="submit" name="submit" value="Submit">
<button value="Back" class="btn" style=";color: white;padding: 10px;"><a href="adminPage">Back</a></button>
</div>
            
            </td>
        	</tr>
         </table>


</form>

    
</body>
</html>