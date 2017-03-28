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
        Polynomial poly2 = new Polynomial(2, 3);
        System.out.println(poly1);
        System.out.println(poly1.evaluateAtX(4));
        long[] coefs = poly1.getCoefficients();
        Polynomial poly3 = poly1.addPolynomial(poly2);
        System.out.println(poly3);
    }

}
