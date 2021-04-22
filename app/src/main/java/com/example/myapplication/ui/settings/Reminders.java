package com.example.myapplication.ui.settings;

public class Reminders {
    private Integer hour;
    private String name;
    private Integer minute;

    public Reminders(String name) {
        this.name = name;
        //this.hour = hour;
        //this.minute = minute;
    }

    public String getName() {
        return name;
    }

   //public Integer getHour() {
   //    return hour;
   //}

   //public Integer getMinute() {
   //    return minute;
   //}

    public void setName(String name) {
        this.name = name;
    }

   //public void setHour(Integer hour) {
   //    this.hour = hour;
   //}

   //public void setMinute(Integer minute) {
   //    this.minute = minute;
   //}
}
