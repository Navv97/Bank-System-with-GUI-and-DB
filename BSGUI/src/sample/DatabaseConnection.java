package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private final String URL  = "jdbc:sqlserver://localhost:1433;database=Bankproject;integratedSecurity=true;";
    private Connection connection;

    public Connection connectDatabase() {
        try{
            connection = DriverManager.getConnection(URL);
            System.out.println("connected to Database");
        }catch (SQLException exception){

        }
        return connection;
    }
}
