/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 */
public class ContaPoupanca extends Conta {

    private String dataAniversario;

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
     * @param dataAniversario
     *            data de aniversario da conta poupanca
     */
    public ContaPoupanca(double saldoInicial, String num, Cliente tit, Agencia ag, String dataAniversario) {
        super(saldoInicial, num, tit, ag);
        this.dataAniversario = dataAniversario;
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
     * @param dataAniversario
     *            data de aniversario da conta poupanca
     */
    public ContaPoupanca(String num, Cliente tit, Agencia ag, String dataAniversario) {
        super(num, tit, ag);
        this.dataAniversario = dataAniversario;
    }

    /**
     * @return data de aniversario da conta poupanca
     */
    public String getDataAniversario() {
        return dataAniversario;
    }

    /**
     * @param dataAniversario
     *            data de aniversario da conta Poupanca
     */
    public void setDataAniversario(String dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    /**
     * Este metodo deve imprimir todos os dados da conta Poupanca
     */
    public void imprimeDados() {
        System.out.println("\n ============ CONTA POUPANCA ====================");
        getAgencia().imprimeDados();
        System.out.println("Numero da conta: " + getNumero());
        System.out.println("Data de aniversario: " + dataAniversario);
        getTitular().imprimeDados();
        System.out.println("Saldo  : R$" + saldo);
        System.out.println("========================================\n");
    }


}
