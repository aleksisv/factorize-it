package fp.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * This class contain the necessary tools for testing whether some integer is
 * prime or not.
 */
public class PrimeTools {

    /**
     * Sieve-based primality test.
     *
     * @param n Integer to be tested.
     * @return Boolean that tells whether the integer n is prime or not.
     */
    public boolean primalityTest(long n) {

        for (int j = 2; j < Math.sqrt(n); j++) {
            if (n % j == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * AKS Primality test that is much faster than the above one.
     *
     * @param n Integer to be tested.
     * @return Boolean that tells whether the integer n is prime or not.
     */
    public boolean aksPrimalityTest(long n) {

        if (isPerfectPower(n)) {
            return false;
        }

        long r = findTheSmallestR(n);

        long upperLimit = Math.min(n-1, r);

        for (long i = 2; i <= upperLimit; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        if (n <= r) {
            return true;
        }
        
        
        long lim = (long) Math.floor( Math.sqrt( phi(r))*(Math.log(n) / Math.log(2)));
        
        Polynomial poly2 = new Polynomial(1, 0).modularExponentiation(n, n);
        Polynomial moduloPoly = new Polynomial(1, 0).exponentiation(r).addPolynomial(new Polynomial(-1));
        
        for (int a = 2; a <= lim; a++) {
            Polynomial poly1 = new Polynomial(1, a).modularExponentiation(n, n);
            //Polynomial poly2 = new Polynomial(1, 0).modularExponentiation(n, n).addPolynomial(new Polynomial(a));
            System.out.println("At: " + a);
            System.out.println("limit: " + lim);
            System.out.println("");
           
            Polynomial poly2a = poly2.addPolynomial(new Polynomial(a));
            
            Polynomial poly = poly1.subtract(poly2a);
            //Polynomial mod1 = new Polynomial(1, 0).exponentiation(r).addPolynomial(new Polynomial(-1));
            Polynomial remainder = poly.mod(moduloPoly);
            
            if(!remainder.polyEquals(new Polynomial(0))) {
                return false;
            }
        }
        

        return true;
    }

    /**
     * Finds the smallest r for which r is bigger than log_2(n).
     *
     * @param n The prime relative to which r is calculated.
     * @return The smallest r satisfying the requirement.
     */
    public long findTheSmallestR(long n) {
        int r = 1;
        while (true) {
            r++;
            if (!areCoprime(n, r)) {
                continue;
            }
            if (multiplicativeOrd(r, n) > Math.pow(Math.log(n) / Math.log(2), 2)) {
                break;
            }
        }
        return r;
    }

    /**
     * Checks the multiplicative order of a modulo n.
     *
     * @param n Modulo.
     * @param a Integers whose multiplicative order needs to be counted.
     * @return The multiplicative order of a modulo n.
     */
    public long multiplicativeOrd(long n, long a) {
        long i = 1;
        while (true) {
            long res = modularExponentiation(a, i, n);
            if (res == 1L) {
                return i;
            }
            i++;
        }

    }

    /**
     * Slower method for testing if an integer is a perfect power.
     *
     * @param n Integer to be tested.
     * @return True if it is, false if it isn't.
     */
    public boolean isPerfectPower(long n) {

        if (n == 1) {
            return true;
        }

        for (int i = 2; i < Math.log(n) + 1; i++) {
            double power = (double) 1 / (double) i;
            double a = Math.pow(n, power);
            double diff = Math.abs(a - Math.round(a));
            if (diff < 0.000000001) {
                return true;
            }
        }

        return false;
    }
    
    /**
     * Function that determines n^exponent modulo mod.
     *
     * @param n Base.
     * @param exponent Exponent.
     * @param mod Modulo.
     * @return n^exponent (Mod mod).
     */
    public long modularExponentiation(long n, long exponent, long mod) {
        if (mod == 1) {
            return 0;
        }
        long c = 1L;

        for (long i = 1; i <= exponent; i++) {
            c = (c * n) % mod;
        }

        return c;
    }

    /**
     * Function that the greatest common divisor of a and b.
     *
     * @param a One integer.
     * @param b Another integer
     * @return gcd(a, b).
     */
    public long gcd(long a, long b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    /**
     * Method that checks whether a and b are coprime. That is, whether gcd(a,
     * b) = 1.
     *
     * @param a One integer.
     * @param b Another integer
     * @return True, if gcd(a, b) = 1, otherwise false.
     */
    public boolean areCoprime(long a, long b) {
        if (gcd(a, b) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Euler's totient function. For given integer n, calculates phi(n), that is
     * the number of integers that are relative prime to n.
     *
     * @param n The argument of phi(n) for which we want to calculate the number
     * of integers relative prime to it.
     * @return The number of integers relative prime to n.
     */
    public long phi(long n) {
        long numCoprime = n;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                numCoprime -= (numCoprime / i);

            }
        }
        if (n >= 2) {
            numCoprime -= (numCoprime / n);
        }

        return numCoprime;
    }
}
