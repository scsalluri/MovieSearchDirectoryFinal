<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
}
.topnav{

  position:absolute;
  top: 18px;
  right: 50px;
  font-size: 28px;
}

</style>
</head>
<title>Admin Main</title>
<body>

<div class="container">
    
  <div class="topright"  > 
         <a href="#" style="color:white" >Admin Settings</a>
  </div>
    
</div>
<div class="topnav">
  
  <a href="#">
  <button type="submit"><i class="fa fa-search" id="search" style="font-size:48px;color:red"></i></button>
  </a>
</div>


</body>
</html>
