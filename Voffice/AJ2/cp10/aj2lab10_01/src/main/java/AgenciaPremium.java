/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 *
 * 
 * 1) Modifique esta classe para que herde de Agencia
 * 
 * 2) Acrescente um construtor valido. 
 * 
 * 3) Sobrescreva o metodo abstrato ajustarLimiteIndividual
 *    de acordo com as seguintes regras de negocio:
 *    
 *    a) se o saldo estiver negativo, abaixo de -5000.00 o limite deve ser ajustado para 1000.00
 *    b) se o saldo estiver positivo, abaixo de +5000.00 o limite deve ser ajustado para 30% do saldo  
 *    c) se o saldo estiver positivo, acima de  +5000.00 o limite deve ser ajustado para 50% do saldo
 * 
 */
public class AgenciaPremium extends Agencia {

	public AgenciaPremium(String num, Banco bc) {
		super(num,bc);
	}

	protected void ajustarLimiteIndividual(ContaEspecial contaEspecial){
		double saldoTemp = contaEspecial.getSaldo();
		if(saldoTemp < -5000){
			contaEspecial.setLimite(1000);
		}else if(saldoTemp > 0 && saldoTemp <= 5000){
			contaEspecial.setLimite(saldoTemp * 0.3);
		}else if(saldoTemp > 5000){
			contaEspecial.setLimite(saldoTemp * 0.5);
		}
	}


}
