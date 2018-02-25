

public class TesteTributavel {

    public static void main(String[] args) {
        
        Banco banco = new Banco("Globalcode Bank", 1000);
        AgenciaStandard agStandard = new AgenciaStandard("001", banco);
        
        Cliente clienteX = new Cliente("Mr. X", "9876543-21");
        Conta conta1 = new ContaEspecial(1000, "11121314", clienteX, agStandard, 600);
        conta1.imprimeDados();
        conta1.saque(180d);
        conta1.saque(370d);
        
        System.out.println("Tributavel: " + conta1.getDescricaoTributavel());
        System.out.println("Imposto: " + conta1.getNomeImposto());
        System.out.println("Imposto Devido: " + conta1.calcularImpostos());
        
        System.out.println("\n----------------------------------------------\n");
        
        Investimento investimento = new Investimento(4000, 0.022, 4);
        System.out.println("Investimento");
        System.out.println("Aplicacao Inicial: " + investimento.getValorAplicado());
        System.out.println("Rendimento Bruto: " + investimento.getRendimentoBruto());

        System.out.println("Tributavel: " + investimento.getDescricaoTributavel());
        System.out.println("Imposto: " + investimento.getNomeImposto());
        System.out.println("Imposto Devido: " + investimento.calcularImpostos());
                
                
    }
}
