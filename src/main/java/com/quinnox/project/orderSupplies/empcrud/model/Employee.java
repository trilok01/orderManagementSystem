package com.quinnox.project.orderSupplies.empcrud.model;

public class Employee {
	private int id, mgr_id;
	String f_name, l_name, desig, email, password;
	
	public Employee() {

	}
	
	public Employee(int id, int mgr_id, String f_name, String l_name, String desig, String email, String password) {
		super();
		this.id = id;
		this.mgr_id = mgr_id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.desig = desig;
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getMgr_id() {
		return mgr_id;
	}
	
	public void setMgr_id(int mgr_id) {
		this.mgr_id = mgr_id;
	}
	
	public String getF_name() {
		return f_name;
	}
	
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	
	public String getL_name() {
		return l_name;
	}
	
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	
	public String getDesig() {
		return desig;
	}
	
	public void setDesig(String desig) {
		this.desig = desig;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
