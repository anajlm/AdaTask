package br.com.ada.domain.entities;

import br.com.ada.domain.TaskWithDeadline;
import br.com.ada.domain.contracts.FilterableTask;
import br.com.ada.domain.enums.Priority;

import java.time.LocalDate;

public class StudyTask extends TaskWithDeadline implements FilterableTask {

    private String subject;

    public StudyTask(String description, Priority priority, LocalDate deadline, String subject) {
        super(description, priority, deadline);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


}
