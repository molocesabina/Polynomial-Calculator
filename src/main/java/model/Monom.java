package model;


public class Monom implements Comparable<Monom> {
	private int coeficientInt;
	private double coeficientDouble;
	private int grad;
	
	
	public Monom(int c, int g){
		coeficientInt = c;
		coeficientDouble = c;
		grad = g;
	}
	
	public Monom(double c, int g){
		coeficientDouble = c;
		grad = g;
	}
	
	
	private static Monom sparge1(String[] grupRupt) {
		if(grupRupt[0].equals("-"))
			return new Monom(-1, Integer.parseInt(grupRupt[1]));
		else if(grupRupt[0].equals("+"))
			return new Monom(1, Integer.parseInt(grupRupt[1]));
		else
			return new Monom(Integer.parseInt(grupRupt[0]), Integer.parseInt(grupRupt[1]));
		}
		
	private static Monom sparge2(String[] grupRupt, String s) {
		if(grupRupt[0].equals("-"))
			return new Monom(-1, 1);
		else if(grupRupt[0].equals("+"))
			return new Monom(1, 1);
		else
			return new Monom(Integer.parseInt(grupRupt[0]), 1);
	}
	
	public static Monom transformaDinString(String sMonom) {
		String monomRupt[]=null;
		if(sMonom.contains("*x^")) {  // 2*x^7
			monomRupt = sMonom.split("\\*x\\^");
			return new Monom(Integer.parseInt(monomRupt[0]), Integer.parseInt(monomRupt[1]));
		}
		else if (sMonom.contains("x^")) {  // +x^7; -x^7; 2x^7
			monomRupt = sMonom.split("x\\^");
			return sparge1(monomRupt);
		}
		else if (sMonom.contains("*x")) { // 3*x
			monomRupt = sMonom.split("\\*x");
			return new Monom(Integer.parseInt(monomRupt[0]), 1);
		}
		else if(sMonom.contains("x")) {  // +x, -x, 3x
			monomRupt = sMonom.split("x");
			return sparge2(monomRupt,sMonom);
		}
		else {
			return new Monom(Integer.parseInt(sMonom), 0); // 3, -1
		}
	}
	
    
	public Monom inmultesteMinus1CuMonom() {
		return new Monom(coeficientDouble*(-1), this.grad);
	}
	
	public Monom imparteMonomLaMonom(Monom m) {
		return new Monom(coeficientDouble/m.coeficientDouble,this.grad-m.grad);
	}
	
	public Monom inmultesteMonomCuMonom(Monom m) {
		return new Monom(coeficientDouble*m.coeficientDouble, grad+m.grad);
	}
	
	public Monom derivaMonom() {
		int coefNou = coeficientInt*grad;
		int gradNou = grad-1;
		if(gradNou>=0)
			return new Monom((double)coefNou, gradNou);
		else
			return new Monom(0.0,0);
	}
	
	public Monom integreazaMonom() {
		if(coeficientDouble != 0)
			return new Monom(coeficientDouble/(grad+1), grad + 1);
		else
			return new Monom(0.0,0);
	}

	public int compareTo(Monom o) {
		if(this.grad<o.grad) {
			return -1;
		} else if(this.grad==o.grad) {
			return 0;
		} else {
		    return 1;
		}
	}
	
	
    private static String taieDecimaleNefolositoare(double nb) {
		String sDouble = String.valueOf(nb);
		int indexVirgula = sDouble.indexOf(".");
		if(sDouble.substring(indexVirgula+1).equals("0"))
			return sDouble.substring(0,indexVirgula);
		return String.format("%.1f", nb);
	}
	
	public String toString() {
		if(grad != 0) {
			if(!(coeficientDouble ==1 || coeficientDouble ==-1) && grad!=1)
				return taieDecimaleNefolositoare(coeficientDouble)+"x^"+grad;
			else if(grad !=1 && coeficientDouble ==1)
				return "x^"+grad;
			else if(grad !=1 && coeficientDouble == -1)
				return "-x^"+grad;
			else if(grad == 1 && !(coeficientDouble ==1 || coeficientDouble ==-1))
				return taieDecimaleNefolositoare(coeficientDouble)+"x";
			else if(coeficientDouble == 1)
				return "x";
			else
				return "-x";
		}
		else
			return taieDecimaleNefolositoare(coeficientDouble);	
	}
	
	public int getCoeficientInt() {
		return coeficientInt;
	}

	public void setCoeficient(int coeficient) {
		this.coeficientInt = coeficient;
	}

	public int getGrad() {
		return grad;
	}

	public void setGrad(int grad) {
		this.grad = grad;
	}
	
	
	public double getCoeficientDouble() {
		return coeficientDouble;
	}
	
	public void setCoeficientDouble(double coeficientDouble) {
		this.coeficientDouble = coeficientDouble;
	}	
}

