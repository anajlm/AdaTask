package br.com.ada.domain;

import br.com.ada.domain.enums.Priority;

import java.time.LocalDate;

/**
 * Abstract class extending BaseTask for tasks with a deadline.
 * Introduces the deadline attribute, allowing tasks to have a specific date by which they need to be completed.
 */
public abstract class TaskWithDeadline extends BaseTask implements Comparable<TaskWithDeadline> {

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

    @Override
    public int compareTo(TaskWithDeadline otherTask){
        return this.deadline.compareTo(otherTask.getDeadline());
    }


}
