/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * 1) Sobrecarregue o metodo inicializaConta permitindo que ele 
 * seja executado sem informar o saldo, e neste caso o saldo inicial
 * devera ser 0.
 * 
 */
public class Conta {

    private double saldo;
    private String numero;
    private String titular;
    private String agencia;
    private int banco;

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

    public void inicializaConta(String num, String tit, String ag, int bc) {
        this.saldo = 0;
        this.numero = num;
        this.titular = tit;
        this.agencia = ag;
        this.banco = bc;
    }

    public void inicializaConta(double saldoInicial, String num, String tit, String ag, int bc) {
        this.inicializaConta(num,tit,ag,bc);
        this.saldo = saldoInicial;
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
        if (valor >= 0)
            this.saldo += valor;
        else
            System.out.println("O valor do deposito deve ser positivo");
    }

    /**
     * Este metodo deve imprimir todos os dados da conta corrente
     */
    public void imprimeDados() {
        System.out.println("\n----------------------------");
        System.out.println(" AGENCIA:" + agencia);
        System.out.println(" NUMERO : " + numero);
        System.out.println(" TITULAR: " + titular);
        System.out.println(" SALDO  : R$" + saldo);
        System.out.println("-----------------------------\n");
    }

    /**
     * @return Saldo da conta
     */
    public double getSaldo() {
        return this.saldo;
    }

    /**
     * @return Numero da agencia da conta
     */
    public String getAgencia() {
        return agencia;
    }

    /**
     * @return Numero do banco da conta
     */
    public int getBanco() {
        return banco;
    }

    /**
     * @return Numero da conta
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @return Nome do titular da conta
     */
    public String getTitular() {
        return titular;
    }

    /**
     * @param saldo
     *            Saldo da conta
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @param agencia
     *            Numero da agencia da conta
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /**
     * @param banco
     *            Numero do banco da conta
     */
    public void setBanco(int banco) {
        this.banco = banco;
    }

    /**
     * @param numero
     *            Numero da conta
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    /**
     * @param titular
     *            Nome do titular da conta
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }
}
