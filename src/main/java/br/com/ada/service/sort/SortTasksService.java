package br.com.ada.service.sort;

import br.com.ada.domain.BaseTask;

import java.util.List;

public interface SortTasksService<T extends BaseTask> {
    List<T> sortTasks(List<T> tasks);
}
