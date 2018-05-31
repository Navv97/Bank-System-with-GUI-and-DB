package com.bank.services;

public class Main {

    public static void main(String[] args) {

        DatabaseConnection databaseConnection = new DatabaseConnection();
        Transactions transactions = new Transactions();
        ClientOperations clientOperations = new ClientOperations();
        double money = 50.2;
        int id = 6, id2 = 7;

        clientOperations.addNewClient(databaseConnection.connectDatabase());
        clientOperations.displayClients(databaseConnection.connectDatabase());
//        clientOperations.displaySpecificClients(databaseConnection.connectDatabase(),3,"'Kab'");

//        clientOperations.deleteClient(databaseConnection.connectDatabase(),601000);
//        clientOperations.displayClients(databaseConnection.connectDatabase());

//        transactions.displayClients(databaseConnection.connectDatabase());
//        System.out.println();
//        transactions.addFunds(id,money,databaseConnection.connectDatabase());
//        transactions.displayClients(databaseConnection.connectDatabase());

//        System.out.println();
//        transactions.withdrawFunds(id,money,databaseConnection.connectDatabase());
//        transactions.displayClients(databaseConnection.connectDatabase());
//
//        System.out.println();
//        transactions.transferFunds(id,id2,money,databaseConnection.connectDatabase());
//        transactions.displayClients(databaseConnection.connectDatabase());

    }

}
