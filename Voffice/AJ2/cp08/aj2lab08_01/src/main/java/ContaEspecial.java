/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * Tarefas: 
 * 1) Faca com que a classe ContaEspecial estenda a classe Conta 
 * 2) Adicione o atributo limite do tipo double e o encapsule 
 * 3) Crie construtores da classe obrigando a passagem do valor do limite na criacao de objetos 
 *  e todos os parametros necessarios anteriormente. 
 * 4) Faca override do metodo imprimeDados fazendo com que ele imprima tambem o
 *  valor do limite alem do tipo da conta (CONTA ESPECIAL) 
 * 5) Faca override do metodo saque para que ele considere o limite na hora de 
 *    verificar se existe ou nao saldo disponivel.
 *    Faca tambem com que este metodo acumule o CPMF devido.
 */
public class ContaEspecial extends Conta {

	private double limite;

	public ContaEspecial(double saldoInicial, String num, Cliente tit, Agencia ag, double limite) {
        super(saldoInicial,num,tit,ag);
		this.setLimite(limite);
    }

	public ContaEspecial(String num, Cliente tit, Agencia ag, double limite){
		this(0,num,tit,ag,limite);
	}

	public double getLimite(){
		return this.limite;
	}

	public void setLimite(double limite){
		this.limite = limite;
	}

	//OVERRIDE
	public void saque(double valor) {
		if(valor > this.limite){
			System.out.println("Este valor supera o limite permitido.");
			return;
		}

        System.out.println("Realizando saque de R$ " + valor + " da conta " + numero);
        if (valor > 0) {
            if (saldo >= valor) {
                saldo -= valor;
                acumularIFN(valor);
            } else
                System.out.println("Saldo insuficiente");
        } else {
            System.out.println("O valor de saque deve ser positivo");
        }
    }

    //OVERRIDE
	public void imprimeDados() {
        super.imprimeDados();
        System.out.println("CONTA ESPECIAL");
        System.out.println("Limite: "+this.getLimite());
        
    }


}
