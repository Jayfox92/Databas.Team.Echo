package com.example.databasteamecho.view;

public class DisplayItem {
    private String label;
    private String value;

    private Class<?> type;

    public DisplayItem(String label, String value,Class<?> type) {
        this.label = label;
        this.value = value;
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return label;
    }
}

