/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bl.util;

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
public class ArrayVerifierTest {

    public ArrayVerifierTest() {
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
     * Test of removeZeroCoefs method, of class ArrayVerifier.
     */
    @Test
    public void testRemoveZeroCoefs() {
        System.out.println("removeZeroCoefs");
        Double[][] a = {{0.0,0.0,0.0,0.0,0.0,0.0}, {5.0,4.0,3.0,2.0,1.0,0.0}};
        Double[][] b = {{0.0,0.0,3.0,0.0,2.0,0.0}, {5.0,4.0,3.0,2.0,1.0,0.0}};
        Double[][] c = {{5.0,6.0,3.0,0.0,0.0,0.0}, {5.0,4.0,3.0,2.0,1.0,0.0}};
        Double[][] d = {{5.0,6.0,3.0,null,null,null}, {5.0,4.0,3.0,null,null,null}};
        Double[][] aexpected = {{0.0}, {0.0}};
        Double[][] bexpected = {{3.0,2.0}, {3.0,1.0}};
        Double[][] cexpected = {{5.0,6.0,3.0}, {5.0,4.0,3.0}};
        Double[][] dexpected = {{5.0,6.0,3.0}, {5.0,4.0,3.0}};
        
        Double[][] aresult = ArrayVerifier.removeZeroCoefs(a);
        Double[][] bresult = ArrayVerifier.removeZeroCoefs(b);
        Double[][] cresult = ArrayVerifier.removeZeroCoefs(c);
        Double[][] dresult = ArrayVerifier.removeZeroCoefs(d);
        assertEquals(aexpected, aresult);
        assertEquals(bexpected, bresult);
        assertEquals(cexpected, cresult);
        assertEquals(dexpected, dresult);
        
    }

}