package br.com.ada.repository;

import br.com.ada.domain.BaseTask;

public interface TaskRepository<T extends BaseTask, U> {
    void createTask(T task);
    T readTask(U id);
    void updateTask(T task);
    void deleteTask(U id);
}
