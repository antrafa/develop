/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 */
public class ContaEspecial extends Conta {

    private double limite;

    public ContaEspecial(double saldoInicial, String num, Cliente tit, Agencia ag, double limite) {
        super(saldoInicial, num, tit, ag);
        setLimite(limite);
    }

    public ContaEspecial(String num, Cliente tit, Agencia ag, double limite) {
        super(num, tit, ag);
        setLimite(limite);
    }

    public void imprimeDados() {
        System.out.println("========================================");
        System.out.println("CONTA ESPECIAL");
        System.out.println("Limite de R$ " + getLimite());
        super.imprimeDados();
    }

    public void saque(double valor) {
        System.out.println("Realizando saque de R$ " + valor + " da conta " + getNumero());
        if (valor > 0) {
            if ((saldo + limite)>= valor) {
                saldo -= valor;
                acumularIFN(valor);
            } else
                System.out.println("Saldo insuficiente");
        } else {
            System.out.println("O valor de saque deve ser positivo");
        }
    }

    /**
     * @return Retorna o atributo limite.
     */
    public double getLimite() {
        return limite;
    }

    /**
     * @param limite
     *            Determina o atributo limite.
     */
    public void setLimite(double limite) {
        this.limite = limite;
    }
}
