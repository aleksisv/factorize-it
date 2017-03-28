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
        Polynomial poly = new Polynomial(2, 3, 4);
        System.out.println(poly);
        System.out.println(poly.evaluateAtX(4));
        long[] coefs = poly.getCoefficients();
        System.out.println(Arrays.toString(coefs));
    }

}
