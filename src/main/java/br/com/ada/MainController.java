package br.com.ada;

import br.com.ada.controller.*;
import br.com.ada.controller.impl.*;
import br.com.ada.domain.entities.*;
import br.com.ada.repository.TaskRepository;
import br.com.ada.repository.inmemory.*;
import br.com.ada.service.*;
import br.com.ada.service.impl.*;
import br.com.ada.util.DataPopulator;

import java.util.Scanner;

/**
 * The main controller class for the AdaTask application.
 * This class instantiates and manages the task controllers, repositories, and services.
 */
public class MainController {
    public static void main(String[] args) {

        // Instantiates Work Task Controller
        TaskRepository<WorkTask, Integer> workTaskRepository = new WorkTaskInMemoryRepository();
        FilterableTaskService<WorkTask, Integer, String> workTaskService = new WorkTaskService(workTaskRepository);
        FilterableTaskWithDeadlineController<WorkTask> workTaskController = new WorkTaskController(workTaskService);

        // Instantiates Study Task Controller
        TaskRepository<StudyTask, Integer> studyTaskRepository = new StudyTaskInMemoryRepository();
        FilterableTaskService<StudyTask, Integer, String> studyTaskService = new StudyTaskService(studyTaskRepository);
        FilterableTaskWithDeadlineController<StudyTask> studyTaskController = new StudyTaskController(studyTaskService);

        // Instantiates Personal Task Controller
        TaskRepository<PersonalTask, Integer> personalTaskRepository = new PersonalTaskInMemoryRepository();
        TaskService<PersonalTask, Integer> personalTaskService = new PersonalTaskService(personalTaskRepository);
        TaskController<PersonalTask> personalTaskController = new PersonalTaskController(personalTaskService);

        // Populates repositories with some tasks for testing purposes
        DataPopulator dataPopulator = new DataPopulator(workTaskRepository, studyTaskRepository, personalTaskRepository);
        dataPopulator.populateRepository();

        Scanner scanner = new Scanner(System.in);

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

    public static void displayMainMenu() {
        System.out.println("==== Main Menu ====");
        System.out.println("1. Work Tasks");
        System.out.println("2. Study Tasks");
        System.out.println("3. Personal Tasks");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
}