/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.codefire.dao.DaoStubImpl;
import ua.com.codefire.dao.IDao;

/**
 *
 * @author CodeFire
 */
@WebServlet("/route")
public class RouteServlet extends HttpServlet{
    
    private final IDao dao = new DaoStubImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("page");
        if(path == null || path.trim().isEmpty()) {
            path = "index";
        }
        request.setAttribute("data", dao.getPageByNameOld(path));
        request.setAttribute("dataDB", dao.getPageByName(path));
        
        request.getRequestDispatcher("WEB-INF/views/page.jsp").forward(request, response);
    }
    
}
