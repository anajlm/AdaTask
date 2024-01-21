package br.com.ada.domain;

import br.com.ada.domain.enums.Priority;

import java.util.Date;

public class StudyTask extends TaskWithDeadline {

    private String subject;

    public StudyTask(String description, Priority priority, Date deadline, String subject) {
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
