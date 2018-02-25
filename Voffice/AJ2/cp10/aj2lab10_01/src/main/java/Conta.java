/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 *  
 */
public class Conta {

    protected double saldo;
    private String numero;
    private Cliente titular;
    private Agencia agencia;
    private double acumuladorIFN;    
    private static double taxaIFN = 0.038;    

    /**
     * @param saldoInicial
     *            Saldo Inicial da conta
     * @param num
     *            Numero da conta
     * @param tit
     *            Titular da conta
     * @param ag
     *            Agencia a qual a conta pertence
     * @param bc
     *            Banco a qual a agencia pertence
     */
    public Conta(double saldoInicial, String num, Cliente tit, Agencia ag) {
        saldo = saldoInicial;
        numero = num;
        titular = tit;
        agencia = ag;
    }

    /**
     * @param num
     *            Numero da conta
     * @param tit
     *            Titular da conta
     * @param ag
     *            Agencia a qual a conta pertence
     * @param bc
     *            Banco a qual a agencia pertence
     */
    public Conta(String num, Cliente tit, Agencia ag) {
        this(0, num, tit, ag);
    }

    /**
     * @param valor
     *            Valor a ser sacado da conta
     */
    public void saque(double valor) {
        System.out.println("Realizando saque de R$ " + valor + " da conta " + numero);
        if (valor > 0) {
            if (saldo >= valor) {
                saldo -= valor;
                acumularIFN(valor);
            } else
                System.out.println("Saldo insuficiente");
        } else {
            System.out.println("O valor de saque deve ser positivo");
        }
    }

    /**
     * @param valor
     *            Valor a ser depositado da conta
     */
    public void deposito(double valor) {
        System.out.println("Realizando deposito de R$" + valor + " da conta " + numero);
        if (valor >= 0) {
            this.saldo += valor;
        } else
            System.out.println("O valor do deposito deve ser positivo");
    }

    /**
     * Este metodo deve imprimir todos os dados da conta corrente
     */
    public void imprimeDados() {
        System.out.println("======================================");
        agencia.imprimeDados();
        System.out.println("Numero da conta: " + numero);
        titular.imprimeDados();
        System.out.println("Saldo  : R$" + saldo);
        System.out.println("========================================");
    }

    /**
     * @return saldo da conta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @return agencia numero da agencia da conta
     */
    public Agencia getAgencia() {
        return agencia;
    }

    /**
     * @return numero numero da conta
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @return Nome do titular da conta
     */
    public Cliente getTitular() {
        return titular;
    }

    /**
     * @param titular
     *            Nome do titular da conta
     */
    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public static double getTaxaIFN() {
        return taxaIFN;
    }

    
    public static void setTaxaIFN(double taxaIFN) {
        Conta.taxaIFN = taxaIFN;
    }
    
    protected void acumularIFN(double valorSaque) {
        acumuladorIFN += taxaIFN * valorSaque;
    }

    public double getIFNAcumulado() {
        return acumuladorIFN;
    }    
}
