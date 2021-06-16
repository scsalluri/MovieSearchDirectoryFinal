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
        font-family: 'Poppins', sans-serif;
            background-image: url('/resources/images/background12.png');
			background-size: 100%;
            
        }
        .t1 button{
        	background-color:#bd0000;
        	border: none;
  			color: white;
 			padding: 5px;
  			text-align: center;
  			text-decoration: none;
  			display: inline-block;
  			font-size: 16px;
        	width:200px;
        	cursor: pointer;
        	transition-duration: 0.3s;
        }
        .t1 button:hover{
        background-color: #4CAF50;
  color: white;
        }
    
        #box{
            
            
            font-family: 'Poppins', sans-serif;
            position:relative;
            z-index: 1;
            background: #000000;
            max-width: 500px;
            margin: auto ;
            padding: 60px;
            opacity: 90%;
            margin-top:100px;
            
            
            
           
           
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
        .topright {
    
  position: absolute;
  top: 58px;
  left: 80px;
  font-size: 25px;
}

    </style>
    </head>
<body>
<a href="/registeredUser">
  <img src="/resources/images/back.png" width="63" height="63">
  </a>
  </div>
<div id="box">
<h2 style="color: white"> Select Report</h2>
<form action="showReports">
<table class="t1" style="color: red">
  <tr>
      <td><button type="submit" name="reportType" value="Movie Name Wise">Movie Names Report</button></td>
      <td><button type="submit" name="reportType" value="Genre Wise">Genre Wise Report</button></td>
  </tr>
  <tr>
      <td><button type="submit" name="reportType" value="Release Year Wise">Release Year Wise Report</button></td>
      <td><button type="submit" name="reportType" value="Actor/Actress Wise">Actor/Actress Report</button></td>
  </tr>
  <tr>
     
    <td><button type="submit" name="reportType" value="Company Wise">Company Wise Report</button></td>
      <td><button type="submit" name="reportType" value="Producer Wise">Producer Wise Report</button></td>
  </tr>
  <tr>
      <td><button type="submit" name="reportType" value="Director Wise">Director Wise Report</button></td>
       <td><button type="submit" name="reportType" value="Language Wise">Language Wise Report</button></td>
  </tr>
  <tr>
     
      <td><button type="submit" name="reportType" value="Current Movies Report">Current Movies Report</button></td>
  
       <td><button type="submit" name="reportType" value="Upcoming Movies">Upcoming Movies Report</button></td>
  </tr>

</table>
</form>
    </div>
</body>
</html>