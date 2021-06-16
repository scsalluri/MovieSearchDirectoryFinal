<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    
    <script type='text/javascript'>
function preview_image(event) 
{
 var reader = new FileReader();
 reader.onload = function()
 {
  var output = document.getElementById('output_image');
  output.src = reader.result;
 }
 reader.readAsDataURL(event.target.files[0]);
}
</script>
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
            padding: 50px;
            opacity: 90%;
            margin-top: 100px;
            font-size: 20px;
        }
         label{
                display: inline-block;
                width: 140px;
                text-align: left;
            color: #fff;
      }
        button{
            width: 100px;
        }
        .btn{
          background-color: #bd0000;
          border: 0 ; 
          color: #ffffff;
          margin-top:50px;
          font-size: 20px;
          width:100px;
          margin: auto;
          
          cursor:pointer;
        }  a:link {
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
        
         .btn:hover
        {
        background-color: #4CAF50;
  color: white;
        }
        .c-btn{
        	text-align: center;
        	margin-top:20px;
        }
        
        #output_image{
          max-width: 100px;
          padding: 30px;
          margin-left:120px;
        }
        #choose-file{
          margin:auto;
          text-align: center;
        }
        #add{
          
          margin-left: 10px;
        }
     
        #upload{
            background-color: black;
            opacity: 90%;
            width:410px;
            margin: auto;
            margin-top:40px;
 			padding: 10px;
            
            
        }
        .main{
      color:red;
      text-align: center;
      margin-top:100px;
      background-color: black;
      opacity: 90%;
      padding: 5px;
      margin-left: 15cm;
      margin-right: 15cm;
      
  }
        
    
    </style>
</head>
<body>

<form  action="save_cast" name="myform" enctype="multipart/form-data" method="post">
	<table align="center" class="main-input" >
       <caption style="color: #fff; font-size: 30px; background-color: #bd0000"><strong>CAST FORM</strong></caption>
        <tr>
          <td>
            
            <label style="margin:5px;color:#fff;" for="fname">First Name</label>
            <input required style="padding: 5px;" type="text" id="fname" name="fname" placeholder="Enter First Name">
            <br>
           <br>
            <label style="margin:5px;color: #fff;" for="lname">Last name </label>
           <input required style="padding: 5px;" type="text" id="lname" name="lname" placeholder="Enter Last 

Name">
            <br>
          </td> 
           <td><div id="upload">
       <div>
            <img align="middle" id="output_image"/>
            </div>
            
            <div style="text-align: right;">
            <input id="choose-file" type="file" accept="image/png, image/jpeg, image/jpg" 
onchange="preview_image(event)" name="image"><br>
                 </div>
       
       </div>
           </td>
            </tr>
           <tr>
            
<td colspan="2"><div class="c-btn">
 <input class="btn" style=";color: white;padding: 10px;" type="submit" name="submit" value="Submit">
     <button value="Back" class="btn" style=";color: white;padding: 10px;"><a href="adminPage">Back</a></button>
</div>
 </td> </tr>
            </table>
   
  </form>




</body>
</html>