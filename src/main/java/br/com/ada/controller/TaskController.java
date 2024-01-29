package br.com.ada.controller;

import br.com.ada.domain.BaseTask;
import br.com.ada.domain.enums.Priority;
import br.com.ada.util.UserInput;

import java.util.Scanner;

/**
 * Interface providing methods for basic task operations such as creating, deleting, editing, and displaying tasks.
 * Also includes a method for running the task-specific menu.
 */
public interface TaskController<T extends BaseTask> {
    UserInput userInput = new UserInput();

    void run();
    void displayTasks();
    void printTask(T task);
    void createTask();
    void editTask();
    void deleteTask();

    default Priority readPriority(){
        Scanner scanner = new Scanner(System.in);

        Priority priority = null;

        int priorityChoice = userInput.readInt("Enter the task priority (1-Low, 2-Medium, 3-High): ");

        switch (priorityChoice) {
            case 1:
                priority = Priority.LOW;
                break;
            case 2:
                priority = Priority.MEDIUM;
                break;
            case 3:
                priority = Priority.HIGH;
                break;
            default:
                throw new IllegalArgumentException("Invalid priority choice.");
        }

        return priority;
    }

    default String readDescription(){
        return userInput.readString("Enter the task description: ");
    }

    default Integer readId(){
        return userInput.readInt("Enter the task id: ");
    }

}
