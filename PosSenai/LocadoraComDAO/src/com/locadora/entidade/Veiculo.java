package com.locadora.entidade;

public class Veiculo {
	private int id;
	private String nome;
	private String marca;
	private int transmissao;
	
	
	
	public int getTransmissao() {
		return transmissao;
	}
	public void setTransmissao(int transmissao) {
		this.transmissao = transmissao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getNomeTransmissao(){
		if(transmissao == 1){
			return "Automático";
		}else if (transmissao == 2){
			return "Manual";
		}else if (transmissao == 3){
			return "Tip-tronic";
		}else{
			return "Não é nada";
		}
	}
}
