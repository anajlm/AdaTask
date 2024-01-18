package br.com.ada.Domain;

import java.util.Date;

public abstract class BaseTask { // priority (1 - 5)
    Integer id;
    String title;
    String description;
    Integer priority;
    Date deadline;

    public abstract void displayTaskDetails();
    public abstract void previewTask();
}
