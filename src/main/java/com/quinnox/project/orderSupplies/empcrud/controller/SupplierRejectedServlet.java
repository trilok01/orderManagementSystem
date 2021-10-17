package com.quinnox.project.orderSupplies.empcrud.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quinnox.project.orderSupplies.empcrud.dao.EmployeeDAO;
import com.quinnox.project.orderSupplies.empcrud.dao.OrderDAO;
import com.quinnox.project.orderSupplies.empcrud.dao.ProductDAO;
import com.quinnox.project.orderSupplies.empcrud.dao.SupplierDAO;
import com.quinnox.project.orderSupplies.empcrud.model.Order;
import com.quinnox.project.orderSupplies.empcrud.model.Product;
import com.quinnox.project.orderSupplies.empcrud.model.Supplier;

/**
 * Servlet implementation class SupplierRejectedServlet
 */
@WebServlet("/SupplierRejectedServlet")
public class SupplierRejectedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierRejectedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside sup rej survlet");
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		int mgr_id = EmployeeDAO.getMgrId(emp_id);
		System.out.println("manager id in supplierRejectedServlet is:  " + mgr_id);
		List<Order> olist = OrderDAO.getSupRejectedOrder(emp_id, mgr_id, "rejected");
		List<Product> plist = new ArrayList<Product>();
		List<Supplier> slist = new ArrayList<Supplier>();
		//for(int )
		
		request.setAttribute("olist", olist);
		System.out.println("size of olist in supplierRejectedServlet is: " + olist.size());
		for(int i = 0; i < olist.size(); i++) {
			int prod_id = olist.get(i).getProd_id();
			int sup_id = olist.get(i).getSupplier_id();
			
			plist.add(ProductDAO.getProduct(prod_id));
			slist.add(SupplierDAO.getSupplier(sup_id));
		}
		
		request.setAttribute("plist", plist);
		request.setAttribute("slist", slist);
		
		RequestDispatcher rd = request.getRequestDispatcher("viewSupplierRejected.jsp");
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
