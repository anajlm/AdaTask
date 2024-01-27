package br.com.ada.controller;

import br.com.ada.domain.contracts.FilterableTask;

import java.util.List;

/**
 * Interface defining the contract for filterable task controllers.
 */
public interface FilterableTaskController<T extends FilterableTask> {
    List<T> applyFilter();
}
