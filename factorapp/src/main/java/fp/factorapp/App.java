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
        PrimeTools p = new PrimeTools();
        Polynomial poly1 = new Polynomial(2, 3, 4, 4, 2);
        Polynomial poly2 = new Polynomial(5, 2, 0, 2, 1);
        System.out.println(poly1);
        Polynomial toBeExponented = new Polynomial(4, 2);
        
        Polynomial poly3 = toBeExponented.exponentiation(5);
        Polynomial poly4 = poly1.times(poly2);
        System.out.println(Arrays.toString(poly4.getCoefficients()));
        
        System.out.println(poly3);
    }

}
