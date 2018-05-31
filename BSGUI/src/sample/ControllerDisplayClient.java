package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class ControllerDisplayClient {

    public Button BackButton;
    public ChangeScreens changeScreensObject = new ChangeScreens();

    public void backButtonAction(ActionEvent actionEvent) {
        System.out.println("BackButton");
        try {
            String string = "MainMenu.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
        }catch (IOException e){

        }
    }
}

