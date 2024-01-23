package br.com.ada.service.sort.impl;

import br.com.ada.domain.TaskWithDeadline;
import br.com.ada.service.sort.SortTasksService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTasksByDeadlineService<T extends TaskWithDeadline> implements SortTasksService<T> {
    @Override
    public List<T> sortTasks(List<T> tasks) {
        Collections.sort(tasks);
        return tasks;
    }
}
