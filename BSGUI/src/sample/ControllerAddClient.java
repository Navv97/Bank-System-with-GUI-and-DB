package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

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

    public void cancelButtonAction(ActionEvent actionEvent) {
        System.out.println("CancelButton");
        try{
            ClientName_box.getText();
            ClientSurname_box.getText();
            ClientCountry_box.getText();
            ClientPesel_box.getText();
            ClientTown_box.getText();
            ClientAddress_box.getText();
            ClientFunds_box.getText();
            String string = "MainMenu.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
        }catch (IOException e){

        }
    }

    public void proceedButtonAction(ActionEvent actionEvent) {
        System.out.println("ProceedButton");
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
}
