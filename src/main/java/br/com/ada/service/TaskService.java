package br.com.ada.service;

import br.com.ada.domain.BaseTask;
import br.com.ada.domain.WorkTask;
import br.com.ada.repository.TaskRepository;

import java.util.List;

public interface TaskService<T extends BaseTask, U> {
    void addTask(T task) ;
    void editTask(T task);
    void deleteTask(U id);
    T getTaskById(U id);
    List<T> getAllTasks();

}
