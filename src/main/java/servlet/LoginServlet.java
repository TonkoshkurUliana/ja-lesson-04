package servlet;

import domain.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.UserService;
import service.impl.UserServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "login", value = "/login")

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");


        User user = null;
        try {
            UserService userService = UserServiceImpl.getUserServiceImpl();
            user = userService.getbyUserEmail(email);
            System.out.println(user);
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println(user);
            throw new RuntimeException(e);
        }
        System.out.println(user);
        if (user == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        assert user != null;
        if (user.getUserPassword().equals(password)) {
            request.setAttribute("userEmail", email);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
