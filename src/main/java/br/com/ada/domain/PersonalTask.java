package br.com.ada.domain;

import br.com.ada.domain.enums.Priority;

public class PersonalTask extends BaseTask {

    public PersonalTask(String description, Priority priority) {
        super(description, priority);
    }

    @Override
    public void displayTask() {
        System.out.println(this.getPriority().getTextColor() +  this.getId() + " PERSONAL: " + this.getDescription());
    }


}
