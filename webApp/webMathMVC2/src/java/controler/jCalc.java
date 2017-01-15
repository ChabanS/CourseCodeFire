/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sergey
 */
@WebServlet("/calc")
public class jCalc extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/calcRedir.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Util util = new Util();
        String res;
        String firstString = request.getParameter("first");
        String secondString = request.getParameter("second");
        if (util.checkString(firstString)) {
            res = "Incorect first numbers -> "+firstString;
        } else {
            if (util.checkString(secondString)) {
                res = "Incorect second numbers!";
            } else {
                double first = Double.parseDouble(firstString);
                double second = Double.parseDouble(secondString);
                String operator = request.getParameter("operator");
                double result;
                if (operator.equals("+")) {
                    result = first + second;
                } else if (operator.equals("-")) {
                    result = first - second;
                } else if (operator.equals("*")) {
                    result = first * second;
                } else {
                    result = first / second;
                }
                res = first + " " + operator + " " + second + " = " + result;
            }
        }
        request.setAttribute("result", res);
        request.getRequestDispatcher("WEB-INF/views/result.jsp").forward(request, response);
    }
}
