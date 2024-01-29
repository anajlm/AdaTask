package br.com.ada.repository.inmemory;

import br.com.ada.domain.entities.PersonalTask;
import br.com.ada.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonalTaskInMemoryRepository implements TaskRepository<PersonalTask, Integer> {

    private List<PersonalTask> tasks;
    private Integer nextId = 1;

    public PersonalTaskInMemoryRepository(){
        this.tasks = new ArrayList<>();
    }

    @Override
    public void createTask(PersonalTask task) {
        task.setId(nextId);
        nextId++;
        this.tasks.add(task);
    }

    @Override
    public PersonalTask getTaskById(Integer id) {
        int index = findTaskIndexById(id);
        if (index != -1) {
            return this.tasks.get(index);
        }
        return null;
    }

    @Override
    public List<PersonalTask> getAllTasks() {
        return this.tasks;
    }

    @Override
    public void updateTask(PersonalTask task) {
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
}