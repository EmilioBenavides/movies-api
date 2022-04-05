import com.google.gson.Gson;
import data.Movie;
//import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name="MovieServlet", urlPatterns="/movies/*")
public class MovieServlet extends HttpServlet {
   int nextID = 1;

    ArrayList<Movie> movies = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");

        try {
            PrintWriter out = response.getWriter();

            String movieString = new Gson().toJson(movies.toArray());
            out.println(movieString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        try {

           BufferedReader br = request.getReader();

            Movie[] movieArray = new Gson().fromJson(br, Movie[].class);

            for (Movie movie : movieArray){
                movie.setId(nextID++);
                movies.add(movie);
            }

            } catch (IOException ex) {
            ex.printStackTrace();
        }
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.println("Movies added");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
