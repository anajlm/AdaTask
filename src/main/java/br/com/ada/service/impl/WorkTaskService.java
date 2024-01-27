package br.com.ada.service.impl;

import br.com.ada.domain.entities.WorkTask;
import br.com.ada.repository.TaskRepository;
import br.com.ada.service.FilterableTaskService;
import br.com.ada.service.TaskService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WorkTaskService implements TaskService<WorkTask, Integer>, FilterableTaskService<WorkTask, Integer, String> {

    private final TaskRepository<WorkTask, Integer> workTaskRepository;

    public WorkTaskService(TaskRepository<WorkTask, Integer> taskRepository){
        this.workTaskRepository = taskRepository;
    }

    @Override
    public void addTask(WorkTask task) {
        workTaskRepository.createTask(task);
    }

    @Override
    public void editTask(WorkTask task) {
        ensureTaskExists(task.getId());
        workTaskRepository.updateTask(task);
    }

    @Override
    public void deleteTask(Integer id) {
        ensureTaskExists(id);
        this.workTaskRepository.deleteTask(id);
    }

    @Override
    public WorkTask getTaskById(Integer id) {
        ensureTaskExists(id);
        return workTaskRepository.getTaskById(id);
    }

    @Override
    public List<WorkTask> getAllTasks() {
        var tasks = workTaskRepository.getAllTasks();
        Collections.sort(tasks);
        return tasks;
    }

    public void ensureTaskExists(Integer id){
        if (workTaskRepository.getTaskById(id) == null) {
            throw new IllegalArgumentException("Work task with ID " + id + " not found.");
        }
    }

    @Override
    public List<WorkTask> getTasksByFilter(String filter) {
        var tasks = getAllTasks();
        return tasks.stream()
                .filter(task -> task.getClient().equalsIgnoreCase(filter))
                .collect(Collectors.toList());
    }

}
