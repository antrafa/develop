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

    protected void ajustarLimiteIndividual(ContaEspecial contaEspecial) {
        if (contaEspecial.getSaldo() < -1000) {       
            contaEspecial.setLimite(0);
        } else if (contaEspecial.getSaldo() < -500) { 
            contaEspecial.setLimite(200);
        } else if (contaEspecial.getSaldo() > 1000) { 
            contaEspecial.setLimite(500);
        } else if (contaEspecial.getLimite() > 500) { 
            contaEspecial.setLimite(500);
        }
    }
    
}
