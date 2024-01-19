package br.com.ada.service;

import br.com.ada.domain.BaseTask;
import br.com.ada.domain.WorkTask;
import br.com.ada.repository.TaskRepository;

import java.util.List;

public class TaskService<T extends BaseTask> {

    private final TaskRepository<T> taskRepository;

    public TaskService(TaskRepository<T> taskRepository){
        this.taskRepository = taskRepository;
    }

    public void addTask(T task) {
        taskRepository.createTask(task);
    }

    public void editTask(T task) {
        taskRepository.updateTask(task);
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteTask(id);
    }

    public T getTaskById(Integer id) { return taskRepository.getTaskById(id); }
    public List<T> getAllTasks(){
        return taskRepository.getAllTasks();
    }

    //sortTasksByDeadline();

}
