package dao;

import com.mysql.cj.jdbc.Driver;
import data.Movie;
import main.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlMoviesDao implements MoviesDao {
    // no array list or hash map here
    private Connection connection = null;

    public MySqlMoviesDao(Config config) {
        // make the connection
        try {
            DriverManager.registerDriver(new Driver());

            this.connection = DriverManager.getConnection( // this is the connection object. If it is not running check: host ect

                    config.getUrl(),
                    config.getUser(),
                    config.getPW()
            );

        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Movie> all() throws SQLException {
        // make an empty array list in which to put our movies and return
        ArrayList<Movie> movies = new ArrayList<>();
        // make a statement (don't need a prepared statement since not using any variables from end user
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM movies");
        // get a resultset from the statement
        ResultSet rs = ps.executeQuery();
        // iterate over the result set
        while (rs.next()) {
            // and make a movie object for each row
            Movie movie = new Movie();
            movie.setId(rs.getInt("id"));
            movie.setTitle(rs.getString("title"));
            movie.setRating(rs.getString("rating"));
            movie.setYearMade(rs.getInt("yearMade"));
            movie.setDateReleased(rs.getString("dateReleased"));
            movie.setPoster(rs.getString("poster"));
            movie.setPlot(rs.getString("plot"));
            movie.setActors(rs.getString("actors"));
            movie.setImdb(rs.getDouble("imdb"));
            movie.setGenre(rs.getString("genre"));
            movie.setRuntime(rs.getString("runtime"));
            movie.setDirector(rs.getString("director"));
            // and add that object to an arraylist of movies
            movies.add(movie);
        }


        // return the arraylist of movies
        return movies;
    }

    @Override
    public Movie findOne(int id) {
        Movie oldData = null;
    try {

        PreparedStatement ps = connection.prepareStatement("SELECT * FROM emilio.movies where id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        oldData = new Movie();
        oldData.setRating(rs.getString("rating"));
        oldData.setPoster(rs.getString("poster"));
        oldData.setDateReleased(rs.getString("dateReleased"));
        oldData.setPlot(rs.getString("plot"));
        oldData.setGenre(rs.getString("genre"));
        oldData.setRuntime(rs.getString("runtime"));
        oldData.setDirector(rs.getString("director"));
        oldData.setActors(rs.getString("actors"));
        oldData.setImdb(rs.getDouble("imdb"));
        oldData.setTitle(rs.getString("title"));
        oldData.setId(rs.getInt("id"));
        oldData.setYearMade(rs.getInt("year"));
        return oldData;
    } catch (SQLException IO){
        IO.printStackTrace();
    }
    return oldData;
    }

    @Override
    public void insert(Movie movie) {
        try {

            // make a preparedstatement
            PreparedStatement ps = connection.prepareStatement("insert into movies " +
                    " (title, rating, poster, yearMade, genre, director, plot, actors, runtime, dateReleased, imdb) " +
                    " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

            // set all of the user info in the preparedstatemnt
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getRating());
            ps.setString(3, movie.getPoster());
            ps.setInt(4, movie.getYearMade());
            ps.setString(5, movie.getGenre());
            ps.setString(6, movie.getDirector());
            ps.setString(7, movie.getPlot());
            ps.setString(8, movie.getActors());
            ps.setString(9, movie.getRuntime());
            ps.setString(10, movie.getDateReleased());
            ps.setDouble(11, movie.getImdb());
            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            keys.next();
            int newId = keys.getInt(0);

            //do something with the id from the new record if necessary
            System.out.println("id from new inserted movie is " + newId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertAll(Movie[] movies) throws SQLException {

        // iterate over the given movies
        for (Movie movie : movies) {
            // call insert() for each of the movies
            insert(movie);
        }
    }

    @Override
    public void update(Movie movie) throws SQLException {
        //assumption : movie only has the fields that we need to update
        //"update movies set title + 'new title' where id = xxx"
        // "update movies set title = 'new title',
        try {
            Movie oldData = findOne(movie.getId());
            String sql = "update emilio.movies " + "set title = ?, " + "yearMade = ?, " + "director = ?, " + "actors = ?, " + "rating = ?, " + "poster = ?, " + "genre = ?, " + "plot = ?, " + "runtime = ?, " + "imdb = ?, " + "dateReleased = ? " + "where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            if (movie.getTitle() != null) {
                statement.setString(1, movie.getTitle());
            } else {
                statement.setString(1, oldData.getTitle());
            }
            if (movie.getYearMade() != 0) {
                statement.setInt(2, movie.getYearMade());
            } else {
                statement.setInt(2, oldData.getYearMade());
            }
            if (movie.getDirector() != null) {
                statement.setString(3, movie.getDirector());
            } else {
                statement.setString(3, oldData.getDirector());
            }
            if (movie.getActors() != null) {
                statement.setString(4, movie.getActors());
            } else {
                statement.setString(4, oldData.getActors());
            }
            if (movie.getRating() != null) {
                statement.setString(5, movie.getRating());
            } else {
                statement.setString(5, oldData.getRating());
            }
            if (movie.getPoster() != null) {
                statement.setString(6, movie.getPoster());
            } else {
                statement.setString(6, oldData.getPoster());
            }
            if (movie.getGenre() != null) {
                statement.setString(7, movie.getGenre());
            } else {
                statement.setString(7, oldData.getGenre());
            }
            if (movie.getPlot() != null) {
                statement.setString(8, movie.getPlot());
            } else {
                statement.setString(8, oldData.getPlot());
            }
            if (movie.getRuntime() != null) {
                statement.setString(9, movie.getRuntime());
            } else {
                statement.setString(9, oldData.getRuntime());
            }
            if (movie.getImdb() != 0) {
                statement.setDouble(10, movie.getImdb());
            } else {
                statement.setDouble(10, oldData.getImdb());
            }
            if (movie.getDateReleased() != null) {
                statement.setString(11, movie.getDateReleased());
            } else {
                statement.setString(11, oldData.getDateReleased());
            }
            statement.setInt(12, movie.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
    // 1. make a prepared statement and assemble the delete query
        PreparedStatement st = connection.prepareStatement("delete from movies where id = ?");

        // 2. set parameters for the statement
        st.setInt(1, id);

        //3. execute the statement
        st.executeUpdate();

    }
}





