<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "com.quinnox.project.orderSupplies.empcrud.dao.SupplierDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int sup_id = Integer.parseInt(request.getParameter("id"));
		
		int status = SupplierDAO.deleteSupplier(sup_id);
		
		String message = "";
		
		if(status == 1){
			message = "Record Deleted Successfully";
		}
		else{
			message = "Error Occured while Deleting Record";
		}
		
		response.sendRedirect("SupplierListServlet?message=" + message);
	%>
</body>
</html>