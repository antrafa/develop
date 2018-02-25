/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 */
public class Banco {

    private String nome;
    private int numero;

    /**
     * @param nome
     *            Nome do banco
     * @param numero
     *            Numero do banco
     */
    public Banco(String nome, int numero) {
        this.setNome(nome);
        this.setNumero(numero);
    }

    /**
     * @return nome nome do banco
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return numero numero do banco
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param nome
     *            nome do banco
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param num
     *            numero do banco
     */
    public void setNumero(int num) {
        numero = num;
    }

    /**
     * Metodo para impressao de todos os dados da classe Banco
     */
    public void imprimeDados() {
        System.out.println("Banco: " + nome + "\tNumero do banco " + numero);
    }
}
