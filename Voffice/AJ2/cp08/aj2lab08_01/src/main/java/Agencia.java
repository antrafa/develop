/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 */
public class Agencia {

    private String numero;
    private Banco banco;

    /**
     * @param num
     *            Numero da agencia
     * @param bc
     *            banco ao qual a agencia pertence
     */
    public Agencia(String num, Banco bc) {
        numero = num;
        banco = bc;
    }

    /**
     * @return numero do banco
     */
    public Banco getBanco() {
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
    public void setBanco(Banco b) {
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
        System.out.println("Agencia no. " + numero);
        banco.imprimeDados();
    }

}