package web;

import br.com.u2d.dao.Calculo;
import junit.framework.TestCase;

public class CalculoTest extends TestCase{

	public void test() {
		int passanum1 = 10;
		int passanum2 = 5;
		int resultesperado = 15;
		
		int atual = Calculo.soma(passanum1, passanum2);
		
		assertEquals(resultesperado, atual, 0);
	}
}
