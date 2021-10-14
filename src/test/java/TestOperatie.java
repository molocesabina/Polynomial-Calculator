import static org.junit.Assert.*;

import java.util.List;

import model.*;
import org.junit.Test;

public class TestOperatie {
	Polinom p1;
	Polinom p2;
	Polinom rezultat;
	
	@Test
	public void testAdunaPolinoame() {
		p1 = Polinom.creeazaPolinomValid("1-2*x");
		p2 = Polinom.creeazaPolinomValid("x");
		rezultat = Operatie.adunaPolinoame(p1, p2);
		assertEquals(rezultat.toString(),"1-x");
		p2 = Polinom.creeazaPolinomValid("-1+2x");
		rezultat = Operatie.adunaPolinoame(p1, p2);
		assertEquals(rezultat.toString(),"0");
		p2 = Polinom.creeazaPolinomValid("x^10000000");
		rezultat = Operatie.adunaPolinoame(p1, p2);
		assertEquals(rezultat.toString(),"1-2x+x^10000000");
		p2 = Polinom.creeazaPolinomValid("0");
		rezultat = Operatie.adunaPolinoame(p1, p2);
		assertEquals(rezultat.toString(),"1-2x");
		p1 = Polinom.creeazaPolinomValid("2*x^7+45*x^5-1");
		p2 = Polinom.creeazaPolinomValid("x^8-3x^5-5");
		rezultat = Operatie.adunaPolinoame(p1, p2);
		assertEquals(rezultat.toString(),"-6+42x^5+2x^7+x^8");
		p1 = Polinom.creeazaPolinomValid("1 * x^0 + 23x");
		p2 = Polinom.creeazaPolinomValid("2*x");
		rezultat = Operatie.adunaPolinoame(p1, p2);
		assertEquals(rezultat.toString(),"1+25x");	
	}

	@Test
	public void testScadePolinoame() {
		p1 = Polinom.creeazaPolinomValid("0");
		p2 = Polinom.creeazaPolinomValid("2x^3");
		rezultat = Operatie.scadePolinoame(p1, p2);
		assertEquals(rezultat.toString(),"-2x^3");
		p1 = Polinom.creeazaPolinomValid("-x+25x^2");
		p2 = Polinom.creeazaPolinomValid("-x+2x^3");
		rezultat = Operatie.scadePolinoame(p1, p2);
		assertEquals(rezultat.toString(),"25x^2-2x^3");
		p1 = Polinom.creeazaPolinomValid("0");
		p2 = Polinom.creeazaPolinomValid("0");
		rezultat = Operatie.scadePolinoame(p1, p2);
		assertEquals(rezultat.toString(),"0");
		
	}

	@Test
	public void testInmultestePolinoame() {
		p1 = Polinom.creeazaPolinomValid("0");
		p2 = Polinom.creeazaPolinomValid("2x^3");
		rezultat = Operatie.inmultestePolinoame(p1, p2);
		assertEquals(rezultat.toString(),"0");
		p2 = Polinom.creeazaPolinomValid("0");
		rezultat = Operatie.inmultestePolinoame(p1, p2);
		assertEquals(rezultat.toString(),"0");
		p1 = Polinom.creeazaPolinomValid("1+x");
		p2 = Polinom.creeazaPolinomValid("1+x");
		rezultat = Operatie.inmultestePolinoame(p1, p2);
		assertEquals(rezultat.toString(),"1+2x+x^2");
		p1 = Polinom.creeazaPolinomValid("x^10000");
		p2 = Polinom.creeazaPolinomValid("1+x");
		rezultat = Operatie.inmultestePolinoame(p1, p2);
		assertEquals(rezultat.toString(),"x^10000+x^10001");
		p1 = Polinom.creeazaPolinomValid("1-x+2x^3");
		p2 = Polinom.creeazaPolinomValid("-1+x-2x^3");
		rezultat = Operatie.inmultestePolinoame(p1, p2);
		assertEquals(rezultat.toString(),"-1+2x-x^2-4x^3+4x^4-4x^6");
		
	}

	@Test
	public void testImpartePolinom() {
		p1 = Polinom.creeazaPolinomValid("0");
		p2 = Polinom.creeazaPolinomValid("2x^3");
		List<Polinom> lista = Operatie.impartePolinom(p1, p2);
		assertEquals(lista.get(0).toString(),"0");
		assertEquals(lista.get(1).toString(),"0");
		p1 = Polinom.creeazaPolinomValid("1-x+2x^2");
		p2 = Polinom.creeazaPolinomValid("1+x");
		lista = Operatie.impartePolinom(p1, p2);
		assertEquals(lista.get(0).toString(),"-3+2x");
		assertEquals(lista.get(1).toString(),"4");
		p1 = Polinom.creeazaPolinomValid("4+3x^2+x^6");
		p2 = Polinom.creeazaPolinomValid("3x^4");
		lista = Operatie.impartePolinom(p1, p2);
		assertEquals(lista.get(0).toString(),"0,3x^2");
		assertEquals(lista.get(1).toString(),"4+3x^2");
	}


	@Test
	public void testDerivaPolinom() {
		p1 = Polinom.creeazaPolinomValid("0");
		rezultat = Operatie.derivaPolinom(p1);
		assertEquals(rezultat.toString(),"0");
		p1 = Polinom.creeazaPolinomValid("1-x+2x^2");
		rezultat = Operatie.derivaPolinom(p1);
		assertEquals(rezultat.toString(),"-1+4x");
		p1 = Polinom.creeazaPolinomValid("1-x+2x^10000+x^10");
		rezultat = Operatie.derivaPolinom(p1);
		assertEquals(rezultat.toString(),"-1+10x^9+20000x^9999");	
	}


	@Test
	public void testIntegreazaPolinom() {
		p1 = Polinom.creeazaPolinomValid("0");
		rezultat = Operatie.integreazaPolinom(p1);
		assertEquals(rezultat.toString(),"0");
		p1 = Polinom.creeazaPolinomValid("1+x+2x^3");
		rezultat = Operatie.integreazaPolinom(p1);
		assertEquals(rezultat.toString(),"x+0,5x^2+0,5x^4");
		
	}

}
