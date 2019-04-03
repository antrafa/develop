import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;


public class TesteCalculadora extends TestCase {
	
	Calculadora calculadora = new Calculadora();
	
	public void testeSoma(){
		assertEquals(4,calculadora.soma(2,2));
	}
	
	public void testeSubtracao(){
		assertEquals(2,calculadora.subtrai(5,3));
	}
	
	public void testeDivisao(){
		assertEquals(2,calculadora.divide(2,1));
	}
	
	public void testeMultiplicacao(){
		assertEquals(4,calculadora.multiplica(2,2));
	}

}
