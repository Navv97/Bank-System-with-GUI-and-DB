package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class DeleteUser {

    public Button CancelButton;
    public Button ProceedButton;
    public TextField ClientToDelete_box;
    public ChangeScreens changeScreensObject = new ChangeScreens();

    public void cancelButtonAction(ActionEvent actionEvent) {
        System.out.println("CancelButton");
        try {
            ClientToDelete_box.setText("");
            String string = "MainMenu.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
        }catch (IOException e){

        }
    }

    public void proceedButtonAction(ActionEvent actionEvent) {
        System.out.println("AddFundButton");
        try {
            ClientToDelete_box.getText();
            String string = "MainMenu.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
        }catch (IOException e){

        }
    }
}
