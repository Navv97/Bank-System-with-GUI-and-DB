package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class ControllerMainMenu {

    public Button AddFunds;

    public ChangeScreens changeScreensObject = new ChangeScreens();
    public Button AddClient;
    public Button Quit;
    public Button TransferFunds;
    public Button WithdrawFunds;
    public Button FindClient;
    public Button DisplayClients;
    public Button DeleteClient;

    public void addFundsAction(ActionEvent actionEvent) {
        System.out.println("AddFundsActionButton");
        try {
            String string = "AddFunds.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
        }catch (IOException e){

        }
    }

    public void addClientAction(ActionEvent actionEvent) {
        System.out.println("AddClientActionButton");
        try {
            String string = "AddClient.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
        }catch (IOException e){

        }
    }

    public void deleteClientAction(ActionEvent actionEvent) {
        System.out.println("DeleteClientActionButton");
        try {
            String string = "DeleteClient.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
        }catch (IOException e){

        }
    }

    public void displayClientsAction(ActionEvent actionEvent) {
        System.out.println("DisplayClientActionButton");
        try {
            String string = "DisplayClient.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
        }catch (IOException e){

        }
    }

    public void findClientAction(ActionEvent actionEvent) {
        System.out.println("FindClientActionButton");
        try {
            String string = "FindClient.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
        }catch (IOException e){

        }
    }

    public void withdrawFundsAction(ActionEvent actionEvent) {
        System.out.println("WithdrawFundsActionButton");
        try {
            String string = "WithdrawFunds.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
        }catch (IOException e){

        }
    }

    public void transferFundsAction(ActionEvent actionEvent) {
        System.out.println("TransferFundsActionButton");
        try {
            String string = "TransferFunds.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
        }catch (IOException e){

        }
    }

    public void quitAction(ActionEvent actionEvent) {
        System.exit(1);
    }
}
