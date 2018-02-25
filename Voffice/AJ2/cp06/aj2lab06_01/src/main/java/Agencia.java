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
     * @param num
     *            Numero da agencia
     * @param bc
     *            banco ao qual a agencia pertence
     */
    public Agencia(String numero, int banco) {
        this.setNumero(numero);
        this.setBanco(banco);
    }

    /**
     * @return numero do banco
     */
    public int getBanco() {
        return banco;
    }

    /**
     * @return numero da agencia
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param b
     *            banco
     */
    public void setBanco(int b) {
        banco = b;
    }

    /**
     * @param num
     *            numero da agencia
     */
    public void setNumero(String num) {
        numero = num;
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
