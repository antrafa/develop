package br.com.antrafa.test;

import java.util.List;

import br.com.antrafa.entity.Cliente;
import br.com.antrata.dao.ClienteDao;
import br.com.antrata.dao.DataAcessObject;

public class ListarClientes {

	public static void main(String[] args) {

		DataAcessObject<Cliente, Integer> dao = new ClienteDao();
		List<Cliente> clientes = dao.findAll();
		
		for (Cliente cliente: clientes) {
			System.out.println(cliente.toString());
		}
		
		Cliente cliente = dao.findById(1);
		System.out.println(cliente);
		
	}
	
}
