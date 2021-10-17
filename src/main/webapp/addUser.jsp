<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "com.quinnox.project.orderSupplies.empcrud.model.Employee,
    com.quinnox.project.orderSupplies.empcrud.dao.EmployeeDAO,
    com.quinnox.project.orderSupplies.empcrud.model.Supplier,
    com.quinnox.project.orderSupplies.empcrud.dao.SupplierDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String f_name = request.getParameter("f_name");
		String l_name = request.getParameter("l_name");
		String desig = request.getParameter("desig");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		int mgr_id = Integer.parseInt(request.getParameter("mgr_id"));
		
		int status;
		if(desig.equals("supplier")){
			Supplier s = new Supplier();
			
			s.setName(f_name);
			s.setEmail(email);
			s.setPassword(pass);
			
			status = SupplierDAO.addSupplier(s);
		}
		
		else{
			Employee e = new Employee();
			
			e.setF_name(f_name);
			e.setL_name(l_name);
			e.setDesig(desig);
			e.setEmail(email);
			e.setPassword(pass);
			e.setMgr_id(mgr_id);
			
			status = EmployeeDAO.addUser(e);
		}
		String message = "";
		
		if(status == 1){
			message = "User Added Successfully";
		}
		else{
			message = "Error Occured while Adding User";
		}
		
		response.sendRedirect("admin.html?message=" + message);
	%>
</body>
</html>