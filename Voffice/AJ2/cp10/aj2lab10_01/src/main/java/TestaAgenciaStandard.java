/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * Esta classe e responsavel pelo teste das Herancas envolvidas
 * entre as classes Agencia e AgenciaStandard
 * 
 * 
 */
public class TestaAgenciaStandard {

    public static void main(String args[]) {
        Banco banco = new Banco("Globalcode Bank", 1000);
        AgenciaStandard agStandard = new AgenciaStandard("001", banco);
        Cliente cliente1 = new Cliente("Cliente 1", "1232323");
        Cliente cliente2 = new Cliente("Cliente 2", "9877845");

        ContaEspecial contaA = new ContaEspecial(1000d,"1111", cliente1, agStandard, 700d);
        ContaEspecial contaB = new ContaEspecial(2000d,"1231", cliente2, agStandard, 1200d);
        ContaEspecial contaC = new ContaEspecial(500d,"3100", cliente2, agStandard, 100d);

        contaA.saque(1600d);
        contaB.saque(3100d);
        contaC.deposito(600);
        
        contaA.imprimeDados();
        contaB.imprimeDados();
        contaC.imprimeDados();
        
        ContaEspecial[] contas = {contaA, contaB, contaC};
        
        agStandard.ajustarLimites(contas);
        
        // limites ajustados: contaA = 200.00 / contaB = 0.00 / contaC = 500.00
    }
}
