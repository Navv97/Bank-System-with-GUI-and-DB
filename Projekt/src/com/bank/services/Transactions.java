package com.bank.services;

import java.sql.*;

public class Transactions extends DisplayUsers {

    void addFunds(int id, double money, Connection connection){
        try{
            Statement statement = connection.createStatement();
            String addFundsSQLQuery = "IF EXISTS (SELECT * FROM Person INNER JOIN [Bank Client] ON Person.personID = [Bank Client].clientID  WHERE [Bank Client].clientID =" + id + ")" + "UPDATE [Bank Client] SET clientFunds = clientFunds +" + money + "WHERE clientID =" + id ;
            statement.executeUpdate(addFundsSQLQuery);
            connection.close();
        }catch (SQLException exception){

        }
    }

    void withdrawFunds(int id, double money, Connection connection){
        try{
            Statement statement = connection.createStatement();
            String addFundsSQLQuery = "IF EXISTS (SELECT * FROM Person INNER JOIN [Bank Client] ON Person.personID = [Bank Client].clientID  WHERE [Bank Client].clientID =" + id + ")" + "UPDATE [Bank Client] SET clientFunds = clientFunds -" + money + "WHERE clientID =" + id ;
            statement.executeUpdate(addFundsSQLQuery);
            connection.close();
        }catch (SQLException exception){

        }
    }

    void transferFunds(int clientToTransferFrom, int clientToTransferTo, double money, Connection connection){
        withdrawFunds(clientToTransferFrom,money,connection);
        addFunds(clientToTransferTo,money,connection);
    }

}
