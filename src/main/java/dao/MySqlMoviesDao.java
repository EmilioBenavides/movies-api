package data;

import com.mysql.cj.jdbc.Driver;
import dao.MoviesDao;
import main.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MySqlMoviesDao implements MoviesDao {
// no array list or hash map here
    private Connection connection;

    public MySqlMoviesDao() {
        // make the connection
        try{
            DriverManager.registerDriver(new Driver());
            try{
        connection = DriverManager.getConnection( // this is the connection object. If it is not running check: host ect
                "jdbc:mysql://" + Config.DB_HOST + ":3306/emilio?allowPublicKeyRetrieval=true&useSSL=false",
                Config.DB_HOST,
                Config.DB_PW
            };
    } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Movie> all() throws SQLException {
        return null;
    }

    @Override
    public Movie findOne(int id) {
        return null;
    }

    @Override
    public void insert(Movie movie) {

    }

    @Override
    public void insertAll(Movie[] movies) throws SQLException {

    }

    @Override
    public void update(Movie movie) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}