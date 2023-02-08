package dao.impl;

import dao.UserDao;
import domain.User;
import connection.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static String READ_ALL = "select * from users";
    private static String CREATE = "insert into users(`email`,`firstName`, `lastName`,`password`, `role`) values (?,?,?,?,?)";
    private static String READ_BY_ID = "select * from users where id =?";
    private static String UPDATE_BY_ID = "update users set email=?, firstName = ?, lastName = ?, role=?  where id = ?";
    private static String DELETE_BY_ID = "delete from users where id=?";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public UserDaoImpl() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        connection = ConnectionUtils.openConnection();
    }

        @Override
        public User create (User user){
            try {
                preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, user.getUserEmail());
                preparedStatement.setString(2, user.getUserFirstName());
                preparedStatement.setString(3, user.getUserLastName());
                preparedStatement.setString(4, user.getUserPassword());
                preparedStatement.setString(5, user.getUserRole());
                preparedStatement.executeUpdate();

                ResultSet rs = preparedStatement.getGeneratedKeys();
                rs.next();
                user.setUserId(rs.getInt(1));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return user;
        }

        @Override
        public User read (Integer id){
            User user = null;
            try {
                preparedStatement = connection.prepareStatement(READ_BY_ID);
                preparedStatement.setInt(1, id);
                ResultSet result = preparedStatement.executeQuery();
                result.next();

                Integer userId = result.getInt("id");
                String email = result.getString("email");
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                String password = result.getString("password");
                String role = result.getString("role");
                user = new User(userId, email, firstName, lastName, password, role);

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return user;
        }

        @Override
        public User update (User user){
            try {
                preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
                preparedStatement.setString(1, user.getUserEmail());
                preparedStatement.setString(2, user.getUserFirstName());
                preparedStatement.setString(3, user.getUserLastName());
                preparedStatement.setString(4, user.getUserRole());
                preparedStatement.setInt(5, user.getUserId());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return user;

        }

        @Override
        public void delete (Integer id){
            try {
                preparedStatement = connection.prepareStatement(DELETE_BY_ID);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public List<User> readAll () {
            List<User> userRecords = new ArrayList<>();
            try {
                preparedStatement = connection.prepareStatement(READ_ALL);
                ResultSet result = preparedStatement.executeQuery();
                while (result.next()) {
                    Integer userId = result.getInt("id");
                    String email = result.getString("email");
                    String firstName = result.getString("firstName");
                    String lastName = result.getString("lastName");
                    String password = result.getString("password");
                    String role = result.getString("role");
                    userRecords.add(new User(userId, email, firstName, lastName, password, role));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return userRecords;
        }

    @Override
    public User getByUseremail(String userEmail) throws SQLException {
        return null;
    }

    @Override
    public User getByUserPassword(String userEmail) throws SQLException {
        return null;
    }
}
