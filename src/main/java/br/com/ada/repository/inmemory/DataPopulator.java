package br.com.ada.repository;

import br.com.ada.domain.PersonalTask;
import br.com.ada.domain.StudyTask;
import br.com.ada.domain.WorkTask;
import br.com.ada.domain.enums.Priority;
import br.com.ada.repository.TaskRepository;

import java.time.LocalDate;

public class DataPopulator {

    TaskRepository<WorkTask, Integer> workTaskRepository;
    TaskRepository<StudyTask, Integer> studyTaskRepository;
    TaskRepository<PersonalTask, Integer> personalTaskRepository;

    public DataPopulator(TaskRepository<WorkTask, Integer> workTaskRepository, TaskRepository<StudyTask, Integer> studyTaskRepository, TaskRepository<PersonalTask, Integer> personalTaskRepository){
        this.workTaskRepository = workTaskRepository;
        this.studyTaskRepository = studyTaskRepository;
        this.personalTaskRepository = personalTaskRepository;
    }

    public void populateRepository(){
        populateWorkTaskRepository();
        populateStudyTaskRepository();
        populatePersonalTaskRepository();
    }

    private void populateWorkTaskRepository(){
        workTaskRepository.createTask(new WorkTask("Prepare presentation", Priority.HIGH, LocalDate.now(), "Client A"));
        workTaskRepository.createTask(new WorkTask("Code review", Priority.MEDIUM, LocalDate.now(), "Project B"));
        workTaskRepository.createTask(new WorkTask("Meeting with team", Priority.LOW, LocalDate.now(), "Project C"));
        workTaskRepository.createTask(new WorkTask("Submit project proposal", Priority.HIGH, LocalDate.now(), "Client B"));
    }

    private void populateStudyTaskRepository(){
        studyTaskRepository.createTask(new StudyTask("Complete homework", Priority.HIGH, LocalDate.now(), "Math"));
        studyTaskRepository.createTask(new StudyTask("Research paper", Priority.MEDIUM, LocalDate.now(), "History"));
        studyTaskRepository.createTask(new StudyTask("Study for exam", Priority.HIGH, LocalDate.now(), "Physics"));
        studyTaskRepository.createTask(new StudyTask("Read scientific articles", Priority.LOW, LocalDate.now(), "Biology"));
    }

    private void populatePersonalTaskRepository() {
        personalTaskRepository.createTask(new PersonalTask("Buy groceries", Priority.MEDIUM));
        personalTaskRepository.createTask(new PersonalTask("Read a book", Priority.LOW));
        personalTaskRepository.createTask(new PersonalTask("Exercise", Priority.HIGH));
        personalTaskRepository.createTask(new PersonalTask("Watch a movie", Priority.MEDIUM));
    }
}


