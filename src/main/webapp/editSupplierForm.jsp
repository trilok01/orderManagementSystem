<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "com.quinnox.project.orderSupplies.empcrud.model.Supplier,
    com.quinnox.project.orderSupplies.empcrud.dao.SupplierDAO"%>
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
	Supplier s = SupplierDAO.getSupplier(Integer.parseInt(id));

	%>
		
	<form id = "editForm" action="UpdateSupplierServlet" method="post">
	
		<input type="hidden" name="sup_id" value="<%=s.getSupplierId()%>" />
		
		<label for = "name">Name:</label><br><br>
		<input type="text" id = "name" name="name" value="<%=s.getName()%>" /><br><br><br>
			
		<label for = "email">Email:</label><br><br>
		<input type="email" name="emailid" value="<%=s.getEmail()%>" /><br><br><br>
			
		<label for = "pass">Password:</label><br><br>
		<input type="text" id = "pass" name="password" value="<%=s.getPassword()%>" /><br><br><br>
			
		<input id = "submit" type="submit" value="Edit User" />
		
	</form>
	<div></div>
</body>
</html>