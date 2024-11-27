package javarush.web_guest_app_test.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import javarush.web_guest_app_test.ConnectionDriverManager;
import javarush.web_guest_app_test.dao.UserDAO;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/start")
public class StartServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (userDAO.authenticate(username, password)) {
            resp.sendRedirect("welcome.jsp");
        } else {
            resp.getWriter().write("Kaka.");
        }
    }
}

