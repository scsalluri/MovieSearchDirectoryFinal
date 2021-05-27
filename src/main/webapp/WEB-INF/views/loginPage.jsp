<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <style>
    body{
   background-image: url('/resources/images/backdrop.png');
    height: 100vh;
    background-color: #000000;
    background-size: cover;
    background-position: center;
    
}
.login{
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
}
.form h3{
    color: #ffffff;
    margin: auto;
}
.form input{
    position:relative;
    font-family: "Poppins", sans-serif;
    outline: 1;
    background: #f2f2f2;
    width: 100%;
    border: 0;
    margin: 15px 0 15px;
    box-sizing: border-box;
    height:25px;
    
}

.message{
    font-family: "Poppins", sans-serif;
    font-size: 10px;
    color: #ffffff;
}

    
#confirmation{
    color: #bd0000;
    margin-left: 10px;
   
}

#loginSubmit{
    font-family:"Poppins", sans-serif;
    text-transform: uppercase;
    outline:1;
    cursor: pointer;
    color:#ffffff;
    background: #bd0000;
    width: 100%;
    border: 0;
    margin: 15px 0 15px;
    box-sizing: border-box;
    height:30px;

}

</style>
<title>Login Form</title>
    
</head>

<body>
    
    <div class="login">
    <div class="form">
        <form class="form-horizontal" method="POST" action="/login-user">
            <h3>User Login</h3>
            
            <input type="text" name="username" placeholder="Enter Username"/>
            
                
            <input type="password" name="password" placeholder="Enter Password"/>
            
            
            <div>
 
            <input type="submit" value="Login" id="loginSubmit" />
            </div>
            
            <div id="confirmation">
            <p id="newuser" style="color:red">New User?
            <a href="register" id="register" style="color:red"> Register Here</a>
            </p>
            </div>
            

    </form>

    </div>
    </div>


</body>
</html>