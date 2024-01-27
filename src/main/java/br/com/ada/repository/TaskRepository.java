package br.com.ada.repository;

import br.com.ada.domain.BaseTask;

import java.util.List;


/**
 * Interface providing methods for basic CRUD operations on tasks.
 * @param <T> The type of task entity.
 * @param <U> The type of task identifier.
 */
public interface TaskRepository<T extends BaseTask, U> {
    void createTask(T task);
    T getTaskById(U id);
    List<T> getAllTasks();
    void updateTask(T task);
    void deleteTask(U id);
}
