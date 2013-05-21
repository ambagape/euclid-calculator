/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USER
 */
public class RingOfPolynomialsTest {

    Double[][] a = null;
    Double[][] b = null;

    public RingOfPolynomialsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        a = new Double[2][5];
        b = new Double[2][2];
        a[0][0] = 2.0;
        a[1][0] = 4.0;
        a[0][1] = -1.0;
        a[1][1] = 3.0;
        a[0][2] = -8.0;
        a[1][2] = 2.0;
        a[0][3] = 1.0;
        a[1][3] = 1.0;
        a[0][4] = 6.0;
        a[1][4] = 0.0;
        b[0][0] = 1.0;
        b[1][0] = 1.0;
        b[0][1] = 1.0;
        b[1][1] = 0.0;
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sum method, of class RingOfPolynomials.
     */
    @Test
    public void testSum() {
        System.out.println("sum");       

        RingOfPolynomials instance = new RingOfPolynomials();
        Double[][] expResult = new Double[2][5];
        expResult[0][0] = 2.0;
        expResult[1][0] = 4.0;
        expResult[0][1] = -1.0;
        expResult[1][1] = 3.0;
        expResult[0][2] = -8.0;
        expResult[1][2] = 2.0;
        expResult[0][3] = 2.0;
        expResult[1][3] = 1.0;
        expResult[0][4] = 7.0;
        expResult[1][4] = 0.0;
        Double[][] result = instance.sum(a, b);
        assertEquals(expResult, result);

        a = new Double[2][4];
        b = new Double[2][2];
        a[0][0] = 2.0;
        a[1][0] = 4.0;
        a[0][1] = -1.0;
        a[1][1] = 3.0;
        a[0][2] = -8.0;
        a[1][2] = 2.0;
        a[0][3] = 1.0;
        a[1][3] = 1.0;

        b[0][0] = 1.0;
        b[1][0] = 1.0;
        b[0][1] = 1.0;
        b[1][1] = 0.0;

        expResult = new Double[2][5];
        expResult[0][0] = 2.0;
        expResult[1][0] = 4.0;
        expResult[0][1] = -1.0;
        expResult[1][1] = 3.0;
        expResult[0][2] = -8.0;
        expResult[1][2] = 2.0;
        expResult[0][3] = 2.0;
        expResult[1][3] = 1.0;
        expResult[0][4] = 1.0;
        expResult[1][4] = 0.0;
        result = instance.sum(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of subtract method, of class RingOfPolynomials.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        
        RingOfPolynomials instance = new RingOfPolynomials();
        Double[][] expResult = new Double[2][4];
        expResult[0][0] = 2.0;
        expResult[1][0] = 4.0;
        expResult[0][1] = -1.0;
        expResult[1][1] = 3.0;
        expResult[0][2] = -8.0;
        expResult[1][2] = 2.0;
        expResult[0][3] = 5.0;
        expResult[1][3] = 0.0;
        
        Double[][] result = instance.subtract(a, b);
        assertEquals(expResult, result);

        a = new Double[2][4];
        b = new Double[2][2];
        a[0][0] = 2.0;
        a[1][0] = 4.0;
        a[0][1] = -1.0;
        a[1][1] = 3.0;
        a[0][2] = -8.0;
        a[1][2] = 2.0;
        a[0][3] = 1.0;
        a[1][3] = 1.0;

        b[0][0] = 1.0;
        b[1][0] = 1.0;
        b[0][1] = 1.0;
        b[1][1] = 0.0;

        expResult = new Double[2][4];
        expResult[0][0] = 2.0;
        expResult[1][0] = 4.0;
        expResult[0][1] = -1.0;
        expResult[1][1] = 3.0;
        expResult[0][2] = -8.0;
        expResult[1][2] = 2.0;        
        expResult[0][3] = -1.0;
        expResult[1][3] = 0.0;
        result = instance.subtract(a, b);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of multiply method, of class RingOfPolynomials.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");        
        RingOfPolynomials instance = new RingOfPolynomials();
        Double[][] expResult = new Double[2][6];
        expResult[0][0] = 2.0;
        expResult[1][0] = 5.0;
        expResult[0][1] = 1.0;
        expResult[1][1] = 4.0;
        expResult[0][2] = -9.0;
        expResult[1][2] = 3.0;
        expResult[0][3] = -7.0;
        expResult[1][3] = 2.0;
        expResult[0][4] = 7.0;
        expResult[1][4] = 1.0;
        expResult[0][5] = 6.0;
        expResult[1][5] = 0.0;
        Double[][] result = instance.multiply(a, b);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of divide method, of class RingOfPolynomials.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        RingOfPolynomials instance = new RingOfPolynomials();
        Double[][] expResult = new Double[2][4];
        expResult[0][0] = 2.0;
        expResult[1][0] = 3.0;
        expResult[0][1] = -3.0;
        expResult[1][1] = 2.0;
        expResult[0][2] = -5.0;
        expResult[1][2] = 1.0;
        expResult[0][3] = 6.0;
        expResult[1][3] = 0.0;
        Double[][] result = instance.divide(a, b);
        assertEquals(expResult, result);        
    }

    /**
     * Test of remainder method, of class RingOfPolynomials.
     */
    @Test
    public void testRemainder() {
        System.out.println("remainder");
        
        RingOfPolynomials instance = new RingOfPolynomials();
        Double[][] expResult = new Double[2][1];
        expResult[0][0] = 0.0;
        expResult[1][0] = 0.0;
        Double[][] result = instance.remainder(a, b);
        assertEquals(expResult, result);
        
    }

}