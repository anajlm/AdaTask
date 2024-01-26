package br.com.ada.controller;

import br.com.ada.domain.FilterableTask;

import java.util.List;

public interface FilterableTaskController<T extends FilterableTask> {
    List<T> getTasksWithFilterApplied();
}
