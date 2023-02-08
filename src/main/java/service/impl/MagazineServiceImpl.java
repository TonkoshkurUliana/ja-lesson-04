package service.impl;

import dao.MagazineDao;
import dao.UserDao;
import dao.impl.MagazineDaoImpl;
import dao.impl.UserDaoImpl;
import domain.Magazine;
import service.MagazineService;

import java.sql.SQLException;
import java.util.List;

public class MagazineServiceImpl implements MagazineService {
    private MagazineDao magazineDao;

    public MagazineServiceImpl() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        magazineDao = new MagazineDaoImpl();
    }

    @Override
    public Magazine create(Magazine magazine) {
        return magazineDao.create(magazine);
    }

    @Override
    public Magazine read(Integer id) {
        return magazineDao.read(id);
    }

    @Override
    public Magazine update(Magazine magazine) {
        return magazineDao.update(magazine);
    }

    @Override
    public void delete(Integer id) {
         magazineDao.delete(id);
    }

    @Override
    public List<Magazine> readAll() {
        return magazineDao.readAll();
    }
}
