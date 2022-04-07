import com.google.gson.Gson;
import data.InMemoryMovieDao;
import data.Movie;
//import javax.servlet.ServletException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "MovieServlet", urlPatterns = "/movies/*")
public class MovieServlet extends HttpServlet {
 private InMemoryMovieDao dao = new InMemoryMovieDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");

        try {
            PrintWriter out = response.getWriter();

            String movieString = new Gson().toJson(dao.all().toArray());
            out.println(movieString);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        try {
            BufferedReader br = request.getReader();

            Movie[] movieArray = new Gson().fromJson(br, Movie[].class);
            dao.insertAll(movieArray);
            PrintWriter out = response.getWriter();
            out.println("Movies added");
        } catch (IOException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        try {
            String[] uriParts = request.getRequestURI().split("/");
            int targetId = Integer.parseInt(uriParts[uriParts.length - 1]);

            // Create a movie object from request body line 68/69
            BufferedReader br = request.getReader();
            Movie newMovie = new Gson().fromJson(br, Movie.class);
            newMovie.setId(targetId);
            dao.update(newMovie);
            PrintWriter out = response.getWriter();
            out.println(targetId);
        } catch(IOException | SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] uriParts = req.getRequestURI().split("/"); //the "Request parameter must match
        int targetId = Integer.parseInt(uriParts[uriParts.length - 1]);
        try {
            dao.delete(targetId);
            PrintWriter out = resp.getWriter();
            out.println(targetId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
