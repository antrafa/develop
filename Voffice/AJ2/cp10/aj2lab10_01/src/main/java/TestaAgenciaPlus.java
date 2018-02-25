/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * Esta classe e responsavel pelo teste das Herancas envolvidas
 * entre as classes Agencia e AgenciaPlus
 * 
 * 
 */
public class TestaAgenciaPlus {

    public static void main(String[] args) {
        Banco banco = new Banco("Globalcode Bank", 1000);
        AgenciaPlus agPlus = new AgenciaPlus("003", banco, 200d, 900d);
        Cliente cliente5 = new Cliente("Cliente 5", "4988223");
        Cliente cliente6 = new Cliente("Cliente 6", "8100700");

        ContaEspecial contaG = new ContaEspecial(1300d, "6171", cliente5, agPlus, 400d);
        ContaEspecial contaH = new ContaEspecial(600d, "7251", cliente5, agPlus, 450d);
        ContaEspecial contaI = new ContaEspecial(750d, "3220", cliente6, agPlus, 2200d);

        contaG.saque(240d);
        contaH.saque(300d);
        contaI.saque(1300d);
        
        contaG.imprimeDados();
        contaH.imprimeDados();
        contaI.imprimeDados();
        
        ContaEspecial[] contas = {contaG, contaH, contaI};
        
        agPlus.ajustarLimites(contas);
        
        // limites ajustados: contaG = 500.00 / contaH = 450.00 / contaI = 1650.00 
    }
}
