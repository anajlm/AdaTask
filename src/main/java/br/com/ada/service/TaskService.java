package br.com.ada.service;

import br.com.ada.domain.BaseTask;

import java.util.List;

/**
 * Interface for basic CRUD operations on tasks.
 * @param <T> The type of task entity.
 * @param <U> The type of task identifier.
 */
public interface TaskService<T extends BaseTask, U> {
    void addTask(T task) ;
    void editTask(T task);
    void deleteTask(U id);
    T getTaskById(U id);
    List<T> getAllTasks();
    void ensureTaskExists(U id);
}
