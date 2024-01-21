package br.com.ada.repository.inmemory;

import br.com.ada.domain.PersonalTask;
import br.com.ada.repository.TaskRepository;

import java.util.List;

public class PersonalTaskInMemoryRepository implements TaskRepository<PersonalTask, Integer> {

    @Override
    public void createTask(PersonalTask task) {

    }

    @Override
    public PersonalTask getTaskById(Integer id) {
        return null;
    }

    @Override
    public List<PersonalTask> getAllTasks() {
        return null;
    }

    @Override
    public void updateTask(PersonalTask task) {

    }

    @Override
    public void deleteTask(Integer id) {

    }
}
