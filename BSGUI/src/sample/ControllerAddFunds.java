package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;

public class ControllerAddFunds {

    public ChangeScreens changeScreensObject = new ChangeScreens();
    public Button ProceedButton;
    public Button CancelButton;
    public TextField EnterClientID_box;
    public TextField EnterAmountOfMoney_box;


    public void ProceedButtonAction(ActionEvent actionEvent) {
        System.out.println("AddFundButton");
        try {
            EnterClientID_box.getText();
            EnterAmountOfMoney_box.getText();
            String string = "MainMenu.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
        }catch (IOException e){

        }
    }

    public void CancelButtonAction(ActionEvent actionEvent) {
        System.out.println("CancelButton");
        try {
            EnterClientID_box.setText("");
            EnterAmountOfMoney_box.setText("");
            String string = "MainMenu.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
        }catch (IOException e){

        }
    }
}
