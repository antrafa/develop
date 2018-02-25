

public class TesteCastUp {

    public static void main(String[] args) {
        
        Banco banco = new Banco("Globalcode Bank", 1000);
        AgenciaStandard agStandard = new AgenciaStandard("001", banco);
        AgenciaPremium agPremium = new AgenciaPremium("002", banco);
        AgenciaPlus agPlus = new AgenciaPlus("003", banco, 1200d, 6000d);
        
        Cliente clienteX = new Cliente("Mr. X", "9876543-21");
        Conta conta1 = new ContaEspecial(1000, "11121314", clienteX, agStandard, 600);
        conta1.saque(180d);

        Cliente clienteY = new Cliente("Mr. Y", "543543-99");
        Conta conta2 = new ContaPoupanca(3000, "33988311", clienteY, agPremium, "01/01/2005");
        conta2.saque(330d);
        
        Cliente clienteZ = new Cliente("Mr. Z", "988875-77");
        Conta conta3 = new Conta(2200, "35768351", clienteZ, agPlus);
        conta3.saque(456d);
        
        Investimento investimento = new Investimento(4000, 0.022, 4);
        
        // ----------------------------------------
        // acione o metodo imprimirTributavel para 
        // todas as contas e investimentos
        // ----------------------------------------
        imprimirTributavel(conta1);
        imprimirTributavel(conta2);
        imprimirTributavel(conta3);
        imprimirTributavel(investimento);

        
        // combine todas as contas e investimentos em um array
        Tributavel[] trib = new Tributavel[4];
        trib[0] = conta1;
        trib[1] = conta2;
        trib[2] = conta3;
        trib[3] = investimento;
        
        System.out.println("imposto total devido: " + calcularImpostoTotalDevido(trib));
        
    }
    
    
    static void imprimirTributavel(Tributavel t) {
        System.out.println("\n------------------------------------------");
        System.out.println("Tributavel: " + t.getDescricaoTributavel());
        System.out.println("Imposto: " + t.getNomeImposto());
        System.out.println("Imposto Devido: " + t.calcularImpostos());
        System.out.println("------------------------------------------\n");        
    }
    
    static double calcularImpostoTotalDevido(Tributavel[] tributaveis) {
        
        double impostoTotalDevido = 0;
        for(int i = 0; i < tributaveis.length; i++) {
            impostoTotalDevido += tributaveis[i].calcularImpostos();
            // acumule o total de impostos devidos
            // de acordo com cada tributavel informado
        }
        return impostoTotalDevido;
        
    }
}
