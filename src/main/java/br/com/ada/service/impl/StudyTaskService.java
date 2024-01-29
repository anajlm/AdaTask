package br.com.ada.service.impl;

import br.com.ada.domain.entities.StudyTask;
import br.com.ada.repository.TaskRepository;
import br.com.ada.service.FilterableTaskService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StudyTaskService implements FilterableTaskService<StudyTask, Integer, String> {

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
        ensureTaskExists(task.getId());
        studyTaskRepository.updateTask(task);
    }

    @Override
    public void deleteTask(Integer id) {
        ensureTaskExists(id);
        this.studyTaskRepository.deleteTask(id);
    }

    @Override
    public StudyTask getTaskById(Integer id) {
        ensureTaskExists(id);
        return studyTaskRepository.getTaskById(id);
    }

    @Override
    public List<StudyTask> getAllTasks() {
        var tasks = studyTaskRepository.getAllTasks();
        // Sort the tasks by deadline
        Collections.sort(tasks);
        return tasks;
    }

    @Override
    public void ensureTaskExists(Integer id) {
        if (studyTaskRepository.getTaskById(id) == null) {
            throw new IllegalArgumentException("Study task with ID " + id + " not found.");
        }
    }


    @Override
    public List<StudyTask> getTasksByFilter(String filter) {
        var tasks = getAllTasks();
        return tasks.stream()
                .filter(task -> task.getSubject().equalsIgnoreCase(filter))
                .collect(Collectors.toList());
    }
}
