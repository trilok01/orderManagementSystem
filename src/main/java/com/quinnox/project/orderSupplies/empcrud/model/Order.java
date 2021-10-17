package com.quinnox.project.orderSupplies.empcrud.model;

public class Order {
	private int order_id, emp_id, mgr_id, prod_id, supplier_id;
	String comments, status, rejected_by, next_state, orderDate;
	
	public Order() {

	}

	public Order(int order_id, int emp_id, int mgr_id, int prod_id, int supplier_id, String comments, String status,
			String rejected_by, String next_state) {
		super();
		this.order_id = order_id;
		this.emp_id = emp_id;
		this.mgr_id = mgr_id;
		this.prod_id = prod_id;
		this.supplier_id = supplier_id;
		this.comments = comments;
		this.status = status;
		this.rejected_by = rejected_by;
		this.next_state = next_state;
	}

	public Order(int order_id, int emp_id, int mgr_id, int prod_id, int supplier_id, String comments, String status,
			String rejected_by, String next_state, String orderDate) {
		super();
		this.order_id = order_id;
		this.emp_id = emp_id;
		this.mgr_id = mgr_id;
		this.prod_id = prod_id;
		this.supplier_id = supplier_id;
		this.comments = comments;
		this.status = status;
		this.rejected_by = rejected_by;
		this.next_state = next_state;
		this.orderDate = orderDate;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public int getMgr_id() {
		return mgr_id;
	}

	public void setMgr_id(int mgr_id) {
		this.mgr_id = mgr_id;
	}

	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRejected_by() {
		return rejected_by;
	}

	public void setRejected_by(String rejected_by) {
		this.rejected_by = rejected_by;
	}

	public String getNext_state() {
		return next_state;
	}

	public void setNext_state(String next_state) {
		this.next_state = next_state;
	}
	
	public String getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
}
