package br.com.ada.domain;

import br.com.ada.domain.enums.Priority;

import java.util.Date;

public abstract class TaskWithDeadline extends BaseTask{

    Date deadline;

    public TaskWithDeadline(String description, Priority priority, Date deadline) {
        super(description, priority);
        this.deadline = deadline;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public abstract void displayTask();

}
