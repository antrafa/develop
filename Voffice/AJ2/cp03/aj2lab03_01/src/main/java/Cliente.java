/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * 1) Encapsule os atributos da classe Cliente
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

    public void setNome(String _nome){
        this.nome = _nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setCpf(String _cpf){
        this.cpf = _cpf;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void inicializaCliente(String nomeCliente, String cpfCliente) {
        setNome(nomeCliente);
        setCpf(cpfCliente);
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
