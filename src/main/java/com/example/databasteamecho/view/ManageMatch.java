package com.example.databasteamecho.view;

import com.example.databasteamecho.controller.MatchController;
import com.example.databasteamecho.model.Matches;
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


public class ManageMatch {
    private Stage primaryStage;

    private MatchController matchController;
    private GUI gui = new GUI();
    private Runnable guiCallback;

    public ManageMatch(Stage primaryStage,Runnable guiCallback,MatchController matchController) {
        this.primaryStage = primaryStage;
        this.guiCallback = guiCallback;
        this.matchController = matchController;
    }
    public void matchScene() {
        AnchorPane anchorPane = new AnchorPane();

        Button listMatchButton = new Button("List match");
        gui.setButtonLayout(listMatchButton, 1, 150);
        gui.setColors(listMatchButton,1);
        listMatchButton.setOnAction(event -> listMatchscene());

        Button addMatchButton = new Button("Add match");
        gui.setButtonLayout(addMatchButton, 1, 150);
        gui.setColors(addMatchButton,2);
        addMatchButton.setOnAction(event -> addMatchScene());

        Button deleteMatchButton = new Button("Delete match");
        gui.setButtonLayout(deleteMatchButton, 1, 150);
        gui.setColors(deleteMatchButton,3);
        deleteMatchButton.setOnAction(event -> deletMatchScene());

        Button updateMatchButton = new Button("Update match");
        gui.setButtonLayout(updateMatchButton, 1, 150);
        gui.setColors(updateMatchButton,4);
        updateMatchButton.setOnAction(event -> updateMatchScene());

        Button mainMenuButton = new Button("Main menu");
        gui.setButtonLayout(mainMenuButton, 6, 150);
        gui.setColors(mainMenuButton,6);
        mainMenuButton.setLayoutX(125);
        mainMenuButton.setOnAction(event -> guiCallback.run());

        /*Button doneButton = new Button("Done");
        gui.setButtonLayout(doneButton, 1, 150);
        doneButton.setVisible(false);
        doneButton.setOnAction(event -> matchScene());*/

        listMatchButton.setLayoutX(50);
        addMatchButton.setLayoutX(250);
        deleteMatchButton.setLayoutX(450);
        updateMatchButton.setLayoutX(650);
        mainMenuButton.setLayoutX(125);

        anchorPane.getChildren().addAll(listMatchButton, addMatchButton, deleteMatchButton, updateMatchButton, mainMenuButton);

        Scene matchScene = new Scene(anchorPane, 900, 600);
        primaryStage.setScene(matchScene);
        primaryStage.show();
    }

