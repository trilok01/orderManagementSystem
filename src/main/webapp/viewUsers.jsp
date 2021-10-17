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

	<h1 align="center">Employee Details</h1>
	
	<p style = "color: white;">${message }</p>
	
	<table id = "orders">
		<tr >
	
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Designation</th>
			<th>Email</th>
			<th>Password</th>
			<th>Manager Id</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach items="${elist}" var="u">
			<tr >
				<td>${u.getId()}</td>
				<td>${u.getF_name()}</td>
				<td>${u.getL_name()}</td>
				<td>${u.getDesig()}</td>
				<td>${u.getEmail()}</td>
				<td>${u.getPassword()}</td>
				<td>${u.getMgr_id()}</td>
				<td><a href="editform.jsp?id=${u.getId()}">Edit</a></td>
				<td><a href="deleteUser.jsp?id=${u.getId()}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<div></div>
</body>
</html>
</body>
</html>