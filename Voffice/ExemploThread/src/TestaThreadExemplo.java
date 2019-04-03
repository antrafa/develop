
public class TestaThreadExemplo {

	public static void main(String[] args) {
		ThreadExemplo t = new ThreadExemplo(1000, '-');
		ThreadExemplo u = new ThreadExemplo(1000, '>');
		ThreadExemplo v = new ThreadExemplo(1000, '<');
		ThreadExemplo x = new ThreadExemplo(1000, 'o');
		
		t.start();
		u.start();
		v.start();
		x.start();
	}
	
}
