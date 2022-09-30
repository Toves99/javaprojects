package Hostel;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public Connection databaseLink;
    public Connection getConnection(String databaseName){
        String dataBaseDriver = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String password = "";
        String dataBaseURL = "jdbc:mysql://localhost:3306/" + databaseName;
        try{
            Class.forName(dataBaseDriver);
            databaseLink = DriverManager.getConnection(dataBaseURL, user, password);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }

}
