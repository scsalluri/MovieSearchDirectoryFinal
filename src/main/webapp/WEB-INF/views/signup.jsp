<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>

<script type="text/javascript">
function func()
{
	var pass=document.myform.password.value;
	var repass=document.myform.repassword.value;
	var n = pass.localeCompare(repass);
		if(n!=0)
		{
			alert("password and re-type password should match!!");
			location.replace(location)
		}
		else
		{
		window.location = "/save-user";
		}
	}
</script>

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
.form button{
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
#i12{
  color: red;
  font-size: 13px;
}
    </style>
<title>Sign Up</title>
    
</head>

<body>
    
    
        
        <div class="sign-up-form">
    	<div class="form" >
    	<form:form class="register-form"  onsubmit="func()"  method="POST" action="save-user" modelAttribute="user" name="myform">
            <h3>User Registration</h3>
            <form:input type="hidden" name="id" value="${user.id}" path="id" />
            <form:input type="text" placeholder="User Name" name="username" path="username"  value="${user.username} "/>
            <form:errors id="i12" path="username" cssClass="text-danger" />
            <form:input  type="text" placeholder="Full Name" name="fullname" path="fullname" value="${user.fullname} "/>
            <form:errors id="i12" path="fullname" cssClass="text-danger" />
            <form:input type="email" placeholder="Email ID" name="email" path="email" value="${user.email}"/>
            <form:errors id="i12" path="email" cssClass="text-danger" />
            <form:input type="password" placeholder="Password" name="password" path="password" value="${user.password}"/>
             <form:errors id="i12" path="password" cssClass="text-danger" />
            <input type="password" placeholder="Re-enter Password" name="repassword" />
         
            <form:button type="submit">Register</form:button>
            <p class="message">Already Registered? <a href="login"><strong>Login Here</strong></a></p>

        
       </form:form>  
     </div>
    </div>       

   
    

</body>
</html>