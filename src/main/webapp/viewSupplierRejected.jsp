<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"
import = "com.quinnox.project.orderSupplies.empcrud.dao.ProductDAO,
com.quinnox.project.orderSupplies.empcrud.dao.ProductDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	
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
	
	<p style = "color: white;"><%=request.getParameter("message") %></p>
	
	<table id = "orders">
		<tr>
			<th>Order No</th>
			<th>Emp Id</th>
			<th>Product Name</th>
			<th>Prev. Supplier</th>
			<th>Comment</th>
			<th>New Supplier</th>
		</tr>
		
		<c:forEach items="${olist}" var="u" varStatus = "status">
			<tr>
				<td>${u.getOrder_id()}</td>
				<td>${u.getEmp_id() }</td>
				<td>${plist[status.index].getProd_name()}</td>
				<td value = "${slist[status.index].getSupplierId()}">${slist[status.index].getName()}</td>
				<td>${u.getComments()}</td>
				<td><a href = "SupplierServlet?prod_id=${plist[status.index].getProd_id()}&emp_id=${u.getEmp_id()}&status=wasRejected&order_id=${u.getOrder_id()}">Select supplier</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>