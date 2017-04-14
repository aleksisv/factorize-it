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
    public void degreeWorks1() {
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

        Polynomial p3 = p1.multiply(p2);

        assertEquals(p3.getCoefficients()[0], 36);
    }

    @Test
    public void exponentiatingPolynomialWorks1() {
        Polynomial p1 = new Polynomial(2, 1, 5);
        Polynomial p2 = p1.exponentiation(3);
        assertEquals(p2.getCoefficients()[4], 66);

    }

    @Test
    public void evaluationWorks1() {
        Polynomial p1 = new Polynomial(20, -3, 2, 3);
        assertEquals(p1.evaluateAtX(3), 522);
    }

    @Test
    public void shiftRightWorks1() {
        Polynomial p1 = new Polynomial(20, -3, 2, 3);
        Polynomial p2 = p1.shiftRight(1);
        assertEquals(p2.getCoefficients()[0], 0);
        assertEquals(p2.getCoefficients()[1], 3);
    }

    @Test
    public void copyThisPolyWorks1() {
        Polynomial p1 = new Polynomial(20, -3, 2, 3, 0, 0, 3);
        Polynomial p2 = p1.copyThisPoly();
        for (int i = 0; i < p1.getDegree(); i++) {
            assertEquals(p1.getCoefficients()[i], p2.getCoefficients()[i]);
        }
    }
    
    @Test
    public void longDivisionWorks1() {
        Polynomial p1 = new Polynomial(1, 30, 375, 2500, 9375, 18750, 15625);
        Polynomial p2 = new Polynomial(1, 5);
        Polynomial q = p1.longDivision(p2);
        
        long[] rightCoefs = {3125, 3125, 1250, 250, 25, 1};
        for (int i = 0; i < q.getCoefficients().length; i++) {
            assertEquals(q.getCoefficients()[i], rightCoefs[i]);
        }
    }
    
    @Test
    public void polyEqualsWorks1() {
        assertTrue(new Polynomial(1, 1).polyEquals(new Polynomial(0, 1, 1)));
        assertTrue(new Polynomial(2, 0, 5).polyEquals(new Polynomial(2, 0, 5)));
        assertFalse(new Polynomial(2, 2, 2).polyEquals(new Polynomial(1, 1, 1)));
        assertTrue(new Polynomial(0, 0, 2, 0).polyEquals(new Polynomial(2, 0)));
    }
    
    @Test
    public void modWorks1() {
        Polynomial p1 = new Polynomial(3, 33, 2, 0);
        Polynomial res1 = p1.mod(3);
        Polynomial c1 = new Polynomial(0, 0, 2, 0);
        System.out.println(res1);
        System.out.println(c1);
        assertTrue(res1.polyEquals(c1));
    }
}
