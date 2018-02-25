/**
 * Classe com o objetivo de praticar arrays de tipos primitivos e reference.
 * 
 * @author Melissa
 */
class Arrays {
  /**
   * Método para que esta classe possa ser executada com o utilitário java.
   * 
   * @param args
   *          - argumentos para o método main
   */
  public static void main(String args[]) {
	String array[] = new String[5];

	for (int i = 0; i < array.length; i++) {
    //array[i] = "Cliente " + i + " email: cliente" + i + "@cliente.com.br";
    array[i] = String.format("Cliente %s email: cliente%<s@cliente.com.br",i);
	}

	for(String cliente : array){
		System.out.println(cliente);
	}

  }
}
