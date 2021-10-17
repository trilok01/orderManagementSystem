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
		text-align: center;
	}
	
	form{
		text-align: center;
	}
	
	select{
		width: 60%;
		height: 45px;
	}
	
	.btn{
		padding: 15px 25px;
		color: #fff;
		background-color: #000;
		border: none;
		color: white;
		border-radius: 5px;
		box-shadow: 12px 12px 16px 0 rgba(0, 0, 0, 1), -8px -8px 12px 0 rgba(255, 255, 255, 0.3);
	   	background: linear-gradient(135deg, rgba(0,0,0,1), rgba(255,255,255,0.25));
	   	font-family: "Times New Roman", Times, serif;
	   	font-size: 15px;
	    font-weight: bold;
	}
	
	.btn:hover{
		background-color: #059862;
		cursor: pointer;
	}
</style>

</head>
<body>
	<p id = "abc" style = "color: white;">${message }</p>
	<form action = "${pageContext.request.contextPath}/OrderServlet" method = "post">
		<input type = "hidden" name = "emp_id" value = "${emp_id }">
		<input type = "hidden" name = "prod_id" value = "${prod_id }">
		<input type = "hidden" name = "status" value = "Processing">
		<input type = "hidden" name = "status1" value = "${wasRejected }">
		<input type = "hidden" name = "order_id" value = "${order_id }">
		<!-- <input type = "hidden" name = "next_state" value = "supplier"> -->
		<input type = "hidden" name = "comment" value = "">
		<input type = "hidden" name = "rejected_by" value = "">
		<select name = "sup_id">
			<c:forEach items="${slist}" var="u">
				<option value = "${u.getSupplierId()}">${u.getName()}</option>
			</c:forEach>
		</select>
		
		<br><br>
		
		<input type="button" onclick="window.history.go(-1);" value="Back" name="button" class="btn">
		<input type = "submit" name = "submit" id = "submit" class = "btn" value = "Place Order">
	</form>
</body>
</html>