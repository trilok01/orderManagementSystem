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
		text-align: center;
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
    
    a{
    	color: white;
    }
	
</style>

</head>
<body>
	
	<input type = "hidden" name = "emp_id" value = "${emp_id }">
	<input type = "hidden" name = "prod_id" value = "${prod_id }">
	<input type = "hidden" name = "status" value = "Processing">
	<input type = "hidden" name = "next_state" value = "supplier">
	<input type = "hidden" name = "comment" value = "">
	<input type = "hidden" name = "rejected_by" value = "">

	<p style = "color: white;">${message }.</p>

	<table id = "orders">
		<tr>
			<th>Emp Id</th>
			<th>Product</th>
			<th>Supplier</th>
			<th>Approve</th>
			<th>Reject</th>
		</tr>
		<c:forEach items="${olist}" var="u" varStatus = "status">
			<tr>
				<td>${u.getEmp_id()}</td>
				<td value = "${plist[status.index].getProd_name()}">${plist[status.index].getProd_name()}</td>
				<td value = "${slist[status.index].getSupplierId()}">${slist[status.index].getName()}</td>
				<td><a href = "OrderServlet?OrderId=${u.getOrder_id() }&mgr_id=${u.getMgr_id()}&next_state=mgr">Approve</a></td>
				
				<td><a href = "rejectForm.jsp?order_id=${u.getOrder_id() }&emp_id=${u.getEmp_id()}&prod_id=${plist[status.index].getProd_id()}&sup_id=${slist[status.index].getSupplierId()}&rej_by=mgr">Reject</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>














