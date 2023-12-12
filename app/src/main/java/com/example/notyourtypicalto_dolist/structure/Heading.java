package com.example.notyourtypicalto_dolist.structure;

public class Heading {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Heading(String text){
        this.text = text;
    }
    public Heading(){
        text ="";
    }

}
