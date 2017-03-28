
package fp.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PolynomialTest {

    
    public PolynomialTest() {

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
    
    @Test
    public void defaultConstructorWorks1() {
        Polynomial p = new Polynomial();
        assertEquals(p.toString(), "0");
    }
    
    @Test
    public void degreeWorks1(){
        Polynomial p = new Polynomial(2, 3);
        assertEquals(p.getDegree(), 1);
        p = new Polynomial(2, 3, 4, 5);
        assertEquals(p.getDegree(), 3);
        p = new Polynomial(2);
        assertEquals(p.getDegree(), 0);
        p = new Polynomial(0, 3, 3, 2);
        assertEquals(p.getDegree(), 2);
    }
    
    @Test
    public void addingPolynomialWorks1() {
        Polynomial p1 = new Polynomial(2, 3);
        Polynomial p2 = new Polynomial(2, 3, 4);
        Polynomial pAdd = p1.addPolynomial(p2);
        assertEquals(pAdd.toString(), "2x^2 + 5x^1 + 7");
    }
    
    @Test
    public void scalingPolynomialWorks1() {
        Polynomial p1 = new Polynomial(10, 2, 1, 2, 3);
        Polynomial p2 = p1.scalePolynomial(10);
        assertEquals(p2.toString(), "100x^4 + 20x^3 + 10x^2 + 20x^1 + 30");
        Polynomial p3 = p2.scalePolynomial(2);
        assertEquals(p3.toString(), "200x^4 + 40x^3 + 20x^2 + 40x^1 + 60");
    }
    
    @Test
    public void multiplyingPolynomialWorks1() {
        Polynomial p1 = new Polynomial(2, 7, 4);
        Polynomial p2 = new Polynomial(2, 1, 7, 6, 9);
        
        Polynomial p3 = p1.times(p2);
        
        assertEquals(p3.getCoefficients()[0], 36);
    }
    
    @Test
    public void exponentiatingPolynomialWorks1() {
        Polynomial p1 = new Polynomial(2, 1, 5);
        Polynomial p2 = p1.exponentiation(3);
        assertEquals(p2.getCoefficients()[4], 66);
        
    }
}
