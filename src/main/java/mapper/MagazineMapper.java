package Mapper;

import domain.Magazine;
import domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MagazineMapper {
    public static Magazine map(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String name = result.getString("name");
        String information = result.getString("information");
        Double price = result.getDouble("price");

        return new Magazine( id, name, information, price);
    }
}
