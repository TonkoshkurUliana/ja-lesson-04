package servlet;

import domain.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.UserService;
import service.impl.UserServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "registration", value = "/registration")

public class RegistrationServlet extends HttpServlet {
    private UserService userService = UserServiceImpl.getUserServiceImpl();

    public RegistrationServlet() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    }

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
        String role = "user";
        userService.create(new User(email, firstName, lastName, password,role));

        request.setAttribute("userEmail", role);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}
