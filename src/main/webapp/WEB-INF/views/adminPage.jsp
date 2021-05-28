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
  background-image: url('/resources/images/backdrop.png');
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
#adminchoice{
    font-family: "Poppins", sans-serif;
    position:relative;
    z-index: 1;
    background: #000000;
    max-width: 700px;
    margin: 0 auto ;
    padding: 45px;
    text-align: center;
    opacity: 90%;
    top:150px;
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
        h2{
            text-align: left;
            
            border-left: 5px solid red;
            padding-left: 10px;
            }
</style>
</head>
<title>Admin Forms</title>
<body>

<div class="container">
    
  <div class="topright"  > 
         <a href="#" style="color:white" >Admin Settings</a>
  </div>
    
</div>
<div class="topnav">
  <a href="#">
  <img src="/resources/images/search.png" width="60" height="50">
  </a>
  
</div>
    <div id="adminchoice">
    <h2 style="color: white"> Select Forms</h2>

    <table style="color: red">
      <tr>
          <td><figure>

              <a href="movieForm"><img src="/resources/images/add movie.png"  width="100" height="100"></a>
              
              </figure></td>

        
          <td><figure>

              <a href="awardForm"><img src="/resources/images/movie award.png"  width="100" height="100"></a>
              
              </figure></td>
   
          <td><figure>

              <a href="#"><img src="/resources/images/cast.png"  width="100" height="100"></a>
              </figure></td>
              
           <td><figure>
              <a href="#"><img src="/resources/images/edit_movie.png"  width="100" height="100"></a>
              </figure></td>

      </tr>


    </table>
    
    
    </div>


</body>
</html>