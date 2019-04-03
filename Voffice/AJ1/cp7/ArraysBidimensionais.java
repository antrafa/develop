/**
 * Classe com o objetivo de praticar a utilização de controladores de fluxo.
 * 
 * @author Globalcode
 */
class ArraysBidimensionais {
  /**
   * Método para que esta classe possa ser executada com o utilitário java.
   * 
   * @param args
   *          - argumentos para o método main
   */
  public static void main(String args[]) {
	int array[][] = { { 1, 6, 7 }, { 2, 5, 1, 0 }, { 2, 4, 1, 2, 1 } };

	//// USANDO FOR EACH
	for(int[] linha : array) {
		
		for(int coluna : linha) {
			System.out.print(coluna + " ");
		}

		System.out.println("");

	}

	//// USANDO FOR
	/*for(int i = 0; i < array.length ; i++ ) {
		
		for(int j = 0; j < array[i].length ; j++ ) {
			System.out.print(array[i][j] + " ");
		}

		System.out.println("");

	}*/

  }
}
