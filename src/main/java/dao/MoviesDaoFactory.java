package dao;

import main.Config;

public class MoviesDaoFactory {
    private static Config config = new Config();

    public enum DaoType {MYSQL, IN_MEMORY};


    public static MoviesDao getMoviesDao(DaoType daoType) {

        switch (daoType) {
            case IN_MEMORY:{
                return new InMemoryMovieDao();
            }
            case MYSQL:{
                return new MySqlMoviesDao(config);
            }
        }
        return null;
    }
}
