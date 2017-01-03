package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    TextField namelist;

    @FXML
    TextField phonelist;
    @FXML
    TextField emaillist;

    @FXML
    ListView list;

    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    public void addItem() {
        if(!namelist.getText().equals("") && !phonelist.getText().equals("") && !emaillist.getText().equals("")) {
            contacts.add(new Contact(namelist.getText(), phonelist.getText(), emaillist.getText()));
            namelist.setText("");
            phonelist.setText("");
            emaillist.setText("");
        }
    }

    public void removeItem() {
        Contact item = (Contact) list.getSelectionModel().getSelectedItem();
        contacts.remove(item);
        System.out.println("removeItem");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
    }
}
