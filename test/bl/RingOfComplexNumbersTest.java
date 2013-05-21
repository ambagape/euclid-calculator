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
 * @author ICT-DOCUWARE 1
 */
public class RingOfComplexNumbersTest {

    Double[][] a = new Double[2][2];
    Double[][] b = new Double[2][2];
    
    public RingOfComplexNumbersTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        b[0][0] = 3.0;
        b[1][0] = 0.0;
        b[0][1] = 5.0;
        b[1][1] = 1.0;

        a[0][0] = 6.0;
        a[1][0] = 0.0;
        a[0][1] = 3.0;
        a[1][1] = 1.0;
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sum method, of class RingOfComplexNumbers.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
       
        RingOfComplexNumbers instance = new RingOfComplexNumbers();
        Double[][] expResult = new Double[2][2];
        expResult[0][0] = 9.0;
        expResult[1][0] = 0.0;
        expResult[0][1] = 8.0;
        expResult[1][1] = 1.0;
        Double[][] result = instance.sum(b, a);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of subtract method, of class RingOfComplexNumbers.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        RingOfComplexNumbers instance = new RingOfComplexNumbers();
        Double[][] expResult = new Double[2][2];
        expResult[0][0] = -3.0;
        expResult[1][0] = 0.0;
        expResult[0][1] = 2.0;
        expResult[1][1] = 1.0;
        Double[][] result = instance.subtract(b, a);
        assertEquals(expResult, result);
    }

    /**
     * Test of multiply method, of class RingOfComplexNumbers.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
       RingOfComplexNumbers instance = new RingOfComplexNumbers();
        Double[][] expResult = new Double[2][2];
        expResult[0][0] = 3.0;
        expResult[1][0] = 0.0;
        expResult[0][1] = 39.0;
        expResult[1][1] = 1.0;
        Double[][] result = instance.multiply(a, b);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of divide method, of class RingOfComplexNumbers.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        b[0][0] = 3.0;
        b[1][0] = 0.0;
        b[0][1] = 5.0;
        b[1][1] = 1.0;

        a[0][0] = 15.0;
        a[1][0] = 0.0;
        a[0][1] = 10.0;
        a[1][1] = 1.0;
        RingOfComplexNumbers instance = new RingOfComplexNumbers();
        Double[][] expResult = new Double[2][2];
        expResult[0][0] = (2.0);
        expResult[1][0] = 0.0;
        expResult[0][1] = -(1.0);
        expResult[1][1] = 1.0;
        Double[][] result = instance.divide(a, b);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of remainder method, of class RingOfComplexNumbers.
     */
    @Test
    public void testRemainder() {
        System.out.println("remainder");
        b[0][0] = 3.0;
        b[1][0] = 0.0;
        b[0][1] = 5.0;
        b[1][1] = 1.0;

        a[0][0] = 15.0;
        a[1][0] = 0.0;
        a[0][1] = 10.0;
        a[1][1] = 1.0;
        RingOfComplexNumbers instance = new RingOfComplexNumbers();
        Double[][] expResult = {{27.0, -11.0},{0.0,1.0}};
        Double[][] result = instance.remainder(a, b);
        assertEquals(expResult, result);
        
    }

}