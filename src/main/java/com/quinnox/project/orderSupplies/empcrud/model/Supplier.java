package com.quinnox.project.orderSupplies.empcrud.model;

public class Supplier {
	private int supplierId;
	String name, email, password;
	
	public Supplier() {

	}

	public Supplier(int supplierId, String name, String email, String password) {
		super();
		this.supplierId = supplierId;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
