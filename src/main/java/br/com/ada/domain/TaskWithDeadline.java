package br.com.ada.domain;

import br.com.ada.domain.enums.Priority;

import java.time.LocalDate;

public abstract class TaskWithDeadline extends BaseTask{

    LocalDate deadline;

    public TaskWithDeadline(String description, Priority priority, LocalDate deadline) {
        super(description, priority);
        this.deadline = deadline;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }


}
