/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package omokaro;

import bl.Algorithm;
import bl.AlgorithmImp;
import bl.EuclideanDomain;
import bl.RingOfComplexNumbers;
import bl.RingOfIntegers;
import bl.RingOfPolynomials;
import java.util.List;
import javax.swing.JTextPane;

/**
 *
 * @author EDSG
 */
abstract public class InputHandler {
    protected InputHandler next;
    protected EuclideanDomain ed = null;
   
    protected String DEFAULT = "Input could not be understood";
    protected static StringBuilder sb = new StringBuilder();
    protected JTextPane inputBox = Frame.getInstance().getInputBox();
    
    abstract protected void handle(String string);

    public static StringBuilder getSB(){
        return sb;
    }

    static class PolyHandler extends InputHandler{
       
        public PolyHandler(InputHandler next){
            this.next = next;
        }

        @Override
        protected void handle(String string) {
            Double result[][] = null;
            List<Double[][]> list = null;
            
            try{
                String inside = string.substring(4,(string.length()-1));
                String[] spl = inside.split(",");              

                String[] holder = spl[0].split(" ");                

                Double[][] polyOne = new Double[2][holder.length];                
                for(int i=0; i<holder.length; i++){
                    polyOne[0][i] = Double.parseDouble(holder[i].split("x")[0]);
                    polyOne[1][i] = holder[i].split("x").length==1? 0: Double.parseDouble(holder[i].split("x")[1]);
                }
                
                holder = spl[1].split(" ");
                Double[][] polyTwo = new Double[2][holder.length];
                for(int i=0; i<holder.length; i++){
                    polyTwo[0][i] = Double.parseDouble(holder[i].split("x")[0]);
                    polyTwo[1][i] =  holder[i].split("x").length==1? 0: Double.parseDouble(holder[i].split("x")[1]);
                }
                if(polyOne[0].length<2&&polyTwo[0].length<2&&polyOne[1][0]==0&&polyTwo[1][0]==0)
                    throw new Exception("This is a set of Integers");

                String op = string.substring(0,3).intern();
                ed = new RingOfPolynomials();
                if(op=="sum"){
                    result = ed.sum(polyOne, polyTwo);
                    sb = new StringBuilder();
                    sb.append("(").append(formatPoly(polyOne)).append(") + (").append(formatPoly(polyTwo)).append(") = ").append(formatPoly(result));
                    return;
                }else if (op == "sub"){
                    result = ed.subtract(polyOne, polyTwo);
                    sb = new StringBuilder();
                    sb.append("(").append(formatPoly(polyOne)).append(") - (").append(formatPoly(polyTwo)).append(") = ").append(formatPoly(result));
                    return;
                } else if (op == "mul"){
                    result = ed.multiply(polyOne, polyTwo);
                    sb = new StringBuilder();
                    sb.append("(").append(formatPoly(polyOne)).append(")(").append(formatPoly(polyTwo)).append(") = ").append(formatPoly(result));
                    return;
                }else if(op=="div"){
                    result = ed.divide(polyOne, polyTwo);
                    sb = new StringBuilder();
                    sb.append("(").append(formatPoly(polyOne)).append(") / (").append(formatPoly(polyTwo)).append(") = ").append(formatPoly(result));
                    return;
                }else if(op=="rem"){
                    result = ed.remainder(polyOne, polyTwo);
                    sb = new StringBuilder();
                    sb.append("(").append(formatPoly(polyOne)).append(") % (").append(formatPoly(polyTwo)).append(") = ").append(formatPoly(result));
                    return;
                }else if(op=="gcd"){
                    Algorithm alg = new AlgorithmImp(ed,polyOne,polyTwo);
                    result = alg.getGcd();
                    list = alg.othervalues();                 
                    sb = new StringBuilder();
                    sb.append("((").append(formatPoly(polyOne)).append("), (").append(formatPoly(polyTwo)).append(")) = ").append(formatPoly(result));
                    sb.append("\n the required pair is: ").append(formatPoly(list.get(0))).append(" and ").append(formatPoly(list.get(1)));
                    return;
                }
                
            }catch(Exception e){
                System.out.println(e.getMessage());                
            }
            if(next==null)
                sb = new StringBuilder(DEFAULT);
            else
                next.handle(string);
        }

        private String formatPoly(Double[][] p){
            String poly =null;            
            for(int i=0;i<p[0].length;i++){
                if(poly==null){
                    poly = String.format("%dX^%d",p[0][i].intValue(),p[1][i].intValue());
                }else{
                    poly = String.format(poly+"%+dX^%d",p[0][i].intValue(),p[1][i].intValue());
                }
            }              
            return poly;
        }
    }
    
    static class IntegerHandler extends InputHandler{

        public IntegerHandler(InputHandler next){
            this.next = next;
        }

