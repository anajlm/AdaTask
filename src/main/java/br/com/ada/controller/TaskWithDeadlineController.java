package br.com.ada.controller;

import br.com.ada.domain.TaskWithDeadline;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Interface defining the contract for task controllers that handle tasks with deadlines.
 *
 * @param <T> The type of tasks that this controller manages, which extends the `TaskWithDeadline` interface.
 */
public interface TaskWithDeadlineController<T extends TaskWithDeadline> extends TaskController<T> {
    default LocalDate readDeadline(){
        String date = userInput.readString("Enter the deadline (dd/MM/yyyy): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while(true) {
            try {
                return LocalDate.parse(date, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the deadline in the format dd/MM/yyyy: ");
            }
        }
    }

}
