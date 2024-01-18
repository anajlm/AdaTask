package br.com.ada.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.ada.domain.BaseTask;

public class TaskRepositoryImpl<T extends BaseTask> implements TaskRepository<T, Integer> {

    private List<T> taskList;

    public TaskRepositoryImpl(){
        this.taskList = new ArrayList<>();
    }

    @Override
    public void createTask(T task) {
        this.taskList.add(task);
    }

    @Override
    public T readTask(Integer id) {
        return null;
    }

    @Override
    public void updateTask(T task) {

    }

    @Override
    public void deleteTask(Integer id) {
        this.taskList.remove(id);
    }
}
