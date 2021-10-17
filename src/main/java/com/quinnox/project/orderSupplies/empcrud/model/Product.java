package com.quinnox.project.orderSupplies.empcrud.model;

public class Product {
	private int prod_id, sup_id;
	String prod_name, description;
	int price, quantity;
	float rating;
	
	public Product() {

	}

	public Product(int prod_id, int sup_id, String prod_name, String description, int price, int quantity,
			float rating) {
		super();
		this.prod_id = prod_id;
		this.sup_id = sup_id;
		this.prod_name = prod_name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.rating = rating;
	}

	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public int getSup_id() {
		return sup_id;
	}

	public void setSup_id(int sup_id) {
		this.sup_id = sup_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	
}
