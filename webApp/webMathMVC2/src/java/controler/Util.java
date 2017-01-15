/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author Sergey
 */
public class Util {
     public boolean checkString(String string) {
        if (string == null || string.trim().isEmpty()) {
            return true;
        }
        try {
            //Integer.parseInt(string);
            Double.parseDouble(string);
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}