    public void listMatchscene(){
        AnchorPane anchorPane = new AnchorPane();

        Button listMatchButton = new Button("List matches");
        gui.setButtonLayout(listMatchButton,7,150);
        gui.setColors(listMatchButton,1);

        Button mainMenuButton = new Button("Main menu");
        gui.setButtonLayout(mainMenuButton,6,150);
        gui.setColors(mainMenuButton,6);
        mainMenuButton.setLayoutX(125);
        mainMenuButton.setOnAction(event -> guiCallback.run());

        Button doneButton = new Button("Back");
        gui.setButtonLayout(doneButton,6,150);
        gui.setColors(doneButton,6);
        doneButton.setLayoutX(300);
        doneButton.setOnAction(event -> matchScene());

        Button deleteMatchButton = new Button("Delete match");
        gui.setButtonLayout(deleteMatchButton,6,150);
        deleteMatchButton.setLayoutX(475);
        gui.setColors(deleteMatchButton,3);
        deleteMatchButton.setOnAction(event -> deleteMatch(anchorPane));

        Button updateMatchButton = new Button("Update match");
        gui.setButtonLayout(updateMatchButton,6,150);
        updateMatchButton.setLayoutX(650);
        gui.setColors(updateMatchButton,4);

        Button generateButton = new Button("Generate");
        gui.setButtonLayout(generateButton,10,150);
        gui.setColors(generateButton,4);

        final CheckComboBox<DisplayItem> checkComboBox = new CheckComboBox<>();
        checkComboBox.getItems().addAll(
                new DisplayItem("ID", "id", Integer.class),
                new DisplayItem("Result", "result", String.class),
                new DisplayItem("Match date", "matchDate",String.class),
                new DisplayItem("Match status", "matchStatus",String.class),
                new DisplayItem("Winner ID", "winnerId",String.class)
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


        generateButton.setOnAction(event1 -> generateMatchList(anchorPane, checkComboBox));


        anchorPane.getChildren().addAll(listMatchButton,mainMenuButton,doneButton,checkComboBox,generateButton,deleteMatchButton,updateMatchButton);
        Scene listMatchScene = new Scene(anchorPane, 900, 600);
        primaryStage.setScene(listMatchScene);
        primaryStage.show();

    }

    public void addMatchScene() {
        AnchorPane anchorPane = new AnchorPane();


        Button addMatchButton = new Button("Add Match");
        gui.setButtonLayout(addMatchButton, 1, 150);
        gui.setColors(addMatchButton, 2);

        Button createButton = new Button("Create new\n match");
        gui.setButtonLayout(createButton, 4, 150);
        gui.setColors(createButton, 4);
        createButton.setPrefHeight(65);


        Button mainMenuButton = new Button("Main menu");
        gui.setButtonLayout(mainMenuButton, 6, 150);
        gui.setColors(mainMenuButton, 6);
        mainMenuButton.setLayoutX(125);
        mainMenuButton.setOnAction(event -> guiCallback.run());

        Button doneButton = new Button("Back");
        gui.setButtonLayout(doneButton, 6, 150);
        gui.setColors(doneButton, 6);
        doneButton.setOnAction(event -> matchScene());

        EventHandler<MouseEvent> eventHandler = event -> {
            Text text = new Text();
            text.setLayoutY(275);
            text.setLayoutX(300);
            gui.setColors(text, 3);
            VBox vbox = new VBox(10);
            vbox.setLayoutX(150);
            vbox.setLayoutY(325);

            /*HBox matchIDBox = new HBox(5);
            Label matchIdLabel = new Label("Match ID");
            matchIdLabel.setMinWidth(65);
            TextField matchIdField = new TextField();
            matchIDBox.getChildren().addAll(matchIdLabel, matchIdField);*/

            HBox resultBox = new HBox(5);
            Label resultLabel = new Label("Result");
            resultLabel.setMinWidth(65);
            TextField resultField = new TextField();
            resultBox.getChildren().addAll(resultLabel, resultField);

            HBox matchDateBox = new HBox(5);
            Label matchDateLabel = new Label("Match date");
            matchDateLabel.setMinWidth(65);
            TextField matchDateField = new TextField();
            matchDateBox.getChildren().addAll(matchDateLabel, matchDateField);

            HBox matchStatusBox = new HBox(5);
            Label matchStatusLabel= new Label("Match status");
            matchStatusLabel.setMinWidth(65);
            TextField matchStatusField = new TextField();
            matchStatusBox.getChildren().addAll(matchStatusLabel, matchStatusField);

            HBox winnerIdBox = new HBox(5);
            Label winnerIdLabel = new Label("Winner ID");
            winnerIdLabel.setMinWidth(65);
            TextField winnerIdField = new TextField();
            winnerIdBox.getChildren().addAll(winnerIdLabel, winnerIdField);

            vbox.getChildren().addAll(resultBox, matchDateBox, matchStatusBox, winnerIdBox);

            Button saveButton = new Button("Save");
            saveButton.setLayoutX(750);
            saveButton.setLayoutY(375);
            saveButton.setOnAction(event1 -> {

                        Node lastChild = anchorPane.getChildren().get(anchorPane.getChildren().size() - 1);
                        if (lastChild instanceof Text) {
                            anchorPane.getChildren().remove(lastChild);
                        }

                        if (!resultField.getText().isEmpty() && !matchDateField.getText().isEmpty() && !winnerIdField.getText().isEmpty() && !matchStatusField.getText().isEmpty()) {
                            Matches matches = new Matches
                            (
                                            resultField.getText(), matchDateField.getText(),
                                            winnerIdField.getText(), matchStatusField.getText()
                            );
                            try {
                                matchController.addMatch(matches);
                                Text textsuccess = new Text("Successfully added " + matches.getId());
                                textsuccess.setLayoutX(720);
                                textsuccess.setLayoutY(420);
                                anchorPane.getChildren().addAll(textsuccess);
                            } catch (Exception ignored) {
                            }
                        } else {
                            Text textfail = new Text("Failed to add match\nMake sure required fields\n are filled out\n and that your inputs \naren't too long \n(rule of thumb 30 characters)");
                            textfail.setLayoutX(720);
                            textfail.setLayoutY(420);
                            anchorPane.getChildren().addAll(textfail);
                        }
                ;
                    }

            );


            anchorPane.getChildren().addAll(text, vbox, saveButton);
        };

        createButton.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);


        anchorPane.getChildren().addAll(createButton, mainMenuButton, doneButton);

        Scene addPlayerScene = new Scene(anchorPane, 900, 600);
        primaryStage.setScene(addPlayerScene);
        primaryStage.show();



    }

