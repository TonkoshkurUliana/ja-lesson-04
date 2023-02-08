package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private static UserService userServiceImpl;


    public UserServiceImpl() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        userDao = new UserDaoImpl();
        }
    public static UserService getUserServiceImpl() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        if(userServiceImpl==null) {
            userServiceImpl=new UserServiceImpl();
        }
        return userServiceImpl;
    }

    @Override
    public User create(User user) {
       return userDao.create(user);
    }

    @Override
    public User read(Integer id) {
        return userDao.read(id);
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public List<User> readAll() {
        return userDao.readAll();
    }

    @Override
    public User getbyUserEmail(String userEmail) throws SQLException {
        return userServiceImpl.getbyUserEmail(userEmail);
    }

    @Override
    public User getbyUserPassword(String password) throws SQLException {
        return userServiceImpl.getbyUserPassword(password);
    }
}
