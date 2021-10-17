package com.quinnox.project.orderSupplies.empcrud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quinnox.project.orderSupplies.empcrud.dao.EmployeeDAO;
import com.quinnox.project.orderSupplies.empcrud.model.Employee;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int emp_id=Integer.parseInt(request.getParameter("emp_id"));
		String f_name=request.getParameter("f_name");
		String l_name=request.getParameter("l_name");
		String desig=request.getParameter("desig");
		String emailid=request.getParameter("emailid");
		String password=request.getParameter("password");
		int mgr_id= Integer.parseInt(request.getParameter("mgr_id"));
		//Invoke User Parameterized constructor & initialise values
		Employee e = new Employee(emp_id, mgr_id, f_name, l_name, desig, emailid, password);
		int status = EmployeeDAO.updateUser(e);
		
		String message = "";
		if(status == 1) {
			message = "Successfully Updated";
		}
		else {
			message = "Error Occured while Updating";
		}
		
		response.sendRedirect("ViewServlet?message=" + message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
