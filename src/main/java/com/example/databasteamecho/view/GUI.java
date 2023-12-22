package com.example.databasteamecho.view;

import com.example.databasteamecho.controller.GameController;
import com.example.databasteamecho.controller.MatchesController;
import com.example.databasteamecho.controller.PlayerController;
import com.example.databasteamecho.controller.TeamController;
import com.example.databasteamecho.model.Game;
import com.example.databasteamecho.model.Matches;
import com.example.databasteamecho.model.Player;
import com.example.databasteamecho.model.Team;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
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
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.controlsfx.control.CheckComboBox;


public class GUI extends Application {
    private Stage primaryStage;
    GameController gameController;
    MatchesController matchesController;
    PlayerController playerController;
    TeamController teamController;
    ManagePlayer managePlayer;

    public static void main(String[] args) {

        launch();
    }


    @Override
    public void start(Stage primaryStage) throws IOException {
    this.primaryStage = primaryStage;
    this.gameController = new GameController();
    this.matchesController = new MatchesController();
    this.playerController = new PlayerController();
    this.teamController = new TeamController();


    this.managePlayer = new ManagePlayer(primaryStage,this::firstScene,playerController);


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
            case 7:
                button.setPrefWidth(150);
                button.setLayoutY(50);
                button.setLayoutX(125);
                break;
            case 8:
                button.setPrefWidth(150);
                button.setLayoutY(50);
                button.setLayoutX(300);
                break;
            case 9:
                button.setPrefWidth(150);
                button.setLayoutY(50);
                button.setLayoutX(475);
                break;
            case 10:
                button.setPrefWidth(150);
                button.setLayoutY(50);
                button.setLayoutX(650);
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
        playerButton.setOnAction(event -> managePlayer.playerScene());
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




}