package servlet;

import domain.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.UserService;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserService userService = UserService.getUserService();
        User user = userService.getUser(login);

        if (user == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        assert user != null;
        if (user.getUserPassword().equals(password)) {
            request.setAttribute("userEmail", login);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
