package com.quinnox.project.orderSupplies.empcrud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quinnox.project.orderSupplies.empcrud.dao.ProductDAO;
import com.quinnox.project.orderSupplies.empcrud.dao.SupplierDAO;
import com.quinnox.project.orderSupplies.empcrud.model.Supplier;


/**
 * Servlet implementation class SupplierServlet
 */
@WebServlet("/SupplierServlet")
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int prod_id = Integer.parseInt(request.getParameter("prod_id"));
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		int order_id = 0;
		if(request.getParameter("order_id") != null) {
			order_id = Integer.parseInt(request.getParameter("order_id"));
		}
		String status = "";
		status = request.getParameter("status");
		
		int sup_id = ProductDAO.getSupplierId(prod_id);
		System.out.println("status and emp_id in supplier servlet is: " + status + " " + emp_id + " sup_id is: " + sup_id);
		//System.out.println(prod_id);
		
		List<Supplier> slist = SupplierDAO.getSuppliers(sup_id);
		if(status != null) {
			System.out.println("inside if block in supplier servlet");
			request.setAttribute("wasRejected", status);
			request.setAttribute("order_id", order_id);
		}
		request.setAttribute("slist", slist);
		request.setAttribute("sup_id", sup_id);
		request.setAttribute("emp_id", emp_id);
		request.setAttribute("prod_id", prod_id);
		RequestDispatcher rd = request.getRequestDispatcher("viewSuppliers.jsp");
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
