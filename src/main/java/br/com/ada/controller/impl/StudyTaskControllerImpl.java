package br.com.ada.controller.impl;

import br.com.ada.controller.TaskController;
import br.com.ada.domain.StudyTask;
import br.com.ada.domain.enums.Priority;
import br.com.ada.service.TaskService;

import java.util.Date;
import java.util.Scanner;

public class StudyTaskControllerImpl implements TaskController {

    private final TaskService<StudyTask, Integer> studyTaskService;
    private Scanner scanner;

    public StudyTaskControllerImpl(TaskService<StudyTask, Integer> studyTaskService) {
        this.studyTaskService = studyTaskService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void createTask() {
        System.out.print("Enter the task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter the task priority (1-Low, 2-Medium, 3-High): ");
        Priority priority = TaskController.readPriority();
        System.out.print("Enter the deadline: ");
        Date deadline = new Date();
        System.out.print("Enter the subject: ");
        String subject = scanner.nextLine();

        StudyTask task = new StudyTask(description, priority, deadline, subject);
        studyTaskService.addTask(task);
        System.out.println("Study Task created successfully.");
    }

    @Override
    public void deleteTask() {
        System.out.print("Enter the task id: ");
        int id = scanner.nextInt();
        studyTaskService.deleteTask(id);
        System.out.println("Study Task deleted successfully.");
    }

    @Override
    public void editTask() {
        System.out.print("Enter the task id: ");
        int id = scanner.nextInt();
        StudyTask taskToEdit = studyTaskService.getTaskById(id);

        System.out.print("Enter the new description: ");
        String newDescription = scanner.nextLine();
        System.out.print("Enter the new priority (1-Low, 2-Medium, 3-High): ");
        Priority newPriority = TaskController.readPriority();
        System.out.print("Enter the new subject: ");
        String newSubject = scanner.nextLine();

        taskToEdit.setDescription(newDescription);
        taskToEdit.setPriority(newPriority);
        taskToEdit.setSubject(newSubject);

        studyTaskService.editTask(taskToEdit);
        System.out.println("Study Task edited successfully.");
    }

    @Override
    public void displayTasks() {
        for (StudyTask task : studyTaskService.getAllTasks()) {
            System.out.println(task.getPriority().getTextColor() + task.getId() + ": " + task.getDescription() + " | Deadline: " + task.getDeadline() + " | Subject: " + task.getSubject() + "\u001B[0m");
        }
    }

    @Override
    public void run() {
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

    private void displayTaskMenu() {
        System.out.println();
        System.out.println("==== Study Task Menu ====");
        System.out.println("1. View all study tasks");
        System.out.println("2. Create study task");
        System.out.println("3. Edit study task");
        System.out.println("4. Delete study task");
        System.out.print("Enter your choice: ");
    }
}