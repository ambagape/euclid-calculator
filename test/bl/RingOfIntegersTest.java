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
public class RingOfIntegersTest {

    public RingOfIntegersTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of sum method, of class RingOfIntegers.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        Double[][] a = new Double[2][1];
        Double[][] b = new Double[2][1];
        a[0][0] = 2.0;
        a[1][0] = 10.0;
        b[0][0] = 3.0;
        b[1][0] = 5.0;
        RingOfIntegers instance = new RingOfIntegers();
        Double[][] expResult = new Double[2][1];
        expResult[0][0] = 5.0;
        expResult[1][0] = 0.0;
        Double[][] result = instance.sum(a, b);
        assertEquals(expResult, result);       
    }

    /**
     * Test of subtract method, of class RingOfIntegers.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");

        Double[][] a = new Double[2][1];
        Double[][] b = new Double[2][1];
        a[0][0] = 2.0;
        a[1][0] = 10.0;
        b[0][0] = 3.0;
        b[1][0] = 5.0;
        RingOfIntegers instance = new RingOfIntegers();
        Double[][] expResult = new Double[2][1];
        expResult[0][0] = -1.0;
        expResult[1][0] = 0.0;
        Double[][] result = instance.subtract(a, b);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of multiply method, of class RingOfIntegers.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        
        Double[][] a = new Double[2][1];
        Double[][] b = new Double[2][1];
        a[0][0] = 2.0;
        a[1][0] = 10.0;
        b[0][0] = 3.0;
        b[1][0] = 5.0;
        RingOfIntegers instance = new RingOfIntegers();
        Double[][] expResult = new Double[2][1];
        expResult[0][0] = 6.0;
        expResult[1][0] = 0.0;
        Double[][] result = instance.multiply(a, b);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of divide method, of class RingOfIntegers.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        
        Double[][] a = new Double[2][1];
        Double[][] b = new Double[2][1];
        a[0][0] = 6.0;
        a[1][0] = 10.0;
        b[0][0] = 3.0;
        b[1][0] = 5.0;
        RingOfIntegers instance = new RingOfIntegers();
        Double[][] expResult = new Double[2][1];
        expResult[0][0] = 2.0;
        expResult[1][0] = 0.0;
        Double[][] result = instance.divide(a, b);
        assertEquals(expResult, result);

        a[0][0] = 5.0;
        a[1][0] = 10.0;
        b[0][0] = 3.0;
        b[1][0] = 5.0;
        expResult[0][0] = 1.0;
        expResult[1][0] = 0.0;
        result = instance.divide(a, b);
        assertEquals(expResult, result);       
    }

    /**
     * Test of remainder method, of class RingOfIntegers.
     */
    @Test
    public void testRemainder() {
        System.out.println("remainder");
        Double[][] a = new Double[2][1];
        Double[][] b = new Double[2][1];
        a[0][0] = 5.0;
        a[1][0] = 10.0;
        b[0][0] = 3.0;
        b[1][0] = 5.0;
        RingOfIntegers instance = new RingOfIntegers();
        Double[][] expResult = new Double[2][1];
        expResult[0][0] = 2.0;
        expResult[1][0] = 0.0;
        Double[][] result = instance.remainder(a, b);
        assertEquals(expResult, result);
        
    }

}