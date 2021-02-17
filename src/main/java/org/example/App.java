package org.example;

import org.example.model.City;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        City city = new City();
        CityDaoJDBC cd = new CityDaoJDBC();
        cd.findById(30);
        System.out.println("----------------------------------------------------------------");
       List<City>list = cd.findByCode("MOZ");
        list.forEach(System.out::println);
        System.out.println("----------------------------------------------------------------");
        List<City>list2 = cd.findByName("Amsterdam");
        list2.forEach(System.out::println);



    }
}
