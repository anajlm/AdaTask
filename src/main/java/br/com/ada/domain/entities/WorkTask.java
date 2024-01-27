package br.com.ada.domain;

import br.com.ada.domain.contracts.FilterableTask;
import br.com.ada.domain.enums.Priority;

import java.time.LocalDate;

public class WorkTask extends TaskWithDeadline implements FilterableTask {

    private String client;


    public WorkTask(String description, Priority priority, LocalDate deadline, String client)  {
        super(description, priority, deadline);
        this.client = client;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

}
