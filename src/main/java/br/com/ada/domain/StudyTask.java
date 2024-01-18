package br.com.ada.domain;

public class StudyTask extends BaseTask {

    @Override
    public void previewTask() {
        System.out.println(this.getPriority().getTextColor() + "STUDY: " + this.getId() + " " + this.getDescription() + " " + this.getPriority());
    }

    @Override
    public void displayTaskDetails() {

    }
}
