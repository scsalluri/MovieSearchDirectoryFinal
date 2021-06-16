<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %> 

<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Recommended Movies</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
  
    <style>
         body{
                background-image: url('/resources/images/background12.png');
                background-size: cover;

            }
            .logout{
                margin-top: -2.5cm;
                margin-left: 30cm;
            }
           
            .logout a{
    color: #bd0000;
}
            #form{
             
             font-family: "Poppins", sans-serif;
             position:relative;
             z-index: 1;
             background: #000000;
             max-width: 660px;
             margin-left: -21cm;
             padding: 45px;
             text-align: center;
             opacity: 90%;
             bottom: 50px;
             margin-top: 4cm;
             padding-top: 45px;
             
         }
         .sb-example-1 .search {
                width: 20%;
                position: relative;
                display: flex;
                left: 40%;
                bottom: 60px;
                }
                .sb-example-1 .searchTerm {
                width: 100%;
                border: 3px solid gray;
                border-right: none;
                padding: 5px;
                border-radius: 5px 0 0 5px;
                outline: none;
                color: #9DBFAF;
                }
                .sb-example-1 .searchTerm:focus{
                color: gray;
                }
                .sb-example-1 .searchButton {
                width: 40px;
                height: 50px;
                border: 1px solid gray;
                background: gray;
                text-align: center;
                color: #fff;
                border-radius: 0 5px 5px 0;
                cursor: pointer;
                font-size: 20px;
                }
                .sb-example-1 .searchButton i{
                color: white;
                }
                .topnav{

				  position:absolute;
				  top: 18px;
				  right: 50px;
				  font-size: 28px;
				}
    </style>
</head>
<body>
<div class="topnav">
  <a href="login">
  <img src="/resources/images/logout.png" width="60" height="60">
  </a>
  </div>

    <div >
        <h2 style="color: white;margin-left: 3cm;">Hi, Charan &nbsp;&nbsp;&nbsp;</h2>
       
        </div>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <div class="sb-example-1">
            <div class="search">
               <input type="text" class="searchTerm" placeholder="What are you looking for?">
               <button type="submit" class="searchButton">
                 <i class="fa fa-search"></i>
              </button>
            </div>
         </div>
         <div class="logout">
            <a href="#"><h3>Logout</h3></a>

         <div id="form">

            <div id="heading">
                <h2 style="color: white ">Top Picks For You</h2>
                <marquee  direction="left" >&nbsp;&nbsp;
                <div style="width:120px; display: inline-block">                    
                   <a href="#"><img src="https://images.squarespace-cdn.com/content/v1/51b3dc8ee4b051b96ceb10de/1615997337403-G2AT6OCZ0LD8VLQ1IHGC/ke17ZwdGBToddI8pDm48kJYq1aWJR-Opw9YCGEJvNoV7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z4YTzHvnKhyp6Da-NYroOW3ZGjoBKy3azqku80C789l0k5fwC0WRNFJBIXiBeNI5fL5tAx0_Wm6zQGcCxuXSnc3-CppMx_loiHYdjEK2HksYg/EwnOBogWEAEiakT.jpeg?format=1500w" width="120px" height="180px" border="5"/></a>
                    <div style="color:white" ,align="middle">GODZILLA</div>
                    <div style="color:white" ,align="middle"><span style="font-size:300%;color:yellow;">&starf;</span>6.3</div>

                </div>&nbsp;&nbsp;
                <div style="width:120px; display: inline-block">                  
                  <a href="#"> <img src="https://mir-s3-cdn-cf.behance.net/project_modules/1400/a1d95586386965.5d97886ac225d.jpg" width="120px" height="180px" border="5"/></a>
                    <div style="color:white" ,align="middle">WAR</div>
                    <div style="color:white" ,align="middle"><span style="font-size:300%;color:yellow;">&starf;</span>6.8</div>
                </div>&nbsp;&nbsp;
                <div style="width:120px; display: inline-block" >                
                  <a href="#"><img src="https://i.pinimg.com/474x/a8/64/9d/a8649d36feab9e4790fc7bd085fbd690.jpg" width="120px" height="180px" border="5"/></a>
                    <div style="color:white",align="middle">MASTER</div>
                    <div style="color:white" ,align="middle"><span style="font-size:300%;color:yellow;">&starf;</span>7.1</div>
                </div>&nbsp;&nbsp;
                <div style="width:120px ; display: inline-block" >                 
               <a href="#">  <img src="https://mir-s3-cdn-cf.behance.net/project_modules/2800_opt_1/fa795295545673.5e99cc741483a.jpg" width="120px" height="180px" border="5"/></a>
                    <div style="color:white",align="middle">EXTRACTION</div>
                    <div style="color:white" ,align="middle"><span style="font-size:300%;color:yellow;">&starf;</span>6.7</div>
                </div>
            </marquee>
    
          </div>
    
</body>
</html>