package fp.utils;

import java.math.BigDecimal;
import java.math.BigInteger;

public class PrimeTools {
    
    public boolean primalityTest(long n) {
        
        for (int j = 2; j < Math.sqrt(n); j++) {
            if(n % j == 0) {
                return false;
            }
        }
        
        return true;
    }
    /*
    An implementation of Agrawal-Kayal-Saxena primality test.
    */
    public boolean aksPrimalityTest(long n) {
        if (isPerfectPower(n)) {
            return false;
        } 
        
        /*
        TO-DO
        */
        return true;
    }
    
    /*
    Needed for the AKS Primality test to work.
    */
    public long multiplicativeOrd(long n, long a) {
        long i = 1;
        while(true) {
            long res = modularExponentiation(a, i, n);
            if(res == 1L) {
                return i;
            }
            i++;
        }
        
    }
    
    public boolean isPerfectPower(long n) {
        if(n == 1) {
            return true; 
        }
        
        for (int i = 2; i <= Math.floor(Math.sqrt(n)); i++) {
            double p = Math.log10(n)/Math.log10(i);
            if(p == Math.floor(p) && p > 1) {
                return true;
            }
        }
        
        return false;   
    }
    /*Daniel Bernstein's algorithm for testing perfect powers.*/
    public boolean isPerfectPowerFast(long n) {
        long b = 1;
        
        while(true) {
            break;
        }
        
        return false;   
    }
    
    
    
    public long modularExponentiation(long n, long exponent, long mod) {
        if(mod == 1) {
            return 0;
        }
        long c = 1L;
        
        for (long i = 1; i <= exponent; i++) {
            c = (c * n) % mod;
        }
        
        return c;
    }
    
    public long gcd(long a, long b) {
        while(a != b) {
            if(a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }
    
    public boolean areCoprime(long a, long b) {
        if (gcd(a, b) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
