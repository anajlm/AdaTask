package br.com.ada.service.impl;

import br.com.ada.domain.PersonalTask;
import br.com.ada.domain.StudyTask;
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
        personalTaskRepository.updateTask(task);
    }

    @Override
    public void deleteTask(Integer id) {
        personalTaskRepository.deleteTask(id);
    }

    @Override
    public PersonalTask getTaskById(Integer id) {
        return personalTaskRepository.getTaskById(id);
    }

    @Override
    public List<PersonalTask> getAllTasks() {
        return personalTaskRepository.getAllTasks();
    }

}
