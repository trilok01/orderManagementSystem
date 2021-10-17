<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "com.quinnox.project.orderSupplies.empcrud.dao.EmployeeDAO,
    com.quinnox.project.orderSupplies.empcrud.model.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%
		String userType = request.getParameter("userType");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("password");
		
		Employee e1 = new Employee();
		e1.setDesig(userType);
		e1.setEmail(userName);
		e1.setPassword(userPassword);
		
		int id = 0;
		id = EmployeeDAO.loginEmployee(e1);
		System.out.println("Inside login process after comming from loginEmployees and id: " + id);
		if(id > 0){
			if(userType.equals("supplier")){
				response.sendRedirect("Supplier.html?Id=" + id);
			}
			
			if(userType.equals("emp")){
				response.sendRedirect("employee.html?Id=" + id);
			}
			
			if(userType.equals("manager")){
				response.sendRedirect("manager.html?Id=" + id);
			}
			
			if(userType.equals("admin")){
				response.sendRedirect("admin.html?Id=" + id);
			}
			if(userType.equals("qm")){
				response.sendRedirect("qualityManager.html?Id=" + id);
			}
		}
		else{
			String errMsg = "Invalid User Name or Password";
			response.sendRedirect("loginForm.jsp?var=" + errMsg + "&emp_type=" + userType);
		}
		
	%>
</body>
</html>