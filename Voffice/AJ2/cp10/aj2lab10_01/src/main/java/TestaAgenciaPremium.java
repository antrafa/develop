/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * Esta classe e responsavel pelo teste das Herancas envolvidas
 * entre as classes Agencia e AgenciaPremium
 * 
 * 
 */
public class TestaAgenciaPremium {

    public static void main(String args[]) {
        Banco banco = new Banco("Globalcode Bank", 1000);
        AgenciaPremium agPremium = new AgenciaPremium("002", banco);
        Cliente cliente3 = new Cliente("Cliente 3", "4534323");
        Cliente cliente4 = new Cliente("Cliente 4", "9677381");

        ContaEspecial contaD = new ContaEspecial(15000d, "1111", cliente3, agPremium, 7000d);
        ContaEspecial contaE = new ContaEspecial(6000d, "1231", cliente3, agPremium, 2000d);
        ContaEspecial contaF = new ContaEspecial(500d, "3100", cliente4, agPremium, 600d);

        contaD.saque(21000d);
        contaE.saque(3000d);
        contaF.deposito(5300d);
        
        contaD.imprimeDados();
        contaE.imprimeDados();
        contaF.imprimeDados();
        
        ContaEspecial[] contas = {contaD, contaE, contaF};
        
        agPremium.ajustarLimites(contas);
        
        // limites ajustados: contaD = 1000.00 / contaE = 900.00 / contaF = 2900.00
        
    }
}
