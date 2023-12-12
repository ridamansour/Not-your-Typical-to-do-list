package com.example.notyourtypicalto_dolist.structure;

public class BaseTask {
    String taskName;
    Status status;

    public BaseTask(String taskName, Status status) {
        this.taskName = taskName;
        this.status = status;
    }
    public BaseTask(String taskName) {
        this.taskName = taskName;
        this.status = Status.Idle;
    }
    public BaseTask() {
        this.taskName = "";
        this.status = Status.Idle;
    }


    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



}
enum Status{
    Done,
    Canceled,
    Idle,
    Trashed
}