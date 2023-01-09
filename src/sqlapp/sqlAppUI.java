package sqlapp;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

public abstract class sqlAppUI extends AnchorPane {

    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final TextField fName;
    protected final TextField mName;
    protected final TextField lName;
    protected final TextField email;
    protected final TextField phone;
    protected final FlowPane flowPane;
    protected final Button newPerson;
    protected final Button updatePerson;
    protected final Button delete;
    protected final Button next;
    protected final Button PreviousPerson;
    protected final Button firstPerson;
    protected final Button lastPerson;
    protected final Label label4;
    protected final Label label5;
    protected final TextField id;
        public sqlAppUI() {

        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        fName = new TextField();
        mName = new TextField();
        lName = new TextField();
        email = new TextField();
        phone = new TextField();
        flowPane = new FlowPane();
        newPerson = new Button();
        updatePerson = new Button();
        delete = new Button();
        next = new Button();
        PreviousPerson = new Button();
        firstPerson = new Button();
        lastPerson = new Button();
        label4 = new Label();
        label5 = new Label();
        id = new TextField();

        setId("AnchorPane");
        setPrefHeight(471.0);
        setPrefWidth(620.0);

        label.setLayoutX(40.0);
        label.setLayoutY(100.0);
        label.setPrefHeight(21.0);
        label.setPrefWidth(96.0);
        label.setText("First Name:");
        label.setFont(new Font(18.0));

        label0.setLayoutX(38.0);
        label0.setLayoutY(152.0);
        label0.setText("Middle Name:");
        label0.setFont(new Font(18.0));

        label1.setLayoutX(38.0);
        label1.setLayoutY(205.0);
        label1.setText("Last Name:");
        label1.setFont(new Font(18.0));

        label2.setLayoutX(38.0);
        label2.setLayoutY(257.0);
        label2.setText("Email:");
        label2.setFont(new Font(18.0));

        label3.setLayoutX(40.0);
        label3.setLayoutY(308.0);
        label3.setText("Phone:");
        label3.setFont(new Font(18.0));

        fName.setLayoutX(154.0);
        fName.setLayoutY(95.0);
        fName.setPrefHeight(31.0);
        fName.setPrefWidth(308.0);

        mName.setLayoutX(154.0);
        mName.setLayoutY(147.0);
        mName.setPrefHeight(21.0);
        mName.setPrefWidth(308.0);

        lName.setLayoutX(154.0);
        lName.setLayoutY(200.0);
        lName.setPrefHeight(31.0);
        lName.setPrefWidth(308.0);

        email.setLayoutX(154.0);
        email.setLayoutY(252.0);
        email.setPrefHeight(21.0);
        email.setPrefWidth(308.0);

        phone.setAlignment(javafx.geometry.Pos.CENTER);
        phone.setLayoutX(154.0);
        phone.setLayoutY(303.0);
        phone.setPrefHeight(31.0);
        phone.setPrefWidth(308.0);

        flowPane.setAlignment(javafx.geometry.Pos.CENTER);
        flowPane.setLayoutX(-9.0);
        flowPane.setLayoutY(347.0);
        flowPane.setPrefHeight(77.0);
        flowPane.setPrefWidth(639.0);
        flowPane.setStyle("-fx-hgap: 15; -fx-border-color: black;");

        newPerson.setMnemonicParsing(false);
        newPerson.setOnAction(this::addPerson);
        newPerson.setText("New");
        newPerson.setFont(new Font(18.0));
        
        updatePerson.setMnemonicParsing(false);
        updatePerson.setOnAction(this::UpdatePerson);
        updatePerson.setText("Update");
        updatePerson.setFont(new Font(18.0));

        delete.setMnemonicParsing(false);
        delete.setOnAction(this::deletePerson);
        delete.setText("Delete");
        delete.setFont(new Font(18.0));

        next.setMnemonicParsing(false);
        next.setOnAction(this::nextPerson);
        next.setText("Next");
        next.setFont(new Font(18.0));

        PreviousPerson.setMnemonicParsing(false);
        PreviousPerson.setOnAction(this::PreviousPerson);
        PreviousPerson.setText("Previous");
        PreviousPerson.setFont(new Font(18.0));

        firstPerson.setMnemonicParsing(false);
        firstPerson.setOnAction(this::firstPerson);
        firstPerson.setText("First");
        firstPerson.setFont(new Font(18.0));

        lastPerson.setMnemonicParsing(false);
        lastPerson.setOnAction(this::lastPerson);
        lastPerson.setText("Last");
        lastPerson.setFont(new Font(18.0));

        label4.setLayoutX(29.0);
        label4.setLayoutY(14.0);
        label4.setText("Person");
        label4.setTextFill(javafx.scene.paint.Color.valueOf("#b51b1b"));
        label4.setFont(new Font(24.0));

        label5.setLayoutX(40.0);
        label5.setLayoutY(61.0);
        label5.setText("ID:");

        id.setLayoutX(154.0);
        id.setLayoutY(56.0);
        id.setPrefHeight(31.0);
        id.setPrefWidth(105.0);
        id.setStyle("-fx-background-color: none;");

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(fName);
        getChildren().add(mName);
        getChildren().add(lName);
        getChildren().add(email);
        getChildren().add(phone);
        flowPane.getChildren().add(newPerson);
        flowPane.getChildren().add(updatePerson);
        flowPane.getChildren().add(delete);
        flowPane.getChildren().add(next);
        flowPane.getChildren().add(PreviousPerson);
        flowPane.getChildren().add(firstPerson);
        flowPane.getChildren().add(lastPerson);
        getChildren().add(flowPane);
        getChildren().add(label4);
        getChildren().add(label5);
        getChildren().add(id);

    }

    protected abstract void addPerson(javafx.event.ActionEvent actionEvent);

    protected abstract void UpdatePerson(javafx.event.ActionEvent actionEvent);

    protected abstract void deletePerson(javafx.event.ActionEvent actionEvent);

    protected abstract void nextPerson(javafx.event.ActionEvent actionEvent);

    protected abstract void PreviousPerson(javafx.event.ActionEvent actionEvent);

    protected abstract void firstPerson(javafx.event.ActionEvent actionEvent);

    protected abstract void lastPerson(javafx.event.ActionEvent actionEvent);

}
