/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * Nao e necessario fazer nenhuma alteracao nesta classe
 * 
 */
public class Cliente {

    private String nome;
    private String cpf;

    /**
     * @param nomeCliente
     *            nome do cliente
     * @param cpfCliente
     *            cpf do cliente
     */
    public void inicializaCliente(String nomeCliente, String cpfCliente) {
        this.cpf = cpfCliente;
        this.nome = nomeCliente;
    }

    /**
     * @return cpf do cliente
     */
    public String getCpf() {
        return this.cpf;
    }

    /**
     * @return nome do cliente
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * @param cpf
     *            CPF do cliente
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @param nome
     *            Nome do Cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo para impressao de todos os dados da classe
     */
    public void imprimeDados() {
        System.out.println("----------------------");
        System.out.println("Nome do cliente :" + this.nome);
        System.out.println("CPF:" + this.cpf);
        System.out.println("----------------------");
    }
}
