package br.com.antrara.innerclass;

public class TesteClasseInterna {

	public static void main(String[] args) {
		
		ClasseExterna externa = new ClasseExterna("Antonio Rafael");
		ClasseExterna.ClasseInterna interna = externa.new ClasseInterna(" Ortega");
		
		interna.escreveNome();

	}

}
