package br.com.ada.controller;

import br.com.ada.domain.TaskWithDeadline;
import br.com.ada.domain.contracts.FilterableTask;

/**
 * Interface representing a controller for tasks with deadlines that are filterable based on specific criteria.
 * It extends both TaskWithDeadlineController and FilterableTaskController interfaces, combining functionality
 * for managing tasks with deadlines and supporting task filtering.
 *
 * @param <T> the type of tasks handled by the controller, which must extend TaskWithDeadline and implement FilterableTask.
 */
public interface FilterableTaskWithDeadlineController<T extends TaskWithDeadline & FilterableTask> extends TaskWithDeadlineController<T>, FilterableTaskController<T> {
}
