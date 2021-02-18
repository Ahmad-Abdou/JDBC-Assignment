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
//        cd.findById(30);
        System.out.println("----------------------------------------------------------------");
//       List<City>list = cd.findByCode("MOZ");
//        list.forEach(System.out::println);
        System.out.println("----------------------------------------------------------------");
//        List<City>list2 = cd.findByName("Amsterdam");
//        list2.forEach(System.out::println);
        System.out.println("----------------------------------------------------------------");
//        List<City>list3 =cd.findAll();
//        list3.forEach(System.out::println);
        System.out.println("----------------------------------------------------------------");
        City updateCity = cd.update(new City(5,"Amsterdam", "NLD", "Noord-Holland", 5464754));
//        System.out.println(updateCity.getPopulation());
        System.out.println("----------------------------------------------------------------");
//        City city2 = new City("Aleppo","SYR","SalahAldeen",123124);
//        System.out.println(cd.add(city2));
        System.out.println("----------------------------------------------------------------");
//        City Delete = new City( 34456672,"Aleppo", "SYR", "SalahAldeen", 123124);
//        System.out.println(cd.delete(Delete));



    }
}
