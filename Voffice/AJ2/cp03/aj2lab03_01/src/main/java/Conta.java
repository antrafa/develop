/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * As seguintes alteracoes foram feitas para encapsulamento dos atributos da classe Conta:
 * - Todos os atributos tem o modificador de acesso private, ou seja, nao poderao ser 
 * alterados diretamente, somente atraves de metodos da propria classe 
 * - Nao e necessario criar setter para o saldo, pois este atributo esta encapsulado 
 * pelos metodos saque(double valor), deposito(double valor) e getSaldo().
 * - Nao e necessario criar os metodos setNumero(), setAgencia(), setBanco(), 
 * estes valores podem ser passados apenas na inicializacao do objeto, na chamada ao metodo
 * inicializaConta().
 * 
 * Analise o codigo abaixo.
 */
public class Conta {

    private double saldo;
    private String numero;
    private String titular;
    private int agencia;
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
    public void inicializaConta(double saldoInicial, String num, String tit, int ag, int bc) {
        saldo = saldoInicial;
        numero = num;
        titular = tit;
        agencia = ag;
        banco = bc;
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
     *            Valor a ser depositado na conta
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
        return saldo;
    }

    /**
     * @return Numero da agencia da conta
     */
    public int getAgencia() {
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
     * @param titular
     *            Nome do titular da conta
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }
}
