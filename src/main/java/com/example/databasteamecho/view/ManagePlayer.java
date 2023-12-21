package com.example.databasteamecho.view;

import com.example.databasteamecho.controller.PlayerController;
import com.example.databasteamecho.model.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.CheckComboBox;

import java.util.List;

public class ManagePlayer {

    Stage primaryStage;
    PlayerController playerController;
    GUI gui = new GUI();
    public ManagePlayer(Stage primaryStage,PlayerController playerController) {
        this.primaryStage = primaryStage;
        this.playerController = playerController;
    }

    public void addPlayerScene() {
        AnchorPane anchorPane = new AnchorPane();


        Button addPlayerButton = new Button("Add player");
        gui.setButtonLayout(addPlayerButton,1,150);
        gui.setColors(addPlayerButton,2);

        Button createButton = new Button("Create new\n player");
        gui.setButtonLayout(createButton,4,150);
        gui.setColors(createButton,4);
        createButton.setPrefHeight(65);


        Button mainMenuButton = new Button("Main menu");
        gui.setButtonLayout(mainMenuButton,6,150);
        gui.setColors(mainMenuButton,6);
        mainMenuButton.setLayoutX(125);
        mainMenuButton.setOnAction(event -> gui.firstScene());

        Button doneButton = new Button("Done");
        gui.setButtonLayout(doneButton,6,150);
        gui.setColors(doneButton,6);
        doneButton.setOnAction(event -> gui.playerScene());


        //entire event for create new player, ends @ row 422
        EventHandler<MouseEvent> eventHandler = event -> {
            Text text = new Text("Note that first name, last name and nickname is required");
            text.setLayoutY(275);
            text.setLayoutX(300);
            gui.setColors(text,3);
            VBox vbox = new VBox(10);
            vbox.setLayoutX(150);
            vbox.setLayoutY(325);



            HBox firstNameBox = new HBox(5);
            Label firstNameLabel = new Label("First name");
            firstNameLabel.setMinWidth(65);
            TextField firstNameField = new TextField();
            firstNameBox.getChildren().addAll(firstNameLabel,firstNameField);

            HBox lastNameBox = new HBox(5);
            Label lastNameLabel = new Label("Last name");
            lastNameLabel.setMinWidth(65);
            TextField lastNameField = new TextField();
            lastNameBox.getChildren().addAll(lastNameLabel,lastNameField);

            HBox nicknameBox = new HBox(5);
            Label nicknameLabel = new Label("Nickname");
            nicknameLabel.setMinWidth(65);
            TextField nicknameField = new TextField();
            nicknameBox.getChildren().addAll(nicknameLabel,nicknameField);

            HBox emailBox = new HBox(5);
            Label emailLabel = new Label("E-mail");
            emailLabel.setMinWidth(65);
            TextField emailField = new TextField();
            emailBox.getChildren().addAll(emailLabel,emailField);

            VBox vbox2 = new VBox(10);
            vbox2.setLayoutX(475);
            vbox2.setLayoutY(325);

            HBox phoneNumberBox = new HBox(5);
            Label phoneNumberLabel = new Label("Phone number");
            phoneNumberLabel.setMinWidth(75);
            TextField phoneNumberField = new TextField();
            phoneNumberBox.getChildren().addAll(phoneNumberLabel,phoneNumberField);

            HBox streetAdressBox = new HBox(5);
            Label streetAdressLabel = new Label("Street adress");
            streetAdressLabel.setMinWidth(75);
            TextField streetAdressField = new TextField();
            streetAdressBox.getChildren().addAll(streetAdressLabel,streetAdressField);

            HBox postalCodeBox = new HBox(5);
            Label postalCodeLabel = new Label("Postal code");
            postalCodeLabel.setMinWidth(75);
            TextField postalCodeField = new TextField();
            postalCodeBox.getChildren().addAll(postalCodeLabel,postalCodeField);

            HBox cityBox = new HBox(5);
            Label cityLabel = new Label("City");
            cityLabel.setMinWidth(75);
            TextField cityField = new TextField();
            cityBox.getChildren().addAll(cityLabel,cityField);

            HBox countryBox = new HBox(5);
            Label countryLabel = new Label("Country");
            countryLabel.setMinWidth(75);
            TextField countryField = new TextField();
            countryBox.getChildren().addAll(countryLabel,countryField);



            vbox.getChildren().addAll(firstNameBox,lastNameBox,nicknameBox,emailBox);
            vbox2.getChildren().addAll(phoneNumberBox,streetAdressBox,postalCodeBox,cityBox,countryBox);

            Button saveButton = new Button("Save");
            saveButton.setLayoutX(750);
            saveButton.setLayoutY(375);
            saveButton.setOnAction(event1 -> {

                        Node lastChild = anchorPane.getChildren().get(anchorPane.getChildren().size() - 1);
                        if (lastChild instanceof Text) {
                            anchorPane.getChildren().remove(lastChild);
                        }

                        if(!firstNameField.getText().isEmpty()&&!lastNameField.getText().isEmpty()&&!nicknameField.getText().isEmpty()){Player player = new Player
                                (
                                        firstNameField.getText(),lastNameField.getText(),
                                        nicknameField.getText(), emailField.getText(), phoneNumberField.getText(),
                                        streetAdressField.getText(),postalCodeField.getText(),cityField.getText(),
                                        countryField.getText()
                                );
                            try{
                                playerController.addPlayer(player);
                                Text textsuccess = new Text("Successfully added "+player.getNickname());
                                textsuccess.setLayoutX(720);
                                textsuccess.setLayoutY(420);
                                anchorPane.getChildren().addAll(textsuccess);
                            }catch (Exception ignored){}
                        }else {
                            Text textfail = new Text("Failed to add player\nMake sure required fields\n are filled out\n and that your inputs \naren't too long \n(rule of thumb 30 characters)");
                            textfail.setLayoutX(720);
                            textfail.setLayoutY(420);
                            anchorPane.getChildren().addAll(textfail);
                        };
                    }
            );


            anchorPane.getChildren().addAll(text,vbox,vbox2,saveButton);
        }; //event ends here for create player

        createButton.addEventHandler(MouseEvent.MOUSE_CLICKED,eventHandler);


        anchorPane.getChildren().addAll(addPlayerButton,createButton,mainMenuButton,doneButton);

        Scene addPlayerScene = new Scene(anchorPane, 900, 600);
        primaryStage.setScene(addPlayerScene);
        primaryStage.show();

    }

    public void generatePlayerList(AnchorPane anchorPane, CheckComboBox checkComboBox)  {
        anchorPane.getChildren().removeIf(node -> node instanceof TableView);
        TableView<Player> tableView = new TableView<>();
        ObservableList<DisplayItem> displayList = checkComboBox.getCheckModel().getCheckedItems();
        for(DisplayItem displayItem:displayList){
            tableView.getColumns().add(createTableColumn(displayItem.getLabel(), displayItem.getValue(), displayItem.getType()));
        }

        List<Player> playerList = playerController.getAll(false);

        ObservableList<Player> observableList = FXCollections.observableList(playerList);

        tableView.setItems(observableList);



        tableView.setLayoutX(50);
        tableView.setLayoutY(225);
        tableView.setPrefHeight(playerList.size()*30);
        tableView.setPrefWidth(displayList.size()*100);

        anchorPane.getChildren().addAll(tableView);

    }
    private <E,T> TableColumn<E, T> createTableColumn(String label, String propertyName, Class<T> type) {
        TableColumn<E, T> column = new TableColumn<>(label);

        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        column.setEditable(true);

        return column;
    }
}
