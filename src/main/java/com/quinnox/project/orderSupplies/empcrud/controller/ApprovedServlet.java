package com.quinnox.project.orderSupplies.empcrud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quinnox.project.orderSupplies.empcrud.dao.EmployeeDAO;
import com.quinnox.project.orderSupplies.empcrud.dao.OrderDAO;
import com.quinnox.project.orderSupplies.empcrud.model.Order;

/**
 * Servlet implementation class ApprovedServlet
 */
@WebServlet("/ApprovedServlet")
public class ApprovedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		String emp_type = request.getParameter("emp_type");
	
		System.out.println("emp_id: " + emp_id + " emp_type: " + emp_type);
		
		int mgr_id = EmployeeDAO.getMgrId(emp_id);
		
		List<Order> olist = OrderDAO.getProductsAndSupplier(emp_id, mgr_id);
		
		request.setAttribute("olist", olist);
		
		RequestDispatcher rd;
		if(mgr_id == 0) {
			rd = request.getRequestDispatcher("approvedOrderForManager.jsp");
		}
		else {
			rd = request.getRequestDispatcher("empAuditTrail.jsp");
		}
		
		rd.forward(request, response);
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
