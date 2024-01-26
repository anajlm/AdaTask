package br.com.ada.controller.impl;

import br.com.ada.controller.TaskController;
import br.com.ada.domain.PersonalTask;
import br.com.ada.domain.enums.Priority;
import br.com.ada.service.*;

import java.util.Scanner;

public class PersonalTaskController implements TaskController {

    private final TaskService<PersonalTask, Integer> personalTaskService;

    private Scanner scanner;

    public PersonalTaskController(TaskService<PersonalTask, Integer> personalTaskService) {
        this.personalTaskService = personalTaskService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void createTask() {
        //scanner.nextLine();
        System.out.print("Enter the task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter the task priority (1-Low, 2-Medium, 3-High): ");
        Priority priority = readPriority();

        PersonalTask task = new PersonalTask(description, priority);
        personalTaskService.addTask(task);
        System.out.println("Personal Task created successfully.");
    }

    @Override
    public void deleteTask() {
        System.out.print("Enter the task id: ");
        int id = scanner.nextInt();
        personalTaskService.deleteTask(id);
        System.out.println("Personal Task deleted successfully.");
    }

    @Override
    public void editTask() {
        System.out.print("Enter the task id: ");
        int id = scanner.nextInt();
        PersonalTask taskToEdit = personalTaskService.getTaskById(id);

        System.out.print("Enter the new description: ");
        String newDescription = scanner.nextLine();

        System.out.print("Enter the new priority (1-Low, 2-Medium, 3-High): ");
        Priority newPriority = readPriority();

        taskToEdit.setDescription(newDescription);
        taskToEdit.setPriority(newPriority);

        personalTaskService.editTask(taskToEdit);
        System.out.println("Personal Task edited successfully.");
    }

    @Override
    public void displayTasks() {
        var tasks = personalTaskService.getAllTasks();
        for (PersonalTask task : tasks) {
            System.out.println(task.getPriority().getTextColor() + task.getId() + ": " + task.getDescription() + "\u001B[0m");
        }
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

    private void displayTaskMenu() {
        System.out.println("==== Personal Task Menu ====");
        System.out.println("1. View all personal tasks");
        System.out.println("2. Create personal task");
        System.out.println("3. Edit personal task");
        System.out.println("4. Delete personal task");
        System.out.print("Enter your choice: ");
    }
}