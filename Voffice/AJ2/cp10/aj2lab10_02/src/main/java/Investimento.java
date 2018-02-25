

public class Investimento implements Tributavel {

    private double valorAplicado;
    private double rendimentoMensal;
    private int meses;
    private static double taxaIR = 0.27; 
    
    public Investimento(double valorAplicado, double rendimentoMensal, int meses) {
        this.valorAplicado = valorAplicado;
        this.rendimentoMensal = rendimentoMensal;
        this.meses = meses;
    }
    
    public static void setTaxaIR(double taxaIR) {
        Investimento.taxaIR = taxaIR;
    }

    public static double getTaxaIR() {
        return taxaIR;
    }

    
    public int getMeses() {
        return meses;
    }

    
    public double getRendimentoMensal() {
        return rendimentoMensal;
    }

    
    public double getValorAplicado() {
        return valorAplicado;
    }

    public double getRendimentoBruto() {
        double rendimentoAcumulado = Math.pow(1 + rendimentoMensal, meses);
        return valorAplicado * (rendimentoAcumulado - 1);
    }
    
    public double getRendimentoLiquido() {
        return getRendimentoBruto() * (1 - taxaIR);        
    }
    
    public String getDescricaoTributavel() {
        return "Fundo de Investimento";
    }

    public String getNomeImposto() {
        return "Imposto de Renda";
    }

    public double calcularImpostos() {
        return getRendimentoBruto() * taxaIR;
    }
    

    
}
