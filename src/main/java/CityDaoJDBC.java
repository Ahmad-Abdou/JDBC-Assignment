import org.example.dao.CityDao;
import org.example.model.City;

import java.sql.*;
import java.util.List;

public class CityDaoJDBC implements CityDao {


    @Override
    public City findById(int id) {

        return null;
    }

    @Override
    public List<City> findByCode(String code) {
        return null;
    }

    @Override
    public List<City> findByName(String name) {
        return null;
    }

    @Override
    public List<City> findAll() {

        return null;
    }

    @Override
    public City add(City city) {
        return null;
    }

    @Override
    public City update(City city) {
        return null;
    }

    @Override
    public int delete(City city) {
        return 0;
    }

    public static Connection mySqlConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
