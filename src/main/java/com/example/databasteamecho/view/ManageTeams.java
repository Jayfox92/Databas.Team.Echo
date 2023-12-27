package com.example.databasteamecho.view;

import com.example.databasteamecho.controller.PlayerController;
import com.example.databasteamecho.controller.TeamController;
import com.example.databasteamecho.model.Player;
import com.example.databasteamecho.model.Team;
import javafx.animation.PauseTransition;
import javafx.beans.property.ReadOnlyStringWrapper;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Abenezer
public class ManageTeams {
    private Stage primaryStage;

    private PlayerController playerController = new PlayerController();
    private TeamController teamController ;
    private GUI GUI =  new GUI();
    private Runnable onMainMenuRequested;

    private PauseTransition pauseTransition = new PauseTransition(Duration.seconds(3));


    public ManageTeams(Stage primaryStage, Runnable onMainMenuRequested, TeamController teamController) {
        this.primaryStage = primaryStage;
        this.onMainMenuRequested = onMainMenuRequested;
        this.teamController = teamController;
    }

    public void teamScene() { //Abenezer
        AnchorPane anchorPane = new AnchorPane();


        Button listTeamsButton = new Button("List teams");
        GUI.setButtonLayout(listTeamsButton, 1, 150);
        GUI.setColors(listTeamsButton, 1);
        listTeamsButton.setOnAction(event -> listTeamScene());

        Button addTeamButton = new Button("Add team");
        GUI.setButtonLayout(addTeamButton, 2, 150);
        GUI.setColors(addTeamButton, 2);
        addTeamButton.setOnAction(event -> addTeamScene());

        Button mainMenuButton = new Button("Main menu");
        GUI.setButtonLayout(mainMenuButton, 6, 150);
        GUI.setColors(mainMenuButton, 6);
        mainMenuButton.setLayoutX(125);
        mainMenuButton.setOnAction(event -> onMainMenuRequested.run());

        Button doneButton = new Button("Done");
        GUI.setButtonLayout(doneButton, 6, 150);
        doneButton.setVisible(false);
        doneButton.setOnAction(event -> teamScene());

        Button addPlayer = new Button("Add Player");
        GUI.setButtonLayout(addPlayer, 3, 150);
        GUI.setColors(addPlayer, 3);
        addPlayer.setOnAction(event -> showAddPlayerToTeamDialog(anchorPane));

        Button removePlayer = new Button("Remove Player");
        GUI.setButtonLayout(removePlayer, 4, 150);
        GUI.setColors(removePlayer, 4);
        removePlayer.setOnAction(event -> showRemovePlayerFromTeamDialog(anchorPane));

        anchorPane.getChildren().addAll(listTeamsButton, addTeamButton, mainMenuButton, doneButton, addPlayer,removePlayer);

        Scene teamScene = new Scene(anchorPane, 900, 600);
        primaryStage.setScene(teamScene);
        primaryStage.show();
    }

