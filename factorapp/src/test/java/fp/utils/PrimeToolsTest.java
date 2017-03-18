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
     @Test
     public void multiplicativeOrderWorks1() {
        PrimeTools p = new PrimeTools();
        assertEquals(p.multiplicativeOrd(7, 4), 3);
        assertEquals(p.multiplicativeOrd(122, 11), 4);
        assertEquals(p.multiplicativeOrd(37, 60), 12);
     }
}
