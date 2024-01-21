package br.com.ada.controller;

import br.com.ada.domain.*;
import br.com.ada.domain.enums.*;
import br.com.ada.service.*;

import java.util.Date;
import java.util.Scanner;

public class ApplicationController {
    private final TaskController workTaskController;
    private final TaskController studyTaskController;
    private final TaskController personalTaskController;

    private final Scanner scanner;


    public ApplicationController(TaskController workTaskController, TaskController studyTaskController, TaskController personalTaskController){
        this.workTaskController = workTaskController;
        this.studyTaskController = studyTaskController;
        this.personalTaskController = personalTaskController;
        this.scanner = new Scanner(System.in);
    }


    public void run(){
        System.out.println("======= AdaTask =======");
        System.out.println();

        displayMainMenu();
        int option = scanner.nextInt();
        scanner.nextLine();

        while(true) {
            switch (option){
                case 1:
                    workTaskController.run();
                    break;
                case 2:
                    studyTaskController.run();
                    break;
                case 3:
                    personalTaskController.run();
                    break;
                case 4:
                    System.out.println("Exiting application...");
                    return;
                default:
                    System.out.println("Please enter a valid option.");
            }
        }
    }

    public void displayMainMenu() {

        System.out.println("==== Main Menu ====");
        System.out.println("1. Work Tasks");
        System.out.println("2. Study Tasks");
        System.out.println("3. Personal Tasks");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }


}
