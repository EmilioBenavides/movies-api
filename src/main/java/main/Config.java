package main;

public class Config {
//    public static final String DB_HOST = "emp.fulgentcorp.com";
//    public static final String DB_USER = "emilio";
//    public static final String DB_PW = "ZQK88cQwFZ26Fuu7";

    public String getUrl() {
        return "jdbc:mysql://emp.fulgentcorp.com:3306/emilio?allowPublicKeyRetrieval=true&useSSL=false";
    }

    public String getUser() {
        return "emilio";
    }

    public String getPW() {
        return "ZQK88cQwFZ26Fuu7";
    }
}
