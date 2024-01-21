package br.com.ada.service.impl;

import br.com.ada.domain.WorkTask;
import br.com.ada.repository.TaskRepository;
import br.com.ada.service.TaskService;

import java.util.List;

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
        return workTaskRepository.getAllTasks();
    }


}
