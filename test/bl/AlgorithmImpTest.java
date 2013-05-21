/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import java.util.ArrayList;
import java.util.List;
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
public class AlgorithmImpTest {

    public AlgorithmImpTest() {
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
     * Test of getGcd method, of class AlgorithmImp.
     */
    @Test
    public void testGetGcd() {
        System.out.println("getGcd");
        Double[][] a = new Double[2][1];
        Double[][] b = new Double[2][1];
        a[0][0] = 252.0;
        a[1][0] = 0.0;
        b[0][0] = 198.0;
        b[1][0] = 0.0;
        Algorithm instance = new AlgorithmImp(new RingOfIntegers(),a,b);
        Double[][] expResult = new Double[2][1];
        expResult[0][0] = 18.0;
        expResult[1][0] = 0.0;
        Double[][] result = instance.getGcd();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of othervalues method, of class AlgorithmImp.
     */
    @Test
    public void testOthervalues() {
        System.out.println("othervalues");
        Double[][] a = new Double[2][1];
        Double[][] b = new Double[2][1];
        a[0][0] = 252.0;
        a[1][0] = 0.0;
        b[0][0] = 198.0;
        b[1][0] = 0.0;
        Algorithm instance = new AlgorithmImp(new RingOfIntegers(),a,b);
        List<Double[][]> expResult = new ArrayList();
        Double[][] s = new Double[2][1];
        Double[][] t = new Double[2][1];
        s[0][0] = 4.0;
        s[1][0] = 0.0;
        t[0][0] = -5.0;
        t[1][0] = 0.0;
        expResult.add(s);
        expResult.add(t);
        List<Double[][]> result = instance.othervalues();
        assertEquals(expResult.get(0), result.get(0));
        assertEquals(expResult.get(1), result.get(1));        
    }
}