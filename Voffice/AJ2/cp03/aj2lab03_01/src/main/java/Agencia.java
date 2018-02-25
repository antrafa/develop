/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * 1) Encapsule os atributos da classe Agencia = tornar os atributos privados e criar getters e setters
 * 
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

    public void setNumero(String _numero){
        this.numero = _numero;
    }

    public String getNumero(){
        return this.numero;
    }
    
    public void setBanco(int _banco){
        this.banco = _banco;
    }
    
    public int getBanco(){
        return this.banco;
    }

    public void inicializaAgencia(String num, int bc) {
        setNumero(num);
        setBanco(bc);
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
