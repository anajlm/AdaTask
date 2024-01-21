package br.com.ada.controller.impl;

import br.com.ada.controller.TaskController;
import br.com.ada.domain.WorkTask;
import br.com.ada.domain.enums.Priority;
import br.com.ada.service.TaskService;

import java.time.LocalDate;
import java.util.Scanner;

public class WorkTaskControllerImpl implements TaskController {

    private final TaskService<WorkTask, Integer> workTaskService;
    Scanner scanner;

    public WorkTaskControllerImpl(TaskService<WorkTask, Integer> workTaskTaskService){
        this.workTaskService = workTaskTaskService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void createTask() {
        //scanner.nextLine();
        System.out.print("Enter the task description: ");
        String description = scanner.nextLine();
        System.out.println("Enter the task priority (1-Low, 2-Medium, 3-High): ");
        Priority priority = TaskController.readPriority();
        System.out.println("Enter the deadline: ");
        LocalDate deadline = LocalDate.now();
        scanner.nextLine();
        System.out.println("Enter the client: ");
        String client = scanner.nextLine();

        WorkTask task = new WorkTask(description, priority, deadline, client);
        workTaskService.addTask(task);
    }

    @Override
    public void deleteTask() {
        System.out.println("Enter the task id: ");
        int id = scanner.nextInt();
        workTaskService.deleteTask(id);
    }

    @Override
    public void editTask() {
        System.out.println();
        System.out.println("Enter the task id: ");
        Integer id = scanner.nextInt();
        WorkTask taskToEdit = workTaskService.getTaskById(id);

        System.out.println("Enter the new description: ");
        String description = scanner.nextLine();
        System.out.println("Enter the new deadline: ");
        Date deadline = new Date();
        System.out.println("Enter the new priority (1-Low, 2-Medium, 3-High): ");
        Priority priority = TaskController.readPriority();
        System.out.println("Enter the new client: ");
        String client = scanner.nextLine();

        taskToEdit.setDescription(description);
        taskToEdit.setPriority(priority);
        taskToEdit.setClient(client);
        taskToEdit.setDeadline(deadline);

        workTaskService.editTask(taskToEdit);

    }

    @Override
    public void displayTasks() {
        System.out.println();
        System.out.println("Work tasks: ");
        if(workTaskService.getAllTasks().size() == 0){
            System.out.println("You don't have work tasks.");
            return;
        }
        for (WorkTask task : workTaskService.getAllTasks()) {
            System.out.println(task.getPriority().getTextColor() + task.getId() + ": " + task.getDescription() + " | Client: " + task.getClient() + " | Deadline: " + task.getDeadline() + "\u001B[0m");
        }
        System.out.println();
    }

    public void run(){
        displayTaskMenu();
        int option = scanner.nextInt();
        scanner.nextLine();

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
    }

    public void displayTaskMenu(){
        System.out.println();
        System.out.println("==== Work Task Menu ====");
        System.out.println("1. View all work tasks");
        System.out.println("2. Create work task");
        System.out.println("3. Edit work task");
        System.out.println("4. Delete work task");
        System.out.println("Enter your choice: ");
    }

}