    public void listTeamScene() {

        AnchorPane anchorPane = new AnchorPane();

        Button listTeamsButton = new Button("List teams");
        GUI.setButtonLayout(listTeamsButton, 7, 150);
        GUI.setColors(listTeamsButton, 1);

        Button mainMenuButton = new Button("Main menu");
        GUI.setButtonLayout(mainMenuButton, 6, 150);
        GUI.setColors(mainMenuButton, 6);
        mainMenuButton.setLayoutX(125);
        mainMenuButton.setOnAction(event -> onMainMenuRequested.run());

        Button doneButton = new Button("Back");
        GUI.setButtonLayout(doneButton, 6, 150);
        GUI.setColors(doneButton, 6);
        doneButton.setLayoutX(300);
        doneButton.setOnAction(event -> teamScene());

        Button deleteTeamButton = new Button("Delete Team");
        GUI.setButtonLayout(deleteTeamButton,6,150);
        deleteTeamButton.setLayoutX(475);
        GUI.setColors(deleteTeamButton,3);
        deleteTeamButton.setOnAction(event -> deleteTeam(anchorPane));

        Button updateTeamButton = new Button("Update Team");
        GUI.setButtonLayout(updateTeamButton ,6,150);
        updateTeamButton .setLayoutX(650);
        GUI.setColors(updateTeamButton ,4);
        updateTeamButton.setVisible(false);

        Button generateButton = new Button("Generate");
        GUI.setButtonLayout(generateButton , 12, 150);
        GUI.setColors(generateButton , 4);


        final CheckComboBox<TeamDisplayItem> teamComboBox = new CheckComboBox<>();
        teamComboBox.getItems().addAll(new TeamDisplayItem("ID", "id", Integer.class ),
                new TeamDisplayItem("Team name", "teamName", String.class),
                new TeamDisplayItem("Game", "game.gameName", String.class));



        teamComboBox.setTitle("Choose columns");
        teamComboBox.setStyle("-fx-font-size: 18;");
        teamComboBox.setLayoutY(50);
        teamComboBox.setLayoutX(350);
        teamComboBox.setPrefWidth(200);

        generateButton.setOnAction(event -> generateTeamList(anchorPane, teamComboBox, updateTeamButton));
        anchorPane.getChildren().addAll(listTeamsButton, mainMenuButton, doneButton,teamComboBox,generateButton,deleteTeamButton,updateTeamButton);
        Scene listTeamScene = new Scene(anchorPane, 900, 600);
        primaryStage.setScene(listTeamScene);
        primaryStage.show ();

    }
    public void addTeamScene() {
        AnchorPane anchorPane = new AnchorPane();

        Button addTeamButton = new Button("Add team");
        GUI.setButtonLayout(addTeamButton, 7, 150);
        GUI.setColors(addTeamButton, 2);

        Button createButton = new Button("Create team");
        GUI.setButtonLayout(createButton, 10, 300);
        GUI.setColors(createButton, 4);
        createButton.setPrefHeight(65);

        Button mainMenuButton = new Button("Main menu");
        GUI.setButtonLayout(mainMenuButton, 6, 150);
        GUI.setColors(mainMenuButton, 6);
        mainMenuButton.setLayoutX(125);
        mainMenuButton.setOnAction(event -> onMainMenuRequested.run());

        Button doneButton = new Button("Back");
        GUI.setButtonLayout(doneButton, 6, 150);
        GUI.setColors(doneButton, 6);
        doneButton.setOnAction(event -> teamScene());



        TextField teamNameField = new TextField();
        teamNameField.setPromptText("Enter Team Name");

        VBox vbox = new VBox(10);
        vbox.setLayoutX(150);
        vbox.setLayoutY(225);

        HBox teamNameBox = new HBox(5);
        Label teamNameLabel = new Label("Team name:");
        teamNameLabel.setMinWidth(65);
        teamNameBox.getChildren().addAll(teamNameLabel, teamNameField);

        vbox.getChildren().add(teamNameBox);

        Button saveButton = new Button("Save");
        GUI.setButtonLayout(saveButton, 6, 150);
        saveButton.setLayoutY(400);
        GUI.setColors(saveButton, 5);
        saveButton.setOnAction(event1 -> {
            if (!teamNameField.getText().isEmpty()) {
                Team newTeam = new Team(teamNameField.getText());
                try {
                    teamController.addTeam(newTeam);
                    displayTemporaryMessage(anchorPane, "Team added successfully: " + newTeam.getTeamName(), 710, 300);
                } catch (Exception e) {
                    displayTemporaryMessage(anchorPane, "Failed to add team. Error: " + e.getMessage(), 710, 300);
                }
            } else {
                displayTemporaryMessage(anchorPane, "Please enter a team name", 710, 300);
            }
        });

        anchorPane.getChildren().addAll(addTeamButton, createButton, mainMenuButton, doneButton, vbox, saveButton);
        Scene addTeamScene = new Scene(anchorPane, 900, 600);
        primaryStage.setScene(addTeamScene);
        primaryStage.show();
    }





