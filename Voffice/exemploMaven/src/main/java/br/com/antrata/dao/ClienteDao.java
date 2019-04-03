package br.com.antrata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.antrafa.ConnectionManager;
import br.com.antrafa.entity.Cliente;

public class ClienteDao implements DataAcessObject<Cliente, Integer> {

	public List<Cliente> findAll(){
		
		String sql = "SELECT * FROM clientes";
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		List<Cliente> clientes = new ArrayList<>();
		
		try {
			conn = ConnectionManager.getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			
			while(rs.next()){
				Cliente cliente = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("telefone"), rs.getString("email"));
				clientes.add(cliente);		
			}
			
		} catch (Exception e) {
			
		} finally {
			ConnectionManager.close(conn, stm, rs);
		}
		
		return clientes;
	}
	
	public Cliente findById(Integer id){
		
		String sql = "SELECT * FROM clientes WHERE id = ?";
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Cliente cliente = null;
		
		try {
			conn = ConnectionManager.getConnection();
			stm = conn.prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery(sql);
			
			if(rs.next()){
				cliente = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("telefone"), rs.getString("email"));
			}
		} catch (Exception e) {
			ConnectionManager.close(conn, stm, rs);
		} finally {
			ConnectionManager.close(conn, stm, rs);
		}
		
		return cliente;
	}
	
	public void delete(Cliente cliente){
		
	}
	
	public Cliente save(Cliente cliente){
		
		Connection conn = null;
		PreparedStatement stm = null;
		Integer ret = null;
		
		try {
			
			conn = ConnectionManager.getConnection();
			String sql = null;
			
			if(cliente.getId() == null){//inserir
				sql = "INSERT INTO clientes (nome,cpf,telefone,email) VALUES (?,?,?,?)";
			} else {
				sql = "UPDATE clientes SET nome = ?, cpf = ?, telefone = ?, email = ? WHERE id = ?";
			}
			
			stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getCpf());
			stm.setString(3, cliente.getTelefone());
			stm.setString(4, cliente.getEmail());
			
			if(cliente.getId() == null){
				stm.setInt(5, cliente.getId());
			}
			
			stm.executeUpdate();
			
			if(cliente.getId() != null){
				ResultSet keys = stm.getGeneratedKeys();
				if(keys.next()){
					cliente.setId(keys.getInt(1));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		
		return cliente;
	}
	
}
