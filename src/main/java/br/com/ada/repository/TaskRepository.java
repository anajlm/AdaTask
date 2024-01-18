package br.com.ada.repository;

import br.com.ada.domain.BaseTask;

import java.util.List;

public interface TaskRepository<T extends BaseTask> {
    void createTask(T task);
    T getTaskById(Integer id);
    List<T> getAllTasks();
    void updateTask(T task);
    void deleteTask(Integer id);
}
