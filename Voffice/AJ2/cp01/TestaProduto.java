class TestaProduto {
	public static void main(String[] args) {
		Produto produto1 = new Produto();
		Produto produto2 = new Produto();

		produto1.codigo = "001";
		produto1.nome = "Fogão";
		produto1.preco = 500.23;
		produto1.fabricante = "Bosh";

		produto2.codigo = "002";
		produto2.nome = "Geladeira";
		produto2.preco = 900d;
		produto2.fabricante = "Brastemp";

		System.out.println("Produto 1: ");
		System.out.println("Código: " + produto1.codigo);
		System.out.println("Nome: " + produto1.nome);
		System.out.println("Preço: " + produto1.preco);
		System.out.println("Fabricante: " + produto1.fabricante);

		System.out.println("---------------------------");

		System.out.println("Produto 2: ");
		System.out.println("Código: " + produto2.codigo);
		System.out.println("Nome: " + produto2.nome);
		System.out.println("Preço: " + produto2.preco);
		System.out.println("Fabricante: " + produto2.fabricante);

	}
}