package br.com.teste.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.teste.entidades.Cliente;

@ManagedBean
@RequestScoped
public class TesteMB {
	
	private String nome;

	@PostConstruct
	private void init(){
		
	}
	
	@PreDestroy
	private void destroy(){
		System.out.println("Destruindo");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String testaBotao(){
		return this.nome;
	}

	public List<Cliente> getClientes() {
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		Cliente cliente = new Cliente();
		cliente.setNome("Antonio");
		cliente.setTelefone("99107452");
		
		clientes.add(cliente);
		
		cliente = new Cliente();
		cliente.setNome("Rafael");
		cliente.setTelefone("33070412");
		
		clientes.add(cliente);
		
		cliente = new Cliente();
		cliente.setNome("Rafael");
		cliente.setTelefone("33070412");
		
		clientes.add(cliente);
		
		cliente = new Cliente();
		cliente.setNome("Rafael");
		cliente.setTelefone("33070412");
		
		clientes.add(cliente);
		
		return clientes;
	}
		
}