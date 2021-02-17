package org.example;

import org.example.model.City;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        City city = new City();
        CityDaoJDBC cd = new CityDaoJDBC();

        cd.findById(20);
        System.out.println();
        cd.findByCode("MOZ");

    }
}
