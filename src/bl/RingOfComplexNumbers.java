/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

/**
 *
 * @author USER
 */
public class RingOfComplexNumbers implements EuclideanDomain {

    Double[][] denomenator = new Double[2][2];
    Double[][] numerator = new Double[2][2];
    
    public Double[][] sum(Double[][] a, Double[][] b) {
       Double[][] c = new Double[2][2];
       c[0][0] =  a[0][0] + b[0][0];
       c[0][1] = a[0][1] + b[0][1];
       c[1][0] = 0.0;
       c[1][1] = 1.0;
       return c;
    }

    public Double[][] subtract(Double[][] a, Double[][] b) {
        Double[][] c = new Double[2][2];
        c[0][0] =  a[0][0] - b[0][0];
        c[0][1] = a[0][1] - b[0][1];
        c[1][0] = 0.0;
        c[1][1] = 1.0;
        return c;
    }

    public Double[][] multiply(Double[][] a, Double[][] b) {
        Double[][]result = new Double[2][2];
        result[0][0] = a[0][0]*b[0][0] + (-a[0][1]*b[0][1]);
        result[0][1] = a[0][0]*b[0][1] + a[0][1]*b[0][0];
        result[1][0] = 0.0;
        result[1][1] = 1.0;
        return result;
    }

    public Double[][] divide(Double[][] a, Double[][] b) {
        Double[][] num = new Double[2][2];
        numerator = multiply(a,conjugate(b));        
        denomenator = multiply(b,conjugate(b));
        num[0][0] = numerator[0][0]/denomenator[0][0];
        num[0][1] = numerator[0][1]/denomenator[0][0];
        num[0][0] = num[0][0]>0 ? Math.floor(num[0][0]) : Math.ceil(num[0][0]);
        num[0][1] = num[0][1]>0 ? Math.floor(num[0][1]) : Math.ceil(num[0][1]);
        num[1][0] = 0.0;
        num[1][1] = 1.0;
        return num;
    }

    public Double[][] remainder(Double[][] a, Double[][] b) {
        Double[][] quotient = divide(a,b);
        Double[][] remainder = subtract(numerator, multiply(quotient, denomenator));
        return remainder;
    }

    private Double[][] conjugate(Double[][] a){
        Double [][] res = new Double[2][2];
        res[0][0] = a[0][0];
        res[0][1] = -a[0][1];
        res[1][0] = a[1][0];
        res[1][1] = a[1][1];
        return res;
    }
}