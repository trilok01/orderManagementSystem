<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "com.quinnox.project.orderSupplies.empcrud.model.Employee,
    com.quinnox.project.orderSupplies.empcrud.dao.EmployeeDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
	form{
		width: 60%;
		margin-left: auto;
		margin-right: auto;
		padding: 40px 20px;
		/*box-shadow: 12px 12px 16px 0 rgba(255, 255, 255, 1), -8px -8px 12px 0 rgba(0, 0, 0, 1);
		background: linear-gradient(135deg, rgba(0,0,0,1), rgba(255,255,255,0.25));*/
	}
	
	label{
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
	
	input:focus {
		box-shadow:  inset 1px 1px 2px black, inset -1px -1px 2px #FFF;
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
	
	div{
		height: 50px;
		width: 50px;
	}
	
</style>

</head>
<body>
	<%
	
	String id=request.getParameter("id");
	Employee u = EmployeeDAO.getRecordById(Integer.parseInt(id));

	%>
		
	<form id = "editForm" action="UpdateServlet" method="post">
	
		<input type="hidden" name="emp_id" value="<%=u.getId()%>" />
		
		<label for = "fname">First Name:</label><br><br>
		<input type="text" id = "fname" name="f_name" value="<%=u.getF_name()%>" /><br><br><br>
		
		<label for = "lname">Last Name:</label><br><br>
		<input type="text" id = "lname" name="l_name" value="<%=u.getL_name()%>" /><br><br><br>
			
		<label for = "desig">Designation:</label><br><br>
		<input type="text" id = "desig" name="desig" value="<%=u.getDesig()%>" /><br><br><br>
			
		<label for = "email">Email:</label><br><br>
		<input type="email" name="emailid" value="<%=u.getEmail()%>" /><br><br><br>
			
		<label for = "pass">Password:</label><br><br>
		<input type="text" id = "pass" name="password" value="<%=u.getPassword()%>" /><br><br><br>
			
		<label for = "mgr_id">Manager Id:</label><br><br>
		<input type="text" id = "mgr_id" name="mgr_id" value="<%=u.getMgr_id()%>" /><br><br><br>
			
		<input id = "submit" type="submit" value="Edit User" />
		
	</form>
	<div></div>
</body>
</html>