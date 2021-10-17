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

import com.quinnox.project.orderSupplies.empcrud.dao.OrderDAO;
import com.quinnox.project.orderSupplies.empcrud.dao.ProductDAO;
import com.quinnox.project.orderSupplies.empcrud.dao.SupplierDAO;
import com.quinnox.project.orderSupplies.empcrud.model.Order;
import com.quinnox.project.orderSupplies.empcrud.model.Product;
import com.quinnox.project.orderSupplies.empcrud.model.Supplier;

/**
 * Servlet implementation class EmpOrderServlet
 */
@WebServlet("/EmpOrderServlet")
public class EmpOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nxtState = request.getParameter("nxtState");
		System.out.println("in emporderservlet after nxtState: " + nxtState);
		int mgr_id = Integer.parseInt(request.getParameter("Id"));
		System.out.println("manager id is: " + mgr_id);
		String message = request.getParameter("message");
		System.out.println("message is: " + message);
		System.out.println("next state is: " + nxtState);
		
		
		List<Order> olist = OrderDAO.getProductsAndSupplier(nxtState, mgr_id);
		System.out.println("size of olist is: " + olist.size());
		List<Product> plist = new ArrayList<Product>();
		List<Supplier> slist = new ArrayList<Supplier>();
		System.out.println("before for loop in emporderservlet");
		for(int i = 0; i < olist.size(); i++) {
			int prod_id = olist.get(i).getProd_id();
			int sup_id = olist.get(i).getSupplier_id();
			
			plist.add(ProductDAO.getProduct(prod_id));
			slist.add(SupplierDAO.getSupplier(sup_id));
		}
		
		//System.out.println(plist.get(0).getName() + " " + slist.get(0).getName());
		request.setAttribute("plist", plist);
		request.setAttribute("slist", slist);
		request.setAttribute("olist", olist);
		request.setAttribute("message", message);
		System.out.println("Before going to viewPendingProducts");
		RequestDispatcher rd = request.getRequestDispatcher("viewPendingProducts.jsp");
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