    public void deletMatchScene() {
        AnchorPane anchorPane = new AnchorPane();

        Button deleteMatchButton = new Button("Delete match");
        gui.setButtonLayout(deleteMatchButton, 1, 150);
        gui.setColors(deleteMatchButton,3);
        deleteMatchButton.setOnAction(event -> deleteMatch(anchorPane));

        Button mainMenuButton = new Button("Main menu");
        gui.setButtonLayout(mainMenuButton, 6, 150);
        gui.setColors(mainMenuButton, 6);
        mainMenuButton.setLayoutX(125);
        mainMenuButton.setOnAction(event -> guiCallback.run());

        anchorPane.getChildren().addAll(deleteMatchButton, mainMenuButton);

        Scene deleteMatchScene = new Scene(anchorPane, 900, 600);
        primaryStage.setScene(deleteMatchScene);
        primaryStage.show();

    }


    public void updateMatchScene() {

    }


    public void generateMatchList(AnchorPane anchorPane, CheckComboBox checkComboBox)  {
        anchorPane.getChildren().removeIf(node -> node instanceof TableView);
        TableView<Matches> tableView = new TableView<>();
        ObservableList<DisplayItem> displayList = checkComboBox.getCheckModel().getCheckedItems();
        for(DisplayItem displayItem:displayList){
            tableView.getColumns().add(createTableColumn(displayItem.getLabel(), displayItem.getValue(), displayItem.getType()));
        }

        List<Matches> matchList = matchController.getAll(false);

        ObservableList<Matches> observableList = FXCollections.observableList(matchList);
        tableView.setItems(observableList);

        tableView.setLayoutX(50);
        tableView.setLayoutY(100);
        tableView.setPrefHeight(matchList.size()*35);
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
    public void deleteMatch(AnchorPane anchorPane){
        TextField deleteText = new TextField();
        deleteText.setPromptText("Enter ID to delete");
        deleteText.setLayoutX(475);
        deleteText.setLayoutY(450);
        deleteText.setPrefWidth(120);
        PauseTransition pause = new PauseTransition(Duration.seconds(3));

        EventHandler<KeyEvent> eventHandler = event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    int id = Integer.parseInt(deleteText.getText());
                    if (matchController.deleteMatch(id)) {
                        Text textsuccess = new Text("Successfully deleted");
                        textsuccess.setLayoutX(475);
                        textsuccess.setLayoutY(435);
                        anchorPane.getChildren().addAll(textsuccess);
                        pause.setOnFinished(e -> anchorPane.getChildren().removeAll(textsuccess));
                        pause.playFromStart();

                    } else {
                        Text textfail = new Text("Failed to delete");
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
}

