package br.com.ada.service;

import br.com.ada.domain.BaseTask;
import br.com.ada.repository.TaskRepository;

import java.util.List;

public class TaskService<T extends BaseTask> {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    void addTask(T task) {
        taskRepository.createTask(task);
    }

    void editTask(T task) {
        taskRepository.updateTask(task);
    }

    void deleteTask(int id) {
        taskRepository.deleteTask(id);
    }

    public List<T> getAllTasks(){
        return taskRepository.getAllTasks();
    }

    //sortTasksFromAToZ();
    //sortTasksFromOldestToNewest();

}
