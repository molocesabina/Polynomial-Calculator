package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import model.*;
import view.*;

public class CalculatorController {
	private CalculatorModel model;
    private CalculatorView  view;
	
    public CalculatorController(CalculatorModel m, CalculatorView v) {
        model = m;
        view  = v;
 
        view.adaugaAdunaListener(new AdunaListener());
        view.adaugaScadeListener(new ScadeListener());
        view.adaugaImnultesteListener(new InmultesteListener());
        view.adaugaImparteListener(new ImparteListener());
        view.adaugaDeriveazaListener(new DeriveazaListener());
        view.adaugaIntegreazaListener(new IntegreazaListener());
        view.adaugaResetListener(new ResetListener());
    }
    
   
    class AdunaListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
            	if(view.getPolinomul1().equals("") || view.getPolinomul2().equals(""))
            		throw new CampLiberExceptie();
            	Polinom polinom1 =  Polinom.creeazaPolinomValid(view.getPolinomul1());
                Polinom polinom2 = Polinom.creeazaPolinomValid(view.getPolinomul2());
            	if(polinom1 == null || polinom2 == null) {
            		throw new SintaxaExceptie();
            	}
                model.initCalculator(polinom1, polinom2, 0);
                view.setRezultat(model.getRezultat().toString());     
            } catch (SintaxaExceptie ex) {
            	JOptionPane.showMessageDialog(null, "Polinoamele nu au fost introduse corect!");
            } catch(CampLiberExceptie ex) {
            	JOptionPane.showMessageDialog(null, "Nu ati dat polinoamele!");
            }
        }
    }
    
    class ScadeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
             try {
            	if(view.getPolinomul1().equals("") || view.getPolinomul2().equals(""))
             		throw new CampLiberExceptie();
             	Polinom polinom1 =  Polinom.creeazaPolinomValid(view.getPolinomul1());
                Polinom polinom2 = Polinom.creeazaPolinomValid(view.getPolinomul2());
             	if(polinom1 == null || polinom2 == null) {
             		throw new SintaxaExceptie();
             	}
                 model.initCalculator(polinom1, polinom2, 1);
                 view.setRezultat(model.getRezultat().toString());     
             } catch (SintaxaExceptie ex) {
             	JOptionPane.showMessageDialog(null, "Polinoamele nu au fost introduse corect!");
             } catch(CampLiberExceptie ex) {
             	JOptionPane.showMessageDialog(null, "Nu ati dat polinoamele!");
             }
        }
    }
    
    class InmultesteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
             try {
            	if(view.getPolinomul1().equals("") || view.getPolinomul2().equals(""))
              		throw new CampLiberExceptie();
              	Polinom polinom1 =  Polinom.creeazaPolinomValid(view.getPolinomul1());
                Polinom polinom2 = Polinom.creeazaPolinomValid(view.getPolinomul2());
             	if(polinom1 == null || polinom2 == null) {
             		throw new SintaxaExceptie();
             	}
                 model.initCalculator(polinom1, polinom2, 2);
                 view.setRezultat(model.getRezultat().toString());     
             } catch (SintaxaExceptie ex) {
             	JOptionPane.showMessageDialog(null, "Polinoamele nu au fost introduse corect!");
             } catch(CampLiberExceptie ex) {
              	JOptionPane.showMessageDialog(null, "Nu ati dat polinoamele!");
             }
        }
    }
    
    class ImparteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
            	if(view.getPolinomul1().equals("") || view.getPolinomul2().equals(""))
              		throw new CampLiberExceptie();
              	Polinom polinom1 =  Polinom.creeazaPolinomValid(view.getPolinomul1());
                Polinom polinom2 = Polinom.creeazaPolinomValid(view.getPolinomul2());
            	if(polinom1 == null || polinom2 == null) {
            		throw new SintaxaExceptie();
            	}
            	if(polinom2.estePolinomulZero())
            		throw new ArithmeticException();
                model.initCalculator(polinom1, polinom2, 3);
                view.setRezultat(model.getRezultat()+"; rest = "+model.getRest());   
            } catch (SintaxaExceptie ex) {
             	JOptionPane.showMessageDialog(null, "Polinoamele nu au fost introduse corect!");
            } catch(ArithmeticException ex) {
            	JOptionPane.showMessageDialog(null, "Impartitorul nu poate fi zero!");
            } catch(CampLiberExceptie ex) {
              	JOptionPane.showMessageDialog(null, "Nu ati dat polinoamele!");
            }
        }
    }
    
    class DeriveazaListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
            	if(view.getPolinomul1().equals(""))
              		throw new CampLiberExceptie();
              	Polinom polinom1 =  Polinom.creeazaPolinomValid(view.getPolinomul1());
            	if(polinom1 == null) {
            		throw new SintaxaExceptie();
            	}
                model.initCalculator(polinom1, null, 4);
                view.setRezultat(model.getRezultat().toString());   
            } catch (SintaxaExceptie ex) {
             	JOptionPane.showMessageDialog(null, "Polinomul 1 nu au fost introdus corect!");
            } catch(CampLiberExceptie ex) {
              	JOptionPane.showMessageDialog(null, "Nu ati dat polinomul 1!");
            }
        }
    }
    
    class IntegreazaListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
            	if(view.getPolinomul1().equals(""))
              		throw new CampLiberExceptie();
              	Polinom polinom1 =  Polinom.creeazaPolinomValid(view.getPolinomul1());
            	if(polinom1 == null) {
            		throw new SintaxaExceptie();
            	}
                model.initCalculator(polinom1, null, 5);
                view.setRezultat(model.getRezultat().toString());   
            } catch (SintaxaExceptie ex) {
             	JOptionPane.showMessageDialog(null, "Polinomul 1 nu au fost introdus corect!");
            } catch(CampLiberExceptie ex) {
              	JOptionPane.showMessageDialog(null, "Nu ati dat polinomul 1!");
            }
        }
    }
    
  
 
    class ResetListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.reset();
            view.reset();
        }
    }
    
    class SintaxaExceptie extends Exception{
    	SintaxaExceptie(String msg){
    		super(msg);
    	}
    	SintaxaExceptie(){
    		super("SINTAXA POLINOM GRESITA");
    	}
    }
    
    class CampLiberExceptie extends Exception{
    	CampLiberExceptie(String msg){
    		super(msg);
    	}
    	CampLiberExceptie(){
    		super("NU AU FOST DATE POLINOAMELE");
    	}
    }
    
  
}

