/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 */
public class AgenciaStandard extends Agencia {

    public AgenciaStandard(String num, Banco bc) {
        super(num, bc);
    }

    /*
     * O metodo ajustarLimiteIndividual herdado da classe Agencia 
     * esta sobrescrito de acordo com as seguintes regras de negocio:
     * 
     *  a) se o saldo estiver negativo, abaixo de -1000.00 o limite deve ser ajustado para 0.0
     *  b) se o saldo estiver negativo, abaixo de  -500.00 o limite deve ser ajustado para 200.00
     *  c) se o saldo estiver positivo acima de    1000.00 o limite deve ser ajustado para 500.00
     *  d) o limite nunca pode ser superior a 500.00    
     */
    protected void ajustarLimiteIndividual(ContaEspecial contaEspecial) {
        if (contaEspecial.getSaldo() < -1000) {       // a
            contaEspecial.setLimite(0);
        } else if (contaEspecial.getSaldo() < -500) { // b
            contaEspecial.setLimite(200);
        } else if (contaEspecial.getSaldo() > 1000) { // c
            contaEspecial.setLimite(500);
        } else if (contaEspecial.getLimite() > 500) { // d
            contaEspecial.setLimite(500);
        }
    }
    
}
