/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlapp;

import dataSource.MyDataSourceFactory;
import dataSource.Person;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Alex-Store
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button newPerson;
    @FXML
    private Button updatePerson;
    @FXML
    private Button delete;
    @FXML
    private Button next;
    @FXML
    private Button PreviousPerson;
    @FXML
    private Button firstPerson;
    @FXML
    private Button lastPerson;
    @FXML
    private TextField fName;
    @FXML
    private TextField mName;
    @FXML
    private TextField lName;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private TextField id;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Person person = new Person();
        person = MyDataSourceFactory.getPerson("select * from person where id=1");
       fillPerson(person);
    }

    @FXML
    private void addPerson(ActionEvent event) {
        Person person = new Person();
        fillPerson(person);
    }

    @FXML
    private void UpdatePerson(ActionEvent event) {
        Person person = new Person();
        int currId=Integer.parseInt(id.getText());
        person = collectPerson();
        if(currId==0)
        {
          MyDataSourceFactory.newPerson(person);
        }
        else
        {
           person.setId(currId);
           MyDataSourceFactory.updatePerson(person);
        }

    }

    @FXML
    private void deletePerson(ActionEvent event) {
        int currentId = Integer.parseInt(id.getText());
        if (currentId != 0) {
            MyDataSourceFactory.removePerson(currentId);
            System.out.println("deleted");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("deleted");
            alert.setHeaderText("row has deleted successfully");
            ButtonType btnOk = new ButtonType("ok");
            alert.getButtonTypes().setAll(btnOk);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == btnOk) {
                alert.close();
            }
            PreviousPerson(event);

        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Not deleted");
            alert.setHeaderText("row hasn't deleted successfully");
        }
    }

    @FXML
    private void nextPerson(ActionEvent event) {
        int currentId = Integer.parseInt(id.getText());
        if (currentId != 0) {
            fillPerson(MyDataSourceFactory.getPerson("select * from person where id = (select min(id) from person where id >" + currentId + ")"));
        } else if (currentId == 0 || Integer.valueOf(id.getText()) == 0) {
            //next.setDisable(false);
            fillPerson(MyDataSourceFactory.getPerson("select * from person LIMIT 1"));
        }
    }

    @FXML
    private void PreviousPerson(ActionEvent event) {
        int currentId = Integer.parseInt(id.getText());
        if (currentId != 0) {
            fillPerson(MyDataSourceFactory.getPerson("select * from person where id = (select max(id) from person where id <" + currentId + ")"));
        } else {
            fillPerson(MyDataSourceFactory.getPerson("SELECT * FROM  person WHERE id = (SELECT MAX(id)  FROM person)"));
        }
    }

    @FXML
    private void firstPerson(ActionEvent event) {
        Person person = new Person();
        person = MyDataSourceFactory.getPerson("select * from person where id=1");
        fillPerson(person);
    }

    @FXML
    private void lastPerson(ActionEvent event) {
        Person person = new Person();
        person = MyDataSourceFactory.getPerson("SELECT * FROM  person WHERE id = (SELECT MAX(id)  FROM person)");

        fillPerson(person);
    }

    public void fillPerson(Person p) {
        id.setEditable(false);
        id.setText(Integer.toString(p.getId()));
        fName.setText(p.getfName());
        lName.setText(p.getlName());
        mName.setText(p.getmName());
        email.setText(p.getEmail());
        phone.setText(Integer.toString(p.getPhone()));
    }

    public Person collectPerson() {
        Person person = new Person();
        //person.setId(Integer.parseInt(id.getText()));
        person.setPhone(Integer.parseInt(phone.getText()));
        person.setfName(fName.getText());
        person.setlName(lName.getText());
        person.setmName(mName.getText());
        person.setEmail(email.getText());
        return person;
    }
    
}
