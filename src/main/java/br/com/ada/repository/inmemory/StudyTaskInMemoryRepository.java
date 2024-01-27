package br.com.ada.repository.inmemory;

import br.com.ada.domain.entities.StudyTask;
import br.com.ada.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class StudyTaskInMemoryRepository implements TaskRepository<StudyTask, Integer> {

    private final List<StudyTask> tasks;
    private Integer nextId = 1;

    public StudyTaskInMemoryRepository(){
        this.tasks = new ArrayList<>();
    }

    @Override
    public void createTask(StudyTask task) {
        task.setId(nextId);
        nextId++;
        this.tasks.add(task);
    }

    @Override
    public StudyTask getTaskById(Integer id) {
        int index = findTaskIndexById(id);
        return this.tasks.get(index);
    }

    @Override
    public List<StudyTask> getAllTasks() {
        return this.tasks;
    }

    @Override
    public void updateTask(StudyTask task) {
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
