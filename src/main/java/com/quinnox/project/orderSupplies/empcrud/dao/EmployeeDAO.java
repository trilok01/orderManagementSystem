package com.quinnox.project.orderSupplies.empcrud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.quinnox.project.orderSupplies.empcrud.model.Employee;

public class EmployeeDAO {
	
	public static int loginEmployee(Employee u){
        int id = 0;
        System.out.println(u.getEmail()+" "+u.getPassword() + " " + u.getDesig());
        try{
            Connection con=ConnectionDAO.getConnection();
            PreparedStatement ps;
            if(u.getDesig().equals("supplier")) {
            	ps=con.prepareStatement("select sup_id, email,password from suppliers where "
                        +"email=? and password=?");
            	ps.setString(1, u.getEmail());
                ps.setString(2, u.getPassword());
            }
            else {
            	ps=con.prepareStatement("select emp_id, emailid,password from employees where "
                    +"emailid=? and password=? and desig=?");
            	
            	ps.setString(1, u.getEmail());
                ps.setString(2, u.getPassword());
                ps.setString(3, u.getDesig());
            }
            

            ResultSet rs=ps.executeQuery();
            boolean status = rs.next();
            id = rs.getInt(1);
            
            while(rs.next())
            {
                System.out.println(rs.getInt(1) + " " + rs.getString(2)+" "+rs.getString(3));
            }
        }
        catch(Exception e){
        	System.out.println(e);
        }
        return id;
    }
	
	public static int getMgrId(int empId) {
		System.out.println("inside employeeDAO getmgrid");
		int mgr_id = 0;
		System.out.println("here");
		try {
			Connection con=ConnectionDAO.getConnection();
			
			PreparedStatement ps = con.prepareStatement("select mgr_id from employees where emp_id=" + empId);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) mgr_id = rs.getInt(1);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return mgr_id;
	}
	
	public static List<Employee> getAllRecords(){
		List<Employee> list=new ArrayList<Employee>();

		try{
			Connection con=ConnectionDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from employees");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Employee u=new Employee();
				u.setId(rs.getInt("emp_id"));
				u.setF_name(rs.getString("f_name"));
				u.setL_name(rs.getString("l_name"));
				u.setDesig(rs.getString("desig"));
				u.setEmail(rs.getString("emailid"));
				u.setPassword(rs.getString("password"));
				u.setMgr_id(rs.getInt("mgr_id"));
	
				list.add(u);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static Employee getRecordById(int emp_id){
		Employee u=new Employee();
		
		try{
			Connection con=ConnectionDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from employees where emp_id=" + emp_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				u.setId(rs.getInt("emp_id"));
				u.setF_name(rs.getString("f_name"));
				u.setL_name(rs.getString("l_name"));
				u.setDesig(rs.getString("desig"));
				u.setEmail(rs.getString("emailid"));
				u.setPassword(rs.getString("password"));
				u.setMgr_id(rs.getInt("mgr_id"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	public static int addUser(Employee e) {
		int status = 0;
		
		try {
			Connection con=ConnectionDAO.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into employees values(?,?,?,?,?,?,?)");
            
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("Select emp_id_seq.NEXTVAL from dual");
            
            int emp_id = 0;
            if(rs.next())        
                emp_id = rs.getInt(1);
            
            ps.setInt(1, emp_id);
            ps.setString(2, e.getF_name());
            ps.setString(3, e.getL_name());
            ps.setString(4, e.getDesig());
            ps.setString(5, e.getEmail());
            ps.setString(6, e.getPassword());
            ps.setInt(7, e.getMgr_id());
            
            status = ps.executeUpdate();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return status;
	}
	
	public static int updateUser(Employee e) {
		int status = 0;
		
		try {
			Connection con=ConnectionDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("update employees set f_name=?, l_name=?, desig=?, emailid=?, password=?, mgr_id=? where emp_id=?");
			
			ps.setString(1, e.getF_name());
			ps.setString(2, e.getL_name());
			ps.setString(3, e.getDesig());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getPassword());
			ps.setInt(6, e.getMgr_id());
			ps.setInt(7, e.getId());
			
			status = ps.executeUpdate();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return status;
	}
	
	public static int deleteUser(int emp_id) {
		int status = 0;
		
		try {
			Connection con=ConnectionDAO.getConnection();
			System.out.println("Connection successfull emp_id: " + emp_id);
			PreparedStatement ps = con.prepareStatement("delete from employees where emp_id=" + emp_id);
			
			status = ps.executeUpdate();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return status;
	}
}
