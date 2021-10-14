package model;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorModel {
	private Polinom p1;
	private Polinom p2;
	private Polinom rezultat;
	private Polinom rest;
	
	// +=0, -=1; *=2; /=3; deriv=4; integ=5
	public void initCalculator(Polinom p1, Polinom p2, int codOp) {
		if(codOp == 0) {
			rezultat = Operatie.adunaPolinoame(p1, p2);
		} else if(codOp == 1) {
			rezultat = Operatie.scadePolinoame(p1, p2);
		} else if(codOp == 2) {
			rezultat = Operatie.inmultestePolinoame(p1, p2);
		} else if(codOp == 3){
			List<Polinom> listaRez = Operatie.impartePolinom(p1, p2);
			rezultat = listaRez.get(0);
			rest = listaRez.get(1);
		} else if(codOp == 4) {
			rezultat = Operatie.derivaPolinom(p1);
		} else {
			rezultat = Operatie.integreazaPolinom(p1);
		}
	}

	public void reset() {
		p1 = null;
		p2 = null;
		rezultat = null;
	}
	
	public Polinom getP1() {
		return p1;
	}
	public void setP1(Polinom p1) {
		this.p1 = p1;
	}
	public Polinom getP2() {
		return p2;
	}
	public void setP2(Polinom p2) {
		this.p2 = p2;
	}
	public Polinom getRezultat() {
		return rezultat;
	}
	public void setRezulat(Polinom rezultat) {
		this.rezultat = rezultat;
	}
	public Polinom getRest() {
		return rest;
	}
	public void setRest(Polinom rest) {
		this.rest = rest;
	}
}