module com.example.databasteamecho {
    requires javafx.controls;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires hibernate.entitymanager;
    exports com.example.databasteamecho;
    opens com.example.databasteamecho.entities to org.hibernate.orm.core;
}


