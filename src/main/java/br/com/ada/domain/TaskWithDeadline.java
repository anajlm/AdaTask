package br.com.ada.domain;

import br.com.ada.domain.enums.Priority;

import java.time.LocalDate;

/**
 * Abstract class extending BaseTask for tasks with a deadline.
 *
 * Introduces the deadline attribute, allowing tasks to have a specific date by which they need to be completed.
 *
 * Implements Comparable, an interface from Java that provides the method compareTo(). Here, compareTo() compares
 * the deadlines. This is used by Service layer to sort the tasks by deadline.
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

    /**
     * Compares this task's deadline with another task's deadline.
     * @param otherTask The other task to compare against.
     * @return A negative integer, zero, or a positive integer as this task's deadline is less than, equal to, or greater than the specified task's deadline.
     */
    @Override
    public int compareTo(TaskWithDeadline otherTask){
        return this.deadline.compareTo(otherTask.getDeadline());
    }


}
