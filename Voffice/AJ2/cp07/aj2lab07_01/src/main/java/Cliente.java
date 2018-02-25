/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 */
public class Cliente {

    private String nome;
    private String cpf;

    /**
     * @param n
     *            nome do cliente
     * @param c
     *            cpf do cliente
     */
    public Cliente(String nome, String cpf) {
        this.setCpf(cpf);
        this.setNome(nome);
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
     *            nome do Cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Metodo para impressao de todos os dados da classe
     */
    public void imprimeDados() {
        System.out.println("----------------------");
        System.out.println("Nome do cliente :" + this.getNome());
        System.out.println("CPF:" + this.getCpf());
        System.out.println("----------------------");
    }

}
