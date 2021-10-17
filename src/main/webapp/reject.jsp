<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.quinnox.project.orderSupplies.empcrud.dao.OrderDAO,com.quinnox.project.orderSupplies.empcrud.model.Order"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reject</title>

<style>
body{
		padding: 0;
		margin: 0;
	}
	form{
		padding: 20px;
		height: 100%;
	}
	
	input, textarea {
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
	
	textarea:focus {
		box-shadow:  inset 1px 1px 2px black, inset -1px -1px 2px #FFF;
	}
	
	#des{
		border-radius: 20px;
	}

	label{
		color: white;
	}
	
	#submit{
		box-shadow: 2px 2px 5px #FFF, -5px -5px 10px black;
		width: 150px;
	}
	
	#submit:hover{
		cursor: pointer;
		box-shadow: -2px -2px 5px #FFF, 2px 2px 5px black;
	}
	
	div{
	height: 100px;
    width: 100px;
}
</style>

</head>
<body>
	
			<%
	String id = request.getParameter("Order_id");
	Order u = OrderDAO.getRecordById(Integer.parseInt(id));
	%>
	
	<form action="RejectServlet" method="post">
		<input type="hidden" name="emp_id" value="<%=u.getEmp_id()%>" />
		<input type="hidden" name="mgr_id" value="<%=u.getMgr_id()%>" />
		<input type="hidden" name="Order_date" value="<%=u.getOrderDate()%>" />
		<input type="hidden" name="prod_id" value="<%=u.getProd_id()%>" />
		<input type="hidden" name="supplier_id" value="<%=u.getSupplier_id()%>" />
			
		<label for = "order_id">Order ID:</label><br><br>
		<input type="text" id = "order_id" name="Order_id" value="<%=u.getOrder_id()%>" readonly/>
		<br><br>
		<label for = "comment">Comments:</label><br><br>
		<input type="text" id = "comment" name="Comments" required/>
		<br><br>
		<label for = "status">Status:</label><br><br>
		<input type="text" id = "status" name="status" value="rejected" readonly/>
		<br><br>
		<label for = "rejected_by">Rejected By:</label><br><br>
		<input type="text" id = "rejected_by" name="rejected_by" value="supplier" readonly/>
		<br><br>
		<label for = "next_state">Next State:</label><br><br>
		<input type="text" id = "next_state" name="next_state" value="rejected" readonly/>
		<br><br>
		<input type="submit" id = "submit" value="Reject Order" />
	</form>
	
	<div></div>
</body>
</html>