package br.com.ada.domain;

public class PersonalTask extends BaseTask {


    @Override
    public void previewTask() {
        System.out.println(this.getPriority().getTextColor() + "PERSONAL: " + this.getId() + " " + this.getDescription() + " ");
    }

    @Override
    public void displayTaskDetails() {

    }
}
