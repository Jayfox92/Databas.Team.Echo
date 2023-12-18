module com.example.databasteamecho {
    requires javafx.controls;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires hibernate.entitymanager;
    requires org.controlsfx.controls;
    exports com.example.databasteamecho.controller;
    exports com.example.databasteamecho.model;
    exports com.example.databasteamecho.view;
    opens com.example.databasteamecho.model to org.hibernate.orm.core;
}


