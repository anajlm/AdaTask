package br.com.ada.domain;

import br.com.ada.domain.enums.Priority;

public class StudyTask extends BaseTask {

    private String subject;

    public StudyTask(String description, Priority priority, String subject) {
        super(description, priority);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void displayTask() {
        System.out.println(this.getPriority().getTextColor() + "STUDY: " + this.getId() + " " + this.getDescription() + " " + this.getPriority() + " " + this.getSubject());
    }

}
