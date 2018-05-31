package com.bank.services;

import com.bank.model.Address;
import com.bank.model.BankClient;
import com.bank.model.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientOperations extends DisplayUsers{

    private final String displaySpecificClientsSelectQuery = "SELECT * FROM Person INNER JOIN [Bank Client] ON Person.personID = [Bank Client].clientID WHERE ";
    private final String personID = "Person.personID = ";
    private final String personName = "Person.personName = ";
    private final String personSurname = "Person.personSurname = ";
    private final String personCountry = "Person.personCountry = ";
    private final String personTown = "Person.personTown = ";
    private final String personAddress = "Person.personAddress = ";
    private final String personPesel = "Person.personPesel = ";

    void addNewClient(Connection connection){
        try {
            Person person = new Person("Czesc", "No",
                    new Address("Ta", "Pewnie", "Test 13"), "22213311111");
            BankClient bankClient = new BankClient(person, 12222.6);
            String insertPersonQuery = "INSERT INTO Person VALUES(" + person.getPersonID() + "," + person.stringForSQLQuery() + ")";
            String insertClientQuery = "INSERT INTO [Bank Client] VALUES(" + person.getPersonID() + "," + bankClient.getClientFunds() + ")";
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertPersonQuery);
            statement.executeUpdate(insertClientQuery);
            connection.close();
        }catch (SQLException exception){

        }
    }

    void deleteClient(Connection connection, int id){
        try{
            String deletePersonQuery = "DELETE FROM Person WHERE Person.personID =" + id;
            String delteClientQuery = "DELETE FROM [Bank Client] WHERE [Bank Client].clientID =" + id;
            Statement statement = connection.createStatement();
            statement.executeUpdate(deletePersonQuery);
            statement.executeUpdate(delteClientQuery);
            connection.close();
        }catch (SQLException exception){

        }
    }

    void displaySpecificClients(Connection connection, int choice, String criterium){
            switch(choice){
                case 1:
                    display(connection,displaySpecificClientsSelectQuery + personID + criterium);
                    break;
                case 2:
                    display(connection,displaySpecificClientsSelectQuery + personName + criterium);
                    break;
                case 3:
                    display(connection,displaySpecificClientsSelectQuery + personSurname + criterium);
                    break;
                case 4:
                    display(connection,displaySpecificClientsSelectQuery + personCountry + criterium);
                    break;
                case 5:
                    display(connection,displaySpecificClientsSelectQuery + personTown + criterium);
                    break;
                case 6:
                    display(connection,displaySpecificClientsSelectQuery + personAddress + criterium);
                    break;
                case 7:
                    display(connection,displaySpecificClientsSelectQuery + personPesel + criterium);
                    break;
                default:
                    break;
            }
    }


}
