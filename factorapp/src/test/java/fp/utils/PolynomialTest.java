/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aleksisvuoksenmaa
 */
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
