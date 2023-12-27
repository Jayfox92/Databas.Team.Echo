package com.example.databasteamecho.view;

import com.example.databasteamecho.controller.PlayerController;
import com.example.databasteamecho.model.Player;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.CheckComboBox;

import java.util.List;

public class ManagePlayer {

    private Stage primaryStage;
    private PlayerController playerController;
    private GUI gui = new GUI();
    private Runnable guiCallback;
    private PauseTransition pause = new PauseTransition(Duration.seconds(3));
    public ManagePlayer(Stage primaryStage,Runnable guiCallback,PlayerController playerController) {
        this.primaryStage = primaryStage;
        this.guiCallback = guiCallback;
        this.playerController = playerController;
    }

    public void playerScene(){
        AnchorPane anchorPane = new AnchorPane();

        Button listPlayersButton = new Button("List players");
        gui.setButtonLayout(listPlayersButton,1,150);
        gui.setColors(listPlayersButton,1);
        listPlayersButton.setOnAction(event -> listPlayerscene());

        Button addPlayerButton = new Button("Add player");
        gui.setButtonLayout(addPlayerButton,2,150);
        gui.setColors(addPlayerButton,2);
        addPlayerButton.setOnAction(event -> addPlayerScene());

        Button deletePlayerButton = new Button("Delete player");
        gui.setButtonLayout(deletePlayerButton,3,150);
        gui.setColors(deletePlayerButton,3);

        Button updatePlayerButton = new Button("Update player");
        gui.setButtonLayout(updatePlayerButton,4,150);
        gui.setColors(updatePlayerButton,4);

        Button mainMenuButton = new Button("Main menu");
        gui.setButtonLayout(mainMenuButton,6,150);
        gui.setColors(mainMenuButton,6);
        mainMenuButton.setLayoutX(125);
        mainMenuButton.setOnAction(event -> guiCallback.run());







        anchorPane.getChildren().addAll(listPlayersButton, addPlayerButton,deletePlayerButton,updatePlayerButton,mainMenuButton);


        Scene playerScene = new Scene(anchorPane, 900, 600);
        primaryStage.setScene(playerScene);
        primaryStage.show();


    }

    public void listPlayerscene(){
        AnchorPane anchorPane = new AnchorPane();

        Button listPlayersButton = new Button("List players");
        gui.setButtonLayout(listPlayersButton,7,150);
        gui.setColors(listPlayersButton,1);

        Button mainMenuButton = new Button("Main menu");
        gui.setButtonLayout(mainMenuButton,6,150);
        gui.setColors(mainMenuButton,6);
        mainMenuButton.setLayoutX(125);
        mainMenuButton.setOnAction(event -> guiCallback.run());

        Button doneButton = new Button("Back");
        gui.setButtonLayout(doneButton,6,150);
        gui.setColors(doneButton,6);
        doneButton.setLayoutX(300);
        doneButton.setOnAction(event -> playerScene());

        Button deletePlayerButton = new Button("Delete player");
        gui.setButtonLayout(deletePlayerButton,6,150);
        deletePlayerButton.setLayoutX(475);
        gui.setColors(deletePlayerButton,3);
        deletePlayerButton.setOnAction(event -> deletePlayer(anchorPane));

        Button updatePlayerButton = new Button("Update player");
        gui.setButtonLayout(updatePlayerButton,6,150);
        updatePlayerButton.setLayoutX(650);
        gui.setColors(updatePlayerButton,4);
        updatePlayerButton.setVisible(false);


        Button generateButton = new Button("Generate");
        gui.setButtonLayout(generateButton,10,150);
        gui.setColors(generateButton,4);




        final CheckComboBox<DisplayItem> checkComboBox = new CheckComboBox<>();
        checkComboBox.getItems().addAll(
                new DisplayItem("ID", "id", Integer.class),
                new DisplayItem("First name", "firstName", String.class),
                new DisplayItem("Last name", "lastName",String.class),
                new DisplayItem("Nickname", "nickname",String.class),
                new DisplayItem("E-mail", "email",String.class),
                new DisplayItem("Phone number", "phonenumber",Long.class),
                new DisplayItem("Street adress", "streetAdress",String.class),
                new DisplayItem("Postal code", "postalCode",String.class),
                new DisplayItem("City", "city",String.class),
                new DisplayItem("Country", "country",String.class)
        );


       checkComboBox.getCheckModel().getCheckedItems().addListener(new ListChangeListener<DisplayItem>() {
            @Override
            public void onChanged(Change<? extends DisplayItem> change) {
                if(change.getList().size() == 0){
                    checkComboBox.getCheckModel().clearChecks();

                }

            }
        });


        checkComboBox.setTitle("Choose columns");
        checkComboBox.setStyle("-fx-font-size: 18;");
        checkComboBox.setLayoutY(50);
        checkComboBox.setLayoutX(350);
        checkComboBox.setPrefWidth(200);


        generateButton.setOnAction(event1 -> generatePlayerList(anchorPane, checkComboBox, updatePlayerButton));


        anchorPane.getChildren().addAll(listPlayersButton,mainMenuButton,doneButton,checkComboBox,generateButton,deletePlayerButton,updatePlayerButton);
        Scene listPlayerscene = new Scene(anchorPane, 900, 600);
        primaryStage.setScene(listPlayerscene);
        primaryStage.show();
    }

