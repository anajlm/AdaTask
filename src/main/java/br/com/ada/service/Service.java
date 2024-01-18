package br.com.ada.service;

import br.com.ada.domain.BaseTask;
import br.com.ada.repository.TaskRepository;

public class Service<T extends BaseTask> {

    private final TaskRepository taskRepository;

    public Service(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    void addTask(T task) {
        taskRepository.createTask(task);
    }

    void editTask(T task) {
        taskRepository.updateTask(task);
    }

    void deleteTask(U id) {
        taskRepository.deleteTask(id);
    }
    void viewTask(T task){
        task.displayTaskDetails();
    }


    public <T> List<T> getAllTasks(){
        taskRepository.getAllTasks();
    }

    sortTasksFromAToZ();
    sortTasksFromOldestToNewest();

}
