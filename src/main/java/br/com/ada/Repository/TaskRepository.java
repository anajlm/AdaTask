package br.com.ada.Repository;

import br.com.ada.Domain.BaseTask;

public interface TaskRepository<T extends BaseTask, U> {
    void createTask(T task);
    T readTask(U id);
    void updateTask(T task);
    void deleteTask(U id);
}
