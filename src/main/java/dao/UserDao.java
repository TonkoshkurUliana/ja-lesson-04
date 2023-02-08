package dao;


import domain.User;
import shared.AbstractCRUD;

import java.sql.SQLException;


public interface UserDao extends AbstractCRUD<User> {
    User getByUseremail(String userEmail) throws SQLException;
    User getByUserPassword(String userEmail) throws SQLException;
    }

