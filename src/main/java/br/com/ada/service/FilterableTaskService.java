package br.com.ada.service;

import br.com.ada.domain.BaseTask;

import java.util.List;

/**
 * Interface defining the contract for filterable task services.
 * @param <T> The type of task.
 * @param <U> The type of task identifier.
 * @param <F> The type of filter.
 */
public interface FilterableTaskService<T extends BaseTask, U, F> extends TaskService<T, U> {
    List<T> getTasksByFilter(F filter);
}
