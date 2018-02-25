class ExemploVarArgs {

	public static void main(String... args) {
		int[] parametros = {1, 2, 4, 5};
		imprimeSemVarArg(parametros);

		parametros = new int[]{7, 8, 6 , 4, 5};
		imprimeSemVarArg(parametros);

		imprimeComVarArg(1);
		imprimeComVarArg(1, 2);
		imprimeComVarArg(1, 2, 3, 6, 4, 5);
		imprimeComVarArg(parametros);
	}

	static void imprimeSemVarArg(int[] inteiros) {
		for (int inteiro : inteiros) {
			System.out.print(" ValorSem: " + inteiro);
		}
		System.out.println("");
	}

	static void imprimeComVarArg(int...inteiros) {
		for (int inteiro : inteiros) {
			System.out.print(" ValorCom: " + inteiro);
		}
		System.out.println("");
	}
}