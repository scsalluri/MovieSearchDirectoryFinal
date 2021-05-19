<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style>


body {
  background-image: url('https://images8.alphacoders.com/100/thumb-1920-1003220.png');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}
.container {
  position: relative;
}

.topright {
    
  position: absolute;
  top: 18px;
  left: 80px;
  font-size: 25px;
  color:#ffffff;
}
.topnav input[type=text] {
  
  padding: 10px;
  font-size: 17px;
  border: 1px solid grey;
  float: left;
  width: 20%;
  background: #f1f1f1;
}

.topnav{

  position:absolute;
  top: 18px;
  right: 50px;
  font-size: 8px;
}
  

</style>
</head>
<title>Main</title>
<body>



<div class="topright">
     <a href="login" style="color:white">Login</a>|<a href="register" style="color:white"> Register</a> | Contact Us
</div>
    <div class="topnav">
        <a href="login">
        <img src="https://lh3.googleusercontent.com/proxy/N2wgud308aZbpVUhv-fIOpFuE6PBO093-3-UghPeEBWsUV26tlP-2wcpwTmtuspNqw5GU7ZcyRp2iqZ0EFujsrboSjSiUAObWlzMtx2BQDxm" width="50" height="50">
        </a>
        
   </div>
   
</body>
</html>
