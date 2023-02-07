package servlet;

import domain.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.UserService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "registration", value = "/registration")

public class RegistrationServlet extends HttpServlet {
    private UserService userService = UserService.getUserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String login = request.getParameter("login");

        userService.saveUser(new User(login, firstName, lastName, email, password));
        request.setAttribute("userEmail", login);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}
