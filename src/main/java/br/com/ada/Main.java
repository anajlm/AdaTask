package br.com.ada;

import br.com.ada.controller.Controller;
import br.com.ada.domain.BaseTask;
import br.com.ada.repository.TaskRepository;
import br.com.ada.repository.InMemoryTaskRepository;
import br.com.ada.service.TaskService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        TaskRepository<BaseTask> taskRepository = new InMemoryTaskRepository<>();
        TaskService<BaseTask> taskService = new TaskService<>(taskRepository);
        Controller controller = new Controller(taskService);

        controller.displayMainMenu();

    }
}