package mapper;

import domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
    public static User map(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String login = result.getString("login");
        String firstName = result.getString("firstName");
        String  lastName = result.getString("lastName");
        String email = result.getString("email");
        String password = result.getString("password");

        return new User( login, firstName, lastName, email, password);
    }
}
