<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orders List</title>	
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
</style>
	
</head>
<body>

	<p style = "color: white;">${message }</p>
	
	<table id = "orders">
		<tr bgcolor="green">
			<th> OrderId</th>
			<th>Emp_id</th>
			<th>Manager_id</th>
			<th>Order_date</th>
			<th>Comment</th>
			<th>Product_id</th>
			<th>Supplier_id</th>
			<th>Accept</th>
			<th>Reject</th>
		</tr>
		
		<c:forEach items="${olist}" var="u">
			<tr>
				<td>${u.getOrder_id()}</td>
				<td>${u.getEmp_id()}</td>
				<td>${u.getMgr_id()}</td>
				<td>${u.getOrderDate()}</td>
				<td>${u.getComments()}</td>
				<td>${u.getProd_id()}</td>
				<td>${u.getSupplier_id()}</td>
				<td><a href="acceptedByQM.jsp?order_id=${u.getOrder_id()}">Accept</a></td>
				<td><a href="rejectedByQM.jsp?order_id=${u.getOrder_id()}">Reject</a></td>
			</tr>
		</c:forEach>
		
	</table>
	
	<br />
</body>
</html>
