<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "com.quinnox.project.orderSupplies.empcrud.dao.OrderDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int orderId = Integer.parseInt(request.getParameter("OrderId"));
		int mgr_id = Integer.parseInt(request.getParameter("mgr_id"));
		
		//System.out.println("order id is: " + orderId);
		int OrderStatus = OrderDAO.updateOrder(orderId, " ", "supplier", "Processing", " ");
		//System.out.println("order status is: " + OrderStatus);
		
		if(OrderStatus > 0) {
			request.setAttribute("message", "Order Placed Successfully");
			//System.out.println("inside if");
		}
		else {
			request.setAttribute("message", "Something went Wrong");
		}
		
		response.sendRedirect("EmpOrderServlet?Id=" + mgr_id +"&nxtState=mgr");
	%>
</body>
</html>