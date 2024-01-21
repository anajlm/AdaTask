package br.com.ada.domain;

import java.util.Date;

import br.com.ada.domain.enums.Priority;

public abstract class BaseTask {
    private Integer id;
    private String description;
    private Priority priority;

    public BaseTask(String description, Priority priority) {
        this.description = description;
        this.priority = priority;
    }


    //textColor = task.getTextColor();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }


}
