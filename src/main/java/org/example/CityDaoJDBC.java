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
        Connection connection = MySQLConnection.connect();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select name,id from city where id = " + id);
            while (result.next()) {
                System.out.println("Finding by id : " + result.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return city;
    }

    @Override
    public List<City> findByCode(String code) {
        List<City> list = new ArrayList<>();
        String query = "select * from city where countryCode=?";

        try (
                PreparedStatement preparedStatement = MySQLConnection.connect().prepareStatement(query)
        ) {
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new City(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                ));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    @Override
    public List<City> findByName(String name) {
        List<City> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = MySQLConnection.connect().prepareStatement("select * from city where name=?")) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new City(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public List<City> findAll() {
      List<City> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = MySQLConnection.connect().prepareStatement("select * from city")){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                    list.add(new City(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5)));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public City add(City city) {

        try (            PreparedStatement preparedStatement = MySQLConnection.connect().prepareStatement("Insert into city (Name , countrycode , District ,Population) values (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        ){
            preparedStatement.setString(1,city.getName());
            preparedStatement.setString(2,city.getCountryCode());
            preparedStatement.setString(3,city.getDistrict());
            preparedStatement.setInt(4,city.getPopulation());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            int key = 0;
            while(resultSet.next()){
                key = resultSet.getInt(1);

            }
            city.setId(key);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return city;
    }

    @Override
    public City update(City city) {
        System.out.println("Updating");

        String query = "UPDATE city SET `Name` = '" +city.getName()+
                "', CountryCode = '" +city.getCountryCode()+
                "', District = '" +city.getDistrict()+
                "', Population =" + city.getPopulation()+
                " where id = "+city.getId();


        City city2 = new City();

        try(
                PreparedStatement preparedStatement = MySQLConnection.connect().prepareStatement(query)
        ) {
            preparedStatement.executeUpdate(query);
            city2 = city;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return city2;
    }

    @Override
    public int delete(City city) {
        int output= 0;
        try ( PreparedStatement preparedStatement = MySQLConnection.connect().prepareStatement("delete from city where id = ?"))
        {
            preparedStatement.setInt(1,city.getId());
           output = preparedStatement.executeUpdate();
            System.out.println(output);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }
}
