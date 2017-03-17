package fp.utils;

import java.math.BigInteger;

public class PrimeTools {
    
    public boolean primalityTest(int n) {
        
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
    public boolean aksPrimalityTest(int n) {
        
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
    public int multiplicativeOrd(int n, int r) {
        int i = 1;
        while(true) {
            if(Math.round(Math.pow(n, i)) % r == 1) {
                return i;
            }
            i++;
        }
    }
}
