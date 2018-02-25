/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 *
 * 
 * 
 */
public class AgenciaPremium /* solucao -> */ extends Agencia {

    public AgenciaPremium(String num, Banco bc) {
        super(num, bc);
    }

    protected void ajustarLimiteIndividual(ContaEspecial contaEspecial) {
        if (contaEspecial.getSaldo() < -5000d) {
            contaEspecial.setLimite(1000d);
        } else if (contaEspecial.getSaldo() < 5000d) {
            contaEspecial.setLimite(contaEspecial.getSaldo() * .3);
        } else if (contaEspecial.getSaldo() > 5000d) {
            contaEspecial.setLimite(contaEspecial.getSaldo() * .5);
        }
    }
}
