/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * Esta classe e responsavel pelo teste das Associacoes desenvolvidas nas classes Banco e Agencia
 * 
 */
public class TestaAssociacao {

    public static void main(String args[]) {
        Banco banco = new Banco("Globalcode Bank", 1000, 5);
        Agencia ag1 = banco.abrirAgencia();
        banco.imprimeAgencias();
        Cliente cliente1 = new Cliente("Joao da Silva", "1232323");
        Cliente cliente2 = new Cliente("Pedro Moraes", "123423");
        Conta c1 = ag1.abrirConta(4000, cliente1);
        Conta c2 = ag1.abrirConta(5000, cliente2);
        Conta c3 = ag1.abrirConta(1000, cliente1);
        Conta c4 = ag1.abrirConta(1000, cliente2);
        Conta c5 = ag1.abrirConta(1000, cliente1);
        Conta c6 = ag1.abrirConta(1000, cliente2);
        Conta c7 = ag1.abrirConta(1000, cliente2);
        ag1.imprimeContas();
    }
}
