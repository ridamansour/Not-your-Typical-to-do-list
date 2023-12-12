package com.example.notyourtypicalto_dolist.structure;

import java.util.List;

public class Area {
    private String title;
    private List<Object> group; // Tasks, projects, headings

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Object> getGroup() {
        return group;
    }

    public void setGroup(List<Object> group) {
        this.group = group;
    }



}
