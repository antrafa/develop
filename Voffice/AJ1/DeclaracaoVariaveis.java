class DeclaracaoVariaveis{

	public static void main (String[] args){

		String nomePessoa = "Antonio";
		int idade = 32;
		String rg = "33333333-9";
		char sexo = 'M';
		double salario = 10000;
		//System.out.println("Senhor(a) " + nomePessoa + ", de " + idade + " anos, portador(a) do RG de número " + rg + ", do sexo " + sexo + ", está registrado(a) com o salário de R$" + salario);

		System.out.printf("Senhor(a) %s, de %s anos, portador(a) do RG de número %s, do sexo %s, está registrado(a) com o salário de R$ %s %n", nomePessoa, idade, rg, sexo, salario);

	}

}