package br.com.antrafa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	
	private static final String DATABASE = "aj";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	public static Connection getConnection(){
		
		Connection conn = null;
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE, USERNAME, PASSWORD);
			System.out.println("Conectando");
		}catch(SQLException e){
			System.out.println("Conexao falhou");
		}
		
		return conn;
		
	}
	
	public static void close(Connection conn){
		
		try {
			if(conn != null && !conn.isClosed()){
				conn.close();
				System.out.println("Fechando conexao");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, Statement stm){
		try {
			if(stm != null && !stm.isClosed()){
				stm.close();
				close(conn);
				System.out.println("Fechando conexao");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void close(Connection conn, Statement stm, ResultSet rs){
		try {
			if(rs != null && !rs.isClosed()){
				rs.close();
				close(conn,stm);
				System.out.println("Fechando conexao");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}