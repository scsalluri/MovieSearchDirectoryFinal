<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=ISO-8859-1" %> 



<!DOCTYPE html>
<html>
    
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
function func()
{
	var pass=document.myform.password.value;
	var repass=document.myform.repassword.value;
	var n = pass.localeCompare(repass);
		if(n!=0)
		{
			alert("password and re-type password should match!!");
			return false;
		}
		
	}
</script>
<style>

/* Coded with love by Achievullah Samim */
body {
	background-image: url('/resources/images/registrationPage.png');
	height: 100vh;
	background-color: #000000;
	background-size: cover;
	background-position: left;
}

html {
	margin: 0;
	padding: 0;
	height: 100%;
	background: #60a3bc !important;
}

.user_card {
	height: 515px;
	width: 500px;
	margin-top: 150px;
    margin-bottom: auto;
	background: white;
	position: relative;
	display: flex;
	justify-content: center;
	flex-direction: column;
	padding: 10px;
    align-self:center;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	-webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	-moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	border-radius: 5px;
}

.brand_logo_container {
	position: absolute;
	height: 170px;
	width: 170px;
	top: -75px;
	border-radius: 50%;
	background: #c0392b;
	padding: 10px;
	text-align: center;
}

.brand_logo {
	height: 150px;
	width: 150px;
	border-radius: 50%;
	border: 2px solid white;
}

.form_container {

    margin-top:80px;
	
}

.btn {
	width: 100%;
	background: #c0392b !important;
	color: white !important;
}

.btn:focus {
	box-shadow: none !important;
	outline: 0px !important;
}

.login_container {
	padding: 0 2rem;
}

.input-group-text {
	background: #c0392b !important;
	color: white !important;
	border: 0 !important;
	border-radius: 0.25rem 0 0 0.25rem !important;
}

.input_user, .input_pass:focus {
	box-shadow: none !important;
	outline: 0px !important;
}

.custom-checkbox .custom-control-input:checked ~.custom-control-label::before
	{
	background-color: #c0392b !important;
}

#login {
	
	
	margin-right: 1000px;
	
}


</style>
	<title>Sign Up Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
</head>

<body>

	<div class="container h-100" id="login">
		<div class="d-flex justify-content-center h-100">
			<div class="user_card">
				<div class="d-flex justify-content-center">
					<div class="brand_logo_container">
						<img src="/resources/images/sign up.png" class="brand_logo" alt="Logo">
					</div>
				</div>
				<div class="d-flex justify-content-center form_container"  >
					<form:form class="register-form"  onsubmit="return func()"  method="POST" action="save-user" modelAttribute="user" name="myform">
						<div class="input-group mb-4" >
						      <form:input type="hidden" name="id" value="${user.id}" path="id" />
							<div class="input-group-append" >
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							  <form:input type="text" placeholder="User Name" name="username" path="username"  pattern="^[a-z0-9_-]{5,15}$"
                                title="Username should only contain alphanumeric characters. e.g. john"  value="${user.username} "/>
							   <form:errors id="i12" path="username" cssClass="text-danger" />
						</div>
						
						<div class="input-group mb-4" >
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							
            <form:input  type="text" placeholder="Full Name" name="fullname" path="fullname" pattern="^[a-zA-Z\\s]*$"
        title="Full name must contain letters and space" value="${user.fullname} "/>
            <form:errors id="i12" path="fullname" cssClass="text-danger" />
						</div>
						
						<div class="input-group mb-4" >
							<div class="input-group-append">
								<span class="input-group-text"><i class="fa fa-envelope"></i></span>
							</div>
						 <form:input type="email" placeholder="Email ID" name="email" path="email" 
						 pattern="^[a-zA-Z0-9.!#$%&'+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)$" title="Email must be abc123@xyz.com format" value="${user.email}"/>
            <form:errors id="i12" path="email" cssClass="text-danger" />
						</div>
						
						<div class="input-group mb-4" >
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							 <form:input type="password" placeholder="Password" name="password" path="password" 
							 pattern="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Password must contain one uppercase letter, one lowercase one symbol and one digit" value="${user.password}"/>
             <form:errors id="i12" path="password" cssClass="text-danger" />
						</div>
						
						<div class="input-group mb-4" >
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							 <input type="password" placeholder="Re-enter Password" name="repassword"  />
         
						</div>
						
				<div class="d-flex justify-content-center mt-4 login_container"  >
				 	<form:button class="btn" type="submit">Register</form:button>
				</div>
		 </form:form>  
				</div>
		
				<div class="mt-4">
					<div class="d-flex justify-content-center links">
						Already signed up !!!! <a href="login"  class="ml-2">Log In</a>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</body>
</html>