package fp.factorapp;

import fp.utils.Polynomial;
import fp.utils.PrimeTools;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * The main class.
 */
public class App {
    
    public static void main(String[] args) {
        PrimeTools pt = new PrimeTools();
        Polynomial p1 = new Polynomial(1, 4);
        
        long t1 = System.nanoTime();
        pt.areCoprime(311343244232L, 33321332134214L);
        long t2 = System.nanoTime();
        p1 = p1.exponentiation(320);
        long t3 = System.nanoTime();
        System.out.println(t3-t2);

        
    }
    
}
