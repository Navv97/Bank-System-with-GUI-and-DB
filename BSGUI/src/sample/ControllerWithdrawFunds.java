package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.*;

public class ControllerWithdrawFunds {

    public TextField EnterClientID_box;
    public TextField EnterAmountOfMoney_box;
    public Button CancelButton;
    public Button ProceedButton;
    public ChangeScreens changeScreensObject = new ChangeScreens();
    public TableView tableView;
    public Button loadButton;
    public Label wrongInputDataID;
    public Label wrongInputDataMoney;
    private ObservableList<ObservableList> data;
    public DatabaseConnection databaseConnectionObject = new DatabaseConnection();


    public void cancelButtonAction(ActionEvent actionEvent) {
        System.out.println("CancelButton");
        try {
            EnterClientID_box.setText("");
            EnterAmountOfMoney_box.setText("");
            String string = "MainMenu.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
        }catch (IOException e){

        }
    }

    public void proceedButtonAction(ActionEvent actionEvent) {
        System.out.println("WithdrawFundButton");
        try {
            ClientAvailabilty clientAvailabilty = new ClientAvailabilty();
            FundsAvailability fundsAvailability = new FundsAvailability();
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Transactions transactions = new Transactions();
            Connection connection = databaseConnection.connectDatabase();
            RoundDownMoney roundDownMoneyObject = new RoundDownMoney();
            boolean flagID, flagMoney, flagBalance;
            int clientID = 0;
            try{
                clientID = Integer.parseInt(EnterClientID_box.getText());
                if(clientAvailabilty.checkClientAvailability(connection, clientID) == 0 ){
                    EnterClientID_box.setText("");
                    wrongInputDataID.setVisible(true);
                    flagID = false;
                }else {
                    wrongInputDataID.setVisible(false);
                    flagID = true;
                }
            }catch (NumberFormatException e){
                EnterClientID_box.setText("");
                wrongInputDataID.setVisible(true);
                flagID = false;
            }
            double amountOfMoney = 0;
            try {
                amountOfMoney = roundDownMoneyObject.roundTwoDecimal(Double.parseDouble(EnterAmountOfMoney_box.getText()));
                if(amountOfMoney < 0){
                    EnterAmountOfMoney_box.setText("");
                    wrongInputDataMoney.setVisible(true);
                    flagMoney = false;
                }else {
                    wrongInputDataMoney.setVisible(false);
                    flagMoney = true;
                }
            }catch (NumberFormatException e){
                EnterAmountOfMoney_box.setText("");
                wrongInputDataMoney.setVisible(true);
                flagMoney = false;
            }
            connection = databaseConnection.connectDatabase();
            if(amountOfMoney <fundsAvailability.checkFundsAvailability(connection,clientID)){
                flagBalance = true;
            }else{
                System.out.println("Za malo hajsu");
                flagBalance = false;
                EnterAmountOfMoney_box.setText("");
                wrongInputDataMoney.setVisible(true);
                flagMoney = false;
            }
            if(flagID && flagMoney && flagBalance){
                System.out.println(clientID + " " + amountOfMoney);
                connection = databaseConnection.connectDatabase();
                transactions.withdrawFunds(clientID, amountOfMoney, connection);
                String string = "MainMenu.fxml";
                changeScreensObject.changeScreens(actionEvent, string);
            }
        }catch (IOException e){
        }
    }

    public void loadButtonAction(ActionEvent actionEvent) {
        try {
            data = FXCollections.observableArrayList();
            Connection connection = databaseConnectionObject.connectDatabase();
            String displayClientsSqlQuery = "SELECT Person.clientID ," + "personName ," + "personSurname ," + "personCountry ," + "personTown ," + "personAddress ," + "personPesel ," + "[Bank Clients].clientFunds" + " FROM Person INNER JOIN [Bank Clients] ON Person.clientID = [Bank Clients].clientID";
            ResultSet resultSet = connection.createStatement().executeQuery(displayClientsSqlQuery);
            for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
                final int j = i;
                TableColumn tableColumn = new TableColumn(resultSet.getMetaData().getColumnName(i + 1));
                tableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
                tableView.getColumns().addAll(tableColumn);
                System.out.println("Column [" + i + "] ");
            }
            while (resultSet.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    row.add(resultSet.getString(i));
                }
                data.add(row);
            }
            tableView.setItems(data);
        } catch (SQLException e) {
        }

    }
}
