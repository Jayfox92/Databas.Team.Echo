package com.example.databasteamecho.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ManageTeams {
    private Stage primaryStage;

    private GUI GUI;
    private Runnable onMainMenuRequested; // Callback for returning to the main menu

    public ManageTeams(Stage primaryStage, Runnable onMainMenuRequested,GUI GUI) {
        this.primaryStage = primaryStage;
        this.onMainMenuRequested = onMainMenuRequested;
        this.GUI = GUI;
    }

    public void teamScene() { //Abenezer
        AnchorPane anchorPane = new AnchorPane();


        Button listTeamsButton = new Button("List teams");
        GUI.setButtonLayout(listTeamsButton, 1, 150);
        GUI.setColors(listTeamsButton, 1);
        Button addTeamButton = new Button("Add team");
        GUI.setButtonLayout(addTeamButton, 2, 150);
        GUI.setColors(addTeamButton, 2);

        Button deleteTeamButton = new Button("Delete team");
        GUI.setButtonLayout(deleteTeamButton, 3, 150);
        GUI.setColors(deleteTeamButton, 3);

        Button updateTeamButton = new Button("Update team");
        GUI.setButtonLayout(updateTeamButton, 4, 150);
        GUI.setColors(updateTeamButton, 4);

        Button mainMenuButton = new Button("Main menu");
        GUI.setButtonLayout(mainMenuButton, 6, 150);
        GUI.setColors(mainMenuButton, 6);
        mainMenuButton.setLayoutX(125);
        mainMenuButton.setOnAction(event -> onMainMenuRequested.run());

        Button doneButton = new Button("Done");
        GUI.setButtonLayout(doneButton, 6, 150);
        doneButton.setVisible(false);
        doneButton.setOnAction(event -> teamScene());

        anchorPane.getChildren().addAll(listTeamsButton, addTeamButton, deleteTeamButton, updateTeamButton, mainMenuButton, doneButton);

        Scene teamScene = new Scene(anchorPane, 900, 600);
        primaryStage.setScene(teamScene);
        primaryStage.show();
    }


}
