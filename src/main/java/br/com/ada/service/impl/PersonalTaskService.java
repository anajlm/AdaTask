package br.com.ada.service.impl;

import br.com.ada.domain.entities.PersonalTask;
import br.com.ada.repository.TaskRepository;
import br.com.ada.service.TaskService;

import java.util.List;

public class PersonalTaskService implements TaskService<PersonalTask, Integer> {

    private final TaskRepository<PersonalTask, Integer> personalTaskRepository;

    public  PersonalTaskService(TaskRepository<PersonalTask, Integer> personalTaskRepository){
        this.personalTaskRepository = personalTaskRepository;
    }

    @Override
    public void addTask(PersonalTask task) {
        personalTaskRepository.createTask(task);
    }

    @Override
    public void editTask(PersonalTask task) {
        ensureTaskExists(task.getId());
        personalTaskRepository.updateTask(task);
    }

    @Override
    public void deleteTask(Integer id) {
        ensureTaskExists(id);
        personalTaskRepository.deleteTask(id);
    }

    @Override
    public PersonalTask getTaskById(Integer id) {
        ensureTaskExists(id);
        return personalTaskRepository.getTaskById(id);
    }

    @Override
    public List<PersonalTask> getAllTasks() {
        return personalTaskRepository.getAllTasks();
    }

    @Override
    public void ensureTaskExists(Integer id) {
        if (personalTaskRepository.getTaskById(id) == null) {
            throw new IllegalArgumentException("Personal task with ID " + id + " not found.");
        }
    }

}
