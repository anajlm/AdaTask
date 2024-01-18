package br.com.ada.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.ada.domain.BaseTask;

public class TaskRepositoryImpl<T extends BaseTask> implements TaskRepository<T> {

    private List<T> taskList;

    public TaskRepositoryImpl(){
        this.taskList = new ArrayList<>();
    }

    @Override
    public void createTask(T task) {
        this.taskList.add(task);
    }

    @Override
    public T getTaskById(Integer id) {
        return this.taskList.get(id);
    }

    @Override
    public List<T> getAllTasks() {
        return this.taskList;
    }

    @Override
    public void updateTask(T task) {

    }

    @Override
    public void deleteTask(Integer id) {
        this.taskList.remove(id);
    }
}
