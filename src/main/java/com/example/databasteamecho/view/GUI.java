package com.example.databasteamecho.view;

import com.example.databasteamecho.controller.PlayerController;
import com.example.databasteamecho.model.Player;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.skin.ComboBoxPopupControl;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.controlsfx.control.CheckComboBox;

import javax.persistence.Entity;


public class GUI extends Application {
    private Stage primaryStage;
    PlayerController playerController;

    public static void main(String[] args) {

        launch();
    }


    @Override
    public void start(Stage primaryStage) throws IOException {
    this.primaryStage = primaryStage;
    this.playerController = new PlayerController();

    firstScene();
    }
    public void setButtonLayout(Button button, int choice, int widthDefault150){
        //upper row = 1,2,3,4
        //middle row = 5
        //lower row (quit, logout, back) ) = 6
        switch (choice){
            case 1:
                button.setPrefWidth(widthDefault150);
                button.setLayoutY(150);
                button.setLayoutX(125);
                break;
            case 2:
                button.setPrefWidth(widthDefault150);
                button.setLayoutY(150);
                button.setLayoutX(300);
                break;
            case 3:
                button.setPrefWidth(widthDefault150);
                button.setLayoutY(150);
                button.setLayoutX(475);
                break;
            case 4:
                button.setPrefWidth(widthDefault150);
                button.setLayoutY(150);
                button.setLayoutX(650);
                break;
            case 5:
                button.setPrefWidth(150);
                button.setLayoutY(275);
                button.setLayoutX(380);
                break;
            case 6:
                button.setPrefWidth(150);
                button.setLayoutY(500);
                button.setLayoutX(380);
                break;
            default:
                break;
        }
    }

