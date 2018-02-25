/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 */
class TestaConta {

    public static void main(String[] args) {
        Conta conta = new Conta();

        conta.inicializaConta(1000, "01234", "Antonio Rafael", 321, 20);
        conta.imprimeDados();
        conta.saque(500.0);
        conta.imprimeDados();
        conta.deposito(700.0);
        conta.imprimeDados();
    }
}
