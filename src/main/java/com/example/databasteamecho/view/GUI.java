package com.example.databasteamecho.view;

import com.example.databasteamecho.controller.PlayerController;
import com.example.databasteamecho.model.Player;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GUI extends Application {
    private Stage primaryStage;
    PlayerController playerController;
    //private final PlayerController playerController = new PlayerController();
    public static void main(String[] args) {
        //PlayerData playerData = new PlayerData();
        //playerData.createPlayers();
        //playerController = new PlayerController();
        launch();
    }


    @Override
    public void start(Stage primaryStage) throws IOException {
    this.primaryStage = primaryStage;
    this.playerController = new PlayerController();

    firstScene();
    }


    public void firstScene(){
        primaryStage.setTitle("Piper Games");
        AnchorPane welcomePane = new AnchorPane();

        Text welcomeText = new Text ("Welcome to Piper Games administrative GUI");
        welcomeText.setLayoutX(100);
        welcomeText.setLayoutY(50);
        welcomeText.setStyle("-fx-fill: darkviolet; -fx-font-size: 36; -fz-font-weight: bold; -fx-font-style: italic;");

        Button exitButton = new Button("Quit");
        exitButton.setOnAction(event -> primaryStage.close());
        exitButton.setStyle("-fx-font-size: 18; -fx-background-color: #236cb3; -fx-text-fill: white");
        exitButton.setPrefWidth(150);
        exitButton.setLayoutY(500);
        exitButton.setLayoutX(380);

        exitButton.setOnMouseEntered(event -> exitButton.setStyle("-fx-font-size: 18; -fx-background-color: rgba(255,0,0,0.5); -fx-text-fill: white"));
        exitButton.setOnMouseExited(event -> exitButton.setStyle("-fx-font-size: 18; -fx-background-color: #236cb3; -fx-text-fill: white"));

        Button playerButton = new Button("Manage players");
        playerButton.setOnAction(event -> playerScene());
        playerButton.setStyle("-fx-font-size: 18; -fx-background-color: darkgreen; -fx-text-fill:white ");
        playerButton.setPrefWidth(150);
        playerButton.setLayoutY(150);
        playerButton.setLayoutX(125);

        playerButton.setOnMouseEntered(event -> playerButton.setStyle("-fx-font-size: 18; -fx-background-color: rgba(0,100,0,0.48); -fx-text-fill: white;"));
        playerButton.setOnMouseExited(event -> playerButton.setStyle("-fx-font-size: 18; -fx-background-color: darkgreen; -fx-text-fill: white;"));


        Button teamButton = new Button("Manage teams");
        teamButton.setStyle("-fx-font-size: 18; -fx-background-color: purple; -fx-text-fill:white ");
        teamButton.setPrefWidth(150);
        teamButton.setLayoutY(150);
        teamButton.setLayoutX(300);

        teamButton.setOnMouseEntered(event -> teamButton.setStyle("-fx-font-size: 18; -fx-background-color: rgba(128,0,128,0.5); -fx-text-fill: white;"));
        teamButton.setOnMouseExited(event -> teamButton.setStyle("-fx-font-size: 18; -fx-background-color: purple; -fx-text-fill: white;"));

        Button gameButton = new Button("Manage games");
        gameButton.setStyle("-fx-font-size: 18; -fx-background-color: maroon; -fx-text-fill:white ");
        gameButton.setPrefWidth(150);
        gameButton.setLayoutY(150);
        gameButton.setLayoutX(475);

        gameButton.setOnMouseEntered(event -> gameButton.setStyle("-fx-font-size: 18; -fx-background-color: rgba(128,0,0,0.5); -fx-text-fill: white;"));
        gameButton.setOnMouseExited(event -> gameButton.setStyle("-fx-font-size: 18; -fx-background-color: maroon; -fx-text-fill: white;"));

        Button matchButton = new Button("Manage matches");
        matchButton.setStyle("-fx-font-size: 18; -fx-background-color: slateblue; -fx-text-fill:white ");
        matchButton.setPrefWidth(150);
        matchButton.setLayoutY(150);
        matchButton.setLayoutX(650);

        matchButton.setOnMouseEntered(event -> matchButton.setStyle("-fx-font-size: 18; -fx-background-color: rgba(106,90,205,0.5); -fx-text-fill: white;"));
        matchButton.setOnMouseExited(event -> matchButton.setStyle("-fx-font-size: 18; -fx-background-color: slateblue; -fx-text-fill: white;"));


        Button staffButton = new Button("Manage staff");
        staffButton.setStyle("-fx-font-size: 18; -fx-background-color: teal; -fx-text-fill:white ");
        staffButton.setPrefWidth(150);
        staffButton.setLayoutY(275);
        staffButton.setLayoutX(380);

        staffButton.setOnMouseEntered(event -> staffButton.setStyle("-fx-font-size: 18; -fx-background-color: rgba(0,128,128,0.5); -fx-text-fill: white;"));
        staffButton.setOnMouseExited(event -> staffButton.setStyle("-fx-font-size: 18; -fx-background-color: teal; -fx-text-fill: white;"));




        welcomePane.getChildren().addAll(welcomeText, exitButton, playerButton,teamButton,gameButton,matchButton,staffButton);

        Scene welcomeScene = new Scene(welcomePane, 900, 600);
        primaryStage.setScene(welcomeScene);
        primaryStage.show();

    }

    public void playerScene(){
        AnchorPane anchorPane = new AnchorPane();

        Button playerButton = new Button("List players");
        playerButton.setStyle("-fx-font-size: 18; -fx-background-color: darkgreen; -fx-text-fill:white ");
        playerButton.setPrefWidth(150);
        playerButton.setLayoutY(150);
        playerButton.setLayoutX(125);

        playerButton.setOnMouseEntered(event -> playerButton.setStyle("-fx-font-size: 18; -fx-background-color: rgba(0,100,0,0.48); -fx-text-fill: white;"));
        playerButton.setOnMouseExited(event -> playerButton.setStyle("-fx-font-size: 18; -fx-background-color: darkgreen; -fx-text-fill: white;"));

        playerButton.setOnAction(event -> listPlayers());

        anchorPane.getChildren().addAll(playerButton);

        Scene playerScene = new Scene(anchorPane, 900, 600);
        primaryStage.setScene(playerScene);
        primaryStage.show();


    }

    public void listPlayers(){
        playerController.getAll(true);
    }


}