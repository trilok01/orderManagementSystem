<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
	form{
		text-align: center;
	}
	
	select{
		width: 60%;
		height: 45px;
	}
	
	#submit{
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
	
	#submit:hover{
		background-color: #059862;
		cursor: pointer;
	}
	
</style>

</head>
<body>

	<form action = "${pageContext.request.contextPath}/SupplierServlet?emp_id=${emp_id }" method = "post">
		<select name = "prod_id">
			<c:forEach items="${plist}" var="u">
				<option value = "${u.getProd_id()}">
					${u.getSup_id()} ${u.getProd_name()} ${u.getPrice()} ${u.getDescription()}
				</option>
			</c:forEach>
		</select>
		
		<br><br>
		
		<input type = "submit" name = "submit" id = "submit" value = "Select Supplier">
	</form>
</body>
</html>