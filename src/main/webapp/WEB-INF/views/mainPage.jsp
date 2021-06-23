<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
body {
  background-image: url('/resources/images/mainPage.png');
  
  background-attachment: fixed;
  background-size: 100% 100%;
}
.container {
  position: relative;
}

.topnav{

  position:absolute;
  top: 18px;
  right: 50px;
  font-size: 28px;
}
#adminchoice{
    font-family: "Poppins", sans-serif;
    position:relative;
    z-index: 1;
    background: #000000;
    max-width: 960px;
    
    top:80px;
    margin: 0 auto ;
    padding: 25px;
    text-align: center;
    opacity: 80%;
    padding-top: 40px;
    left:10px;
    
}
.col-2 {
    width: 32%;
    float: left;
}
            .searchTerm {
            width: 35%;
            border: 5px solid gray;
            border-right: none;
            padding: 6px;
            border-radius: 5px 0 0 5px;
            outline: none;
            color: #9DBFAF;
            }
            .searchTerm:focus{
            color: gray;
            }
            .searchButton {
            margin-left:0px;
            width: 35px;
            height: 50px;
            border: 1px solid gray;
            background: gray;
            text-align: center;
            color: #fff;
            border-radius: 0 5px 5px 0;
            cursor: pointer;
            font-size: 20px;
            }
            .searchButton i{
            color: white;
            }
   .heading{
            text-align: left;
            font-size: 25px;
            border-left: 5px solid red;
            padding-left: 10px;
    }


    #search{
        padding-bottom:20px ;
        
    }
   
    form{
        font-size: large;
        font-weight: bold;
    }
    
.tablepad
{
padding-left: 30px;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Welcome To Movie Search Directory</title>
</head>
<body>


<div class="topnav">
  <a href="login"><img src="/resources/images/user.png" width="60" height="50">
  </a>
</div>	



    <div id="adminchoice">
    
		
		<TABLE  style="color:red; width: 100% ">
			<TR>
			<TD><MARQUEE><H1 style="color:#FFA500">Welcome to<img src="/resources/images/icon.png" height="80px"></H1></MARQUEE></TD>
			
			</TR>
		</TABLE>
		
 
 <form action="nameSearch">
    <table style="color:white; align-self: left; margin-top: 50px; width: 100%" >
     
        <tr height="50px"> 
            
               <td align="left">
               
             
                  
               
                     <label class="heading">Search by Movie Name</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="text" id="movname" name="movname" required min="1" class="searchTerm" placeholder="What are you looking for?">
                       <button type="submit" class="searchButton">
                         <i class="fa fa-search"></i>
                      </button>
                  
             
               
               
                     </td>
          </tr>
         
          <tr height="50px"> 
          <td>
		   <label style="color:red;">OR</label>
		   </td>
		 </tr>
		    <tr height="50px">
          <td  align="left">
		   <label class="heading">Specialized Search</label>
		   </td>
		 </tr>
          </table>
    
    </form>
          

<form action="specializedSearch">
    <table class="t3" style="color: red; margin-top: 30px;width:100%;">
      <tr>
          <td>
            
            <label for="Genre">Genre:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
          <select style="padding: 5px;width:200px" name="genre" id="genre" > 
           <option value="Select Genre">Select Genre</option>
			<c:forEach var="gens" items="${gen}">
	         	  <option value="${gens.genreName}">${gens.genreName}</option>
	          	 </c:forEach>
			</select> 
            <br></br>
          
           
          </td>

          <td class="tablepad">
          
            <label for="Director">Director:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <select style="padding: 5px;width:200px" name="director" id="director" > 
             <option value="Select Director">Select Director</option>
			<c:forEach var="dir" items="${director}">
	         	 <option value="${dir}">${dir}</option>
	          	 </c:forEach>
			</select> 
            <br></br>
          



            </td>
        </tr>
    
        <tr>
          <td>
    
            <label>Actor:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <select style="padding: 5px;width:200px" name="actor" id="actor" > 
             <option value="Select Actor">Select Actor</option>
			<c:forEach var="act" items="${actor}">
	         	 <option value="${act}">${act}</option>
	          	 </c:forEach>
			</select> 
            <br></br>
         
      
    
          
          </td>

          <td class="tablepad">
           


            <label for="Actress">Actress:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
            <select style="padding: 5px;width:200px" name="actress" id="actress" > 
             <option value="Select Actress">Select Actress</option>
			<c:forEach var="actr" items="${actress}">
	         	 <option value="${actr}">${actr}</option>
	          	 </c:forEach>
			</select> 
            <br></br>
       
     


            </td>
            <td id="search">&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" class="btn btn-danger" value="Specialised Search" /></td>
        </tr>
        <tr>
          <td>
    
            <label for="User rating">User rating:</label>
          <select style="padding: 5px;width:200px" name="rating" id="rating" > 
           <option value="Select Rating">Select Rating</option>
			<%for ( int i = 1; i <= 10; i++){ %>
         <option><%= i %></option>
      <%}%>
			</select> 
            
        
  
    
          
          </td>

          <td class="tablepad">
        
            <label for="language">Language:&nbsp;&nbsp;&nbsp;</label>
            <select style="padding: 5px;width:200px" name="language" id="language" > 
             <option value="Select Language">Select Language</option>
			<c:forEach var="lang" items="${langs}">
	         	 <option value="${lang.languageName}">${lang.languageName}</option>
	          	 </c:forEach>
			</select> 
           
           
           


            </td>
        </tr>
        
         


    </table>
      <input type="hidden" value="mainPage" name="regUser" />
    </form>>
    
    </div>

</body>
</html>