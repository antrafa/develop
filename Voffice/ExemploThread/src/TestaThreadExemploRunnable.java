
public class TestaThreadExemploRunnable {

	public static void main(String[] args) throws InterruptedException {
		ThreadExemploRunnable t = new ThreadExemploRunnable(1000, '-');
		ThreadExemploRunnable u = new ThreadExemploRunnable(1000, '>');
		ThreadExemploRunnable x = new ThreadExemploRunnable(1000, 'o');
		ThreadExemploRunnable v = new ThreadExemploRunnable(1000, '<');
		
		Thread t1 = new Thread(t);
		Thread u1 = new Thread(u);
		Thread v1 = new Thread(v);
		Thread x1 = new Thread(x);
		
		t1.start();
		u1.start();
		v1.start();
		x1.start();
	}
	
}
