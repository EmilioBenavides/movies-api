package main;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;

public class JDBCTest {
//    public static void main(String[] args) throws SQLException {
//        DriverManager.registerDriver(new Driver());
//        Connection connection = DriverManager.getConnection( // this is the connection object. If it is not running check: host ect
//                "jdbc:mysql://" + Config.DB_HOST + ":3306/emilio?allowPublicKeyRetrieval=true&useSSL=false",
//                Config.DB_HOST,
//                Config.DB_PW
//        );
//        ArrayList<Car> cars = new cars;
//
//
//        // Use the connection for sql work
//        Statement st = connection.createStatement();
//        ResultSet carRows = st.executeQuery("select vin, year, mileage from cars"); // how to execute a query
//        // this is how to iterate over the rows and print out fields for each row
//        int rowCount = 0;
//        while(carRows.next()) { // this method with move to the next row
//            rowCount++;
//            System.out.printf("%s ", carRows.getString("vin")); //you pass in the column name
//            System.out.printf("%d ", carRows.getInt("year"));
//            System.out.println(carRows.getInt("mileage"));
//
//            //make a car object from that row
//            Car car = new Car(carRows.getString("vin"),
//                    carRows.getInt("year"),
//                    carRows.getInt("mileage"));
//      //      System.out.println(car);
//            cars.add(car);
//        }
//        System.out.println("row count: " + rowCount);
//
//        carRows = st.executeQuery("select count(id) from cars"); // how to count by "id"
//        carRows.next();
//        System.out.println("row count via count function: " + carRows.getInt("count(id)"));
//        System.out.println(cars);
//
//
//        //Insert a car (prepared statements)
//        ArrayList<Car> cars = fetchAllCars();
//        System.out.println(cars);
//        // Instert a car (prepared statements)
//        Statement st = connection.createStatement();
//        st.executeUpdate("insert into cars( vin, year, mileage) values ('aaaaa', 2000, 10000)");
//
//        cars = fetchAllCars();
//        System.out.println(cars);
//
//        st.close();
//        connection.close();
//
//        carRows.close();
//        st.close(); // Statement should be closed
//        connection.close(); // if you don't close the connection it will stay open for at least 8 hours by default
//    }
//
//    //NEVER EVER EVER DO THIS....
//
//   // String mySQL = "insert into cars (vin, year, mileage) values ('" + newVin + " ', " + newYear + ect
//
//
//    // General sql injection prevention technique is use parameterized queries
//    // jdbc calls them prepared statments
//
//    PreparedStatement ps = connection.preparedStatement(insert into cars (vin, year, mileage) values (?,?,?)",
//            PreparedStatement.RETURN_GENERATED_KEYS);
//    ps.setString(1, newVin);
//    ps.setInt(2, newYear);
//    ps.setInt(3, newMileage);
//    ps.executeUpdate();
//
//    ResultSet newKeys = ps.getGeneratedKeys();
//    newKeys.next();
//    int newId + newKeys.getInt(1);
//    System.out.println("new record id is " + newKeys.getInt(1));
//    newKeys.close();
//
//    cars = fetchAllCars();
//    System.out.println(cars);
//
//    newYear = 2010;
//
//    ps = connection.preparedStatement("update cars set year = ? where id = ?");
//    ps.setInt(1, newYear);
//    ps.setInt(2, newId);
//    ps.executeUpdate();
//
//    cars = fetchAllCars();
//    System.out.println(cars);
//
//
//    ps = connection


}
