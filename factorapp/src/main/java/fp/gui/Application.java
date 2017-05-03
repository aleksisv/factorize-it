package fp.gui;

import fp.utils.PrimeTools;

public class Application {
    private PrimeTools primeTools;

    public Application() {
        this.primeTools = new PrimeTools();
    }
    
    public boolean primalityTest(long number) {
        return primeTools.aksPrimalityTest(number);
    }

    public void factorization(long number) {
       
    }

    
}
