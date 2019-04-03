package br.com.antrafa.test;

import java.util.Scanner;

import br.com.antrafa.entity.Cliente;
import br.com.antrata.dao.ClienteDao;

public class CadastraCliente {

	private static Scanner scanner;

	public static void main(String[] args) {
		
		scanner = new Scanner(System.in);

		System.out.println("Informe o Codigo: ");
		String strId = scanner.nextLine();
		Integer id = null;
		if(strId != null && !strId.equals("")){
			id = Integer.parseInt(strId);
		}
		
		System.out.println("Informe o nome: ");
		String nome = scanner.nextLine();
		
		System.out.println("Informe o CPF: ");
		String cpf = scanner.nextLine();
		
		System.out.println("Informe o telefone: ");
		String telefone = scanner.nextLine();
		
		System.out.println("Informe o email: ");
		String email = scanner.nextLine();
		
		Cliente cliente = new Cliente(id, nome, cpf, telefone, email);
		
		ClienteDao dao = new ClienteDao();
		Cliente result = dao.save(cliente);
		
		System.out.println("Inserido " + result);
		
	}
	
}
