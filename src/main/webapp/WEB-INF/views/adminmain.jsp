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
    max-width: 460px;
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
  <img src="http://www.clker.com/cliparts/R/6/l/K/8/R/search-icon-red-hi.png" width="60" height="50">
  </a>
  
</div>
    <div id="adminchoice">
    <h2 style="color: white"> Select Forms</h2>

    <table style="color: red">
      <tr>
          <td><figure>

              <a href="#"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Drama-film-stub-icon.svg/1200px-Drama-film-stub-icon.svg.png"  width="60" height="60"></a>
              <figcaption><a href="#">MOVIES</a></figcaption>
              </figure></td>

          <td><figure>

              <a href="#"><img src="https://as2.ftcdn.net/jpg/01/40/48/37/500_F_140483708_dF4sTuJhpqx6jywpDW5Qt5sqL7gfDkHh.jpg"  width="50" height="50"></a>
              <figcaption><a href="#">COMPANY</a></figcaption>
              </figure></td>
          <td><figure>

              <a href="#"><img src="https://cdn.iconscout.com/icon/premium/png-256-thumb/movie-award-2583133-2153617.png"  width="50" height="50"></a>
              <figcaption><a href="#">MOVIE AWARD</a></figcaption>
              </figure></td>
      </tr>
         <tr>
          <td><figure>

              <a href="#"><img src="https://icon-library.com/images/casting-icon/casting-icon-15.jpg"  width="50" height="50"></a>
              <figcaption><a href="#">CAST</a></figcaption>
              </figure></td>

          <td><figure>

              <a href="#"><img src="https://lh3.googleusercontent.com/proxy/yEw3TW65IW_Y_RKJvit0kLgctGE1wSMVxTd3WMVkU62PxIA4llS-LGmgBcL2jvvwV9D_qHInwD4Ao4nV8D3IukG9SrhmGoFCOHMT_QmgHs0dpQ"  width="50" height="50"></a>
              <figcaption><a href="#">TRAILER</a></figcaption>
              </figure></td>
      </tr>


    </table>
    
    
    </div>


</body>
</html>