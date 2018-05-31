package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ControllerFindClient {
    public Button CancelButton;
    public Button ProceedButton;
    public TextField EnterCriterium_box;
    public TextField EnterStatement_box;
    public ChangeScreens changeScreensObject = new ChangeScreens();

    public void cancelButtonAction(ActionEvent actionEvent) {
        System.out.println("CancelButton");
        try {
            EnterCriterium_box.setText("");
            EnterStatement_box.setText("");
            String string = "MainMenu.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
        }catch (IOException e){

        }

    }

    public void proceedButtonAction(ActionEvent actionEvent) {
        System.out.println("FinClientButton");
        try {
            EnterCriterium_box.getText();
            EnterStatement_box.getText();
            String string = "MainMenu.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
        }catch (IOException e){

        }
    }
}
