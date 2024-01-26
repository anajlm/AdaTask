package br.com.ada.service.task.impl;

import br.com.ada.domain.StudyTask;
import br.com.ada.repository.TaskRepository;
import br.com.ada.service.task.TaskService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StudyTaskService implements TaskService<StudyTask, Integer> {

    private final TaskRepository<StudyTask, Integer> studyTaskRepository;

    public StudyTaskService(TaskRepository taskRepository){
        this.studyTaskRepository = taskRepository;
    }

    @Override
    public void addTask(StudyTask task) {
        studyTaskRepository.createTask(task);
    }

    @Override
    public void editTask(StudyTask task) {
        studyTaskRepository.updateTask(task);
    }

    @Override
    public void deleteTask(Integer id) {
        this.studyTaskRepository.deleteTask(id);
    }

    @Override
    public StudyTask getTaskById(Integer id) {
        return studyTaskRepository.getTaskById(id);
    }

    @Override
    public List<StudyTask> getAllTasks() {
        var tasks = studyTaskRepository.getAllTasks();
        Collections.sort(tasks);
        return tasks;
    }

    public List<StudyTask> getTasksBySubject(String subject){
        var tasks = studyTaskRepository.getAllTasks();
        return tasks.stream()
                .filter(task -> task.getSubject().equalsIgnoreCase(subject))
                .collect(Collectors.toList());
    }


}
