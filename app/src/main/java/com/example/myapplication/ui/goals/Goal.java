package com.example.myapplication.ui.goals;

public class Goal {
    private String name;
    private String notes;

    public Goal(String name, String notes) {
        this.name = name;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public String getNotes() {
        return notes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
