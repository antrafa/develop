
public class ThreadExemplo extends Thread {

	private int numero;
	private char c;
	
	public ThreadExemplo(int numero, char c){
		this.numero = numero;
		this.c = c;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < numero; i++){
			System.out.print(c);
		}
	}
	
}
