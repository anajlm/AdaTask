# AdaTask
Task Management Console App

## Table of Contents
1. [Overview](#overview)
2. [Technical Implementation](#technical-implementation)
3. [Project Structure](#project-structure)
4. [Additional Considerations](#additional-considerations)
5. [Usage](#usage)
6. [Dependencies](#dependencies)
7. [Contributing](#contributing)
8. [License](#license)


## Overview

AdaTask is a simple console application for managing tasks. It allows users to create, edit, delete, and view personal, work and study tasks.

## Technical Implementation

### Project Structure

The project is structured into different layers:


- **Domain Layer**: Defines the structure and business rules for tasks. 

- The `BaseTask` class serves as the base entity, containing common attributes.
- Subclass `PersonalTask` inherit from `BaseTask` and add specific details for study task type.
- The `TaskWithDeadline` abstract class extends `BaseTask` and represents tasks with a deadline. It introduces the `deadline` attribute, allowing tasks to have a specific date by which they need to be completed.
- The `WorkTask` class extends `TaskWithDeadline` and represents work tasks. It includes a `client` attribute, indicating the client associated with the task.
 - The `StudyTask` class also extends `TaskWithDeadline` and represents study tasks. It includes a `subject` attribute, indicating the subject of study.

- **Repository Layer**: Manages data storage. The repository layer uses the `TaskRepository` interface to provide methods for basic CRUD operations (Create, Read, Update, Delete) on tasks. It employs in-memory lists for simplicity. The repository is designed to handle various task types through generics.

The `TaskRepository` interface declares methods for basic CRUD operations on tasks.
`PersonalTaskInMemoryRepository`, `StudyTaskInMemoryRepository` and `WorkTaskInMemoryRepository` implements `TaskRepository` for personal tasks, study tasks and  work tasks, respectively, utilizing an in-memory list for data storage. 

Each repository class provides implementations for creating, retrieving, updating, and deleting tasks specific to its type.


- **Service Layer**: Implements application logic, including operations for task manipulation. Interacts with the Repository layer to perform data operations and serves as an intermediary between the Controller and Repository layers.

The `TaskService` interface declares methods for basic CRUD operations on tasks.
The `PersonalTaskService` class, `StudyTaskService` class and `WorkTaskService` class implements `TaskService` for personal tasks, study tasks and work tasks, respectively, interacting with the corresponding repository.
     

- **Controller Layer**: Manages user interaction via the console. Task-specific controllers process user input, execute corresponding actions, and display results in the console. They interact with the Service layer to perform tasks like creating, editing, deleting, and viewing tasks. Each controller is designed to handle a specific task type.

The `TaskController` interface declares methods for basic task operations such as creating, deleting, editing, and displaying tasks. It also includes a method for running the task-specific menu.

`PersonalTaskControllerImpl`, `StudyTaskControllerImpl`, and `WorkTaskControllerImpl` implement the `TaskController` interface, providing task-specific implementations for each type of task.

The `ApplicationController` class serves as the main controller, managing the overall flow of the application. It interacts with the user, displays the main menu, and delegates control to the specific task controllers based on user input.

Each task controller displays a specific menu for its type of task and provides implementations for task operations like creation, deletion, editing, and display.


### Application Flow

     - The application flow starts with the `ApplicationController`, which displays the main menu and redirects to the corresponding task controller based on user input.
     - Each task controller interacts with the user to perform operations on tasks by invoking methods from the corresponding service layer.
     - Task-specific controllers leverage the common `TaskController` interface, promoting consistency and maintainability.

    
### Additional Considerations

- The project adheres to SOLID principles for clean and extensible design.

- Demonstrates the application of inheritance and generics in data structures and task manipulation operations.


## Usage

Ensure you have [IntelliJ IDEA](https://www.jetbrains.com/idea/) installed on your system. Open the project in IntelliJ and run the application by executing the main class. 

Follow the on-screen instructions to interact with the application.



## Dependencies 

The project does not have any external dependencies.

## Contributing

If you'd like to contribute to AdaTask, please fork the repository, create a new branch, make your changes, and submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).




