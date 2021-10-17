<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>

	body{
		padding: 0;
		margin: 0;
	}
	
	#orders {
	  border-collapse: collapse;
	  width: 100%;
	  text-align: center;
  	}
  	
  	#orders td{
  		color: white;
  	}

	#orders td, #orders th {
	  padding: 8px;
	}
	
	#orders tr {}
	
	#orders tr:hover {background-color: #166d3b;}
	
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
	
</style>

</head>
<body>

	<table id = "orders">
		<tr>
			<th>Order No.</th>
			<th>Product</th>
			<th>Supplier</th>
			<th>Status</th>
			<th>Timestamp</th>
			<th>Comment</th>
		</tr>
		
		<c:forEach items="${olist}" var="u">
			<tr>
				<td>${u.getOrder_id()}</td>
				<td>${u.getProd_id()}</td>
				<td>${u.getSupplier_id()}</td>
				<td>${u.getStatus()}</td>
				<td>${u.getOrderDate()}</td>
				<td>${u.getComments()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>