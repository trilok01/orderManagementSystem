package com.quinnox.project.orderSupplies.empcrud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quinnox.project.orderSupplies.empcrud.dao.SupplierDAO;
import com.quinnox.project.orderSupplies.empcrud.model.Supplier;

/**
 * Servlet implementation class SupplierListServlet
 */
@WebServlet("/SupplierListServlet")
public class SupplierListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("message");
		
		System.out.println("message in supplierlistservlet is: " + message);
		
		List<Supplier> slist = SupplierDAO.getAllSupplierDetails(); // call methods in DAO layer
		request.setAttribute("slist", slist);
		RequestDispatcher rd;
		if(message != null) {
			request.setAttribute("message", message);
		}
		rd = request.getRequestDispatcher("viewSupplierList.jsp");
		
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
