package fp.gui;

import fp.utils.PrimeTools;


/**
 * Class that calls the PrimeTools-class to determine primality in each case.
 * Used by PrimelityTest.java.
 */
public class Application {

    private PrimeTools primeTools;

    /**
     * Constructor creates a new PrimeTools-object.
     */
    public Application() {
        this.primeTools = new PrimeTools();
    }

    /**
     * Constructor creates a new PrimeTools-object.
     * @param number The number whose primality we want to test.
     * @return true or false, according to the primality of the number.
     */
    public boolean primalityTest(long number) {
        return primeTools.aksPrimalityTest(number);
    }

    public void factorization(long number) {

    }


}
