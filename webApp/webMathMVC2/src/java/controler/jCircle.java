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
@WebServlet("/circle")
public class jCircle extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Util util = new Util();
        String radius = request.getParameter("radius");
        String res;
        if (util.checkString(radius)) {
            res = "Incorect radius -> " + radius;
        } else{
        double radiusDouble = Double.parseDouble(radius);
        double result = Math.PI * (radiusDouble * radiusDouble);
        res = "Area of a circle with radius " + radius + " = " + result;
        }
        request.setAttribute("result", res);
        request.getRequestDispatcher("WEB-INF/views/result.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/circleRedir.jsp").forward(request, response);
    }

}
