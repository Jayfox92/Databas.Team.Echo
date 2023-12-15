module com.example.databasteamecho {
    requires javafx.controls;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires hibernate.entitymanager;
   // exports com.example.databasteamecho;
    exports com.example.databasteamecho.view;
    //opens com.example.databasteamecho.Entities to org.hibernate.orm.core;
}


