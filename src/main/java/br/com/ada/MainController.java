package br.com.ada;

import br.com.ada.domain.*;
import br.com.ada.controller.*;
import br.com.ada.controller.impl.*;
import br.com.ada.repository.inmemory.DataPopulator;
import br.com.ada.repository.inmemory.impl.PersonalTaskInMemoryRepository;
import br.com.ada.repository.inmemory.impl.StudyTaskInMemoryRepository;
import br.com.ada.repository.TaskRepository;
import br.com.ada.repository.inmemory.impl.WorkTaskInMemoryRepository;
import br.com.ada.service.*;
import br.com.ada.service.impl.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        TaskRepository<WorkTask, Integer> workTaskRepository = new WorkTaskInMemoryRepository();
        FilterableTaskService<WorkTask, Integer, String> workTaskService = new WorkTaskService(workTaskRepository);
        TaskController workTaskController = new WorkTaskControllerImpl(workTaskService);

        TaskRepository<StudyTask, Integer> studyTaskRepository = new StudyTaskInMemoryRepository();
        FilterableTaskService<StudyTask, Integer, String> studyTaskService = new StudyTaskService(studyTaskRepository);
        TaskController studyTaskController = new StudyTaskControllerImpl(studyTaskService);

        TaskRepository<PersonalTask, Integer> personalTaskRepository = new PersonalTaskInMemoryRepository();
        TaskService<PersonalTask, Integer> personalTaskService = new PersonalTaskService(personalTaskRepository);
        TaskController personalTaskController = new PersonalTaskControllerImpl(personalTaskService);

        DataPopulator dataPopulator = new DataPopulator(workTaskRepository, studyTaskRepository, personalTaskRepository);
        dataPopulator.populateRepository();

        ApplicationController controller = new ApplicationController(workTaskController, studyTaskController, personalTaskController);

        controller.run();

    }
}