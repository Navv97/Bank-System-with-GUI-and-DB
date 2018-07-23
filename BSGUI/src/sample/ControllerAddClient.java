package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.IOException;
import java.util.regex.Pattern;

public class ControllerAddClient {
    public TextField ClientName_box;
    public TextField ClientSurname_box;
    public TextField ClientCountry_box;
    public TextField ClientPesel_box;
    public TextField ClientTown_box;
    public TextField ClientAddress_box;
    public TextField ClientFunds_box;
    public Button CancelButton;
    public Button ProceedButton;
    public ChangeScreens changeScreensObject = new ChangeScreens();
    public Label wrongInputDataCountry;
    public Label wrongInputDataName;
    public Label wrongInputDataPesel;
    public Label wrongInputDataFunds;
    public Label wrongInputDataAddress;
    public Label wrongInputDataTown;
    public Label wrongInputDataSurname;

    public void cancelButtonAction(ActionEvent actionEvent) {
        System.out.println("CancelButton");
        try{
            ClientName_box.setText("");
            ClientSurname_box.setText("");
            ClientCountry_box.setText("");
            ClientPesel_box.setText("");
            ClientTown_box.setText("");
            ClientAddress_box.setText("");
            ClientFunds_box.setText("");
            String string = "MainMenu.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
        }catch (IOException e){

        }
    }

    public void proceedButtonAction(ActionEvent actionEvent) {
        System.out.println("ProceedButton");
        try{
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.connectDatabase();
            boolean flagName, flagSurname, flagCountry, flagTown, flagPesel, flagFunds;
            try {
                if(!validInputForString(ClientName_box.getText())){
                    wrongInputDataName.setVisible(true);
                    flagName = false;
                }else{
                    flagName = true;
                    wrongInputDataName.setVisible(false);
                }
                if(!validInputForString(ClientSurname_box.getText())){
                    wrongInputDataSurname.setVisible(true);
                    flagSurname = false;
                }else{
                    flagSurname = true;
                    wrongInputDataSurname.setVisible(false);
                }
                if(!validInputForString(ClientCountry_box.getText())){
                    wrongInputDataCountry.setVisible(true);
                    flagCountry = false;
                }else{
                    flagCountry = true;
                    wrongInputDataCountry.setVisible(false);
                }
                if(!validInputForString(ClientTown_box.getText())){
                    wrongInputDataTown.setVisible(true);
                    flagTown = false;
                }else{
                    wrongInputDataTown.setVisible(false);
                    flagTown = true;
                }
                String test =  ClientPesel_box.getText();
                connection = databaseConnection.connectDatabase();
                if(!validInputForNumberData(test) ||  test.length() != 11 || checkPeselAvailability(connection,test) == 1){
                    wrongInputDataPesel.setVisible(true);
                    flagPesel = false;
                }else{
                    flagPesel = true;
                    wrongInputDataPesel.setVisible(false);
                }
                double funds = 0;
                try{
                    funds = Double.parseDouble(ClientFunds_box.getText());
                    if(funds < 0){
                        wrongInputDataFunds.setVisible(true);
                        flagFunds = false;
                    }else {
                        flagFunds = true;
                        wrongInputDataFunds.setVisible(false);
                    }
                }catch (NumberFormatException e){
                    wrongInputDataFunds.setVisible(true);
                    flagFunds = false;
                }
                if(flagCountry && flagFunds && flagName && flagPesel && flagSurname && flagTown) {
                    Person person = new Person(ClientName_box.getText(), ClientSurname_box.getText(), new Address(ClientCountry_box.getText(), ClientTown_box.getText(), ClientAddress_box.getText()), ClientPesel_box.getText());
                    BankClient bankClient = new BankClient(person, funds);
                    System.out.println("Test1");
                    String insertPersonQuery = "INSERT INTO Person VALUES(" + person.stringForSQLQuery() + ")";
                    System.out.println("Test2");
                    connection = databaseConnection.connectDatabase();
                    Statement statement = connection.createStatement();
                    System.out.println("Test3");
                    String insertClientQuery = "INSERT INTO [Bank Clients] VALUES(" + bankClient.getClientFunds() + ")";
                    System.out.println("Test4");
                    statement.executeUpdate(insertPersonQuery);
                    System.out.println("Test5");
                    connection = databaseConnection.connectDatabase();
                    statement = connection.createStatement();
                    statement.executeUpdate(insertClientQuery);
                    System.out.println("Test6");
                    connection.close();
                    System.out.println("Test7");
                    String string = "MainMenu.fxml";
                    changeScreensObject.changeScreens(actionEvent,string);
                    System.out.println("Test8");
                }
            }catch (SQLException exception){

            }
//            addNewClient(connection);
        }catch (IOException e){

        }
    }

    public int checkPeselAvailability(Connection connection, String clientPesel){
        try {
            String sqlQuery = "SELECT personPesel FROM [Person] WHERE personPesel = " + "'" + clientPesel + "'";
            String viablePESEL = "test";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while(resultSet.next()){
                System.out.println(viablePESEL);
                viablePESEL = resultSet.getString("personPesel");
                System.out.println(viablePESEL);
                ClientPesel_box.setText("Pesel taken");
            }
            connection.close();
            if(viablePESEL.equals(clientPesel)) {
                return 1;
            }else{
                return 0;
            }
        }catch (SQLException e){
            return 0;
        }
    }

    boolean validInputForString(String stringToValidate){
        if(Pattern.matches("[a-zA-Z]+", stringToValidate)){
            return true;
        } else {
            System.out.println("Podales nie poprawne dane");
            return false;
        }
    }

    boolean validInputForNumberData(String stringToValidate){
        if(Pattern.matches("[0-9]+", stringToValidate)){
            return true;
        } else {
            System.out.println("Podales nie poprawne dane");
            return false;
        }
    }

}