/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bl.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class ArrayVerifier {
    
    public static boolean isZero(Double[][] a){
        for(double coef : a[0]){
            if(coef != 0.0)
                return false;
        }
        return true;
    }
    
     public static Double[][] removeZeroCoefs(Double[][] a){
        List<Double> coefs = new ArrayList<Double>();
        List<Double> powers = new ArrayList<Double>();

        for(int i = 0; i<a[0].length; i++){
            if( a[0][i]!=null){
                coefs.add(a[0][i]);
                powers.add(a[1][i]==null?0:a[1][i]);
            }
        }

       Double[][] res = new Double[2][coefs.size()];
       for(int ind=0;ind<coefs.size();ind++){
           res[0][ind] = coefs.get(ind);
           res[1][ind] = powers.get(ind);
       }
        if(isZero(res)){
            Double[][] b = new Double[2][1];
            b[0][0] = 0.0;
            b[1][0] = 0.0;
            return b;
        }
       coefs.clear();
       powers.clear();

        for(int i = 0; i<res[0].length; i++){
            
            if( res[0][i] != 0 ){
                coefs.add(res[0][i]);
                powers.add(res[1][i]);
            }
        }

       res = new Double[2][coefs.size()];
       for(int ind=0;ind<coefs.size();ind++){
           res[0][ind] = coefs.get(ind);
           res[1][ind] = powers.get(ind);
       }
        return res;
     }
}
