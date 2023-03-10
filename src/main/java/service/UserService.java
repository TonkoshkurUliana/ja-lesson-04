package service;

import domain.User;
import shared.AbstractCRUD;
;import java.sql.SQLException;


public interface UserService extends AbstractCRUD<User> {
    User getbyUserEmail(String userEmail) throws SQLException;
    User getbyUserPassword(String password) throws SQLException;
}
