/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 */
public class TestaConta {

    public static void main(String[] args) {
        // Criar um objeto do tipo Conta
        Conta conta1 = new Conta();

        // Usar o metodo inicializaConta para fazer a inicializacao do objeto criado
        conta1.inicializaConta(1000, "0912", "Antonio Rafael", 9123, 10);
        
        // executar um deposito
        conta1.deposito(2500);
        
        // Imprimir o saldo apos o deposito
        System.out.println("O saldo é "+conta1.getSaldo());
        
        // executar um saque cujo valor seja menor que o saldo
        conta1.saque(500);
        
        // Imprimir o saldo apos o deposito
        System.out.println("O saldo é "+conta1.getSaldo());
        
        // executar uma retirada cujo valor seja maior que o saldo
        conta1.saque(5000);
        
        // Imprimir o saldo apos o deposito
        System.out.println("O saldo é "+conta1.getSaldo());
    }
}
