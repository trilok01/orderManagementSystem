package com.quinnox.project.orderSupplies.empcrud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quinnox.project.orderSupplies.empcrud.dao.SupplierDAO;
import com.quinnox.project.orderSupplies.empcrud.model.Supplier;

/**
 * Servlet implementation class UpdateSupplierServlet
 */
@WebServlet("/UpdateSupplierServlet")
public class UpdateSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSupplierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sup_id=Integer.parseInt(request.getParameter("sup_id"));
		String name=request.getParameter("name");
		String emailid=request.getParameter("emailid");
		String password=request.getParameter("password");

		//Invoke User Parameterized constructor & initialise values
		Supplier s = new Supplier(sup_id, name, emailid, password);
		int status = SupplierDAO.updateSupplier(s);
		
		String message = "";
		if(status == 1) {
			message = "Successfully Updated";
		}
		else {
			message = "Error Occured while Updating";
		}
		
		response.sendRedirect("SupplierListServlet?message=" + message);
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
