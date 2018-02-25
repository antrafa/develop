/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * Nao e necessario fazer nenhuma alteracao nesta classe
 */
public class Agencia {

    private String numero;
    private int banco;

    /**
     * @return Numero do banco
     */
    public int getBanco() {
        return banco;
    }

    /**
     * @return Numero da agencia
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param num
     *            Numero da agencia
     * @param bc
     *            Banco ao qual a agencia pertence
     */
    public void inicializaAgencia(String num, int bc) {
        this.numero = num;
        this.banco = bc;
    }

    /**
     * @param b
     *            banco
     */
    public void setBanco(int b) {
        this.banco = b;
    }

    /**
     * @param numero
     *            Numero da agencia
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Metodo para impressao de todos os dados da classe
     */
    public void imprimeDados() {
        System.out.println("----------------------");
        System.out.println("Agencia no. " + numero);
        System.out.println("Banco no." + banco);
        System.out.println("----------------------");
    }
}
