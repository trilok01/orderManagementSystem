<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>

<style>
	body{
		padding: 0;
		margin: 0;
		text-align: center;
	}
	
	#orders {
	  border-collapse: collapse;
	  width: 100%;
	  text-align: center;
  	}

	#orders td, #orders th {
	  padding: 8px;
	}
	
	#orders tr {
		color: white;
	}
	
	#orders tr:hover {
		background-color: #166d3b;
	}
	
	#orders th {
	  padding-top: 12px;
	  padding-bottom: 12px;
	  color: white;
	  background-color:black;
		
	}
	
	th {
      position: sticky;
      top: 0;
    }
    
    a{
    	color: white;
    }
    
    div{
    	width: 50px;
    	height: 50px;
    }
</style>

</head>
<body>

	<h1 align="center">Supplier Details</h1>
	
	<p style = "color: white;">${message }</p>
	
	<table id = "orders">
		<tr >
	
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach items="${slist}" var="u">
			<tr >
				<td>${u.getSupplierId()}</td>
				<td>${u.getName()}</td>
				<td>${u.getEmail()}</td>
				<td>${u.getPassword()}</td>
				<td><a href="editSupplierForm.jsp?id=${u.getSupplierId()}">Edit</a></td>
				<td><a href="deleteSupplier.jsp?id=${u.getSupplierId()}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<div></div>
</body>
</html>
</body>
</html>