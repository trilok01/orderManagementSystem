<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.quinnox.project.orderSupplies.empcrud.dao.ProductDAO,
    com.quinnox.project.orderSupplies.empcrud.model.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	
	Product p = new Product();
	
	p.setProd_name(request.getParameter("name"));
	p.setPrice(Integer.parseInt(request.getParameter("price")));
	p.setRating(Float.parseFloat(request.getParameter("rating")));
	p.setDescription(request.getParameter("description"));
	p.setSup_id(Integer.parseInt(request.getParameter("sup_id")));
	p.setQuantity(Integer.parseInt(request.getParameter("quantity")));
	
	int i = ProductDAO.save(p);
	String message = "";
	
	if (i > 0) {
		message = "Product Added Successfully";
	} else {
		message = "Something went Wrong";
	}
	
	response.sendRedirect("addProduct.jsp?sup_id=" + Integer.parseInt(request.getParameter("sup_id")) + "&message=" + message);
	%>
</body>
</html>