package br.com.ada.controller;

import br.com.ada.domain.FilterableTask;
import br.com.ada.domain.TaskWithDeadline;

public interface FilterableTaskWithDeadlineController<T extends TaskWithDeadline & FilterableTask> extends TaskWithDeadlineController<T>, FilterableTaskController<T> {
}
