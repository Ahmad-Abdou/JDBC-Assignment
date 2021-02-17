package org.example;

import org.example.dao.CityDao;
import org.example.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoJDBC implements CityDao {


    @Override
    public City findById(int id) {
        City city = new City();
        Connection connection = mySqlConnection();
        String query = "select id,name from city where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " - " + resultSet.getString("name"));
            } else {
                System.out.println(" No data ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return city;
    }

    @Override
    public List<City> findByCode(String code) {
        List<City> list = new ArrayList<>();
        Connection connection = mySqlConnection();
       String query = "select id,name,countryCode from city where countryCode = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,code);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String countryCode = resultSet.getString("countryCode");
                list.add(new City(id,name,countryCode));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
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
