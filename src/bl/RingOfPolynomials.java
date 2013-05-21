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
public class RingOfPolynomials implements EuclideanDomain {

    public Double[][] sum(Double[][] a, Double[][] b) {
        Double[][] ans = new Double[2][a[0].length+b[0].length];
        boolean flag = false;
        for(int i=0; i<a[0].length; i++){
            ans[0][i] = a[0][i];
            ans[1][i] = a[1][i];
        }
        if(a[0].length < b[0].length){
            Double[][] t = a;
            a = b;
            b = t;
        }
        for(int i=0;i<b[0].length; i++){
            for(int j=0;j < a[0].length; j++){
                if(a[1][j].doubleValue() == b[1][i].doubleValue()){
                    ans[0][j] += b[0][i];
                    flag = true;
                }                
            }
            if(!flag){
                ans[0][a[0].length+i] = b[0][i];
                ans[1][a[1].length+i] = b[1][i];
            }
            flag = false;
        }
        return ArrayVerifier.removeZeroCoefs(ans);
    }

    public Double[][] subtract(Double[][] a, Double[][] b) {
        Double[][] ans = new Double[2][a[0].length+b[0].length];
        boolean flag = false;
        for(int i=0; i<a[0].length; i++){
            ans[0][i] = a[0][i];
            ans[1][i] = a[1][i];
        }
        if(a[0].length < b[0].length){
            Double[][] t = a;
            a = b;
            b = t;
        }
        for(int i=0;i<b[0].length; i++){
            for(int j=0;j < a[0].length; j++){
                if(a[1][j].doubleValue() == b[1][i].doubleValue()){
                    ans[0][j] -= b[0][i];
                    flag = true;
                }
            }
            if(!flag){
                ans[0][a[0].length+i] = -b[0][i];
                ans[1][a[1].length+i] = b[1][i];
            }
            flag = false;
        }
        
        
        return ArrayVerifier.removeZeroCoefs(ans);
    }

    public Double[][] multiply(Double[][] a, Double[][] b) {
        Double[][] result = new Double[2][a[0].length*b[0].length];
        
        List<Double> coef = new ArrayList();
        List<Double> powers = new ArrayList();
        if(a[0].length < b[0].length){
            Double[][] t = a;
            a = b;
            b = t;
        }            
        
        //Multiplying the polynomials     

        int k = 0;
        for(int i=0;i<a[0].length; i++){
            for(int j=0;j < b[0].length; j++){                
                result[0][k] = a[0][i] * b[0][j];
                result[1][k] = a[1][i] + b[1][j];
                k++;
            }
        }

        //Collecting like terms
        double cum = 0;
comparing:
        for(int i=0;i<result[0].length;i++){
            cum = result[0][i];            
            for(int j=0; j<result[0].length; j++){
                if(result[1][i].doubleValue()==result[1][j].doubleValue() && i!=j){
                    if(powers.contains(result[1][i]))
                        continue comparing;
                    cum += result[0][j];
                    
                }
            }            
            coef.add(cum);
            powers.add(result[1][i]);
            
        }
        if(coef.size()!=powers.size())
            throw new java.lang.IllegalStateException("The list of coefficients does not correspond with the size of unknowns");
        Double[][] finalResult = new Double[2][coef.size()];
        for(int m=0;m<finalResult[0].length;m++){
            finalResult[0][m] = coef.get(m);
            finalResult[1][m] = powers.get(m);
        }
        return ArrayVerifier.removeZeroCoefs(finalResult);
    }

    public Double[][] divide(Double[][] a, Double[][] b) {
       if(a[0].length < b[0].length){
            Double[][] t = a;
            a = b;
            b = t;
        }
       Double[][] res = new Double[2][a[0].length];
       Double[][] tem = new Double[2][a[0].length];
       Double[][] quo = new Double[2][1];
       
       int i = 0;
       while(b[1][0]<= a[1][0]){
           quo[0][0] = a[0][0] / b[0][0];
           quo[1][0] = a[1][0] - b[1][0];
           res[0][i] = quo[0][0];
           res[1][i] = quo[1][0];
           tem = multiply(quo, b);
           a = subtract(a,tem);
           i++;    
       }       
       return ArrayVerifier.removeZeroCoefs(res);
    }

    public Double[][] remainder(Double[][] a, Double[][] b) {
        Double []aCopy[] = new Double[2][a[0].length];
        int i = 0;
        for(double val: a[0]){
            aCopy[0][i] = val;
            i++;
        }
        i = 0;
        for(double val: a[1]){
            aCopy[1][i] = val;
            i++;
        }
        Double[][] result = divide(a,b);
        Double[][] product = multiply(result,b);
        Double[][] remainder = subtract(aCopy,product);
        return remainder;
    }
}
