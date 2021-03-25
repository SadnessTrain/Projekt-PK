package pk_projekt;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class Kalkulator extends JFrame implements ActionListener {
		
	private static final long serialVersionUID = -350197252473129350L;			//trzeba by³o dodaæ, nie rozumiem czemu, nie znajde odpowiedzi któr¹ bym zrozumia³
	static JFrame f;
	static JTextField t;
	String l0, l1, l2;							// liczby do wpisania
	
		
		public static void main(String[] args){
	    	
			Kalkulator c = new Kalkulator();
			
			t = new JTextField(16);				// output
			t.setEditable(false);				// nie mo¿na w nim pisaæ
												// poni¿ej s¹ przyciski
	        
	        JPanel p = new JPanel();
	        p.setBackground(Color.gray);
	        
	        SwingUtilities.invokeLater(new Runnable(){
	            public void run() {
	                new Kalkulator();
	            }
	        });
	        
	        Kalkulator temp = new Kalkulator();
	        temp.gui();
	        
	    }
		
		public void gui() {
			
			Kalkulator c = new Kalkulator();
			
			t = new JTextField(16);				// output
			t.setEditable(false);				// nie mo¿na w nim pisaæ
												// poni¿ej s¹ przyciski
			
			f = new JFrame("Kalkulator");
			f.setLayout(new FlowLayout());
			f.setLocationRelativeTo(null);
			f.setSize(600, 600);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // podobno warto daæ
			f.setVisible(true);
			
			JButton b0 = new JButton("0");
			JButton b1 = new JButton("1");
			JButton b2 = new JButton("2");
			JButton b3 = new JButton("3");
			JButton b4 = new JButton("4");
			JButton b5 = new JButton("5");
			JButton b6 = new JButton("6");
			JButton b7 = new JButton("7");
			JButton b8 = new JButton("8");
			JButton b9 = new JButton("9");
			
			JButton bs = new JButton("+");				// sumowanie
			JButton bo = new JButton("-");				// odejmowanie
			JButton bd = new JButton("/");				// dzielenie
			JButton bm = new JButton("*");				// mno¿enie
			JButton brw = new JButton("=");				// równa siê
			JButton bk = new JButton(".");				// kropka
			JButton bclr = new JButton("C");			// clear
			
			f.getContentPane().add(b0);
			f.getContentPane().add(b1);
			f.getContentPane().add(b2);
			f.getContentPane().add(b3);
			f.getContentPane().add(b4);
			f.getContentPane().add(b5);
			f.getContentPane().add(b6);
			f.getContentPane().add(b7);
			f.getContentPane().add(b8);
			f.getContentPane().add(b9);
			f.getContentPane().add(bs);
			f.getContentPane().add(bo);
			f.getContentPane().add(bd);
			f.getContentPane().add(bm);
			f.getContentPane().add(brw);
			f.getContentPane().add(bk);
			f.getContentPane().add(bclr);
			f.getContentPane().add(t);
			
			 bm.addActionListener(c);			// action listenery
		     bd.addActionListener(c);
		     bo.addActionListener(c);
		     bs.addActionListener(c);
		     b9.addActionListener(c);
		     b8.addActionListener(c);
		     b7.addActionListener(c);
		     b6.addActionListener(c);
		     b5.addActionListener(c);
		     b4.addActionListener(c);
		     b3.addActionListener(c);
		     b2.addActionListener(c);
		     b1.addActionListener(c);
		     b0.addActionListener(c);
		     bk.addActionListener(c);
		     bclr.addActionListener(c);
		     brw.addActionListener(c);
		}
		
		public void actionPerformed(ActionEvent e) {
			
			String s = e.getActionCommand();												// jakoœ s³ucha przycisków i robi z tego string(?)
			
			if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {			// je¿eli wybrany przycisk to liczba 1-9/'.'
	            if (!l1.equals(""))															// to j¹ wpisuje albo dodaje po kropce
	                l2 = l2 + s;
	            else
	                l0 = l0 + s;
	            t.setText(l0 + l1 + l2);													// setText wpisuje wynik w pole tekstowe, dlatego t.[..]
			}
			else if (s.charAt(0) == 'C') {													// usuwa
	            l0 = l1 = l2 = "";
	            t.setText(l0 + l1 + l2);
	        }
			else if (s.charAt(0) == '=') {
				  
	            double x;																	// tymczasowa zmienna
	  
	            if (l1.equals("+"))															// wybiera jak obliczyæ i to robi
	                x = (Double.parseDouble(l0) + Double.parseDouble(l2));					
	            else if (l1.equals("-"))
	                x = (Double.parseDouble(l0) - Double.parseDouble(l2));
	            else if (l1.equals("/"))
	                x = (Double.parseDouble(l0) / Double.parseDouble(l2));
	            else
	                x = (Double.parseDouble(l0) * Double.parseDouble(l2));
	  
	            t.setText(l0 + l1 + l2 + "=" + x);											// setText wpisuje wynik w pole tekstowe

	  
	            l0 = Double.toString(x);													// konwert w string ¿eby mo¿na by³o wpisaæ w pole na tekst(?)
	  
	            l1 = l2 = "";																// resetuje zmienne
	            
	        }
			/*else {

	            if (l1.equals("") || l2.equals(""))											// ?
	                l1 = s;

	            else {
	                
	            	double x;
	  
	                if (l1.equals("+"))
	                    x = (Double.parseDouble(l0) + Double.parseDouble(l2));
	                else if (l1.equals("-"))
	                    x = (Double.parseDouble(l0) - Double.parseDouble(l2));
	                else if (l1.equals("/"))
	                    x = (Double.parseDouble(l0) / Double.parseDouble(l2));
	                else
	                    x = (Double.parseDouble(l0) * Double.parseDouble(l2));
	  
	                l0 = Double.toString(x);
	  
	                // place the operator
	                l1 = s;
	  
	                // make the operand blank
	                l2 = "";
	                
	            }
			
			}*/
		}
}
