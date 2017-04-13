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
        Polynomial p = new Polynomial(1, 30, 375, 2500, 9375, 18750, 15625);
        Polynomial res = p.longDivision(new Polynomial(1, 5));
        System.out.println(res);
        
    }
    
}
