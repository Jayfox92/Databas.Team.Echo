module com.example.databasteamecho {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.databasteamecho to javafx.fxml;
    exports com.example.databasteamecho;
}