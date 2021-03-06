package data;

public class Movie {

    private String title;
    private String director;
    private String poster;
    private String dateReleased;
    private String genre;
    private String plot;
    private String rating;
    private String runtime;
    private String actors;
    private double imdb;
    private int yearMade;
    private int id;

    public Movie() {
    }

    public Movie(String title, String director, String poster, String dateReleased, String genre, String plot, String rating, double imdb, String runtime, String actors, int year, int id) {
        this.title = title;
        this.director = director;
        this.poster = poster;
        this.dateReleased = dateReleased;
        this.genre = genre;
        this.plot = plot;
        this.rating = rating;
        this.runtime = runtime;
        this.imdb = imdb;
        this.actors = actors;
        this.yearMade = year;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(String dateReleased) {
        this.dateReleased = dateReleased;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public int getYearMade() {
        return yearMade;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }

}
