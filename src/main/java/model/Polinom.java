package model;
import java.util.ArrayList;


import java.util.Collections;
import java.util.List;
import java.util.regex.*;



public class Polinom {
	private int grad;
	private List<Monom> p;
	
	public Polinom() {
		grad = -1;
		p = new ArrayList<Monom>();
	}
	
	public void addMonom(Monom m) {
	   p.add(m);
	}

	public Polinom inmultestePolinomCuMonom(Monom m) {
		Polinom poliInmulMono = new Polinom();
		poliInmulMono.p.add(new Monom(0.0,0));
		poliInmulMono.grad = 0;
		for(Monom i: this.p) {
		    poliInmulMono.p.add(i.inmultesteMonomCuMonom(m));
		}
		poliInmulMono.grad = poliInmulMono.ultimulMonomDinPoli().getGrad();
		return poliInmulMono;
	}
	
    public boolean estePolinomulZero() {
       if(p.size()==1) {
    	   if(this.ultimulMonomDinPoli().getCoeficientDouble()==0 &&  this.ultimulMonomDinPoli().getGrad()==0)
    		   return true;
       }
       return false;
    }
    
    public Polinom copiaza() {
    	Polinom c = new Polinom();
    	c.setGrad(this.grad);
    	for(Monom m: p) {
    		c.p.add(new Monom(m.getCoeficientDouble(), m.getGrad()));
    	}
    	return c;
    }
    
    public Monom ultimulMonomDinPoli() {
       return p.get(p.size()-1);
    }
	
	public void stergeMonoameZero() {
		List<Monom> deSters = new ArrayList<Monom>();
		for(Monom m: p) {
			if(m.getCoeficientDouble()==0) {
				deSters.add(m);
			}
		}
		p.removeAll(deSters);
		if(p.size()==0)
			p.add(new Monom(0.0,0));
	}
	
	public String toString() {
		String s = "";
		for(Monom m: this.p) {
			if(this.p.get(0)==m) {
				s+=m.toString();
			} else {
				if(m.getCoeficientDouble()>=0) {
					s+="+"+m.toString();
				} else {
					s+=m.toString();
				}
			}
		}
		return s;
	}
		
	public static Polinom creeazaPolinomValid(String sPolinom) {
		if(!(sPolinom.charAt(0)=='-' || sPolinom.charAt(0)=='+'))
			sPolinom = "+"+sPolinom;
		sPolinom = sPolinom.replaceAll("\\s","");
		sPolinom = sPolinom.toLowerCase();
		Pattern pattern = Pattern.compile("([+-]((\\d+[*]?x\\^\\d+)|(x\\^\\d+)|(\\d+[*]?x)|(\\d+)|(x)))");
		Matcher matcher = pattern.matcher(sPolinom);
		String[] grupRupt = null;
		String sFormatGrupuri="";
		Polinom p = new Polinom();
		while (matcher.find()) {
			Monom m = Monom.transformaDinString(matcher.group());
			sFormatGrupuri+= matcher.group();
			p.getP().add(m);
		}
		if(!sPolinom.equals(sFormatGrupuri))
			return null;
		p.sortPolinom();
		p.setGrad(p.ultimulMonomDinPoli().getGrad());
	    return p;
	}
	
   
	public void sortPolinom() {
		Collections.sort(p);
	}
	
	public int getGrad() {
		return grad;
	}

	public void setGrad(int grad) {
		this.grad = grad;
	}

	public List<Monom> getP() {
		return p;
	}

	public void setP(List<Monom> p) {
		this.p = p;
	}
	
}