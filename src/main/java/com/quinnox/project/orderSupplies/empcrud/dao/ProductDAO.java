package com.quinnox.project.orderSupplies.empcrud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.quinnox.project.orderSupplies.empcrud.model.Product;

public class ProductDAO {
	public static List<Product> getProducts(){
		List<Product> plist=new ArrayList<Product>();
		
		try{
			Connection con=ConnectionDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from products");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Product p = new Product();
				p.setProd_name(rs.getString("prod_name"));
				p.setProd_id(rs.getInt("prod_id"));
				p.setPrice(rs.getInt("price"));
				p.setDescription(rs.getString("des"));
				p.setRating(rs.getInt("rating"));
				p.setQuantity(rs.getInt("quantity"));
				p.setSup_id(rs.getInt("sup_id"));

				plist.add(p);
			}
		}
		catch(Exception e){
			System.out.println(e);
			}
			return plist;
	}
	
	public static Product getProduct(int prod_id) {
		Product p = new Product();
		
		try{
			Connection con=ConnectionDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select prod_id, prod_name from products where prod_id=" + prod_id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				p.setProd_name(rs.getString("prod_name"));
				p.setProd_id(rs.getInt("prod_id"));
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return p;
	}
	
	public static int save(Product u){
		System.out.println(u.getProd_id());
		System.out.println(u.getProd_name());
		System.out.println(u.getPrice());
		System.out.println(u.getRating());
		System.out.println(u.getDescription());
		System.out.println(u.getSup_id());
		System.out.println(u.getQuantity());
		//System.out.println(u.getQuantity());
		int status=0;
		try{
			Connection con=ConnectionDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into Products values(?,?,?,?,?,?,?)");
			
			Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("Select prod_id_seq.NEXTVAL from dual");
            
            int prod_id = 0;
            if(rs.next())        
                prod_id = rs.getInt(1);

			ps.setInt(1, prod_id);
			ps.setString(2, u.getProd_name());
			ps.setInt(3, u.getPrice());
			ps.setFloat(4, u.getRating());
			ps.setString(5, u.getDescription());
			ps.setInt(6, u.getSup_id());
			ps.setInt(7, u.getQuantity());
			status=ps.executeUpdate();
		}catch(Exception e)
		{System.out.println(e);}
		return status;
	}
	
	public static int getSupplierId(int prod_id) {
		int sup_id = 0;
		try{
			Connection con=ConnectionDAO.getConnection();
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select sup_id from products where prod_id=" + prod_id);
			
			if(rs.next()) sup_id = rs.getInt(1);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return sup_id;
	}
}
