import com.google.gson.Gson;
import data.Movie;
//import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name="MovieServlet", urlPatterns="/movies/*")
public class MovieServlet extends HttpServlet {
//    int nextID = 1;

    ArrayList<Movie> movies = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");

        try {
            PrintWriter out = response.getWriter();

            Movie movie = new Movie("Willow", "Ron Howard", "https://www.imdb.com/title/tt0096446/mediaviewer/rm3353624064/?ref_=tt_ov_i", "20 May 1988", "Action", "A young farmer is chosen to undertake a perilous journey in order to protect a special baby from an evil queen",
                   "R", 7, "126 min", "Val Kilmer", 1988, 1);

            String movieString = new Gson().toJson(movie);
            out.println(movieString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
