package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerDisplayClient{

    public Button BackButton;
    public Button LoadButton;
    public ChangeScreens changeScreensObject = new ChangeScreens();
    public DatabaseConnection databaseConnectionObject = new DatabaseConnection();
    public TableView tableView;
    public ObservableList<ObservableList> data;

    public void backButtonAction(ActionEvent actionEvent) {
        System.out.println("BackButton");
        try {
            String string = "MainMenu.fxml";
            changeScreensObject.changeScreens(actionEvent,string);
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

