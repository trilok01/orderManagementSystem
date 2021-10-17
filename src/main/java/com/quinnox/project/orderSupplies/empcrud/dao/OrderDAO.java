package com.quinnox.project.orderSupplies.empcrud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.quinnox.project.orderSupplies.empcrud.model.Order;

public class OrderDAO {
	
	public static int placeOrder(Order o) {
		int status = 0;
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Timestamp sqlTS = new java.sql.Timestamp(utilDate.getTime());
		
		try {
			Connection con=ConnectionDAO.getConnection();
			
			/*Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select systimestamp from dual");
            if(rs.next())        
                sqlTS = rs.getTimestamp(1);*/
            
            PreparedStatement ps;
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("Select order_id.NEXTVAL from dual");
            
            int orderId = 0;
            if(rs.next())        
                orderId = rs.getInt(1);
			
            ps = con.prepareStatement("insert into orders values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			ps.setInt(1, orderId);
			ps.setInt(2, o.getEmp_id());
			ps.setInt(3, o.getMgr_id());
			ps.setTimestamp(4, sqlTS);
			ps.setString(5, o.getComments());
			ps.setInt(6, o.getProd_id());
			ps.setInt(7, o.getSupplier_id());
			ps.setString(8, o.getNext_state());
			ps.setString(9, o.getStatus());
			ps.setString(10, o.getRejected_by());
			
			status = ps.executeUpdate();
			
			System.out.println(o.getOrder_id()+" "+o.getEmp_id()+" "+o.getMgr_id()+" "+sqlTS+" "+o.getComments()+" "+o.getProd_id()+" "+o.getSupplier_id()+" "+o.getNext_state()+" "+o.getStatus()+" "+o.getRejected_by());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static List<Order> getProductsAndSupplier(int emp_id, int mgr_id) {
		List<Order> plist=new ArrayList<Order>();
			
		try{
			Connection con=ConnectionDAO.getConnection();
			PreparedStatement ps;
			
			if(mgr_id == 0) {
				ps = con.prepareStatement("select * from orders where mgr_id =" + emp_id + " or emp_id =" + emp_id);
			}
			else {
				ps = con.prepareStatement("select * from orders where emp_id=" + emp_id);
			}
			
			
			ResultSet rs=ps.executeQuery();
			DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");  
			System.out.println("got order details");
			while(rs.next()){
				Order o = new Order();
				
				o.setOrder_id(rs.getInt("order_id"));
				o.setEmp_id(rs.getInt("emp_id"));
				o.setMgr_id(rs.getInt("mgr_id"));
				o.setComments(rs.getString("comments"));
				o.setProd_id(rs.getInt("prod_id"));
				o.setSupplier_id(rs.getInt("supplier_id"));
				o.setNext_state(rs.getString("next_state"));
				o.setStatus(rs.getString("status"));
				o.setRejected_by(rs.getString("rejected_by"));
				o.setOrderDate(dateFormat.format(rs.getDate("order_date")));
				plist.add(o);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return plist;
	}
	
	public static List<Order> getProductsAndSupplier(String next_state, int mgr_id) {
		List<Order> plist=new ArrayList<Order>();
			
		try{
			Connection con=ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from orders where next_state ='" + next_state + "' and mgr_id =" + mgr_id);
			
			
			ResultSet rs=ps.executeQuery();
			DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");  
			System.out.println("got order details");
			while(rs.next()){
				Order o = new Order();
				
				o.setOrder_id(rs.getInt("order_id"));
				o.setEmp_id(rs.getInt("emp_id"));
				o.setMgr_id(rs.getInt("mgr_id"));
				o.setComments(rs.getString("comments"));
				o.setProd_id(rs.getInt("prod_id"));
				o.setSupplier_id(rs.getInt("supplier_id"));
				o.setNext_state(rs.getString("next_state"));
				o.setStatus(rs.getString("status"));
				o.setRejected_by(rs.getString("rejected_by"));
				o.setOrderDate(dateFormat.format(rs.getDate("order_date")));
				plist.add(o);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return plist;
	}
	
	public static int updateOrder(int order_id, String comments, String next_state, String status, String rejected_by) {
		int updateStatus = 0;
		System.out.println("before try");
		try {
			Connection con=ConnectionDAO.getConnection();
            
            PreparedStatement ps;
			
            System.out.println("before setting all values");
			ps = con.prepareStatement("update orders set comments='" + comments + "', next_state='" + next_state + "', status='" + status + "', rejected_by='" + rejected_by + "' where order_id=" + order_id);

			System.out.println("after setting all values");
			updateStatus = ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return updateStatus;
	}
	

	
	public static List<Order> getSupRejectedOrder(int emp_id, int mgr_id, String next_state){
		List<Order> olist=new ArrayList<Order>();
		
		try{
			Connection con=ConnectionDAO.getConnection();
			System.out.println("before executing query in order table");
			PreparedStatement ps=con.prepareStatement("select * from orders where rejected_by = 'supplier' and mgr_id =" + emp_id + " or emp_id=" + emp_id + " and next_state='rejected'");
			ResultSet rs=ps.executeQuery();
						
			while(rs.next()){
				Order o = new Order();
				o.setOrder_id(rs.getInt("order_id"));
				o.setEmp_id(rs.getInt("emp_id"));
				o.setMgr_id(rs.getInt("mgr_id"));
				o.setComments(rs.getString("comments"));
				o.setProd_id(rs.getInt("prod_id"));
				o.setSupplier_id(rs.getInt("supplier_id"));
				o.setNext_state(rs.getString("next_state"));
				o.setStatus(rs.getString("status"));
				o.setRejected_by(rs.getString("rejected_by"));
				
				olist.add(o);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
			return olist;
	}
	
	public static List<Order>getAllRecords(int sup_id){
		List<Order> list=new ArrayList<Order>();
		try{
			Connection con=ConnectionDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from orders where next_state='supplier' and supplier_id =" + sup_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Order u=new Order();
				u.setOrder_id(rs.getInt("Order_id"));
				u.setEmp_id(rs.getInt("emp_id"));
				u.setMgr_id(rs.getInt("mgr_id"));
				u.setOrderDate(rs.getString("order_date"));
				u.setComments(rs.getString("Comments"));
				u.setProd_id(rs.getInt("Prod_id"));
				u.setSupplier_id(rs.getInt("supplier_id"));
				u.setStatus(rs.getString("status"));
				u.setRejected_by(rs.getString("rejected_by"));
				u.setNext_state(rs.getString("next_state"));
				list.add(u);
			}
		}
		catch(Exception e)
		{System.out.println(e);
		}
		return list;
	}
	
	public static Order getRecordById(int Order_id){
		Order u=null;
		try{
			Connection con=ConnectionDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Orders where Order_id=?");
			ps.setInt(1,Order_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				u=new Order();
				u.setOrder_id(rs.getInt("Order_id"));
				u.setEmp_id(rs.getInt("emp_id"));
				u.setMgr_id(rs.getInt("mgr_id"));
				u.setComments(rs.getString("Comments"));
				u.setProd_id(rs.getInt("Prod_id"));
				u.setSupplier_id(rs.getInt("supplier_id"));
				u.setStatus(rs.getString("status"));
				u.setRejected_by(rs.getString("rejected_by"));
				u.setNext_state(rs.getString("next_state"));
			}
		}catch(Exception e){System.out.println(e);}
		return u;
	}
	
	public static int acceptOrder(Order u){
		int status=0;
		try{
			Connection con=ConnectionDAO.getConnection();
			PreparedStatement ps=con.prepareStatement(
					"update Orders set comments=?,status=?,Next_state=? where Order_id=?");
			
			ps.setString(1,u.getComments());
			ps.setString(2,u.getStatus());
			ps.setString(3,u.getNext_state());
			ps.setInt(4,u.getOrder_id());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static int rejectOrder(Order u){
		int status=0;
		try{
			Connection con=ConnectionDAO.getConnection();
			PreparedStatement ps=con.prepareStatement(
					"update Orders set comments=?,status=?,Next_state=?,rejected_by=? where Order_id=?");
			
			ps.setString(1,u.getComments());
			ps.setString(2,u.getStatus());
			ps.setString(3,u.getNext_state());
			ps.setString(4, u.getRejected_by());
			ps.setInt(5,u.getOrder_id());
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static List<Order> getRecordsForQM(){
		List<Order> list=new ArrayList<Order>();
		try{
			Connection con=ConnectionDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from orders where next_state='qm'");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Order u=new Order();
				u.setOrder_id(rs.getInt("Order_id"));
				u.setEmp_id(rs.getInt("emp_id"));
				u.setMgr_id(rs.getInt("mgr_id"));
				u.setOrderDate(rs.getString("order_date"));
				u.setComments(rs.getString("Comments"));
				u.setProd_id(rs.getInt("Prod_id"));
				u.setSupplier_id(rs.getInt("supplier_id"));
				u.setStatus(rs.getString("status"));
				u.setRejected_by(rs.getString("rejected_by"));
				u.setNext_state(rs.getString("next_state"));
				list.add(u);
			}
		}
		catch(Exception e)
		{System.out.println(e);
		}
		return list;
	}

}

