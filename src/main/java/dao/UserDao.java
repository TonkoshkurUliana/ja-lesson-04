package dao;

import mapper.UserMapper;
import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class UserDao {
        private static String READ_ALL = "select * from users";
        private static String CREATE = "insert into users (login,firstname,lastname,email,password) values (?,?,?,?,?)";
        private Connection connection;
        private PreparedStatement preparedStatement;

        public UserDao(Connection connection) {
            this.connection = connection;
        }

        public void insert(User user) throws SQLException {
            preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setString(1, user.getUserLogin());
            preparedStatement.setString(2, user.getUserFirstName());
            preparedStatement.setString(3, user.getUserLastName());
            preparedStatement.setString(4, user.getUserEmail());
            preparedStatement.setString(5, user.getUserPassword());
            preparedStatement.executeUpdate();
        }

        public  List<User> readAll() throws SQLException {
            List<User> listOfUser = new ArrayList<>();
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                listOfUser.add(UserMapper.map(result));
            }
            return listOfUser;
        }
    }

