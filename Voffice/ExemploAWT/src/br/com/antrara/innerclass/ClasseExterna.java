package br.com.antrara.innerclass;

public class ClasseExterna {
	
	private String nome;
	
	public ClasseExterna(String nome){
		this.nome = nome;
	}

	public class ClasseInterna{
		
		public ClasseInterna(String internaNome){
			nome += internaNome;
		}
		
		public void escreveNome(){
			System.out.println("Nome = " + nome);
		}
		
	}
	
}