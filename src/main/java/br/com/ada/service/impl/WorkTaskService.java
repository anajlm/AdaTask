package br.com.ada.service.task.impl;

import br.com.ada.domain.WorkTask;
import br.com.ada.repository.TaskRepository;
import br.com.ada.service.task.TaskService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WorkTaskService implements TaskService<WorkTask, Integer> {

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
        workTaskRepository.updateTask(task);
    }

    @Override
    public void deleteTask(Integer id) {
        this.workTaskRepository.deleteTask(id);
    }

    @Override
    public WorkTask getTaskById(Integer id) {
        return workTaskRepository.getTaskById(id);
    }

    @Override
    public List<WorkTask> getAllTasks() {
        var tasks = workTaskRepository.getAllTasks();
        Collections.sort(tasks);
        return tasks;
    }

    public List<WorkTask> getTasksByClient(String client) {
        var tasks = workTaskRepository.getAllTasks();
        return tasks.stream()
                .filter(task -> task.getClient().equalsIgnoreCase(filter))
                .collect(Collectors.toList());
    }

}
