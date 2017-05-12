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

    private Polynomial ONE;
    private Polynomial ZERO;

    public PrimeTools() {
        this.ONE = new Polynomial(1, 0);
        this.ZERO = new Polynomial(0);
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

        long upperLimit = Math.min(n - 1, r);

        for (long i = 2; i <= upperLimit; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        if (n <= r) {
            return true;
        }

        // Limit for testing the polynomial congruence.
        long lim = (long) Math.floor(Math.sqrt(phi(r)) * (Math.log(n) / Math.log(2)));

        Polynomial poly2 = new Polynomial(1, 0).modularExponentiation(n, n);
        Polynomial moduloPoly = new Polynomial(1, 0).exponentiation(r).addPolynomial(new Polynomial(-1));
        Polynomial zeroPoly = new Polynomial(0);

        // If (X+1)^n != X^n + a (mod X^r, n), n is a prime number.
        for (int a = 2; a <= lim; a++) {
            Polynomial poly1 = new Polynomial(1, a).modularExponentiation(n, n);

            Polynomial poly2a = poly2.addPolynomial(new Polynomial(a));

            Polynomial poly = poly1.subtract(poly2a);

            Polynomial remainder = poly.mod(moduloPoly);

            if (!remainder.polyEquals(zeroPoly)) {
                return false;
            }
        }

        // Otherwise, the number is a prime.
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
     * Function that the greatest common divisor of a and b. Time complexity of
     * this method is bounded above by O(log(min(a, b)))
     *
     * @param a One integer.
     * @param b Another integer
     * @return gcd(a, b).
     */
    public long gcd(long a, long b) {
        long helper = 0;
        while (b != 0) {
            helper = b;
            b = a % b;
            a = helper;
        }
        return a;
    }

    /**
     * Binary operation version of the gcd-method. Time complexity of this
     * method is bounded above by O(log(min(a, b)))
     *
     * @param a One integer.
     * @param b Another integer
     * @return gcd(a, b).
     */
    public long binaryGcd(long a, long b) {
        if (a == b) {
            return a;
        }

        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        if ((~a & 1) == 1) {
            if ((b & 1) == 1) {
                return binaryGcd(a >> 1, b);
            } else {
                return binaryGcd(a >> 1, b >> 1) << 1;
            }
        }

        if ((~b & 1) == 1) {
            return binaryGcd(a, b >> 1);
        }

        if (a > b) {
            return binaryGcd((a - b) >> 1, b);
        }

        return binaryGcd((b - a) >> 1, a);
    }

    /**
     * Method that checks whether a and b are coprime. That is, whether gcd(a,
     * b) = 1.
     *
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
     * Time complexity is bounded by O(n).
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

    /**
     * Sieve of Erastothenes. The naive way to test primality.
     *
     * @param integer The integer to be tested.
     * @return Truth value: is integer primal or not.
     */
    public boolean sieveErastothens(long integer) {
        for (int i = 2; i <= Math.sqrt(integer); i++) {
            if (integer % i == 0 && integer != 2) {
                return false;
            }
        }
        return true;
    }
}
