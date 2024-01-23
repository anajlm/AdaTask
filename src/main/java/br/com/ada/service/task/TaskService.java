package br.com.ada.service.task;

import br.com.ada.domain.BaseTask;

import java.util.List;

public interface TaskService<T extends BaseTask, U> {
    void addTask(T task) ;
    void editTask(T task);
    void deleteTask(U id);
    T getTaskById(U id);
    List<T> getAllTasks();

}