    public void addPlayerScene() {
        AnchorPane anchorPane = new AnchorPane();


        Button addPlayerButton = new Button("Add player");
        gui.setButtonLayout(addPlayerButton,7,150);
        gui.setColors(addPlayerButton,2);

        Button createButton = new Button("Create new\n player");
        gui.setButtonLayout(createButton,10,150);
        gui.setColors(createButton,4);
        createButton.setPrefHeight(65);


        Button mainMenuButton = new Button("Main menu");
        gui.setButtonLayout(mainMenuButton,6,150);
        gui.setColors(mainMenuButton,6);
        mainMenuButton.setLayoutX(125);
        mainMenuButton.setOnAction(event -> guiCallback.run());

        Button doneButton = new Button("Back");
        gui.setButtonLayout(doneButton,6,150);
        gui.setColors(doneButton,6);
        doneButton.setOnAction(event -> playerScene());



        EventHandler<MouseEvent> eventHandler = event -> {
            Text text = new Text("Note that first name, last name and nickname is required");
            text.setLayoutX(225);
            text.setLayoutY(175);
            gui.setColors(text,3);
            VBox vbox = new VBox(10);
            vbox.setLayoutX(150);
            vbox.setLayoutY(225);



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
            vbox2.setLayoutY(225);

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
            gui.setButtonLayout(saveButton,6,150);
            saveButton.setLayoutY(400);
            gui.setColors(saveButton,5);
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
                                Text textsuccess = new Text("Successfully added "+player.getFirstName()+", \""+player.getNickname()+"\"");
                                textsuccess.setLayoutX(710);
                                textsuccess.setLayoutY(300);
                                anchorPane.getChildren().addAll(textsuccess);
                            }catch (Exception ignored){}
                        }else {
                            Text textfail = new Text("Failed to add player\nMake sure required fields\n are filled out\n and that your inputs \naren't too long \n(rule of thumb 30 characters)");
                            textfail.setLayoutX(710);
                            textfail.setLayoutY(300);
                            anchorPane.getChildren().addAll(textfail);
                        };
                    }
            );


            anchorPane.getChildren().addAll(text,vbox,vbox2,saveButton);
        };

        createButton.addEventHandler(MouseEvent.MOUSE_CLICKED,eventHandler);


        anchorPane.getChildren().addAll(addPlayerButton,createButton,mainMenuButton,doneButton);

        Scene addPlayerScene = new Scene(anchorPane, 900, 600);
        primaryStage.setScene(addPlayerScene);
        primaryStage.show();

    }

    public void generatePlayerList(AnchorPane anchorPane, CheckComboBox checkComboBox, Button updateButton)  {
        anchorPane.getChildren().removeIf(node -> node instanceof TableView);
        anchorPane.getChildren().removeIf(node -> node instanceof HBox);
        anchorPane.getChildren().removeIf(node -> node instanceof VBox);
        TableView<Player> tableView = new TableView<>();
        updateButton.setVisible(true);
        ObservableList<DisplayItem> displayList = checkComboBox.getCheckModel().getCheckedItems();
        for(DisplayItem displayItem:displayList){
            tableView.getColumns().add(createTableColumn(displayItem.getLabel(), displayItem.getValue(), displayItem.getType()));
        }

        List<Player> playerList = playerController.getAll(false);

        ObservableList<Player> observableList = FXCollections.observableList(playerList);

        tableView.setItems(observableList);

        Player selectedItem = tableView.getSelectionModel().getSelectedItem();
        updateButton.setOnAction(event -> {updatePlayer(anchorPane,tableView.getSelectionModel().getSelectedItem(),tableView);});

        tableView.setLayoutX(50);
        tableView.setLayoutY(100);
        tableView.setPrefHeight(playerList.size()*35);
        tableView.setPrefWidth(displayList.size()*100);
        tableView.setMinHeight(100);
        tableView.setMaxHeight(350);
        tableView.setMaxWidth(800);

        anchorPane.getChildren().addAll(tableView);

    }
    private <E,T> TableColumn<E, T> createTableColumn(String label, String propertyName, Class<T> type) {
        TableColumn<E, T> column = new TableColumn<>(label);

        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));

        return column;
    }

    public void deletePlayer(AnchorPane anchorPane){
        TextField deleteText = new TextField();
        deleteText.setPromptText("Enter ID to delete");
        deleteText.setLayoutX(475);
        deleteText.setLayoutY(450);
        deleteText.setPrefWidth(120);


        EventHandler<KeyEvent> eventHandler = event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    int id = Integer.parseInt(deleteText.getText());
                    if (playerController.deletePlayer(id)) {
                        Text textsuccess = new Text("Successfully deleted player");
                        textsuccess.setLayoutX(475);
                        textsuccess.setLayoutY(435);
                        anchorPane.getChildren().addAll(textsuccess);
                        pause.setOnFinished(e -> anchorPane.getChildren().removeAll(textsuccess));
                        pause.playFromStart();

                    } else {
                        Text textfail = new Text("Failed to delete player");
                        textfail.setLayoutX(475);
                        textfail.setLayoutY(435);
                        anchorPane.getChildren().addAll(textfail);
                        pause.setOnFinished(e -> anchorPane.getChildren().removeAll(textfail));
                        pause.playFromStart();

                    }
                } catch (Exception ignored) {}
            }
        };

        deleteText.addEventHandler(KeyEvent.KEY_PRESSED, eventHandler);
        anchorPane.getChildren().add(deleteText);
    }

    public void updatePlayer(AnchorPane anchorPane, Player player,TableView tableView){

        if (tableView.getSelectionModel().getSelectedItem() != null){
            anchorPane.getChildren().removeIf(node -> node instanceof TableView);
            Text text = new Text("Note that first name, last name and nickname is required");
            text.setLayoutX(225);
            text.setLayoutY(175);
            gui.setColors(text,3);
            VBox vbox = new VBox(10);
            vbox.setLayoutX(150);
            vbox.setLayoutY(225);



            HBox firstNameBox = new HBox(5);
            Label firstNameLabel = new Label("First name");
            firstNameLabel.setMinWidth(65);
            TextField firstNameField = new TextField(player.getFirstName());
            firstNameBox.getChildren().addAll(firstNameLabel,firstNameField);

            HBox lastNameBox = new HBox(5);
            Label lastNameLabel = new Label("Last name");
            lastNameLabel.setMinWidth(65);
            TextField lastNameField = new TextField(player.getLastName());
            lastNameBox.getChildren().addAll(lastNameLabel,lastNameField);

            HBox nicknameBox = new HBox(5);
            Label nicknameLabel = new Label("Nickname");
            nicknameLabel.setMinWidth(65);
            TextField nicknameField = new TextField(player.getNickname());
            nicknameBox.getChildren().addAll(nicknameLabel,nicknameField);

            HBox emailBox = new HBox(5);
            Label emailLabel = new Label("E-mail");
            emailLabel.setMinWidth(65);
            TextField emailField = new TextField(player.getEmail());
            emailBox.getChildren().addAll(emailLabel,emailField);

            VBox vbox2 = new VBox(10);
            vbox2.setLayoutX(475);
            vbox2.setLayoutY(225);

            HBox phoneNumberBox = new HBox(5);
            Label phoneNumberLabel = new Label("Phone number");
            phoneNumberLabel.setMinWidth(75);
            TextField phoneNumberField = new TextField(player.getPhonenumber());
            phoneNumberBox.getChildren().addAll(phoneNumberLabel,phoneNumberField);

            HBox streetAdressBox = new HBox(5);
            Label streetAdressLabel = new Label("Street adress");
            streetAdressLabel.setMinWidth(75);
            TextField streetAdressField = new TextField(player.getStreetAdress());
            streetAdressBox.getChildren().addAll(streetAdressLabel,streetAdressField);

            HBox postalCodeBox = new HBox(5);
            Label postalCodeLabel = new Label("Postal code");
            postalCodeLabel.setMinWidth(75);
            TextField postalCodeField = new TextField(player.getPostalCode());
            postalCodeBox.getChildren().addAll(postalCodeLabel,postalCodeField);

            HBox cityBox = new HBox(5);
            Label cityLabel = new Label("City");
            cityLabel.setMinWidth(75);
            TextField cityField = new TextField(player.getCity());
            cityBox.getChildren().addAll(cityLabel,cityField);

            HBox countryBox = new HBox(5);
            Label countryLabel = new Label("Country");
            countryLabel.setMinWidth(75);
            TextField countryField = new TextField(player.getCountry());
            countryBox.getChildren().addAll(countryLabel,countryField);



            vbox.getChildren().addAll(firstNameBox,lastNameBox,nicknameBox,emailBox);
            vbox2.getChildren().addAll(phoneNumberBox,streetAdressBox,postalCodeBox,cityBox,countryBox);

            Button saveButton = new Button("Save");
            gui.setButtonLayout(saveButton,6,150);
            saveButton.setLayoutY(400);
            gui.setColors(saveButton,5);
            saveButton.setOnAction(event1 -> {

                        Node lastChild = anchorPane.getChildren().get(anchorPane.getChildren().size() - 1);
                        if (lastChild instanceof Text) {
                            anchorPane.getChildren().remove(lastChild);
                        }

                        if(!firstNameField.getText().isEmpty()&&!lastNameField.getText().isEmpty()&&!nicknameField.getText().isEmpty()){

                            player.setFirstName(firstNameField.getText());
                            player.setLastName(lastNameField.getText());
                            player.setNickname(nicknameField.getText());
                            player.setEmail(emailField.getText());
                            player.setPhonenumber(phoneNumberField.getText());
                            player.setStreetAdress(streetAdressField.getText());
                            player.setPostalCode(postalCodeField.getText());
                            player.setCity(cityField.getText());
                            player.setCountry(countryField.getText());
                            try{
                                playerController.updatePlayer(player);
                                Text textsuccess = new Text("Successfully updated "+player.getFirstName()+"\n\""+player.getNickname()+"\"");
                                textsuccess.setLayoutX(710);
                                textsuccess.setLayoutY(300);
                                anchorPane.getChildren().addAll(textsuccess);
                                pause.setOnFinished(e -> anchorPane.getChildren().removeAll(textsuccess));
                                pause.playFromStart();

                            }catch (Exception ignored){}
                        }else {
                            Text textfail = new Text("Failed to update player\nMake sure required fields\n are filled out\n and that your inputs \naren't too long \n(rule of thumb 30 characters)");
                            textfail.setLayoutX(710);
                            textfail.setLayoutY(300);
                            anchorPane.getChildren().addAll(textfail);
                            pause.setOnFinished(e -> anchorPane.getChildren().removeAll(textfail));
                            pause.playFromStart();
                        };
                    }
            );

            PauseTransition pause2 = new PauseTransition(Duration.seconds(7));
            anchorPane.getChildren().addAll(text,vbox,vbox2,saveButton);
            pause.setOnFinished(e -> anchorPane.getChildren().remove(text));
            pause.playFromStart();

        } else {
            Text textfail = new Text("Please select a player to update");
            textfail.setLayoutX(650);
            textfail.setLayoutY(475);
            anchorPane.getChildren().add(textfail);
            pause.setOnFinished(e -> anchorPane.getChildren().remove(textfail));
            pause.playFromStart();
        }
    }

}
