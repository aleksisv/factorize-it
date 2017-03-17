
package fp.factorapp;

import fp.utils.PrimeTools;

public class App {

    public static void main(String[] args) {
        PrimeTools p = new PrimeTools();
        
        boolean b = p.aksPrimalityTest(100);
        
        System.out.println(b);
    }
    
}
