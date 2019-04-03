/**
 * Classe com o objetivo de praticar a utilização de controladores de fluxo.
 * 
 * @author Globalcode
 */
class ControleFluxoCondicional {
  /**
   * Método para que esta classe possa ser executada com o utilitário java.
   * 
   * @param args
   *          - argumentos para o método main
   */
  public static void main(String[] args) {
	String nome = "Carolina Pereira";
	int idade = 20;
	String rg = "34.654.789-9";
	char sexo = 'F';
	double salario = 1500.0;
	int anoAtual = 2009;
	double aliquota = 0.20;
	int anoNascimento = anoAtual - idade;
	String sexoPorExtenso;
	if(sexo == 'M'){
		sexoPorExtenso = "masculino";
	}else{
		sexoPorExtenso = "feminino";
	}

	String textNome = "";
	String textNasc = "";
	String textRg = "";
	String textSexo = "";
	String textTrabalho = "";
	String textImposto = "";


	switch(sexo){
		case 'M':
			textNome = "O Senhor " + nome;
			textNasc = ", nascido no ano de " + anoNascimento;
			textRg = " portador do rg de numero " + rg + ", \n";
			textTrabalho = ", está registrado com o salário de R$ " + salario;
		break;

		case 'F':
			textNome = "A Senhora " + nome;
			textNasc = ", nascida no ano de " + anoNascimento;
			textRg = " portadora do rg de numero " + rg + ", \n";
			textTrabalho = ", está registrada com o salário de R$ " + salario;
		break;

		default:
			textNome = "O(a) Senhor " + nome;
			textNasc = ", nascido(a) no ano de " + anoNascimento;
			textRg = " portador(a) do rg de numero " + rg + ", \n";
			textTrabalho = ", está registrado(a) com o salário de R$ " + salario;
		break;
	}

	double impostoDevido = salario * aliquota;
	textSexo = " do sexo " + sexoPorExtenso;
	textImposto = " e pagará R$ " + impostoDevido + " de imposto.";


	System.out.println(textNome + textRg + textNasc + textSexo + textTrabalho
	    + textImposto);
  }
}
