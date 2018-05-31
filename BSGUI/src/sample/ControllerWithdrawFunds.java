package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ControllerWithdrawFunds {

    public TextField EnterClientID_box;
    public TextField EnterAmountOfMoney_box;
    public Button CancelButton;
    public Button ProceedButton;
    public ChangeScreens changeScreensObject = new ChangeScreens();

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
            EnterClientID_box.getText();
            EnterAmountOfMoney_box.getText();
            String string = "MainMenu.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
        }catch (IOException e){

        }
    }
}
