# AdaTask
Task Management Console App

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technical Implementation](#technical-implementation)
	- [Project Structure](#21-project-structure)
	- [Application Flow](#22-application-flow)
	- [Additional Considerations](#23-additional-considerations)
- [Usage](#usage)
- [Dependencies](#dependencies)
- [Contributing](#contributing)
- [License](#license)



## Overview

AdaTask is a simple console application for managing tasks. It allows users to create, edit, delete, and view personal, work and study tasks.



## Features

- **Task Creation**: Add new tasks with details such as title, description, deadline, etc.

- **Task Editing**: Update details of existing tasks.

- **Task Removal**: Delete existing tasks.

- **Task Viewing**: List all tasks or filter by specific criteria.



## Technical Implementation


### Project Structure

AdaTask follows a layered architecture design pattern, organizing its components into distinct layers, each with its specific responsibilities.


#### Domain Layer: 

Defines the structure and business rules for tasks. 

- `BaseTask`: Base entity containing common attributes.
- `TaskWithDeadline`: Abstract class extending `BaseTask` for tasks with a deadline. It introduces the `deadline` attribute, allowing tasks to have a specific date by which they need to be completed.


- **Contracts**
	- `FilterableTask`: Interface defining tasks that can be filtered based on specific criteria.

- **Enums**
	- Priority: defines the priority levels that can be assigned to tasks: LOW, MEDIUM, and HIGH.

- **Entities**
	- `PersonalTask`: Inherits from `BaseTask` for personal tasks.
	- `StudyTask`: Extends `TaskWithDeadline` and and implements FilterableTask. Represents study tasks. It includes a `subject` attribute, indicating the subject of study.
	- `WorkTask`: Extends `TaskWithDeadline` and implements FilterableTask. Represents work tasks. It includes a `client` attribute, indicating the client associated with the task.
	
	
#### Repository Layer: 

Manages data storage using in-memory lists for simplicity.

- `TaskRepository`: Interface to provide methods for basic CRUD operations (Create, Read, Update, Delete) on tasks. This interface is designed to handle various task types through generics.

- `PersonalTaskInMemoryRepository`, `StudyTaskInMemoryRepository`, and `WorkTaskInMemoryRepository`: Implement TaskRepository for personal, study, and work tasks. Each repository class provides implementations for creating, retrieving, updating, and deleting tasks specific to its type.


#### Service Layer: 

Implements application logic, including operations for task manipulation. Interacts with the Repository layer to perform data operations and serves as an intermediary between the Controller and Repository layers.

- `TaskService`: Interface for basic CRUD operations on tasks.

- `PersonalTaskService`, `StudyTaskService`, and `WorkTaskService`: Implement TaskService for personal, study, and work tasks, respectively, interacting with the corresponding repository.



#### Controller Layer: 

Manages user interaction via the console. Task-specific controllers process user input, execute corresponding actions, and display results in the console. They interact with the Service layer to perform tasks like creating, editing, deleting, and viewing tasks. Each controller is designed to handle a specific task type.

- `TaskController`: Interface that provides methods for basic task operations such as creating, deleting, editing, and displaying tasks. It also includes a method for running the task-specific menu.

- `TaskWithDeadlineController`: Interface extending TaskController, specifically for tasks with deadlines. It includes methods for handling deadline-related operations.

- `FilterableTaskController`: Interface for controllers that support task filtering based on specific criteria.

- `FilterableTaskWithDeadlineController`: Extends TaskWithDeadlineController and FilterableTaskController, combining functionality for tasks with deadlines and filtering capabilities.

- **Implementations**

	- `PersonalTaskController`: Implements the `TaskController` interface, providing task-specific implementations for task operations. 


	- `StudyTaskController` and `WorkTaskController`: Implements FilterableTaskWithDeadlineController for managing work tasks with deadlines. It supports filtering tasks by client and includes operations for task manipulation.


	- `MainController`: Serves as the main controller, managing the overall flow of the application. It interacts with the user, displays the main menu, and delegates control to the specific task controllers based on user input.


### Application Flow

- The application flow starts with the `MainController`, which displays the main menu and redirects to the corresponding task controller based on user input.
- Each task controller interacts with the user to perform operations on tasks by invoking methods from the corresponding service layer.

    
### Additional Considerations

- The project adheres to SOLID principles for clean and extensible design.

- Demonstrates the application of inheritance and generics in data structures and task manipulation operations.



## Usage


1. Ensure you have [IntelliJ IDEA](https://www.jetbrains.com/idea/) installed on your system. Open the project in IntelliJ and run the application by executing the `MainController` class. 

2. Upon running the application, you will be presented with a menu to select the task category (personal, study, or work).

<p align="center"><img src="img/main_menu.png" alt="Main Menu" ></p>
 
3. Choose an option to view tasks, create a new task, edit an existing task, or delete a task.
Follow the on-screen instructions to perform the desired operation.

<p align="center">
	<img src="img/work_task_menu.png" alt="Work Task Menu" >
	<img src="iimg/study_task_menu.png" alt="Study Task Menu" >
	<img src="img/personal_task_menu.png" alt="Personal Task Menu" >
</p>


## Dependencies 

The project does not have any external dependencies.

## Contributing

If you'd like to contribute to AdaTask, please fork the repository, create a new branch, make your changes, and submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).



