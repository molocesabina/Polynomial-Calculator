package model;

import java.util.ArrayList;
import java.util.List;

public class Operatie {
	
	public static Polinom adunaPolinoame(Polinom p1, Polinom p2) {
		Polinom poliAdunate = p1.copiaza();
		for(Monom m2: p2.getP()) {
			int amGasitGrad = 0;
			for(Monom a: poliAdunate.getP()) {
				if(m2.getGrad() == a.getGrad()) {
					amGasitGrad = 1;
					a.setCoeficientDouble(m2.getCoeficientDouble()+a.getCoeficientDouble());
				}
			}
			if(amGasitGrad == 0) {
				poliAdunate.addMonom(new Monom(m2.getCoeficientDouble(),m2.getGrad()));
			}
		}
		poliAdunate.stergeMonoameZero();
		poliAdunate.sortPolinom();
		poliAdunate.setGrad(poliAdunate.ultimulMonomDinPoli().getGrad());
		return poliAdunate;
	}
	
	

	public static Polinom scadePolinoame(Polinom p1, Polinom p2) {
		Polinom p2InmultitMin1 = new Polinom();
		for(Monom m: p2.getP()) {
			p2InmultitMin1.addMonom( m.inmultesteMinus1CuMonom());
		}
		return adunaPolinoame(p2InmultitMin1, p1);
	}
	
	public static Polinom inmultestePolinoame(Polinom p1, Polinom p2) {
		Polinom poliInmultite = new Polinom();
		poliInmultite.addMonom(new Monom(0.0, 0));
		poliInmultite.setGrad(0);
		for(Monom m: p1.getP()) {
			poliInmultite = adunaPolinoame(poliInmultite, p2.inmultestePolinomCuMonom(m) );
		}
		return poliInmultite;
	}
	

    public static List<Polinom> impartePolinom(Polinom n, Polinom d) {
    	Polinom q = new Polinom();
    	q.getP().add(new Monom(0.0,0));
    	q.setGrad(0);
    	Polinom r = n.copiaza();
    	while(r.getGrad()>=d.getGrad() && r.estePolinomulZero() == false) {
    		Monom mt = r.ultimulMonomDinPoli().imparteMonomLaMonom(d.ultimulMonomDinPoli());
    		Polinom t = new Polinom();
    		t.setGrad( mt.getGrad());
    		t.addMonom(mt);
    		q = adunaPolinoame(q,t);
    		r = scadePolinoame(r, inmultestePolinoame(t,d));
    	}
    	List<Polinom> l = new ArrayList<Polinom>();
    	l.add(q);
    	l.add(r);
    	return l;
    }
    
    public static Polinom integreazaPolinom(Polinom p) {
    	Polinom poliIntegrat = new Polinom();
    	for(Monom m: p.getP()) {
    		Monom md = new Monom(m.getCoeficientDouble(), m.getGrad());
    	    poliIntegrat.addMonom(md.integreazaMonom());
    	}
        poliIntegrat.setGrad( poliIntegrat.ultimulMonomDinPoli().getGrad());
    	return poliIntegrat;
    	
    }
    

    public static Polinom derivaPolinom(Polinom p) {
    	Polinom poliDerivat = new Polinom();
    	for(Monom m: p.getP()) {
    		Monom md = m.derivaMonom();
    		poliDerivat.addMonom(md);
    	}
    	poliDerivat.stergeMonoameZero();
    	poliDerivat.setGrad( poliDerivat.ultimulMonomDinPoli().getGrad());
    	return poliDerivat;
    }
    
    
    
}
