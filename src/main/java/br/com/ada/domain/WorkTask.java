package br.com.ada.domain;

import br.com.ada.domain.enums.Priority;

import java.util.Date;

public class WorkTask extends TaskWithDeadline {

    private String client;


    public WorkTask(String description, Priority priority, Date deadline, String client)  {
        super(description, priority, deadline);
        this.client = client;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Override
    public void displayTask() {
        System.out.println(this.getPriority().getTextColor() + this.getId() + " WORK: " + this.getDescription() + " | Client: " + this.getClient() + " | Deadline: " + this.getDeadline());
    }

}
