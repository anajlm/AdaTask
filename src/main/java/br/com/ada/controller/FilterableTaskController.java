package br.com.ada.controller;

import br.com.ada.domain.contracts.FilterableTask;

import java.util.List;

/**
 * Interface defining the contract for filterable task controllers.
 *
 * @param <T> The type of tasks that can be filtered. It extends the FilterableTask interface,
 * indicating that tasks of this type support filtering based on specific criteria.
 */
public interface FilterableTaskController<T extends FilterableTask> {
    List<T> applyFilter();
}