    public void generateTeamList(AnchorPane anchorPane, CheckComboBox<TeamDisplayItem> teamComboBox, Button updateButton) {

        anchorPane.getChildren().removeIf(node -> node instanceof TableView);
        anchorPane.getChildren().removeIf(node -> node instanceof HBox);
        anchorPane.getChildren().removeIf(node -> node instanceof VBox);

        TableView<Team> tableView = new TableView<>();
        updateButton.setVisible(true);

        ObservableList<TeamDisplayItem> teamDisplayList = teamComboBox.getCheckModel().getCheckedItems();
        for (TeamDisplayItem teamDisplayItem : teamDisplayList) {
            if (teamDisplayItem.getLabel().equals("Game")) {
                TableColumn<Team, String> gameColumn = createGameNameColumn("Game", "game.gameName");
                tableView.getColumns().add(gameColumn);
            } else {
                TableColumn<Team, ?> column = createTableColumn(teamDisplayItem.getLabel(), teamDisplayItem.getValue(), teamDisplayItem.getType());
                tableView.getColumns().add(column);
            }
        }

        List<Team> teamList = teamController.getAllTeams(false);
        ObservableList<Team> observableList = FXCollections.observableArrayList(teamList);
        tableView.setItems(observableList);

        tableView.setLayoutX(50);
        tableView.setLayoutY(100);
        tableView.setPrefHeight(teamList.size() * 35);
        tableView.setPrefWidth(teamDisplayList.size() * 100);
        tableView.setMinHeight(100);
        tableView.setMaxHeight(350);
        tableView.setMaxWidth(800);

        updateButton.setOnAction(event -> {
            Team selectedTeam = tableView.getSelectionModel().getSelectedItem();
            if (selectedTeam != null) {
                updateTeam(anchorPane, selectedTeam, tableView);
            }
        });

        anchorPane.getChildren().addAll(tableView);
    }



    private <E> TableColumn<E, String> createGameNameColumn(String label, String propertyName) {
        TableColumn<E, String> column = new TableColumn<>(label);
        column.setCellValueFactory(cellData -> {
            Team team = (Team) cellData.getValue();
            if (team.getGame() != null) {
                return new ReadOnlyStringWrapper(team.getGame().getGameName());
            }
            return new ReadOnlyStringWrapper("");
        });
        return column;
    }

