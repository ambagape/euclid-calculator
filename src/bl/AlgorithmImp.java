/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import bl.util.ArrayVerifier;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class AlgorithmImp implements Algorithm {
    EuclideanDomain ed;
    Double[][] dividend;
    Double[][] divisor;
    List<Double[][]> equation = new ArrayList();

    public AlgorithmImp(EuclideanDomain ed, Double[][] dividend, Double[][] divisor){
        this.ed = ed;
        this.dividend = dividend;
        this.divisor = divisor;
    }

    public Double[][] getGcd() {
        do{
            Double[][] temp = divisor;
            equation.add(ed.divide(dividend, divisor));
            divisor = ed.remainder(dividend,divisor);
            dividend = temp;            
        }while(!ArrayVerifier.isZero(divisor));
        return dividend;
    }

    public List<Double[][]> othervalues() {
        List<Double[][]> ans = new ArrayList();
        if(equation.isEmpty())
            getGcd();
        Double[][] s = new Double[2][dividend[0].length];
        Double[] t[] = new Double[2][dividend[0].length];
        Double temps[][] = new Double[2][dividend[0].length];
        Double[][] tempt = new Double[2][dividend[0].length];
        Double[][] temptemps = new Double[2][dividend[0].length];
        Double[][] temptempt = new Double[2][dividend[0].length];
        
        temps[0][0] = 1.0;
        temps = ArrayVerifier.removeZeroCoefs(temps);
        tempt[0][0] = 0.0;
        tempt = ArrayVerifier.removeZeroCoefs(tempt);
        s[0][0] = 0.0;
        s = ArrayVerifier.removeZeroCoefs(s);
        t[0][0] = 1.0;
        t = ArrayVerifier.removeZeroCoefs(t);
        for(int i = 0;i<equation.size()-1;i++){
            temptemps = s;
            temptempt = t;
            s = ed.subtract(temps,ed.multiply(s,equation.get(i)));
            t = ed.subtract(tempt, ed.multiply(t, equation.get(i)));
            temps = temptemps;
            tempt = temptempt;
        }
        ans.add(s);
        ans.add(t);
        return ans;
    }

}
