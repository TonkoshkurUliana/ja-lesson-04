package dao.impl;

import connection.ConnectionUtils;
import dao.BucketDao;
import domain.Bucket;
import domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BucketDaoImpl implements BucketDao {
    private static String READ_ALL = "select * from bucket";
    private static String CREATE = "insert into bucket(`userId`,`magazineId`, `purchaseDate`) values (?,?,?)";
    private static String READ_BY_ID = "select * from bucket where id =?";
    private static String UPDATE_BY_ID = "update bucket set userId=?, magazineId = ?, purchaseDate = ?";
    private static String DELETE_BY_ID = "delete from bucket where id=?";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public BucketDaoImpl() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        connection = ConnectionUtils.openConnection();
    }

    @Override
    public Bucket create(Bucket bucket) {
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, bucket.getUserId());
            preparedStatement.setInt(2, bucket.getProductId());
            preparedStatement.setDate(3, bucket.getPurchaseDate());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            bucket.setId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bucket;
    }

    @Override
    public Bucket read(Integer id) {
        Bucket bucket = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            result.next();

            Integer idBucket = result.getInt("id");
            Integer userId = result.getInt("userId");
            Integer productId = result.getInt("magazineId");
            Date purchaseDate = result.getDate("purchaseDate");


            bucket = new Bucket(idBucket, userId, productId, purchaseDate);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bucket;
    }

    @Override
    public Bucket update(Bucket bucket) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setInt(1, bucket.getUserId());
            preparedStatement.setInt(2, bucket.getProductId());
            preparedStatement.setDate(3, bucket.getPurchaseDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bucket;

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
    public List<Bucket> readAll() {
        List<Bucket> bucketRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Integer idBucket = result.getInt("id");
                Integer userId = result.getInt("userId");
                Integer productId = result.getInt("magazineId");
                Date purchaseDate = result.getDate("purchaseDate");

                bucketRecords.add(new Bucket(idBucket, userId, productId, purchaseDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bucketRecords;
    }
}
