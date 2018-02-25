/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * Analise o codigo
 * 
 */
class Cliente {

    String nome;
    String cpf;

    /**
     * @param nomeCliente
     *            nome do cliente
     * @param cpfCliente
     *            cpf do cliente
     */
    void inicializaCliente(String nomeCliente, String cpfCliente) {
        cpf = cpfCliente;
        nome = nomeCliente;
    }

    /**
     * Metodo para impressao de todos os dados da classe
     */
    void imprimeDados() {
        System.out.println("----------------------");
        System.out.println("Nome do cliente :" + nome);
        System.out.println("CPF:" + cpf);
        System.out.println("----------------------");
    }
}
