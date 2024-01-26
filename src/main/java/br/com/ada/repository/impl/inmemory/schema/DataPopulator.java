package br.com.ada.repository.inmemory;

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
        workTaskRepository.createTask(new WorkTask("Prepare presentation", Priority.HIGH, LocalDate.now().plusDays(1), "Client A"));
        workTaskRepository.createTask(new WorkTask("Code review", Priority.MEDIUM, LocalDate.now().plusDays(3), "Project B"));
        workTaskRepository.createTask(new WorkTask("Meeting with team", Priority.LOW, LocalDate.now().plusDays(9), "Project C"));
        workTaskRepository.createTask(new WorkTask("Submit project proposal", Priority.HIGH, LocalDate.now().plusDays(6), "Client B"));
    }

    private void populateStudyTaskRepository(){
        studyTaskRepository.createTask(new StudyTask("Complete homework", Priority.HIGH, LocalDate.now().plusDays(7), "Math"));
        studyTaskRepository.createTask(new StudyTask("Research paper", Priority.MEDIUM, LocalDate.now().plusDays(10), "History"));
        studyTaskRepository.createTask(new StudyTask("Study for exam", Priority.HIGH, LocalDate.now().plusDays(5), "Physics"));
        studyTaskRepository.createTask(new StudyTask("Read scientific articles", Priority.LOW, LocalDate.now().plusDays(20), "Biology"));
    }

    private void populatePersonalTaskRepository() {
        personalTaskRepository.createTask(new PersonalTask("Read a book", Priority.LOW));
        personalTaskRepository.createTask(new PersonalTask("Exercise", Priority.HIGH));
        personalTaskRepository.createTask(new PersonalTask("Watch a movie", Priority.MEDIUM));
        personalTaskRepository.createTask(new PersonalTask("Buy groceries", Priority.MEDIUM));
    }
}


