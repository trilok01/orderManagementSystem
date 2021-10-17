<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.quinnox.project.orderSupplies.empcrud.dao.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		
		int status = OrderDAO.updateOrder(order_id, "Quality Issue", "supplier", "rejected", "qm");
		
		String message = "";
		
		if(status == 1){
			message = "Order Rejected";
		}
		else{
			message = "Something went wrong";
		}
		
		//request.setAttribute("message", message);
		response.sendRedirect("QMOrderServlet?message=" + message);
	%>
</body>
</html>