package pk_projekt;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;


public class Kalkulator extends JFrame implements ActionListener {
		
	private static final long serialVersionUID = -350197252473129350L;			//trzeba było dodać, nie rozumiem czemu, nie znajde odpowiedzi którą bym zrozumiał
	static JFrame f;
	static JTextField t;
	String l0, l1, l2;							// liczby do wpisania
	
	Kalkulator()								//konstruktor
    {
        l0 = l1 = l2 = "";
    }
	
		public static void main(String[] args){
	    	
			Kalkulator c = new Kalkulator();
			
		}
			
		public void actionPerformed(ActionEvent e) {
			
			String s = e.getActionCommand();												// jakoś słucha przycisków i robi z tego string(?)
			
			if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {			// jeżeli wybrany przycisk to liczba 1-9/'.'
	            if (!l1.equals(""))															// to ją wpisuje albo dodaje po kropce
	                l2 = l2 + s;															// linijka 115 TO GÓWNO KTÓRE WSZYSTKO PSUJE
	            else																		// same nullPointery jak nie klikne najpierw clear
	                l0 = l0 + s;															// dobra naprawiłem, jednak moja wina. nie lubie kiedy to jest moja wina
	            t.setText(l0 + l1 + l2);													// setText wpisuje wynik w pole tekstowe, dlatego t.[..]
			}
			else if (s.charAt(0) == 'C') {													// usuwa
	            l0 = l1 = l2 = "";															// DLACZEGO jak najpierw klikne clear
	            t.setText(l0 + l1 + l2);													// to wszystko zaczyna działać
	        }
			else if (s.charAt(0) == '=') {
				  
	            double x;																	// tymczasowa zmienna
	  
	            if (l1.equals("+"))															// wybiera jak obliczyć i to robi
	                x = (Double.parseDouble(l0) + Double.parseDouble(l2));					
	            else if (l1.equals("-"))
	                x = (Double.parseDouble(l0) - Double.parseDouble(l2));
	            else if (l1.equals("/"))
	                x = (Double.parseDouble(l0) / Double.parseDouble(l2));
	            else
	                x = (Double.parseDouble(l0) * Double.parseDouble(l2));
	  
	            t.setText(l0 + l1 + l2 + "=" + x);											// setText wpisuje wynik w pole tekstowe

	  
	            l0 = Double.toString(x);													// konwert w string żeby można było wpisać w pole na tekst(?)
	  
	            l1 = l2 = "";																// resetuje zmienne
	            
	        }
			else {

	            if (l1.equals("") || l2.equals(""))											// nie, nie wiem dlaczego to znowu tu jest
	                l1 = s;																	// cały blok kodu copy-pastowany ale działa

	            else {
	                
	            	double x;																// reject calculator, return to ancient egypt
	  
	                if (l1.equals("+"))
	                    x = (Double.parseDouble(l0) + Double.parseDouble(l2));
	                else if (l1.equals("-"))
	                    x = (Double.parseDouble(l0) - Double.parseDouble(l2));
	                else if (l1.equals("/"))
	                    x = (Double.parseDouble(l0) / Double.parseDouble(l2));
	                else
	                    x = (Double.parseDouble(l0) * Double.parseDouble(l2));
	  
	                l0 = Double.toString(x);
	  
	                l1 = s;
	  
	                l2 = "";
	                
	            }
			
			}
		}
}
