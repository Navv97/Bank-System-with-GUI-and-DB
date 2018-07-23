package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientAvailabilty {
    public int checkClientAvailability(Connection connection, int clientID){
        try {
            String sqlQuery = "SELECT clientID FROM [Bank Clients] WHERE clientID = " + clientID;
            int viableID = 0;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while(resultSet.next()){
                viableID = resultSet.getInt("clientID");
                System.out.println(viableID);
            }
            connection.close();
            return viableID;
        }catch (SQLException e){
            return 0;
        }
    }
}
