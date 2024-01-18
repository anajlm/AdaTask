package br.com.ada.Controller;

import br.com.ada.Repository.TaskRepository;
import br.com.ada.Repository.TaskRepositoryImpl;
import br.com.ada.Service.Service;

public class Controller {

    public static void main(String[] args) {

        TaskRepository taskRepository = new TaskRepositoryImpl();
        Service taskService = new Service(taskRepository);
    }
}
