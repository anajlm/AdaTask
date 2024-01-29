package br.com.ada.controller.impl;

import br.com.ada.controller.TaskController;
import br.com.ada.domain.entities.PersonalTask;
import br.com.ada.domain.enums.Priority;
import br.com.ada.service.TaskService;

import java.util.Scanner;

/**
 * Controller implementation for managing personal tasks.
 */
public class PersonalTaskController implements TaskController<PersonalTask> {

    private final TaskService<PersonalTask, Integer> personalTaskService;

    private Scanner scanner;

    public PersonalTaskController(TaskService<PersonalTask, Integer> personalTaskService) {
        this.personalTaskService = personalTaskService;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void run() {
        displayTaskMenu();
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                displayTasks();
                break;
            case 2:
                createTask();
                break;
            case 3:
                editTask();
                break;
            case 4:
                deleteTask();
                break;
            default:
                System.out.println("Please enter a valid option.");
        }
        scanner.nextLine();
    }


    @Override
    public void displayTasks() {
        System.out.println();
        System.out.println("==== Display Personal Tasks ====");

        var tasks = personalTaskService.getAllTasks();
        for (PersonalTask task : tasks) {
            printTask(task);
        }
    }

    @Override
    public void printTask(PersonalTask task) {
        System.out.println(task.getPriority().getTextColor() + task.getId() + ": " + task.getDescription() + "\u001B[0m");
    }

    @Override
    public void createTask() {
        System.out.println();
        System.out.println("==== Create Personal Task ====");

        String description = readDescription();
        Priority priority = readPriority();

        personalTaskService.addTask(new PersonalTask(description, priority));
        System.out.println("Personal Task created successfully.");
    }

    @Override
    public void editTask() {
        System.out.println();
        System.out.println("==== Edit Personal Task ====");

        Integer id = readId();

        try {
            PersonalTask taskToEdit = personalTaskService.getTaskById(id);

            String description = readDescription();
            Priority priority = readPriority();

            taskToEdit.setDescription(description);
            taskToEdit.setPriority(priority);

            personalTaskService.editTask(taskToEdit);
            System.out.println("Personal Task edited successfully.");
        } catch (IllegalArgumentException e){
            System.out.println("Unable to edit task: " + e.getMessage());
        }
    }

    @Override
    public void deleteTask() {
        System.out.println();
        System.out.println("==== Delete Personal Task ====");

        Integer id = readId();
        try {
            personalTaskService.deleteTask(id);
            System.out.println("Personal Task deleted successfully.");
        } catch (IllegalArgumentException e){
            System.out.println("Unable to delete task: " + e.getMessage());
        }
    }

    private void displayTaskMenu() {
        System.out.println();
        System.out.println("==== Personal Task Menu ====");
        System.out.println("1. View all personal tasks");
        System.out.println("2. Create personal task");
        System.out.println("3. Edit personal task");
        System.out.println("4. Delete personal task");
        System.out.print("Enter your choice: ");
    }
}