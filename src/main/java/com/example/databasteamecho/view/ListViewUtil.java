package com.example.databasteamecho.view;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.lang.reflect.Method;

public class ListViewUtil {

    public static <EntityType> Callback<ListView<EntityType>, ListCell<EntityType>> createGenericCellFactory(String propertyName) {
        return listView -> new ListCell<EntityType>() {
            @Override
            protected void updateItem(EntityType entity, boolean isEmptyCell) {
                super.updateItem(entity, isEmptyCell);
                if (isEmptyCell || entity == null) {
                    setText(null);
                } else {
                    try {
                        Method getterMethod = entity.getClass().getMethod("get" + capitalizeFirstLetter(propertyName));
                        Object propertyValue = getterMethod.invoke(entity);
                        setText(propertyValue.toString());
                    } catch (Exception e) {
                        setText("Error: " + e.getMessage());
                    }
                }
            }

            private String capitalizeFirstLetter(String string) {
                if (string == null || string.isEmpty()) {
                    return string;
                }
                return Character.toUpperCase(string.charAt(0)) + string.substring(1);
            }
        };
    }
}
