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

        long upperLimit = Math.min(n, r);

        for (long i = 2; i <= upperLimit; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        if (n <= r) {
            return true;
        }

        /*
        TO-DO
         */
        return true;
    }

    public long findTheSmallestR(long n) {
        int r = 1;
        while (true) {
            r++;
            if (!areCoprime(n, r)) {
                continue;
            }
            System.out.println(multiplicativeOrd(r, n));
            if (multiplicativeOrd(r, n) > Math.pow(Math.log(n), 2)) {
                break;
            }
        }
        return r;
    }

    /**
     * Checks the multiplicative order of a modulo n.
     *
     * @param n Modulo.
     * @param a
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
            System.out.println(diff);
            if (diff < 0.000000001) {
                return true;
            }
        }

        return false;
    }

    /**
     * Daniel Bernstein's algorithm for testing whether an integer is a perfect
     * power.
     *
     * @param n Integer to be tested.
     * @return True if it is, false if it isn't.
     */
    public boolean isPerfectPowerFast(long n) {
        long b = 1;

        while (true) {
            break;
        }

        return false;
    }

    /**
     * Function that determines n^exponent modulo mod.
     *
     * @param n Base.
     * @param exponent Exponent.
     * @param mod Modulo.s
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
}
