package fp.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrimeToolsTest {

    public PrimeToolsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void primalityCheckWorks1() {
        PrimeTools p = new PrimeTools();
        assertFalse(p.primalityTest(201));
        assertTrue(p.primalityTest(13));
        assertTrue(p.primalityTest(2));
    }

    /**
     *
     */
    @Test
    public void multiplicativeOrderWorks1() {
        PrimeTools p = new PrimeTools();
        assertEquals(p.multiplicativeOrd(7, 4), 3);
        assertEquals(p.multiplicativeOrd(122, 11), 4);
        assertEquals(p.multiplicativeOrd(37, 60), 12);
    }

    @Test
    public void gcdWorks1() {
        PrimeTools p = new PrimeTools();
        assertEquals(p.gcd(2, 3), 1);
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                assertEquals(p.gcd(i, j), p.gcd(j, i));
            }
        }
        assertEquals(p.gcd(123512, 13245), 1);
        assertEquals(p.gcd(14000, 13245022), 14);
    }

    @Test
    public void areCoprimeWorks() {
        PrimeTools p = new PrimeTools();
        assertTrue(p.areCoprime(23, 45));
        assertFalse(p.areCoprime(23, 46));
        assertTrue(p.areCoprime(4, 9));
        assertFalse(p.areCoprime(46, 2323));
    }

    @Test
    public void isPerfectPowerWorks() {
        PrimeTools p = new PrimeTools();
        assertTrue(p.isPerfectPower(8));
        assertTrue(p.isPerfectPower(1));
        assertFalse(p.isPerfectPower(3));
        assertTrue(p.isPerfectPower(15625));
    }

    @Test
    public void isPerfectPowerWorksForLarge1() {
        PrimeTools p = new PrimeTools();
        assertTrue(p.isPerfectPower(46656));
        assertFalse(p.isPerfectPower(46655));
        assertTrue(p.isPerfectPower(823543));
        assertFalse(p.isPerfectPower(823542));
        assertTrue(p.isPerfectPower(16777216));
        assertFalse(p.isPerfectPower(16777215));
        assertTrue(p.isPerfectPower(134217728));
        assertFalse(p.isPerfectPower(134217727));
    }

    @Test
    public void modularExponentiationWorks1() {
        PrimeTools p = new PrimeTools();
        assertEquals(p.modularExponentiation(2, 3, 7), 1);
        assertEquals(p.modularExponentiation(22, 13, 1), 0);
        assertEquals(p.modularExponentiation(4, 2, 4), 0);
        assertEquals(p.modularExponentiation(2, 4, 6), 4);

    }

    @Test
    public void findTheSmallestRWorks1() {
        PrimeTools p = new PrimeTools();
        assertEquals(p.findTheSmallestR(31), 29);

    }

    @Test
    public void phiWorks1() {
        PrimeTools p = new PrimeTools();
        int[] correctAnswers = {4, 10, 4, 12, 6, 8, 8, 16, 6, 18};
        for (int i = 0; i < 10; i++) {
            assertEquals(p.phi(i + 10), correctAnswers[i]);
        }
        assertEquals(p.phi(1321321), 1299600);

        assertEquals(p.phi(2542130), 1016848);

    }

    @Test
    public void aksWorks1() {
        PrimeTools p = new PrimeTools();
        assertEquals(p.aksPrimalityTest(3), true);

    }
}
