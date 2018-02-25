package br.com.globalcode.impostos;

public interface Tributavel {
    public String getDescricaoTributavel();
    public String getNomeImposto();
    public double calcularImpostos();
}
