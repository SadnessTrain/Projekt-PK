package notepad;

import java.util.Random;

public class GUI {
	 
    public static void main(String a[]){
         
        System.out.println("Random number: "+Math.random());
        

        
        Random r = new Random();
        double random = 0.1 + r.nextDouble() * (10 - 0.1);
        System.out.println(random);
        
        //wyswietla sie duzo liczb po przecinku. Trzeba uzyc setScale(2) ale nie ogarniam jak
        
        double start = 100;
        // start to wartosc waluty
        
        //odpalcie to w loopie co np 5 sek, to bedziemy mieli ranomiser 1 waluty
        if (Math.random() > 0.5) {
        	System.out.println(start + " + " + random);
        	} else {
        		System.out.println(start + " - " + random );
        	}
        
    }
}