public class Funcionario extends Pessoa {
	private String carteiraTrabalho;

	public String getCarteiraTrabalho(){
		return this.carteiraTrabalho;
	}

	public void setCarteiraTrabalho(String carteira){
		this.carteiraTrabalho = carteira;
	}

	public void imprimeDados(){
		System.out.println("Nome: "+this.getNome());
		System.out.println("Carteira de trabalho: "+this.getCarteiraTrabalho());
	}
}