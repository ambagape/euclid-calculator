/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

/**
 *
 * @author USER
 */
public interface EuclideanDomain {
    Double[][] sum(Double[][] a, Double[][] b);
    Double[][] subtract(Double[][] a, Double[][] b);

    Double[][] multiply(Double[][] a, Double[][] b);

    Double[][] divide(Double[][] a, Double[][] b);
    Double[][] remainder(Double[][] a, Double[][] b);
}
