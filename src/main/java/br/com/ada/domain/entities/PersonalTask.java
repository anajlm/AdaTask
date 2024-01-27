package br.com.ada.domain.entities;

import br.com.ada.domain.BaseTask;
import br.com.ada.domain.enums.Priority;

public class PersonalTask extends BaseTask {

    public PersonalTask(String description, Priority priority) {
        super(description, priority);
    }


}
