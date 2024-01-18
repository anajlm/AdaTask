package br.com.ada.domain;

public class WorkTask extends BaseTask {


    @Override
    public void previewTask() {
        System.out.println(this.getPriority().getTextColor() + "WORK: " + this.getId() + " " + this.getDescription() + " ");
    }

    @Override
    public void displayTaskDetails() {

    }
}
