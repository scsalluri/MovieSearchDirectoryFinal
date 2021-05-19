<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %>  
<!DOCTYPE html>
<html>
    <head>
      <title>Report</title>
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <style>
        
        th,td{
            
            padding-left: 50px;
            padding-top: 20px;
        }
        body {
            background-image:url('https://images8.alphacoders.com/100/thumb-1920-1003220.png');
            background-size: cover;
            
        }
    
        #box{
            
            
            font-family: 'Roboto', sans-serif;
            position:relative;
            z-index: 1;
            background: #000000;
            max-width: 550px;
            margin: 0 auto ;
            padding: 45px;
            opacity: 90%;
            
            
            
            position: fixed; /* or absolute */
            top: 20%;
            left: 32%;
           
        }
          
            
    
        table{
             
             margin-left: auto;
             margin-right: auto;

        }
        h2{
            text-align: left;
            
            border-left: 5px solid red;
            padding-left: 10px;
            

        }
        a:link {
            color: red;
            background-color: transparent;
            text-decoration: none;
        }
        a:visited {
             color: red;
             background-color: transparent;
             text-decoration: none;
        }
        a:hover {
          color: red;
          background-color: transparent;
          text-decoration: underline;
        }
        a:active {
          color: red;
          background-color: transparent;
          text-decoration: underline;
        }

    </style>
    </head>
<body>
<div id="box">
<h2 style="color: white"> Select Report</h2>

<table style="color: red">
  <tr>
      <td ><a href="#">Movie Name Wise</a></td>
      <td><a href="#">Country Wise</a></td>
  </tr>
  <tr>
      <td><a href="#">Genre Wise</a></td>
      <td><a href="#">Release Year Wise</a></td>
  </tr>
  <tr>
      <td><a href="#">Actor Wise</a></td>
      <td><a href="#">Best Movie Year Wise</a></td>
  </tr>
  <tr>
      <td><a href="#">Producer Wise</a></td>
      <td><a href="#">Director Wise</a></td>
  </tr>
  <tr>
      <td><a href="#">Language Wise</a></td>
      <td><a href="#">Company Wise</a></td>
  </tr>
  <tr>
      <td><a href="#">Top Rated Movies</a></td>
      <td><a href="#">User Rating Movies</a></td>
  </tr>
  <tr>
      <td><a href="#">Upcoming Movies</a></td>
      <td><a href="#">Currently Playing Movies</a></td>
  </tr>
</table>
    </div>
</body>
</html>