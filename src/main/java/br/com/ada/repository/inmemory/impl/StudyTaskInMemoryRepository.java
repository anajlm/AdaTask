package br.com.ada.repository.inmemory.impl;

import br.com.ada.domain.StudyTask;
import br.com.ada.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class StudyTaskInMemoryRepository implements TaskRepository<StudyTask, Integer> {

    private final List<StudyTask> tasks = new ArrayList<>();

    @Override
    public void createTask(StudyTask task) {
        this.tasks.add(task);
    }

    @Override
    public StudyTask getTaskById(Integer id) {
        return null;
    }

    @Override
    public List<StudyTask> getAllTasks() {
        return this.tasks;
    }

    @Override
    public void updateTask(StudyTask task) {

    }

    @Override
    public void deleteTask(Integer id) {
        tasks.remove(id);
    }
}
