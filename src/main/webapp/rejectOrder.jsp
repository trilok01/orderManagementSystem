<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "com.quinnox.project.orderSupplies.empcrud.dao.OrderDAO,
    com.quinnox.project.orderSupplies.empcrud.dao.EmployeeDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		int prod_id = Integer.parseInt(request.getParameter("prod_id"));
		int sup_id = Integer.parseInt(request.getParameter("sup_id"));
		String comment = request.getParameter("comment");
		String rejected_by = request.getParameter("rejected_by");
		
		int mgr_id = EmployeeDAO.getMgrId(emp_id);
		int OrderStatus = OrderDAO.updateOrder(order_id, comment, "Rejected", "Rejected", rejected_by);
		
		System.out.println("after updting order table");
		
		/*request.setAttribute("nxtState", rejected_by);
		request.setAttribute("Id", mgr_id);
		request.setAttribute("message", "Order Rejected");*/
		
		response.sendRedirect("EmpOrderServlet?nxtState=" + rejected_by + "&Id=" + mgr_id + "&message=Order Rejected");
		
	%>
</body>
</html>