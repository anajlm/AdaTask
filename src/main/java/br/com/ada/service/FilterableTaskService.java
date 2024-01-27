package br.com.ada.service;

import br.com.ada.domain.BaseTask;

import java.util.List;

/**
 * Interface defining the contract for filterable task services.
 */
public interface FilterableTaskService<T extends BaseTask, U, F> extends TaskService<T, U> {
    List<T> getTasksByFilter(F filter);
}
