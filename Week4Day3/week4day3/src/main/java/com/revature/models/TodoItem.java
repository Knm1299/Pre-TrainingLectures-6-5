package com.revature.models;

public class TodoItem {
    int id;
    String contents;


    public TodoItem(int id, String contents){
        this.id = id;
        this.contents = contents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String toString(){
        return "[" + id + ", " + contents + "]";
    }
}
