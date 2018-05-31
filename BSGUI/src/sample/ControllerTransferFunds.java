package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ControllerTransferFunds {
    public TextField AdresseeID_box;
    public TextField ReceiverID_box;
    public TextField AmoutOfMoney_box;
    public Button CancelButton;
    public Button ProceedButton;
    public ChangeScreens changeScreensObject = new ChangeScreens();

    public void cancelButtonAction(ActionEvent actionEvent) {
        System.out.println("CancelButton");
        try {
            AdresseeID_box.setText("");
            ReceiverID_box.setText("");
            AmoutOfMoney_box.setText("");
            String string = "MainMenu.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
        }catch (IOException e){

        }
    }

    public void proceedButtonAction(ActionEvent actionEvent) {
        System.out.println("ProceedButton");
        try {
            AdresseeID_box.getText();
            ReceiverID_box.getText();
            AmoutOfMoney_box.getText();
            String string = "MainMenu.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
        }catch (IOException e){

        }
    }
}
