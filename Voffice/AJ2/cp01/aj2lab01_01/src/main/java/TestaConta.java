/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * 
 * 1) Crie um objeto da classe Conta 
 * 2) Inicialize todos os atributos deste objeto 
 * 3) Imprima os valores dos atributos da classe Conta de forma a obter o seguinte resultado:
 * 
 * ----------------------------- 
 * AGENCIA: 1 BANCO : 234 
 * NUMERO : 01945 
 * TITULAR: Globalcode 
 * SALDO : R$10000.0
 * -----------------------------
 * 
 * Sugestoes: 
 * Utilizando '\t' para tab
 * Ex: System.out.println("Texto\tTexto");
 * 
 * voce produzira a seguinte saida: 
 * Texto  Texto
 */
class TestaConta {

    public static void main(String[] args) {

    	Conta conta = new Conta();
    	conta.agencia = 10;
    	conta.banco = 20;
    	conta.numero = "871309";
    	conta.titular = "Antonio Rafael Ortega";
    	conta.saldo = 20000;

		System.out.println("-----------------------------");
		System.out.printf("AGENCIA: %s \t BANCO : %s \n",conta.agencia,conta.banco);
		System.out.printf("NUMERO : %s \n",conta.numero);
		System.out.printf("TITULAR: %s \n",conta.titular);
		System.out.printf("SALDO : R$%s \n",conta.saldo);
		System.out.println("----------------------------");
    }
}
