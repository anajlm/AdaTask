package br.com.ada.Service;

import br.com.ada.Domain.BaseTask;
import br.com.ada.Repository.TaskRepository;

public class Service<T extends BaseTask> {

    private final TaskRepository taskRepository;

    public Service(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    void addTask(T task) {
        taskRepository.createTask(task);
    }

    void editTask() {
        taskRepository.updateTask(T);
    }

    void deleteTask(U id) {
        taskRepository.deleteTask(id);
    }
    void viewTask(T task){
        task.showTask();
    }


    getAllTasks(){
        taskRepository.getAll();
    }
    getWorkTasks();
    getStudyTasks();
    getPersonalTasks();

    sortTasksFromAToZ();
    sortTasksFromOldestToNewest();

}
