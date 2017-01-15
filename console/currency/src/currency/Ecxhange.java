/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currency;

/**
 *
 * @author Sergey
 */
public class Ecxhange {
    private double usd;
    private double uah;
    double result;

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public void setUah(double uah) {
        this.uah = uah;
    }
    public double exchange(){
        return usd*uah;
    }
}
