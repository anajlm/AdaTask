package br.com.ada.repository.inmemory;

import br.com.ada.domain.entities.WorkTask;
import br.com.ada.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class WorkTaskInMemoryRepository implements TaskRepository<WorkTask, Integer> {

    private final List<WorkTask> tasks;
    private Integer nextId = 1;

    public WorkTaskInMemoryRepository() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public void createTask(WorkTask task) {
        task.setId(nextId);
        nextId++;
        tasks.add(task);
    }

    @Override
    public WorkTask getTaskById(Integer id) {
        int index = findTaskIndexById(id);
        if (index != -1) {
            return this.tasks.get(index);
        }
        return null;
    }

    @Override
    public List<WorkTask> getAllTasks() {
        return this.tasks;
    }

    @Override
    public void updateTask(WorkTask task) {
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
