package br.com.ada.controller;

import br.com.ada.domain.enums.Priority;

import java.util.Scanner;

public interface TaskController {

    void createTask();
    void deleteTask();
    void editTask();
    void displayTasks();
    void run();

    static Priority readPriority(){
        Scanner scanner = new Scanner(System.in);

        Priority priority = null;
        while (priority == null){
            int priorityChoice = scanner.nextInt();

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
                    System.out.println("Please choose a valid priority.");
            }
        }

        scanner.nextLine();
        return priority;
    }

}
