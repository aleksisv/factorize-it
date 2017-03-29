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
        Polynomial p = new Polynomial(0, 2, 5, 4, 3, 20);
        System.out.println(p);
        Polynomial p2 = p.exponentiation(3);
        System.out.println(p2);
        Polynomial p3 = p.addPolynomial(p);
        System.out.println(p3);
        
    }

}
