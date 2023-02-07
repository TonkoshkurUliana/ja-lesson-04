package Dao;

import Mapper.MagazineMapper;
import domain.Magazine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagazineDao {
    private static String READ_ALL = "select * from magazine";
    private static String CREATE = "insert into magazine (name,information,price) values (?,?,?)";
    private Connection connection;
    private PreparedStatement preparedStatement;

    public MagazineDao(Connection connection) {
        this.connection = connection;
    }

    public void insert(Magazine magazine) throws SQLException {
        preparedStatement = connection.prepareStatement(CREATE);
        preparedStatement.setString(1, magazine.getName());
        preparedStatement.setString(2, magazine.getInformation());
        preparedStatement.setDouble(3, magazine.getPrice());
        preparedStatement.executeUpdate();
    }

    public  List<Magazine> readAll() throws SQLException {
        List<Magazine> listOfMagazine = new ArrayList<>();
        preparedStatement = connection.prepareStatement(READ_ALL);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            listOfMagazine.add(MagazineMapper.map(result));
        }
        return listOfMagazine;
    }
}

