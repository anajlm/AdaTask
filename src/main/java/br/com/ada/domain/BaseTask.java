package br.com.ada.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import br.com.ada.domain.enums.Priority;

public abstract class BaseTask {
    private Integer id;
    private String description;
    private Priority priority;
    Date deadline;


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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }




}
