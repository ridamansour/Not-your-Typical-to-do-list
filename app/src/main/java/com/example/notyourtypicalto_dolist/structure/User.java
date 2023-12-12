package com.example.notyourtypicalto_dolist.structure;

import java.util.List;

public class User {
    private String firstName;
    private String familyName;
    private String email;
    private List<Object> all; //areas and projects
    private Area Trash;
    private Area Today;
    private Area LogBook;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public List<Object> getAll() {
        return all;
    }

    public void setAll(List<Object> all) {
        this.all = all;
    }
}
