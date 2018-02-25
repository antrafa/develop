/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 */
public class ContaEspecial extends Conta {

    private double limite;

    /**
     * @param saldoInicial
     *            Saldo Inicial da conta
     * @param num
     *            Numero da conta
     * @param tit
     *            Titular da conta
     * @param ag
     *            Agencia a qual a conta pertence
     * @param limite
     *            limite da conta Especial
     */
    public ContaEspecial(double saldoInicial, String num, Cliente tit, Agencia ag, double limite) {
        super(saldoInicial, num, tit, ag);
        this.limite = limite;
    }

    /**
     * @param num
     *            Numero da conta
     * @param tit
     *            Titular da conta
     * @param ag
     *            Agencia a qual a conta pertence
     * @param limite
     *            limite da conta Especial
     */
    public ContaEspecial(String num, Cliente tit, Agencia ag, double limite) {
        super(num, tit, ag);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    /**
     * @param limite
     *            de credito
     */
    public void setLimite(double limite) {
        this.limite = limite;
    }

    /**
     * @param valor:
     *            valor a ser sacado da conta
     */
    public void saque(double valor) {
        System.out.println("Realizando saque de R$ " + valor + " da conta " + getNumero());
        if (valor > 0) {
            if (saldo + limite >= valor) {
                saldo -= valor;
                acumularIFN(valor);
            } else
                System.out.println("Saldo e limite insuficientes");
        } else {
            System.out.println("O valor de saque deve ser positivo");
        }
    }

    /**
     * Este metodo deve imprimir todos os dados da conta Especial
     */
    public void imprimeDados() {
        System.out.println("\n===========CONTA ESPECIAL ===========================");
        getAgencia().imprimeDados();
        System.out.println("Numero da conta: " + getNumero());
        getTitular().imprimeDados();
        System.out.println("Saldo  : R$" + saldo);
        System.out.println("Limite : R$" + limite);
        System.out.println("TOTAL  : R$" + (saldo + limite));
        System.out.println("========================================\n");
    }
}
