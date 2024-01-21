package br.com.ada;

import br.com.ada.domain.*;
import br.com.ada.repository.*;
import br.com.ada.repository.inmemory.*;
import br.com.ada.service.*;
import br.com.ada.service.impl.*;
import br.com.ada.controller.*;
import br.com.ada.controller.impl.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        TaskRepository<WorkTask, Integer> workTaskRepository = new WorkTaskInMemoryRepository();
        TaskService<WorkTask, Integer> workTaskService = new WorkTaskService(workTaskRepository);
        TaskController workTaskController = new WorkTaskControllerImpl(workTaskService);

        TaskRepository<StudyTask, Integer> studyTaskRepository = new StudyTaskInMemoryRepository();
        TaskService<StudyTask, Integer> studyTaskService = new StudyTaskService(studyTaskRepository);
        TaskController studyTaskController = new StudyTaskControllerImpl(studyTaskService);

        TaskRepository<PersonalTask, Integer> personalTaskRepository = new PersonalTaskInMemoryRepository();
        TaskService<PersonalTask, Integer> personalTaskService = new PersonalTaskService(personalTaskRepository);
        TaskController personalTaskController = new PersonalTaskControllerImpl(personalTaskService);


        ApplicationController controller = new ApplicationController(workTaskController, studyTaskController, personalTaskController);

        controller.run();

    }
}