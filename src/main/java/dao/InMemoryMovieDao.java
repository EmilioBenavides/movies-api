package data;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InMemoryMovieDao {

    int nextID = 1;
    ArrayList<Movie> movies = new ArrayList<>();

    public List<Movie> all() throws SQLException { //this function will now work on the servlet side
        return movies;
    }

    public void insertAll(Movie[] movies) throws SQLException {
        for (Movie movie : movies) {
            movie.setId(nextID++);
            this.movies.add(movie);// we add the "this" so intellij knows its referring to the movies instance variable
        }
    }

    public void update(Movie newMovie) throws SQLException {
        //search for movie that has the same id as newMovie
        for (Movie movie : movies) {
            if (newMovie.getId() == movie.getId()) {
                // change movie title to title that was in request body
                if (newMovie.getTitle() != null) {
                    movie.setTitle(newMovie.getTitle());
                }

                // change movie title to title that was in request body
                if (newMovie.getDirector() != null) {
                    movie.setDirector(newMovie.getDirector());
                }

                // change movie title to title that was in request body
                if (newMovie.getPoster() != null) {
                    movie.setPoster(newMovie.getPoster());
                }

                // change movie title to title that was in request body
                if (newMovie.getDateReleased() != null) {
                    movie.setDateReleased(newMovie.getDateReleased());
                }

                // change movie title to title that was in request body
                if (newMovie.getGenre() != null) {
                    movie.setGenre(newMovie.getGenre());
                }

                // change movie title to title that was in request body
                if (newMovie.getPlot() != null) {
                    movie.setPlot(newMovie.getPlot());
                }

                // change movie title to title that was in request body
                if (newMovie.getRating() != null) {
                    movie.setRating(newMovie.getRating());
                }

                // change movie title to title that was in request body
                if (newMovie.getRuntime() != null) {
                    movie.setRuntime(newMovie.getRuntime());
                }

                // change movie title to title that was in request body
                if (newMovie.getActors() != null) {
                    movie.setActors(newMovie.getActors());
                }

                // change movie title to title that was in request body
                if (newMovie.getYear() != null) {
                    movie.setYear(newMovie.getYear());
                }
            }
        }
    }

    public void delete(int id) throws SQLException {
        for (int i =0; i < movies.size(); i++){
            Movie movie = movies.get(i);
            if (id == movie.getId()) {
                movies.remove(i);
            }
        }
    }
}
