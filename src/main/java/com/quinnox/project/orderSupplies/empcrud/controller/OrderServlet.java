package com.quinnox.project.orderSupplies.empcrud.controller;

import java.io.IOException;

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
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("status1 is: " + request.getParameter("status1"));
		int emp_id, mgr_id;
		if(request.getParameter("emp_id") != null) {
			emp_id = Integer.parseInt(request.getParameter("emp_id"));
			mgr_id = EmployeeDAO.getMgrId(emp_id);
		}
		else {
			mgr_id = Integer.parseInt(request.getParameter("mgr_id"));
		}
		
		if(request.getParameter("status1") != null && request.getParameter("status1").equals("wasRejected")) {
			System.out.println("inside first if block");
			int orderId = Integer.parseInt(request.getParameter("order_id"));
			
			//System.out.println("order id is: " + orderId);
			int OrderStatus = OrderDAO.updateOrder(orderId, " ", "supplier", "Processing", " ");
			System.out.println("order status is: " + OrderStatus + " and mgr_id is: " + mgr_id);
			
			String message;
			
			if(OrderStatus > 0) {
				message = "Supplier Changed Successfully";
				//System.out.println("inside if");
			}
			else {
				message = "Something went Wrong";
			}
			
			//response.sendRedirect("EmpOrderServlet?Id=" + mgr_id +"&nxtState=mgr");
			RequestDispatcher rd = request.getRequestDispatcher("SupplierRejectedServlet?mgr_id=" + mgr_id +"&message=" + message);
			rd.forward(request, response);
		}
		
		else if(mgr_id == 0) {
			System.out.println("inside else-if block");
			System.out.println("next state is: " + request.getParameter("next_state"));

			System.out.println("manager id is: " + mgr_id);
			
			Order o = new Order();

			o.setEmp_id(Integer.parseInt(request.getParameter("emp_id")));
			o.setMgr_id(mgr_id);
			System.out.println("after mgr id");
			o.setComments("Auto Approved");
			System.out.println("after comment");
			o.setProd_id(Integer.parseInt(request.getParameter("prod_id")));
			System.out.println("after prod_id");
			o.setSupplier_id(Integer.parseInt(request.getParameter("sup_id")));
			System.out.println("after sup_id");
			o.setStatus(request.getParameter("status"));
			System.out.println("after status");
			o.setRejected_by(request.getParameter("rejected_by"));
			System.out.println("after rejected");
			o.setNext_state("supplier");
			System.out.println("after nextstate");
			
			int OrderStatus = OrderDAO.placeOrder(o);
			System.out.println("orderStatus is: " + OrderStatus);
			request.setAttribute("Id", request.getParameter("emp_id"));
			request.setAttribute("orderStatus", OrderStatus);
			
			if(OrderStatus > 0) {
				request.setAttribute("message", "Order Placed Successfully");
			}
			else {
				request.setAttribute("message", "Something went Wrong");
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("viewSuppliers.jsp");
			rd.forward(request, response);
		}
		
		else if((request.getParameter("mgr_id") != null) && (Integer.parseInt(request.getParameter("mgr_id")) != 0) && (request.getParameter("next_state").equals("mgr"))) {
			int orderId = Integer.parseInt(request.getParameter("OrderId"));
			
			//System.out.println("order id is: " + orderId);
			int OrderStatus = OrderDAO.updateOrder(orderId, " ", "supplier", "Processing", " ");
			//System.out.println("order status is: " + OrderStatus);
			
			String message;
			
			if(OrderStatus > 0) {
				message = "Order Approved";
				//System.out.println("inside if");
			}
			else {
				message = "Something went Wrong";
			}
			
			//response.sendRedirect("EmpOrderServlet?Id=" + mgr_id +"&nxtState=mgr");
			RequestDispatcher rd = request.getRequestDispatcher("EmpOrderServlet?Id=" + mgr_id +"&nxtState=mgr&message=" + message);
			rd.forward(request, response);
		}
		
		else{
			
			System.out.println("inside else-if block");
			//System.out.println("next state is: " + request.getParameter("next_state"));
			System.out.println("manager id is: " + mgr_id);
			
			Order o = new Order();

			o.setEmp_id(Integer.parseInt(request.getParameter("emp_id")));
			o.setMgr_id(mgr_id);
			System.out.println("after mgr id");
			o.setComments(request.getParameter("comment"));
			System.out.println("after comment");
			o.setProd_id(Integer.parseInt(request.getParameter("prod_id")));
			System.out.println("after prod_id");
			o.setSupplier_id(Integer.parseInt(request.getParameter("sup_id")));
			System.out.println("after sup_id");
			o.setStatus(request.getParameter("status"));
			System.out.println("after status");
			o.setRejected_by(request.getParameter("rejected_by"));
			System.out.println("after rejected");
			o.setNext_state("mgr");
			System.out.println("after nextstate");
			
			int OrderStatus = OrderDAO.placeOrder(o);
			System.out.println("orderStatus is: " + OrderStatus);
			request.setAttribute("Id", request.getParameter("emp_id"));
			request.setAttribute("orderStatus", OrderStatus);
			
			if(OrderStatus > 0) {
				request.setAttribute("message", "Order Placed Successfully");
			}
			else {
				request.setAttribute("message", "Something went Wrong");
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("viewSuppliers.jsp");
			rd.forward(request, response);
		}
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
