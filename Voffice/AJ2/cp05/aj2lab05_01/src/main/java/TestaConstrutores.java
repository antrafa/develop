/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java 
 * 1) Construa um objeto da classe Conta com cada construtor e chame o metodo imprimeDados 
 * 2) Construa um objeto da classe Cliente e chame o metodo imprimeDados
 * 
 */
public class TestaConstrutores {

    public static void main(String[] args) {
    	Conta c1 = new Conta(1000.0, "124", "Antonio", "5432", 20);
		Conta c2 = new Conta("578493", "Rafael", "0987", 30);

		c1.imprimeDados();
		c2.imprimeDados();

		Cliente cli = new Cliente("Antonio Rafael", "23453214");
		cli.imprimeDados();
    }
}
