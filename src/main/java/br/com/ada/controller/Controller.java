package br.com.ada.controller;

import br.com.ada.domain.*;
import br.com.ada.domain.enums.*;
import br.com.ada.service.*;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.List;

public class Controller {
    private final TaskService<BaseTask> taskService;

    Scanner scanner = new Scanner(System.in);

    public Controller(TaskService<BaseTask> taskService){
        this.taskService = taskService;
    }

    public void main(){
        System.out.println("Welcome to AdaTask!!!");
        System.out.println();

        displayMainMenu();
    }

    public void displayMainMenu(){


        while(true) {
            System.out.println("--------Main Menu--------");
            System.out.println("1 - View tasks");
            System.out.println("2 - Create task");
            System.out.println("3 - Edit task");
            System.out.println("4 - Delete task");

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
            }
        }
    }

    public void editTask(){
        System.out.println("Enter the id of task to edit: ");
        int id = scanner.nextInt();
        BaseTask task = taskService.getTaskById(id);

        System.out.println("Enter the new description: ");
        String newDescription = scanner.nextLine();

        System.out.println("Enter the new priority: ");
        Priority newPriority = readPriority();

        if(task instanceof TaskWithDeadline){
            Date deadline =
                    if ()
        } else if (task instanceof )

        taskService.editTask();
    }

    public void deleteTask(){
        System.out.println("Enter the id of task to delete: ");
        int id = scanner.nextInt();
        taskService.deleteTask(id);
    }

    public void displayTasks(){
        List<? extends BaseTask> tasks = this.taskService.getAllTasks();
        if(tasks.isEmpty()){
            System.out.println("Não há tarefas para mostrar.");
            return;
        }

        for (BaseTask task : tasks){
            task.displayTask();
        }
    }

    public void createTask() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which kind of task would you like do create?");
        System.out.println("1 - Work Task");
        System.out.println("2 - Study Task");
        System.out.println("3 - Personal Task");
        int option = scanner.nextInt();
        scanner.nextLine();


        System.out.println("Enter task description: ");
        String description = scanner.nextLine();

        System.out.println("Enter task ");

        Priority priority = readPriority();

        switch (option) {
            case 1:
                /*System.out.println("Enter the client's name: ");
                String client = scanner.nextLine();
                BaseTask workTask = new WorkTask(description, priority, client);
                taskService.addTask(workTask);*/
                createWorkTask(description, priority);
                break;
            case 2:
                /*System.out.println("Enter the subject: ");
                String subject = scanner.nextLine();
                BaseTask studyTask = new StudyTask(description, priority, subject);
                taskService.addTask(studyTask);*/
                createStudyClass(description, priority);
                break;
            case 3:
                /*BaseTask personalTask = new PersonalTask(description, priority);
                taskService.addTask(personalTask);*/
                createPersonalTask();
                break;
            default:
                System.out.println("error");

        }
        //service.createTask
    }

    public Priority readPriority(){
        Priority priority = null;
        while (priority == null){
            System.out.println("Priority (1 - Low, 2 - Medium, 3 - High): ");
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
        return priority;
    }
    public void displayCreateWorkTaskMenu(){

    }

    public static void displayCreateStudyTaskMenu(){

    }


    public static void  displayCreatePersonalTaskMenu(){

    }

    public static void displayDeleteTaskMenu(){
        System.out.println("Enter task id: ");

    }

}
