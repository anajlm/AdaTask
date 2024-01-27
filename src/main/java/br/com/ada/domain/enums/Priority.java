package br.com.ada.domain.enums;

/**
 * Enum representing the priority levels of tasks.
 */
public enum Priority {

    LOW("\u001B[32m"), // green
    MEDIUM("\u001B[33m"), // yellow
    HIGH("\u001B[31m"); // red

    String textColor;

    Priority(String textColor) {
        this.textColor = textColor;
    }

    public String getTextColor(){
        return this.textColor;
    }
}
