package br.com.ada.controller.impl;

import br.com.ada.controller.FilterableTaskWithDeadlineController;
import br.com.ada.domain.entities.WorkTask;
import br.com.ada.domain.enums.Priority;
import br.com.ada.service.FilterableTaskService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class WorkTaskController implements FilterableTaskWithDeadlineController<WorkTask> {

    private final FilterableTaskService<WorkTask, Integer, String> workTaskService;
    Scanner scanner;

    public WorkTaskController(FilterableTaskService<WorkTask, Integer, String> workTaskService){
        this.workTaskService = workTaskService;
        this.scanner = new Scanner(System.in);
    }

    public void run(){
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
        System.out.println("==== Display Work Tasks ====");

        List<WorkTask> tasks = applyFilter();

        if(tasks.isEmpty()){
            System.out.println("The research did not find any work tasks.");
            return;
        }

        for (WorkTask task : tasks) {
            printTask(task);
        }
        System.out.println();
    }

    public void printTask(WorkTask task){
        System.out.println(task.getPriority().getTextColor() + task.getId() + ": " + task.getDescription() + " | Client: " + task.getClient() + " | Deadline: " + task.getDeadline() + "\u001B[0m");
    }

    @Override
    public void createTask() {
        System.out.println();
        System.out.println("==== Create Work Task ====");

        String description = readDescription();
        Priority priority = readPriority();
        LocalDate deadline = readDeadline();
        String client = readClient();

        workTaskService.addTask(new WorkTask(description, priority, deadline, client));
        System.out.println("Work Task created successfully.");
    }

    @Override
    public void editTask() {
        System.out.println();
        System.out.println("==== Edit Work Task ====");

        Integer id = readId();
        try {
            WorkTask taskToEdit = workTaskService.getTaskById(id);

            String description = readDescription();
            Priority priority = readPriority();
            LocalDate deadline = readDeadline();
            String client = readClient();

            taskToEdit.setDescription(description);
            taskToEdit.setPriority(priority);
            taskToEdit.setClient(client);
            taskToEdit.setDeadline(deadline);

            workTaskService.editTask(taskToEdit);
            System.out.println("Work Task edited successfully.");
        } catch (IllegalArgumentException e){
            System.out.println("Unable to edit task: " + e.getMessage());
        }

    }

    @Override
    public void deleteTask() {
        System.out.println();
        System.out.println("==== Delete Work Task ====");

        Integer id = readId();
        try {
            workTaskService.deleteTask(id);
            System.out.println("Work Task deleted successfully.");
        } catch (IllegalArgumentException e){
            System.out.println("Unable to delete task: " + e.getMessage());
        }
    }



    // AUX METHODS
    public void displayTaskMenu(){
        System.out.println();
        System.out.println("==== Work Task Menu ====");
        System.out.println("1. View all work tasks");
        System.out.println("2. Create work task");
        System.out.println("3. Edit work task");
        System.out.println("4. Delete work task");
        System.out.println("Enter your choice: ");
    }

    public List<WorkTask> applyFilter(){
        String clientFilter = readClientFilter();
        if(clientFilter.isEmpty()){
            return workTaskService.getAllTasks();
        } else {
            return workTaskService.getTasksByFilter(clientFilter);
        }
    }

    // USER INPUT AND OUTPUT METHODS
    public String readClient(){
        return userInput.readString("Enter the client: ");
    }

    public String readClientFilter(){
         return userInput.readString("Enter client to filter tasks (leave empty to display all): ");
    }



}
