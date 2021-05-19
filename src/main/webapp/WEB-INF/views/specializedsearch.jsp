<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
body{
    font-family: "Poppins", sans-serif;
    background-image: url('https://images8.alphacoders.com/100/thumb-1920-1003220.png');
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: cover;
  }
 .main{
    color: aliceblue;
    padding: auto;
    margin-left: 6cm;

 }
 .reports{
     margin-left: 10cm;
     color: aliceblue;
     padding-bottom: 10cm;
     margin-top: -1cm;
 }
 .logout{
    text-decoration: crimson;
    padding: 10px 26px;
    margin-top: -11.5cm;
    display: inline-block;
    float: right;
    

 }
.logout a{
    color: #bd0000;
}
 .form{
     opacity: 90%;
     padding-bottom: 100px;
     padding-top: 260px;
     padding-right: 100px;
     padding-left: 100px;
     background-color:black;
     margin-top: -8cm;
     margin-left:4cm;
     margin-right: 4cm;
 }
 .head{
     color: aliceblue;
     margin-top: -7cm;
     margin-left: -1cm;
 }
 .sbname{
     margin-left:9cm;
     color: aliceblue;
 }
 .form1{
     color: aliceblue;
     margin-left:7cm;
 }
 .or{
     margin-left: 4.5cm;
 }
 .form2{
     color: aliceblue;
 }
.btn{
    background: #bd0000;
    color: #ffffff;
    border: 0;
    padding: 5px;
    cursor: pointer;
}
</style>
<title>Document</title>  
</head>
<body>
    <div class="main">
    <h4>Hi,username</h4>
</div>
    <div class="reports">
        <h4>Reports</h4>
    </div>
    <div class="logout">
        <a href="#">Logout</a>
    </div>
    <div class="form">
        <form>
            <div class="head">
              <h2>Search Movies</h2>
            </div>
            <div class="sbname">
                <h3>Search by Movie Name</h3>
            </div>
            <div class="form1">
            <form>
                <label >Movie Name</label>
                <input type="text" id="mname" name="mname">
                <input class="btn" type="submit" value="Search">
                </form>
                <div class="or">
                <h3>OR</h3>
               </div>
               <div class="form2">
               <form>
                   <label style="margin-left: -2cm; padding-bottom: 3px;margin-top: 2cm;">Genre</label>
                <input  type="text" id="genre" name="genre">
                <label style="margin-left: 1cm;padding-bottom: 3px;margin-top: 2cm;" >Director</label>
                <input type="text" id="director" name="director"><br>
                <label style="margin-left: -2cm;padding-bottom: 3px;margin-top: 2cm;">Actor</label>
                <input type="text" id="actor" name="actor">
                <label style="margin-left: 1cm;padding-bottom: 3px;margin-top: 2cm;">Actress</label>
                <input style="margin-top: 1cm;" type="text" id="actress" name="actress"><br>
                <label style="margin-left: -3cm;padding-bottom: 3px;margin-top: 2cm;">User Rating</label>
                <input type="text" id="rating" name="rating">
                <label style="margin-left: 1cm;padding-bottom: 3px;margin-top: 2cm;">Language</label>
                <input style="margin-top: 1cm;" type="text" id="lang" name="lang">

               </form>
               </div>
        
        </div>
        </form>

        <form style="margin-left: 10cm; margin-top: 1cm;">
            <input class="btn" type="submit" value="Specialised Search">
        </form>
        
    </div>

</body>
</html>