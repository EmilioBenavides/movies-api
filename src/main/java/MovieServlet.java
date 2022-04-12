import com.google.gson.Gson;
import dao.MoviesDao;
import data.Movie;
import dao.MySqlMoviesDao;
import main.Config;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import static dao.MoviesDaoFactory.DaoType.MYSQL;
import static dao.MoviesDaoFactory.getMoviesDao;

@WebServlet(name = "MovieServlet", urlPatterns = "/movies/*")
public class MovieServlet extends HttpServlet {
    private Config config = new Config();
 //private InMemoryMovieDao dao = new InMemoryMovieDao();
 //private MySqlMoviesDao dao = new MySqlMoviesDao(config);
    MoviesDao dao = getMoviesDao(MYSQL);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            try {
                String[] uriParts = request.getRequestURI().split("/");
                int targetId = Integer.parseInt(uriParts[uriParts.length - 1]);
                PrintWriter out = response.getWriter();
                out.println( new Gson().toJson(
                        dao.findOne(targetId)));
            } catch (NumberFormatException e) {
                PrintWriter out = response.getWriter();
                out.println(new Gson().toJson(
                        dao.all()));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        try {
            BufferedReader br = request.getReader();

            Movie[] movieArray = new Gson().fromJson(br, Movie[].class);
            dao.insertAll(movieArray);
        } catch (IOException | SQLException ex) {
            ex.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.println(new Gson().toJson("{message: \"Movies POST was successful\"}"));
        response.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        response.setContentType("application/json");
        try {
            String[] uriParts = request.getRequestURI().split("/");
          int targetId = Integer.parseInt(uriParts[uriParts.length - 1]);

            // Create a movie object from request body line 68/69
            BufferedReader br = request.getReader();
            Movie newMovie = new Gson().fromJson(br, Movie.class);
            newMovie.setId(targetId);
            dao.update(newMovie);
        } catch(IOException | SQLException e){
            e.printStackTrace();
        }
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println(new Gson().toJson("{message: \"Movies UPDATE was successful\"}"));
        response.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        String[] uriParts = req.getRequestURI().split("/"); //the "Request parameter must match
        int targetId = Integer.parseInt(uriParts[uriParts.length - 1]);
        try {
            dao.delete(targetId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.println(new Gson().toJson("{message: \"Movies DELETE was successful\"}"));
        response.setStatus(200);
    }
}
