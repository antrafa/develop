package br.com.globalcode.banking.simulacao;

import br.com.globalcode.banking.Investimento;
import br.com.globalcode.impostos.Tributavel;

public class TesteInvestimento {

    public static void main(String[] args) {
        
        if (args.length != 3) {
            System.out.println("Forma de utilizacao:");
            System.out.println("TesteInvestimento <valor aplicado> <taxa de rendimento mensal> <meses para aplicacao>");
            System.out.println("ex.: TesteInvestimento 1300.00 0.016 12");            
            return;
        }
        
        double valorAplicado = Double.parseDouble(args[0]);
        double rendimentoMensal = Double.parseDouble(args[1]);
        int meses = Integer.parseInt(args[2]); 
        
        Investimento investimento = new Investimento(valorAplicado, rendimentoMensal, meses);
        
        System.out.println("Resultados:");
        System.out.println("Rendimento Bruto -> " + investimento.getRendimentoBruto());
        imprimeTributacao(investimento);
        System.out.println("Rendimento Liquido -> " + investimento.getRendimentoLiquido());
        
    }
    
    static void imprimeTributacao(Tributavel t) {
        System.out.println(t.getNomeImposto() + " -> " + t.calcularImpostos());
    }
}
