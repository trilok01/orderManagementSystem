<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>

<style>

	/*$ruler: 16px;
	$color-red: #AE1100;
	$color-bg: #EBECF0;
	$color-shadow: #BABECC;
	$color-white: #FFF;*/

	body{
		background-image: url('images/loginbg.jpg');
		text-align: center;
		animation: breath_af 40s linear 1;
	}
	
	@keyframes breath_af {
		0%   { background-size: 150% auto; }
		18% { background-size:100% auto; }
		80% { background-size: 110% auto; }
		100% { background-size: 100% auto; }
	}
	
	form{
		margin-top: 100px;
		width: 40%;
		margin-left: auto;
		margin-right: auto;
		padding: 40px 20px;
		border-radius: 60px;
		border: 1px solid white;
		/*box-shadow: 12px 12px 16px 0 rgba(255, 255, 255, 1), -8px -8px 12px 0 rgba(0, 0, 0, 1);
		background: linear-gradient(135deg, rgba(0,0,0,1), rgba(255,255,255,0.25));*/
	}
	
	h1{
		color: white;
	}
	
	input {
		border: 0;
		outline: 0;
		font-family: "Times New Roman", Times, serif;
		font-size: 16px;
		border-radius: 320px;
		padding: 16px;
		background-color: rgba(0, 0, 0, 0.1);
		color: white;
		margin-right: 8px;
		box-shadow:  inset 2px 2px 5px black, inset -5px -5px 10px #FFF;
		width: 100%;
		box-sizing: border-box;
		transition: all 0.2s ease-in-out;
		appearance: none;
		-webkit-appearance: none;
	}
	
	::placeholder{
		color: white;
		font-family: "Times New Roman", Times, serif;
	}
	
	input:focus {
		box-shadow:  inset 1px 1px 2px black, inset -1px -1px 2px #FFF;
	}
  
	#error{
		float: left;
		display: inline;
	}
	
	#forgetPass{
		float: left;
		color: white;
		text-decoration: none;
	}
  
	#submit {
		color:white;
		width: 30%;
		float: right;
		font-weight: bold;
		box-shadow: -5px -5px 20px black,  5px 5px 20px white;
		transition: all 0.2s ease-in-out;
		cursor: pointer;
		font-weight: 600;
	}
  
	#submit:hover {
		box-shadow: -2px -2px 5px #FFF, 2px 2px 5px #BABECC;
	}
  
	#changediv{
		text-decoration: none;
		padding: 10px;
		color: white;
		border-radius: 320px;
		font-weight: bold;
		box-shadow: -5px -5px 20px black,  5px 5px 20px white;
		transition: all 0.2s ease-in-out;
		cursor: pointer;
	}
  
	#changediv:hover {
		box-shadow: -2px -2px 5px #FFF, 2px 2px 5px #BABECC;
	}
  
</style>

<script>
		function myFunction(){
			var url_string = window.location.href;
			var url = new URL(url_string);
			var e = url.searchParams.get("var");
			document.getElementById("errorMessage").innerHTML = e;
		}
</script>

</head>
<body onload = myFunction()>
	
	<%
		String emp_type = request.getParameter("emp_type");
		String display_type = emp_type;
		if(display_type.equals("emp")) display_type = "Employee";
		if(display_type.equals("manager")) display_type = "Manager";
		if(display_type.equals("supplier")) display_type = "Supplier";
		if(display_type.equals("qm")) display_type = "Quality Manager";
		if(display_type.equals("admin")) display_type = "Admin";
	%>
	
	
	<form id = "loginForm" method = "post" action = "LoginProcess.jsp">
		<h1>Login as <%= display_type %></h1>
		<br>
		<input type = "text" name = "userType" id = "userType" class = "formElements" value = "<%= emp_type %>" hidden>
		
		<input type = "text" name = "userName" id = "userName" class = "formElements" placeholder = "User Name" required>
		<br><br>
		<input type = "password" name = "password" id = "password" class = "formElements" placeholder = "Password" required>
		<br><br>
		<div id = "error">
			<a href = "#" id = "forgetPass">Forgotten Password?</a>
			<br><br>
			<span id = "errorMessage" style = "color: #000;"></span>
		</div>
		<input type = "submit" name = "submit" id = "submit" value = "Log In">
		<br><br><br>
		<hr>
		<br>
		<center>
		<a id = "changediv" href = "loginPage.html">Login as another user type</a>
		</center>
		
	</form>
</body>
</html>