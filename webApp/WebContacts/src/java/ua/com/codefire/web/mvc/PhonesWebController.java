/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.web.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.codefire.controllers.PhonesController;
import ua.com.codefire.controllers.PhonesControllerImpl;

/**
 *
 * @author codefire
 */
@WebServlet("/list")
public class PhonesWebController extends HttpServlet {

    private PhonesController controller;

    @Override
    public void init() throws ServletException {
        controller = new PhonesControllerImpl(getServletContext().getRealPath("/WEB-INF/database.db"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", controller.getAllContacts());
        request.getRequestDispatcher("WEB-INF/views/list.jsp").forward(request, response);
    }

}
