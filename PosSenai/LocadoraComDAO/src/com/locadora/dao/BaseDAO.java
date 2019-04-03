package com.locadora.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO {
	
	protected static Connection con;
	protected static Statement comando;

	protected static void conectar() {  
		try {  
			Class.forName("com.mysql.jdbc.Driver");  
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fln", "root", "root");    
			comando = con.createStatement();   
		} catch (SQLException e) {  
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
	}  

	protected static void fechar() {  
		try {  
			comando.close();  
			con.close();   
		} catch (SQLException e) {  
			e.printStackTrace();  
		}  
	}  

}
