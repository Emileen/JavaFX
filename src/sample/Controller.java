package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


public class Controller implements Initializable {
    JsonSerializer serializer = new JsonSerializer();

    public static File f = new File("contacts.json");


    //the three inputs from the user
    @FXML
    TextField namelist;

    @FXML
    TextField phonelist;
    @FXML
    TextField emaillist;

    @FXML
    ListView list;

    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    public void addItem() throws Exception {
        //takes the input and then creates the list
        //it also checks to see that if any of the lists are empty then you will not be able to add the name
        if (!namelist.getText().equals("") && !phonelist.getText().equals("") && !emaillist.getText().equals("")) {
            contacts.add(new Contact(namelist.getText(), phonelist.getText(), emaillist.getText()));
            namelist.setText("");
            phonelist.setText("");
            emaillist.setText("");
            writeToFile();
            //readFromFile();
        }


    }

    public void writeToFile() throws Exception {
        String json = serializer.serialize(contacts);
        //creates a file writer object
        FileWriter fw = new FileWriter(f);
        //writes the json to the file path that has been created
        fw.write(json);
        //closes the file
        fw.close();
    }

    public void readFromFile() throws Exception {
        Scanner s = new Scanner(f);
        s.useDelimiter("\\Z");
        String contents = s.next();
        JsonParser parser = new JsonParser();
        Contact contact = parser.parse(contents, Contact.class);
        System.out.println(contact);

    }

    public void removeItem() throws Exception {
        // will remove the item from the list
        Contact item = (Contact) list.getSelectionModel().getSelectedItem();
        contacts.remove(item);
        System.out.println("removeItem");
        writeToFile();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
    }

}