    private <E,T> TableColumn<E, T> createTableColumn(String label, String propertyName, Class<T> type) {
        TableColumn<E, T> column = new TableColumn<>(label);

        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));

        return column;
    }



    public void deleteTeam(AnchorPane anchorPane) {
        TextField deleteText = new TextField();
        deleteText.setPromptText("Enter Team ID to delete");
        deleteText.setLayoutX(475);
        deleteText.setLayoutY(450);
        deleteText.setPrefWidth(140);

        EventHandler<KeyEvent> eventHandler = event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    int id = Integer.parseInt(deleteText.getText());
                    Team teamToDelete = teamController.getTeamById(id); // Fetch team details before deletion
                    if (teamToDelete != null && teamController.deleteTeamById(id)) {
                        String successMessage = "Successfully deleted team: " + teamToDelete.getTeamName();
                        displayTemporaryMessage(anchorPane, successMessage, 475, 435);
                    } else {
                        displayTemporaryMessage(anchorPane, "Failed to delete team", 475, 435);
                    }
                } catch (Exception e) {
                    displayTemporaryMessage(anchorPane, "Invalid input or team not found", 475, 435);
                }
            }
        };
        deleteText.addEventHandler(KeyEvent.KEY_PRESSED, eventHandler);
        anchorPane.getChildren().add(deleteText);
    }


    public void updateTeam(AnchorPane anchorPane, Team team, TableView<Team> tableView) {
        if (tableView.getSelectionModel().getSelectedItem() != null) {
            anchorPane.getChildren().removeIf(node -> node instanceof TableView);

            VBox vbox = new VBox(10);
            vbox.setLayoutX(150);
            vbox.setLayoutY(225);

            HBox teamNameBox = new HBox(5);
            Label teamNameLabel = new Label("Team name:");
            teamNameLabel.setMinWidth(65);
            TextField teamNameField = new TextField(team.getTeamName());
            teamNameBox.getChildren().addAll(teamNameLabel, teamNameField);

            vbox.getChildren().addAll(teamNameBox);

            Button saveButton = new Button("Save");
            GUI.setButtonLayout(saveButton, 6, 150);
            saveButton.setLayoutY(400);
            GUI.setColors(saveButton, 5);
            saveButton.setOnAction(event1 -> {
                if (!teamNameField.getText().isEmpty()) {
                    team.setTeamName(teamNameField.getText());
                    try {
                        teamController.updateTeam(team);
                        Team updatedTeam = teamController.getTeamById(team.getId());
                        String successMessage = "Team updated successfully: " + updatedTeam.getTeamName();
                        displayTemporaryMessage(anchorPane, successMessage, 710, 300);
                    } catch (Exception e) {
                        displayTemporaryMessage(anchorPane, "Update failed. Error: " + e.getMessage(), 710, 300);
                    }
                } else {
                    displayTemporaryMessage(anchorPane, "Please enter the name of the team in a text format", 710, 300);
                }
            });



            anchorPane.getChildren().addAll(vbox, saveButton);
        } else {
            displayTemporaryMessage(anchorPane, "Please select a team", 650, 375);
        }
    }



    private void showAddPlayerToTeamDialog(AnchorPane anchorPane) {
        ChoiceDialog<Team> teamDialog = new ChoiceDialog<>();
        teamDialog.setTitle("Add Player");
        teamDialog.setHeaderText("Select a Team");
        teamDialog.getItems().addAll(teamController.getAllTeams(false));

        teamDialog.showAndWait().ifPresent(team -> {
            if (team == null) {
                displayTemporaryMessage(anchorPane, "No team selected", 650, 375);
                return;
            }

            List<Player> availablePlayers = playerController.getAll(false)
                    .stream()
                    .filter(p -> p.getTeam() == null)
                    .collect(Collectors.toList());

            ChoiceDialog<Player> playerDialog = new ChoiceDialog<>();
            playerDialog.setTitle("Add Player to " + team.getTeamName());
            playerDialog.setHeaderText("Select a Player to Add");
            playerDialog.getItems().addAll(availablePlayers);

            playerDialog.showAndWait().ifPresent(player -> {
                if (player == null) {
                    displayTemporaryMessage(anchorPane, "No player selected", 650, 375);
                    return;
                }

                if (teamController.addPlayerToTeam(player.getId(), team.getId())) {
                    displayTemporaryMessage(anchorPane, "Player added successfully to " + team.getTeamName(), 650, 375);
                } else {
                    displayTemporaryMessage(anchorPane, "Failed to add player", 650, 375);
                }
            });
        });
    }




    private void showRemovePlayerFromTeamDialog(AnchorPane anchorPane) {
        ChoiceDialog<Team> teamDialog = new ChoiceDialog<>();
        teamDialog.setTitle("Remove Player");
        teamDialog.setHeaderText("Select a Team");
        teamDialog.getItems().addAll(teamController.getAllTeams(false));

        teamDialog.showAndWait().ifPresent(team -> {
            if (team == null) {
                displayTemporaryMessage(anchorPane, "No team selected", 650, 375);
                return;
            }

            List<Player> teamPlayers = new ArrayList<>(team.getPlayers());
            if (teamPlayers.isEmpty()) {
                displayTemporaryMessage(anchorPane, "No players in team", 650, 375);
                return;
            }

            ChoiceDialog<Player> playerDialog = new ChoiceDialog<>();
            playerDialog.setTitle("Remove Player from " + team.getTeamName());
            playerDialog.setHeaderText("Select a Player to Remove");
            playerDialog.getItems().addAll(teamPlayers);

            playerDialog.showAndWait().ifPresent(player -> {
                if (player == null) {
                    displayTemporaryMessage(anchorPane, "No player selected", 650, 375);
                    return;
                }

                if (teamController.removePlayerFromTeam(player.getId())) {
                    displayTemporaryMessage(anchorPane, "Player removed successfully from " + team.getTeamName(), 650, 375);
                } else {
                    displayTemporaryMessage(anchorPane, "Failed to remove player", 650, 375);
                }
            });
        });
    }


    private void displayTemporaryMessage(AnchorPane anchorPane, String message, double x, double y) {
        Text messageText = new Text(message);
        messageText.setLayoutX(x);
        messageText.setLayoutY(y);
        anchorPane.getChildren().add(messageText);
        pauseTransition.setOnFinished(e -> anchorPane.getChildren().remove(messageText));
        pauseTransition.playFromStart();
    }


}