        @Override
        protected void handle(String string) {
            Double result[][] = null;
            List<Double[][]> list = null;
            try{
                String inside = string.substring(4,(string.length()-1));
                String[] spl = inside.split(",");
                if(spl.length==2){
                
                    Double[][] a = {{Double.parseDouble(spl[0])},{0.0}};
                    Double[][] b = {{Double.parseDouble(spl[1])},{0.0}};
                    
                    String op = string.substring(0,3).intern();
                    ed = new RingOfIntegers();
                    if(op=="sum"){                        
                        result = ed.sum(a, b);
                        sb = new StringBuilder();
                        sb.append("").append(a[0][0].intValue()).append(" + ").append(b[0][0].intValue()).append(" = ").append(result[0][0].intValue());
                        return;
                    } else if (op=="mul"){
                        result = ed.multiply(a, b);
                        sb = new StringBuilder();
                        sb.append("").append(a[0][0].intValue()).append(" x ").append(b[0][0].intValue()).append(" = ").append(result[0][0].intValue());
                        return;
                    } else if (op=="sub"){
                        result = ed.subtract(a, b);
                        sb = new StringBuilder();
                        sb.append("").append(a[0][0].intValue()).append(" - ").append(b[0][0].intValue()).append(" = ").append(result[0][0].intValue());
                        return;
                    } else if (op=="div"){
                        result = ed.divide(a, b);
                        sb = new StringBuilder();
                        sb.append("").append(a[0][0].intValue()).append(" / ").append(b[0][0].intValue()).append(" = ").append(result[0][0].intValue());
                        return;
                    } else if (op == "rem"){
                        result = ed.remainder(a, b);
                        sb = new StringBuilder();
                        sb.append("").append(a[0][0].intValue()).append(" % ").append(b[0][0].intValue()).append(" = ").append(result[0][0].intValue());
                        return;
                    } else if (op == "gcd") {
                        Algorithm alg = new AlgorithmImp(ed,a,b);
                        result = alg.getGcd();
                        list = alg.othervalues();
                        sb = new StringBuilder();
                        sb.append("(").append(a[0][0].intValue()).append(",").append(b[0][0].intValue()).append(") = ").append(result[0][0].intValue()).append('\n').append("\t The required pair is ").append(list.get(0)[0][0].intValue()).append(" and ").append(list.get(1)[0][0].intValue());
                        return;
                    }
                }               
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            if(next==null)
                sb = new StringBuilder(DEFAULT);
            else
                next.handle(string);
        }
    }

    static class CompHandler extends InputHandler{

        public CompHandler(InputHandler next){
            this.next = next;
        }


        @Override
        protected void handle(String string) {
            Double result[][] = null;
            List<Double[][]> list = null;

            try{
                String inside = string.substring(4,(string.length()-1));
                String[] spl = inside.split(",");

                String[] holder = spl[0].split("\\+|\\-");
                Double[][] comOne = new Double[2][2];
                comOne[0][0] = Double.parseDouble(holder[0]);
                comOne[1][0] = 0.0;
                comOne[0][1] = Double.parseDouble(""+holder[1].charAt(0));
                comOne[1][1] = 1.0;
                
                holder = spl[1].split("\\+|\\-");
                Double[][] comTwo = new Double[2][2];
                comTwo[0][0] = Double.parseDouble(holder[0]);
                comTwo[1][0] = 0.0;
                comTwo[0][1] = Double.parseDouble(""+holder[1].charAt(0));
                comTwo[1][1] = 1.0;
               
                String op = string.substring(0,3).intern();
                ed = new RingOfComplexNumbers();
                if(op=="sum"){
                    result = ed.sum(comOne, comTwo);                   
                    String s = String.format("(%d %+d"+"i) + (%d %+d"+"i) = %d %+d"+"i",comOne[0][0].intValue(),comOne[0][1].intValue(),comTwo[0][0].intValue(), comTwo[0][1].intValue(), result[0][0].intValue(),result[0][1].intValue());
                    sb = new StringBuilder(s);
                    return;
                }else if (op == "sub"){
                   result = ed.subtract(comOne, comTwo);
                    String s = String.format("(%d %+d"+"i) - (%d %+d"+"i) = %d %+d"+"i",comOne[0][0].intValue(),comOne[0][1].intValue(),comTwo[0][0].intValue(), comTwo[0][1].intValue(), result[0][0].intValue(),result[0][1].intValue());
                    sb = new StringBuilder(s);
                    return;
                } else if (op == "mul"){
                    result = ed.multiply(comOne, comTwo);
                    String s = String.format("(%d %+d"+"i) x (%d %+d"+"i) = %d %+d"+"i",comOne[0][0].intValue(),comOne[0][1].intValue(),comTwo[0][0].intValue(), comTwo[0][1].intValue(), result[0][0].intValue(),result[0][1].intValue());
                    sb = new StringBuilder(s);
                    return;
                }else if(op=="div"){
                    result = ed.divide(comOne, comTwo);
                    String s = String.format("(%d %+d"+"i) / (%d %+d"+"i) = %d %+d"+"i",comOne[0][0].intValue(),comOne[0][1].intValue(),comTwo[0][0].intValue(), comTwo[0][1].intValue(), result[0][0].intValue(),result[0][1].intValue());
                    sb = new StringBuilder(s);
                    return;
                } else if (op == "rem"){
                    result = ed.remainder(comOne, comTwo);
                    String s = String.format("(%d %+d"+"i) % (%d %+d"+"i) = %d %+d"+"i",comOne[0][0].intValue(),comOne[0][1].intValue(),comTwo[0][0].intValue(), comTwo[0][1].intValue(), result[0][0].intValue(),result[0][1].intValue());
                    sb = new StringBuilder(s);
                    return;
                } else if (op == "gcd") {
                    Algorithm alg = new AlgorithmImp(ed,comOne,comTwo);
                    result = alg.getGcd();
                    list = alg.othervalues();                    
                    String s = String.format("((%d %+d"+"i), (%d %+d"+"i)) = %d %+d"+"i \n \t The required pair is %d %+d"+"i and %d %+d"+"i",comOne[0][0].intValue(),comOne[0][1].intValue(),comTwo[0][0].intValue(), comTwo[0][1].intValue(), result[0][0].intValue(),result[0][1].intValue(),list.get(0)[0],list.get(0)[1],list.get(1)[0],list.get(1)[1]);
                    sb = new StringBuilder(s);
                    return;
                }

            }catch(Exception e){
                System.out.println(e.getMessage());
                
            }
            if(next==null)
                sb = new StringBuilder(DEFAULT);
            else
                next.handle(string);
        }
    }
}
