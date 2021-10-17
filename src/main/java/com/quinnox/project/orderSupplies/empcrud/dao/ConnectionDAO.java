package com.quinnox.project.orderSupplies.empcrud.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDAO {
	public static Connection getConnection(){
		Connection con = null;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe","quint","redhat123");
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        return con;
    }
}
