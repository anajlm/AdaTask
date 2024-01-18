package br.com.ada.controller;

import br.com.ada.service.TaskService;

import java.util.Scanner;

public class Controller {
    private TaskService taskService;

    public Controller(TaskService taskService){
        this.taskService = taskService;
    }

    public static void displayMainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione a operação desejada: ");
        System.out.println("1 - View tasks");
        System.out.println("2 - Create task");
        System.out.println("3 - Edit task");
        System.out.println("4 - Delete task");

        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                displayTasks();
            case 2:
                displayCreateTaskMenu();
            case 3:
                displayDeleteTaskMenu();
            default:
        }
    }

    public static void displayTasks(){


    }

    public static void displayCreateTaskMenu() {
        System.out.println("Which kind of task would you like do create?");
        System.out.println("1 - Work Task");
        System.out.println("2 - Study Task");
        System.out.println("3 - Personal Task");

        switch (option) {
            case 1:
                displayCreateWorkTaskMenu();
            case 2:
                displayCreateStudyTaskMenu();
            case 3:
                displayCreatePersonalTaskMenu();
            default:


        }
        //service.createTask
    }

    public static void displayCreateWorkTaskMenu(){

    }

    public static void displayCreateStudyTaskMenu(){

    }


    public static void  displayCreatePersonalTaskMenu(){

    }

    public static void displayDeleteTaskMenu(){
        System.out.println("Enter task id: ");

    }

}
