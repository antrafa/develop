package br.com.antrafa.test;

import java.sql.Connection;

import br.com.antrafa.ConnectionManager;

public class TestaConexao {

	public static void main(String[] args) {
		
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			ConnectionManager.close(conn);
		} catch (Exception e) {
			System.out.println("Erro");
		}

	}

}
