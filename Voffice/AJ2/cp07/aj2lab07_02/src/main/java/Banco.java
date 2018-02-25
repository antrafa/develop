/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * A compreensao desta classe e fundamental para usa-la como exemplo.
 * Em um modelo real, um Banco possui muitas agencias.
 * 
 * Este relacionamento de classes foi mapeado nesta classe, e isso pode ser 
 * verificado ao analisar o atributo chamado agencias que e um array de 
 * instancias da classe Agencia
 * 
 * Adicionalmente, o banco e responsavel pela abertura de agencias.
 * 
 * Para refletir essa realidade, foram criados os metodos abrirAgencia e 
 * adicionaArrayAgencia
 * 
 * O metodo abrirAgencia e usado para instanciar a classe Agencia.
 * 
 * O metodo adicionaArrayAgencia e responsavel por inserir a classe instanciada
 * dentro do array agencias
 * 
 * Neste modelo estaremos partindo da premissa que temos que definir uma 
 * quantidade fixa de agencias no momento da criacao do banco.
 * 
 * Desta maneira, fomos obrigados a colocar o numero maximo de agencias dentre os 
 * parametros do construtor
 * 
 * Tambem incluimos o metodo de impressao das agencias que fazem parte do banco 
 * (metodo imprimeAgencias)
 * 
 */
public class Banco {

    private String nome;
    private int numero;
    private Agencia agencias[];
    private int numAgenciasAbertas = 0;
    private static int numeroProximaAgencia = 1234;

    /**
     * @param nome
     *            Nome do banco
     * @param numero
     *            Numero do banco
     * @param numeroMaxAgencias
     *            Numero maximo de agencias
     */
    public Banco(String nome, int numero, int numeroMaxAgencias) {
        this.nome = nome;
        this.numero = numero;
        this.agencias = new Agencia[numeroMaxAgencias];
    }

    /**
     * @return nome do banco
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return numero do banco
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param nome
     *            Nome do banco
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param num
     *            Numero do banco
     */
    public void setNumero(int num) {
        numero = num;
    }

    /**
     * Metodo para impressao de todos os dados da classe Banco
     */
    public void imprimeDados() {
        System.out.println("Banco: " + nome + "\tNumero do banco " + numero);
    }

    /**
     * Metodo para abertura de uma Agencia dentro da instancia da classe Banco
     * 
     * @return Agencia que foi criada
     */
    public Agencia abrirAgencia() {
        Agencia a = new Agencia("" + numeroProximaAgencia++, this,10);
        boolean agenciaAdicionada = adicionaArrayAgencias(a);
        if (agenciaAdicionada) {
            return a;
        } else {
            return null;
        }
    }

    /**
     * Metodo para inclusao da agencia recem aberta dentro do array de agencias
     * 
     * @return Retorna um booleano identificando se a agencia foi inserida com sucesso
     */
    private boolean adicionaArrayAgencias(Agencia ag) {
        if (this.agencias.length <= numAgenciasAbertas) {
            System.out.println("Banco ERROR: Nao foi possivel criar uma nova agencia");
            return false;
        } else {
            System.out.println("Banco DEBUG: Agencia adicionada ao array " + numAgenciasAbertas);
            this.agencias[numAgenciasAbertas] = ag;
            numAgenciasAbertas++;
            return true;
        }
    }

    /**
     * Metodo para imprimir todas as agencias que fazem parte deste banco
     */
    public void imprimeAgencias() {
        System.out.println("\n\n=============== RELATORIO DE AGENCIAS DO BANCO ==================\n");
        System.out.println("Numero de agencias abertas: " + numAgenciasAbertas);
        for (int i = 0; i < numAgenciasAbertas; i++) {
            agencias[i].imprimeDados();
        }
        System.out.println("===============================================");
    }
}