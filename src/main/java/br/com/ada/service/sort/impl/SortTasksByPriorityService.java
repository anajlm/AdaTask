package br.com.ada.service.sort.impl;

import br.com.ada.domain.BaseTask;
import br.com.ada.service.sort.SortTasksService;

import java.util.Comparator;
import java.util.List;

public class SortTasksByPriorityService<T extends BaseTask> implements SortTasksService<T> {
    @Override
    public List<T> sortTasks(List<T> tasks) {
        tasks.sort(Comparator.comparing(BaseTask::getPriority));
        return tasks;
    }
}
