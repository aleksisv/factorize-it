package fp.utils;

import java.math.BigInteger;

public class PrimeTools {
    
    public boolean primalityTest(int i) {
        
        for (int j = 2; j < Math.sqrt(i); j++) {
            if(i % j == 0) {
                return false;
            }
        }
        
        return true;
    }
}
