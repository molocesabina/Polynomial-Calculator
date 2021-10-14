package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;


import model.*;

public class CalculatorView extends JFrame{
	 private JTextField textFieldPolinom1 = new JTextField(40);
	 private JTextField textFieldPolinom2     = new JTextField(40);
	 private JTextField textFieldRezultat     = new JTextField(40);
	 private JButton    adunaBtn = new JButton("+");
	 private JButton    scadeBtn = new JButton("-");
	 private JButton    inmultesteBtn = new JButton("*");
	 private JButton    imparteBtn = new JButton("/");
	 private JButton    deriveazaBtn = new JButton("dx");
	 private JButton    integreazaBtn = new JButton("\u222B");
	 private JButton    resetBtn   = new JButton("Reset");
	 private Image img = new ImageIcon(getClass().getClassLoader().getResource("back0.jpg")).getImage().getScaledInstance(705, 365, Image.SCALE_DEFAULT);
	
	 public CalculatorView() {
	        textFieldRezultat.setEditable(false);
	        JPanel content = new JPanel() {
                public void paintComponent(Graphics g) {
                     g.drawImage(img, 0, 0, null);
                }
             };
	        
	        content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS)); 
	        content.setOpaque(true);
	        
	        
	        JPanel panelPolinoame = new JPanel();
	        panelPolinoame.setLayout(new BoxLayout(panelPolinoame,BoxLayout.X_AXIS));
	        panelPolinoame.setOpaque(false);
	        JPanel panelEtichete = new JPanel();
	        panelEtichete.setOpaque(false);
	        //panelEtichete.setBackground(new Color(230, 230, 250)); //(230, 230, 250)
	        panelEtichete.setLayout(new BoxLayout(panelEtichete,BoxLayout.Y_AXIS)); 
	        panelEtichete.add( Box.createRigidArea(new Dimension(0,10)) );
	        JLabel lblPrimulPolinom1 = new JLabel("PRIMUL POLINOM");
	        lblPrimulPolinom1.setForeground(new Color(0, 0, 0));
	        lblPrimulPolinom1.setFont(new Font("Tahoma", Font.BOLD, 17));
	        panelEtichete.add(lblPrimulPolinom1);
	        panelEtichete.add( Box.createRigidArea(new Dimension(0,9)) );
	        JLabel lblAlDoileaPolinom = new JLabel("AL DOILEA POLINOM ");
	        lblAlDoileaPolinom.setForeground(new Color(0, 0, 0));
	        lblAlDoileaPolinom.setFont(new Font("Tahoma", Font.BOLD, 17));
	        panelEtichete.add(lblAlDoileaPolinom);
	        panelEtichete.add( Box.createRigidArea(new Dimension(0,9)) );
	        JLabel lblRezultat = new JLabel("REZULTAT");
	        lblRezultat.setForeground(new Color(0, 0, 0));
	        lblRezultat .setFont(new Font("Tahoma", Font.BOLD, 17));
	        panelEtichete.add(lblRezultat);
	        panelEtichete.add( Box.createRigidArea(new Dimension(0,10)) );
	        
	        panelPolinoame.add(panelEtichete);
	        
	        JPanel panelTextFields = new JPanel();
	        panelTextFields.setOpaque(false);
	        //panelTextFields.setBackground(new Color(230, 230, 250));
	        panelTextFields.setLayout(new BoxLayout(panelTextFields,BoxLayout.Y_AXIS)); 
	        panelTextFields.add( Box.createRigidArea(new Dimension(0,10)) );
	        textFieldPolinom1.setBorder(null);
	        textFieldPolinom1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        panelTextFields.add(textFieldPolinom1);
	        panelTextFields.add( Box.createRigidArea(new Dimension(0,5)) );
	        textFieldPolinom2.setBorder(null);
	        textFieldPolinom2.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        panelTextFields.add(textFieldPolinom2);
	        panelTextFields.add( Box.createRigidArea(new Dimension(0,5)) );
	        textFieldRezultat.setBorder(null);
	        textFieldRezultat.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        panelTextFields.add(textFieldRezultat);
	        panelTextFields.add( Box.createRigidArea(new Dimension(0,5)) );
	        
	        panelPolinoame.add(panelTextFields);
	        
	        
	        JPanel panelBuntoane = new JPanel();
	        panelBuntoane.setOpaque(false);
	        
	        panelBuntoane.setLayout(new BoxLayout(panelBuntoane,BoxLayout.Y_AXIS));
	        panelBuntoane.add( Box.createRigidArea(new Dimension(0,5)) );
	        JPanel panelOp= new JPanel();
	        panelOp.setOpaque(false);
	        JPanel panelOp1= new JPanel();
	        panelOp1.setOpaque(false);
			panelOp.add(panelOp1);
			JPanel panelOp2= new JPanel();
			panelOp2.setOpaque(false);
			panelOp.add(panelOp2);
			
			panelOp2.setLayout(new GridLayout(3,2)); 
	        adunaBtn.setFont(new Font("Tahoma", Font.BOLD, 17));
	        adunaBtn.setPreferredSize(new Dimension(110,50));
	        panelOp2.add(adunaBtn);       
	        scadeBtn.setFont(new Font("Tahoma", Font.BOLD, 17));
	        panelOp2.add(scadeBtn);      
	        inmultesteBtn.setFont(new Font("Tahoma", Font.BOLD, 17));
	        panelOp2.add(inmultesteBtn);       
	        imparteBtn.setFont(new Font("Tahoma", Font.BOLD, 17));
	        panelOp2.add(imparteBtn);
	        deriveazaBtn.setFont(new Font("Tahoma", Font.BOLD, 17));
	        panelOp2.add(deriveazaBtn);
	        integreazaBtn.setFont(new Font("Tahoma", Font.BOLD, 17));
	        panelOp2.add(integreazaBtn);
	        
	        panelBuntoane.add(panelOp);
	        
	        panelBuntoane.add( Box.createRigidArea(new Dimension(0,5)) );
	        resetBtn.setFont(new Font("Tahoma", Font.BOLD, 17));
	        panelBuntoane.add(resetBtn);
	        panelBuntoane.add( Box.createRigidArea(new Dimension(0,5)) );
	        content.add(panelPolinoame);
	        content.add(panelBuntoane);
	 
	       
	   
            this.setContentPane(content);
	        this.pack();
	        
	        this.setTitle("Polynomial Calculator");
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	    
	    public void reset() {
	    	textFieldPolinom1.setText("");
	    	textFieldPolinom2.setText("");
	    	textFieldRezultat.setText("");
	    	
	    }
	    
	    public String getPolinomul1() {
	        return textFieldPolinom1.getText();
	    }
	    
	    public String getPolinomul2() {
	        return textFieldPolinom2.getText();
	    }
	    
	    public void setRezultat(String rezultat) {
	        textFieldRezultat.setText(rezultat);
	    }
	    
	    public void adaugaAdunaListener(ActionListener al) {
	    	adunaBtn.addActionListener(al);
	    }
	    
	    public void adaugaScadeListener(ActionListener al) {
	    	scadeBtn.addActionListener(al);
	    }
	    
	    public void adaugaImnultesteListener(ActionListener al) {
	    	inmultesteBtn.addActionListener(al);
	    }
	    
	    public void adaugaImparteListener(ActionListener al) {
	    	imparteBtn.addActionListener(al);
	    }
	    
	    public void adaugaDeriveazaListener(ActionListener al) {
	    	deriveazaBtn.addActionListener(al);
	    }
	    
	    public void adaugaIntegreazaListener(ActionListener al) {
	    	integreazaBtn.addActionListener(al);
	    }
	    
	    public void adaugaResetListener(ActionListener al) {
	    	resetBtn.addActionListener(al);
	    }
}