    public void setColors(Node button,int choice){
        switch (choice){
            case 1:
                button.setStyle("-fx-font-size: 18; -fx-background-color: darkgreen; -fx-text-fill:white ");
                button.setOnMouseEntered(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: rgba(0,100,0,0.48); -fx-text-fill: white;"));
                button.setOnMouseExited(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: darkgreen; -fx-text-fill: white;"));
                break;
            case 2:
                button.setStyle("-fx-font-size: 18; -fx-background-color: purple; -fx-text-fill:white ");
                button.setOnMouseEntered(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: rgba(128,0,128,0.5); -fx-text-fill: white;"));
                button.setOnMouseExited(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: purple; -fx-text-fill: white;"));

                break;
            case 3:
                button.setStyle("-fx-font-size: 18; -fx-background-color: maroon; -fx-text-fill:white ");
                button.setOnMouseEntered(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: rgba(128,0,0,0.5); -fx-text-fill: white;"));
                button.setOnMouseExited(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: maroon; -fx-text-fill: white;"));

                break;
            case 4:
                button.setStyle("-fx-font-size: 18; -fx-background-color: slateblue; -fx-text-fill:white ");
                button.setOnMouseEntered(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: rgba(106,90,205,0.5); -fx-text-fill: white;"));
                button.setOnMouseExited(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: slateblue; -fx-text-fill: white;"));

                break;
            case 5:
                button.setStyle("-fx-font-size: 18; -fx-background-color: teal; -fx-text-fill:white ");
                button.setOnMouseEntered(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: rgba(0,128,128,0.5); -fx-text-fill: white;"));
                button.setOnMouseExited(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: teal; -fx-text-fill: white;"));

                break;
            case 6:
                button.setStyle("-fx-font-size: 18; -fx-background-color: #236cb3; -fx-text-fill: white");
                button.setOnMouseEntered(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: rgba(255,0,0,0.5); -fx-text-fill: white"));
                button.setOnMouseExited(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: #236cb3; -fx-text-fill: white"));

                break;
            default:
                break;
        }

    }


    public void firstScene(){
        primaryStage.setTitle("Piper Games");
        AnchorPane welcomePane = new AnchorPane();

        Text welcomeText = new Text ("Welcome to Piper Games administrative GUI");
        welcomeText.setLayoutX(100);
        welcomeText.setLayoutY(50);
        welcomeText.setStyle("-fx-fill: darkviolet; -fx-font-size: 36; -fz-font-weight: bold; -fx-font-style: italic;");

        Button playerButton = new Button("Manage players");
        playerButton.setOnAction(event -> playerScene());
        setButtonLayout(playerButton, 1, 150);
        setColors(playerButton,1);


        Button teamButton = new Button("Manage teams");
        setButtonLayout(teamButton, 2,150);
        setColors(teamButton,2);


        Button gameButton = new Button("Manage games");
        setButtonLayout(gameButton,3,150);
        setColors(gameButton,3);


        Button matchButton = new Button("Manage matches");
        setButtonLayout(matchButton,4,160);
        setColors(matchButton,4);


        Button staffButton = new Button("Manage staff");
        setButtonLayout(staffButton,5,160);
        setColors(staffButton,5);


        Button exitButton = new Button("Quit");
        exitButton.setOnAction(event -> primaryStage.close());
        setButtonLayout(exitButton,6,150);
        setColors(exitButton,6);



        welcomePane.getChildren().addAll(welcomeText, exitButton, playerButton,teamButton,gameButton,matchButton,staffButton);

        Scene welcomeScene = new Scene(welcomePane, 900, 600);
        primaryStage.setScene(welcomeScene);
        primaryStage.show();

    }

    public void playerScene(){
        AnchorPane anchorPane = new AnchorPane();

        Button listPlayersButton = new Button("List players");
        setButtonLayout(listPlayersButton,1,150);
        setColors(listPlayersButton,1);
        listPlayersButton.setOnAction(event -> listPlayerscene());

        Button addPlayerButton = new Button("Add player");
        setButtonLayout(addPlayerButton,2,150);
        setColors(addPlayerButton,2);
        addPlayerButton.setOnAction(event -> addPlayerScene());

        Button deletePlayerButton = new Button("Delete player");
        setButtonLayout(deletePlayerButton,3,150);
        setColors(deletePlayerButton,3);

        Button updatePlayerButton = new Button("Update player");
        setButtonLayout(updatePlayerButton,4,150);
        setColors(updatePlayerButton,4);

        Button mainMenuButton = new Button("Main menu");
        setButtonLayout(mainMenuButton,6,150);
        setColors(mainMenuButton,6);
        mainMenuButton.setLayoutX(125);
        mainMenuButton.setOnAction(event -> firstScene());







        anchorPane.getChildren().addAll(listPlayersButton, addPlayerButton,deletePlayerButton,updatePlayerButton,mainMenuButton);


        Scene playerScene = new Scene(anchorPane, 900, 600);
        primaryStage.setScene(playerScene);
        primaryStage.show();


    }

    public void listPlayerscene(){
        AnchorPane anchorPane = new AnchorPane();

        Button listPlayersButton = new Button("List players");
        setButtonLayout(listPlayersButton,1,150);
        setColors(listPlayersButton,1);

        Button mainMenuButton = new Button("Main menu");
        setButtonLayout(mainMenuButton,6,150);
        setColors(mainMenuButton,6);
        mainMenuButton.setLayoutX(125);
        mainMenuButton.setOnAction(event -> firstScene());

        Button doneButton = new Button("Done");
        setButtonLayout(doneButton,6,150);
        setColors(doneButton,6);
        doneButton.setOnAction(event -> playerScene());

        Button generateButton = new Button("Generate");
        setButtonLayout(generateButton,4,150);
        setColors(generateButton,4);




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
        checkComboBox.setLayoutY(150);
        checkComboBox.setLayoutX(350);
        checkComboBox.setPrefWidth(200);

        generateButton.setOnAction(event1 -> generatePlayerList(anchorPane, checkComboBox));


        anchorPane.getChildren().addAll(listPlayersButton,mainMenuButton,doneButton,checkComboBox,generateButton);
        Scene listPlayerscene = new Scene(anchorPane, 900, 600);
        primaryStage.setScene(listPlayerscene);
        primaryStage.show();
    }

    public void addPlayerScene(){
        AnchorPane anchorPane = new AnchorPane();

        Button addPlayerButton = new Button("Add player");
        setButtonLayout(addPlayerButton,1,150);
        setColors(addPlayerButton,2);

        Button createButton = new Button("Create new\n player");
        setButtonLayout(createButton,4,150);
        setColors(createButton,4);
        createButton.setPrefHeight(65);


        Button mainMenuButton = new Button("Main menu");
        setButtonLayout(mainMenuButton,6,150);
        setColors(mainMenuButton,6);
        mainMenuButton.setLayoutX(125);
        mainMenuButton.setOnAction(event -> firstScene());

        Button doneButton = new Button("Done");
        setButtonLayout(doneButton,6,150);
        setColors(doneButton,6);
        doneButton.setOnAction(event -> playerScene());



        EventHandler<MouseEvent> eventHandler = event -> {
            Text text = new Text("Note that first name, last name and nickname is required");
            text.setLayoutY(275);
            text.setLayoutX(300);
            setColors(text,3);
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
            saveButton.setOnAction(event1 -> {Player player = new Player(firstNameField.getText(),lastNameField.getText(),
                    nicknameField.getText(), emailField.getText(), phoneNumberField.getText(),
                    streetAdressField.getText(),postalCodeField.getText(),cityField.getText(),
                    countryField.getText()
                    );
                playerController.addPlayer(player);
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
    private <E,T> TableColumn<E, T> createTableColumn(String label,String propertyName,Class<T> type) {
        TableColumn<E, T> column = new TableColumn<>(label);

        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        column.setEditable(true);

        return column;
    }



}