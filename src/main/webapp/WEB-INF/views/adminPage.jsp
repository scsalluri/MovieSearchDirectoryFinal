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
 font-family: 'Poppins', sans-serif;
  background-image: url('/resources/images/background1.png');
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
    width:70% 
    margin-left:1.5cm;
    padding: 45px;
    text-align: center;
    opacity: 90%;
    top:200px;
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
        h1{
            text-align: centre;
            
   
            }
</style>
</head>
<title>Admin Forms</title>
<body>

<div class="container">
    
  <div class="topright"  > 
  		



         <h1 style="color:white" >Admin Settings</h1>
         
  </div>
    
</div>
<div class="topnav">
  <a href="logout">
  <img src="/resources/images/logout.png" width="60" height="60">
  </a>
</div>
    <div id="adminchoice">
    <h1 style="color: white"> Select Forms</h1>

    <table align="center" style="color: red">
      <tr>
          <td><figure>

              <a href="movieForm"><img src="/resources/images/add movie.png"  width="100" height="100"></a>
              
              </figure></td>

        
          <td><figure>

              <a href="awardForm"><img src="/resources/images/movie award.png"  width="100" height="100"></a>
              
              </figure></td>
   
          <td><figure>

              <a href="castForm"><img src="/resources/images/cast.png"  width="100" height="100"></a>
              </figure></td>
              
           <td><figure>
              <a href="edit_form"><img src="/resources/images/edit_movie.png"  width="100" height="100"></a>
              </figure></td>
              
            <td><figure>
              <a href="language"><img src="/resources/images/language.png"  width="100" height="100"></a>
              </figure></td>
              
               <td><figure>
              <a href="genre"><img src="/resources/images/genre.png"  width="100" height="100"></a>
              </figure></td>
              
              <td><figure>
              <a href="award"><img src="/resources/images/add award.png"  width="100" height="100"></a>
              </figure></td>
               <td><figure>
              <a href="comp"><img src="/resources/images/add company.png"  width="100" height="100"></a>
              </figure></td>
      </tr>


    </table>
    
    
    </div>


</body>
</html>