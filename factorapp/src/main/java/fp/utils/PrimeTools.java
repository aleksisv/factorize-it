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
        
        /*
        We check if n is a perfect power.
        */
        int a = 1;
        int b = 1;
        while(true) {
            b=1;
            if(Math.pow(a, b) > n) {
                break;
            }
            while(true) {
                if (Math.abs((Math.pow(a, b) - n)) < 0.5) {
                    return false;
                }
                else if(Math.pow(a, b) > n) {
                    break;
                } else if (b > n) {
                    break;
                }
                b++;
            }
            a++;
        }
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
}
