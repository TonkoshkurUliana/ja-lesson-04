package dao.impl;

import dao.MagazineDao;
import domain.Magazine;
import connection.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MagazineDaoImpl implements MagazineDao {
    private static String READ_ALL = "select * from magazine";
    private static String CREATE = "insert into magazine(`name`,`information`, `price`) values (?,?,?)";
    private static String READ_BY_ID = "select * from magazine where id =?";
    private static String UPDATE_BY_ID = "update magazine set name=?, information = ?, price = ?";
    private static String DELETE_BY_ID = "delete from magazine where id=?";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public MagazineDaoImpl() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        connection = ConnectionUtils.openConnection();
    }

    @Override
    public Magazine create(Magazine magazine) {
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, magazine.getName());
            preparedStatement.setString(2, magazine.getInformation());
            preparedStatement.setDouble(3, magazine.getPrice());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            magazine.setId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }

       return magazine;
    }

    @Override
    public Magazine read(Integer id) {
        Magazine magazine = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();

            Integer magazineId = result.getInt("id");
            String name = result.getString("name");
            String information = result.getString("information");
            Double price = result.getDouble("price");

            magazine = new Magazine(magazineId, name, information, price);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return magazine;
    }

    @Override
    public Magazine update(Magazine magazine) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, magazine.getName());
            preparedStatement.setString(2, magazine.getInformation());
            preparedStatement.setDouble(3, magazine.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return magazine;

    }

    @Override
    public void delete(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Magazine> readAll() {
        List<Magazine> magazineRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Integer id = result.getInt("id");
                String name = result.getString("name");
                String information = result.getString("information");
                Double price = result.getDouble("price");

                magazineRecords.add(new Magazine(id, name, information, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return magazineRecords;
    }
}

