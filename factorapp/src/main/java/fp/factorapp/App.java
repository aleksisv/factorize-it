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
        Polynomial p = new Polynomial(20, 10, 2);
        System.out.println(pt.phi(99));
        System.out.println(pt.phi(254213000));
        System.out.println(p);
        System.out.println(p.shiftRight(2));
    }
    
}
