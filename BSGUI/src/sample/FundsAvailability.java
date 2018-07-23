package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FundsAvailability {
    public double checkFundsAvailability(Connection connection, int clientID){
        try {
            String sqlQuery = "SELECT clientFunds FROM [Bank Clients] WHERE clientID = " + clientID;
            double funds = 0;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while(resultSet.next()){
                funds = resultSet.getDouble("clientFunds");
                System.out.println(funds);
            }
            connection.close();
            return funds;
        }catch (SQLException e){
            return 0;
        }
    }
}
