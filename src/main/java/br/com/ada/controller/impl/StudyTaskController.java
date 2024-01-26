package br.com.ada.controller.impl;

import br.com.ada.controller.FilterableTaskWithDeadlineController;
import br.com.ada.controller.TaskController;
import br.com.ada.controller.TaskWithDeadlineController;
import br.com.ada.domain.StudyTask;
import br.com.ada.domain.WorkTask;
import br.com.ada.domain.enums.Priority;
import br.com.ada.service.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class StudyTaskController implements FilterableTaskWithDeadlineController<StudyTask> {

    private final FilterableTaskService<StudyTask, Integer, String> studyTaskService;

    private Scanner scanner;

    public StudyTaskController(FilterableTaskService<StudyTask, Integer, String> studyTaskService) {
        this.studyTaskService = studyTaskService;
        this.scanner = new Scanner(System.in);
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

    @Override
    public void displayTasks() {
        System.out.println();
        System.out.println("==== Display Work Tasks ====");

        List<StudyTask> tasks = getTasksWithFilterApplied();

        if(tasks.isEmpty()){
            System.out.println("You don't have work tasks.");
            return;
        }

        for (StudyTask task : tasks) {
            printTask(task);
        }
        System.out.println();
    }

    @Override
    public void printTask(StudyTask task) {
        System.out.println(task.getPriority().getTextColor() + task.getId() + ": " + task.getDescription() + " | Subject: " + task.getSubject()  + " | Deadline: " + task.getDeadline() + "\u001B[0m");
    }

    @Override
    public void createTask() {
        System.out.println();
        System.out.println("==== Create Work Task ====");

        String description = readDescription();
        Priority priority = readPriority();
        LocalDate deadline = readDeadline();
        String subject = readSubject();

        studyTaskService.addTask(new StudyTask(description, priority, deadline, subject));
        System.out.println("Study Task created successfully.");
    }

    @Override
    public void deleteTask() {
        Integer id = readId();
        try {
            studyTaskService.deleteTask(id);
            System.out.println("Study Task deleted successfully.");
        } catch (IllegalArgumentException e){
            System.out.println("Unable to delete task: " + e.getMessage());
        }
    }

    @Override
    public void editTask() {
        System.out.println();
        System.out.println("==== Edit Study Task ====");

        Integer id = readId();
        try {
            StudyTask taskToEdit = studyTaskService.getTaskById(id);

            String description = readDescription();
            Priority priority = readPriority();
            String subject = readSubject();
            LocalDate deadline = readDeadline();

            taskToEdit.setDescription(description);
            taskToEdit.setPriority(priority);
            taskToEdit.setSubject(subject);
            taskToEdit.setDeadline(deadline);

            studyTaskService.editTask(taskToEdit);
            System.out.println("Study Task edited successfully.");
        } catch (IllegalArgumentException e){
            System.out.println("Unable to edit task: " + e.getMessage());
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

    private String readSubject() {
        return userInput.readString("Enter the task subject: ");
    }

    @Override
    public List<StudyTask> getTasksWithFilterApplied() {
        String subjectFilter = readSubjectFilter();
        if(subjectFilter.isEmpty()){
            return studyTaskService.getAllTasks();
        } else {
            return studyTaskService.getTasksByFilter(subjectFilter);
        }
    }

    public String readSubjectFilter(){
        return userInput.readString("Enter client to subject tasks (leave empty to display all): ");
    }
}