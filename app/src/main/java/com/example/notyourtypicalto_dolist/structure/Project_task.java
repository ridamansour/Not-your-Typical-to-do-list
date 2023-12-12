package com.example.notyourtypicalto_dolist.structure;

import java.util.ArrayList;
import java.util.List;

public class Project_task {



    private String title;
    private List<Object> projRes; //Objects need to be a list of tasks or/and headings
    private Integer progressPersentage;
    private Integer TaskCount;

    public Project_task() {
        this.projRes = new ArrayList<Object>();
        progressPersentage = 0;
        TaskCount = 0;

    }

    public Integer getProgressPersentage() {
        return progressPersentage;
    }

    public void setProgressPersentage(Integer progressPersentage) {
        this.progressPersentage = progressPersentage;
    }

    public List<Object> getProjRes() {
        return projRes;
    }

    public void setProjRes(List<Object> projRes) {
        this.projRes = projRes;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void addTask(Task task){
        projRes.add(task);
        TaskCount++;
    }
    public void editTask(Task task){
        projRes.add(task);
        TaskCount++;
    }
    public void addHeading(Heading heading){
        projRes.add(heading);
    }

}
