package br.com.ada;

import br.com.ada.controller.Controller;
import br.com.ada.repository.TaskRepository;
import br.com.ada.repository.TaskRepositoryImpl;
import br.com.ada.service.Service;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        TaskRepository taskRepository = new TaskRepositoryImpl();
        Service taskService = new Service(taskRepository);
        Controller controller = new Controller();

    }
}