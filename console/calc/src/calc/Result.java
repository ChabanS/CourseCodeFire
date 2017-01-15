/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

/**
 *
 * @author Sergey
 */
public class Result {

    private double a, b;
    private String mathSymbol;

    double getResult() {
        double result;
        if (mathSymbol.equals("+")) {
            result = a + b;
        } else if (mathSymbol.equals("-")) {
            result = a - b;
        } else if (mathSymbol.equals("*")) {
            result = a * b;
        } else {
            result = a / b;
        }
        return result;
    }

    /**
     * @param a the a to set
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * @param b the b to set
     */
    public void setB(double b) {
        this.b = b;
    }

    /**
     * @param mathSymbol the mathSymbol to set
     */
    public void setMathSymbol(String mathSymbol) {
        this.mathSymbol = mathSymbol;
    }
}
