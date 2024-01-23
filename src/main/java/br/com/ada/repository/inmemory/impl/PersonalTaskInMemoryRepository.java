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

/*package br.com.ada.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.ada.domain.BaseTask;

public class InMemoryTaskRepository<T extends BaseTask> implements TaskRepository<T> {

    private List<T> tasks;
    private Integer nextId = 1;

    public InMemoryTaskRepository(){
        this.tasks = new ArrayList<>();
    }

    @Override
    public void createTask(T task) {
        task.setId(nextId);
        nextId++;
        this.tasks.add(task);
    }

    @Override
    public T getTaskById(Integer id) {
        return this.tasks.get(id);
    }

    @Override
    public List<T> getAllTasks() {
        return this.tasks;
    }

    @Override
    public void updateTask(T task) {
        int index = findTaskIndexById(task.getId());
        tasks.set(index, task);
    }

    @Override
    public void deleteTask(Integer id) {
        int index = findTaskIndexById(id);
        this.tasks.remove(index);
    }

    public int findTaskIndexById(Integer id){
        for(int i=0; i< tasks.size(); i++){
            if(tasks.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

}*/