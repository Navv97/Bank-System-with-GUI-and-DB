package com.bank.services;

import java.sql.*;

public class DisplayUsers {

    public void displayClients(Connection connection){
        String displayClientsSQLQuery = "SELECT * FROM\n" +
                "Person INNER JOIN [Bank Client] ON Person.personID = [Bank Client].clientID";
        display(connection,displayClientsSQLQuery);
    }

    public void display(Connection connection, String sqlQuery){
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while(resultSet.next()) {
                int id = resultSet.getInt("personID");
                String name = resultSet.getString("personName");
                String surname = resultSet.getString("personSurname");
                String country = resultSet.getString("personCountry");
                String town = resultSet.getString("personTown");
                String address = resultSet.getString("personAddress");
                String pesel = resultSet.getString("personPesel");
                double money = resultSet.getDouble("clientFunds");
                System.out.println(id + " " + name + " " + surname + " " + country + " " + town + " " + address + " " + pesel + " " + money);
            }
            connection.close();
        }catch(SQLException exception){

        }
    }
}
