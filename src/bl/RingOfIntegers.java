/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

/**
 *
 * @author USER
 */
public class RingOfIntegers implements EuclideanDomain {
    
    public Double[][] sum(Double[][] a, Double[][] b) {
        Double[][] r = new Double[2][1];
        r[0][0] = a[0][0]+b[0][0];
        r[1][0] = 0.0;
        return r;
    }

    public Double[][] subtract(Double[][] a, Double[][] b) {
        Double[][] r = new Double[2][1];
        r[0][0] = a[0][0]-b[0][0];
        r[1][0] = 0.0;
        return r;
    }

    public Double[][] multiply(Double[][] a, Double[][] b) {
        Double[][] r = new Double[2][1];
        r[0][0] = a[0][0]*b[0][0];
        r[1][0] = 0.0;
        return r;
    }

    public Double[][] divide(Double[][] a, Double[][] b) {
        Double[][] r = new Double[2][1];
        r[0][0] = a[0][0]/b[0][0];
        r[0][0] = Math.floor(r[0][0]);
        r[1][0] = 0.0;
        return r;
    }

    public Double[][] remainder(Double[][] a, Double[][] b) {
        Double[][] remainder = new Double[2][1];
        Double[][] r = new Double[2][1];
        r[0][0] = Math.floor(a[0][0]/b[0][0]);
        remainder = subtract(a, multiply(b,r));
        remainder[1][0] = 0.0;
        return remainder;
    }
}
