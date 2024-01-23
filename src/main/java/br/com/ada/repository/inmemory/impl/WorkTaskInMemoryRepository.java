package br.com.ada.repository.inmemory;

import br.com.ada.domain.WorkTask;
import br.com.ada.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class WorkTaskInMemoryRepository implements TaskRepository<WorkTask, Integer> {

    private final List<WorkTask> tasks;

    public WorkTaskInMemoryRepository() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public void createTask(WorkTask task) {
        tasks.add(task);
    }

    @Override
    public WorkTask getTaskById(Integer id) {
        return null;
    }

    @Override
    public List<WorkTask> getAllTasks() {
        return tasks;
    }

    @Override
    public void updateTask(WorkTask task) {

    }

    @Override
    public void deleteTask(Integer id) {
        tasks.remove(id);
    }
}
