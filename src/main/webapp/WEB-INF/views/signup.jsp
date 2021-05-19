<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <style>
    body{
    background-image: url('https://images8.alphacoders.com/100/thumb-1920-1003220.png');
    /*height: 100vh;
    background-color: #000000;*/
    background-size: cover;
    background-position: center;
    
}
.sign-up-form{
    width: 360px;
    padding: 10% ;
    margin:auto;
    
}
.form{
    font-family: "Poppins", sans-serif;
    position:relative;
    z-index: 1;
    background: #000000;
    max-width: 360px;
    margin: 0 auto ;
    padding: 45px;
    text-align: center;
    opacity: 90%;
    top:20%;
}
.form h3{
    color: #ffffff;
    margin: auto;
}
.form input{
    font-family: "Poppins", sans-serif;
    outline: 1;
    background: #f2f2f2;
    width: 100%;
    border: 0;
    margin: 15px 0 15px;
    box-sizing: border-box;
    padding: 5px;
    
}
#signupSubmit{
    font-family:"Poppins", sans-serif;
    text-transform: uppercase;
    cursor: pointer;
    background: #bd0000;
    width: 100%;
    color: #ffffff;
    padding: 5px;
    border: 0;
    margin-top: 15px;
    
}
.message{
    font-family: "Poppins", sans-serif;
    font-size: 10px;
    color: #ffffff;
}
.form a{
    color: #bd0000;
    margin-left: 10px;
    
}
    </style>
<title>Sign Up</title>
    
</head>

<body>
    
    
        
        <div class="sign-up-form">
    	<div class="form" >
    	<form class="register-form"  action="maincontroller" method="POST" action="save-user">
            <h3>User Registration</h3>
            <input type="hidden" name="id" value="${user.id} /">
            <input type="text" placeholder="User Name" name="username" value="${user.username} "/>
            <input  type="text" placeholder="First Name" name="firstname" value="${user.firstname} "/>
            <input type="text" placeholder="Last Name" name="lastname" value="${user.lastname} "/>
            <input type="email" placeholder="Email ID" name="email" value="${user.email}"/>
            <input type="password" placeholder="Password" name="password" value="${user.password}">
            <input type="password" placeholder="Re-enter Password" name="repass"/>
            <input type= "submit" value="Register" id="signupSubmit"/>
            <p class="message">Already Registered? <a href="login"><strong>Login Here</strong></a></p>

        
       </form>  
     </div>
    </div>       

   
    

</body>
</html>