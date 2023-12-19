package com.example.databasteamecho.view;

import com.example.databasteamecho.controller.PlayerController;
import com.example.databasteamecho.model.Player;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.skin.ComboBoxPopupControl;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
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
                button.setStyle("-fx-font-size: 18; -fx-background-color: darkgreen; -fx-text-fill:white ");
                button.setOnMouseEntered(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: rgba(0,100,0,0.48); -fx-text-fill: white;"));
                button.setOnMouseExited(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: darkgreen; -fx-text-fill: white;"));
                break;
            case 2:
                button.setPrefWidth(widthDefault150);
                button.setLayoutY(150);
                button.setLayoutX(300);
                button.setStyle("-fx-font-size: 18; -fx-background-color: purple; -fx-text-fill:white ");
                button.setOnMouseEntered(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: rgba(128,0,128,0.5); -fx-text-fill: white;"));
                button.setOnMouseExited(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: purple; -fx-text-fill: white;"));

                break;
            case 3:
                button.setPrefWidth(widthDefault150);
                button.setLayoutY(150);
                button.setLayoutX(475);
                button.setStyle("-fx-font-size: 18; -fx-background-color: maroon; -fx-text-fill:white ");
                button.setOnMouseEntered(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: rgba(128,0,0,0.5); -fx-text-fill: white;"));
                button.setOnMouseExited(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: maroon; -fx-text-fill: white;"));

                break;
            case 4:
                button.setPrefWidth(widthDefault150);
                button.setLayoutY(150);
                button.setLayoutX(650);
                button.setStyle("-fx-font-size: 18; -fx-background-color: slateblue; -fx-text-fill:white ");
                button.setOnMouseEntered(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: rgba(106,90,205,0.5); -fx-text-fill: white;"));
                button.setOnMouseExited(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: slateblue; -fx-text-fill: white;"));

                break;
            case 5:
                button.setPrefWidth(150);
                button.setLayoutY(275);
                button.setLayoutX(380);
                button.setStyle("-fx-font-size: 18; -fx-background-color: teal; -fx-text-fill:white ");
                button.setOnMouseEntered(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: rgba(0,128,128,0.5); -fx-text-fill: white;"));
                button.setOnMouseExited(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: teal; -fx-text-fill: white;"));

                break;
            case 6:
                button.setPrefWidth(150);
                button.setLayoutY(500);
                button.setLayoutX(380);
                button.setStyle("-fx-font-size: 18; -fx-background-color: #236cb3; -fx-text-fill: white");
                button.setOnMouseEntered(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: rgba(255,0,0,0.5); -fx-text-fill: white"));
                button.setOnMouseExited(event -> button.setStyle("-fx-font-size: 18; -fx-background-color: #236cb3; -fx-text-fill: white"));

                break;
            default:
                break;
        }
    }

    public void setTextLayout(int x){

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


        Button teamButton = new Button("Manage teams");
        setButtonLayout(teamButton, 2,150);


        Button gameButton = new Button("Manage games");
        setButtonLayout(gameButton,3,150);


        Button matchButton = new Button("Manage matches");
        setButtonLayout(matchButton,4,160);



        Button staffButton = new Button("Manage staff");
        setButtonLayout(staffButton,5,160);



        Button exitButton = new Button("Quit");
        exitButton.setOnAction(event -> primaryStage.close());
        setButtonLayout(exitButton,6,150);




        welcomePane.getChildren().addAll(welcomeText, exitButton, playerButton,teamButton,gameButton,matchButton,staffButton);

        Scene welcomeScene = new Scene(welcomePane, 900, 600);
        primaryStage.setScene(welcomeScene);
        primaryStage.show();

    }

    public void playerScene(){
        AnchorPane anchorPane = new AnchorPane();

        Button listPlayersButton = new Button("List players");
        setButtonLayout(listPlayersButton,1,150);


        Button addPlayerButton = new Button("Add player");
        setButtonLayout(addPlayerButton,2,150);

        Button deletePlayerButton = new Button("Delete player");
        setButtonLayout(deletePlayerButton,3,150);

        Button updatePlayerButton = new Button("Update player");
        setButtonLayout(updatePlayerButton,4,150);

        Button mainMenuButton = new Button("Main menu");
        setButtonLayout(mainMenuButton,6,150);
        mainMenuButton.setLayoutX(125);
        mainMenuButton.setOnAction(event -> firstScene());

        Button doneButton = new Button("Done");
        setButtonLayout(doneButton,6,150);
        doneButton.setVisible(false);
        doneButton.setOnAction(event -> playerScene());


        EventHandler<MouseEvent> eventHandlerList = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                doneButton.setVisible(true);
                addPlayerButton.setVisible(false);
                deletePlayerButton.setVisible(false);
                updatePlayerButton.setVisible(false);

                Button generateButton = new Button("Generate");
                setButtonLayout(generateButton,4,150);




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

                anchorPane.getChildren().addAll(checkComboBox,generateButton);
            }
        };
        listPlayersButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerList);
        listPlayersButton.setOnAction(event2 -> listPlayerscene(anchorPane));

        anchorPane.getChildren().addAll(listPlayersButton, addPlayerButton,deletePlayerButton,updatePlayerButton,mainMenuButton,doneButton);
        anchorPane.getChildren().retainAll(listPlayersButton, addPlayerButton,deletePlayerButton,updatePlayerButton,mainMenuButton,doneButton);



        Scene playerScene = new Scene(anchorPane, 900, 600);
        primaryStage.setScene(playerScene);
        primaryStage.show();


    }

    public void listPlayerscene(AnchorPane anchorPane){


        Button listPlayersButton = new Button("List players");
        setButtonLayout(listPlayersButton,1,150);


        Button addPlayerButton = new Button("Add player");
        setButtonLayout(addPlayerButton,2,150);

        Button deletePlayerButton = new Button("Delete player");
        setButtonLayout(deletePlayerButton,3,150);

        Button updatePlayerButton = new Button("Update player");
        setButtonLayout(updatePlayerButton,4,150);

        Button mainMenuButton = new Button("Main menu");
        setButtonLayout(mainMenuButton,6,150);
        mainMenuButton.setLayoutX(125);
        mainMenuButton.setOnAction(event -> firstScene());

        Button doneButton = new Button("Done");
        setButtonLayout(doneButton,6,150);
        doneButton.setVisible(false);
        doneButton.setOnAction(event -> playerScene());


        EventHandler<MouseEvent> eventHandlerList = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                doneButton.setVisible(true);
                addPlayerButton.setVisible(false);
                deletePlayerButton.setVisible(false);
                updatePlayerButton.setVisible(false);

                Button generateButton = new Button("Generate");
                setButtonLayout(generateButton,4,150);




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

                anchorPane.getChildren().addAll(checkComboBox,generateButton);
            }
        };
        listPlayersButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerList);


        Scene listPlayerscene = new Scene(anchorPane);
        primaryStage.setScene(listPlayerscene);
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