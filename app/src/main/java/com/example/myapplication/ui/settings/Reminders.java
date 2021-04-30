package com.example.myapplication.ui.settings;

public class Reminders {
    private final boolean sunday;
    private final boolean monday;
    private final boolean tuesday;
    private final boolean wednesday;
    private final boolean thursday;
    private final boolean friday;
    private final boolean saturday;
    private Integer hour;
    private String name;
    private Integer minute;

    public Reminders(String name, int hour, int minute, boolean sunday, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday) {
        this.name = name;
        this.hour = hour;
        this.minute = minute;
        this.sunday = sunday;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
    }

    public String getName() {
        return name;
    }

   public Integer getHour() {
       return hour;
   }

   public Integer getMinute() {
       return minute;
   }

   public boolean getSunday(){
       return sunday;
   }

    public boolean getMonday(){
        return monday;
    }

    public boolean getTuesday(){
        return tuesday;
    }

    public boolean getWednesday(){
        return wednesday;
    }

    public boolean getThrusday(){
        return thursday;
    }

    public boolean getFriday(){
        return friday;
    }

    public boolean getSaturday(){
        return saturday;
    }

    public void setName(String name) {
        this.name = name;
    }

   public void setHour(Integer hour) {
       this.hour = hour;
   }

   public void setMinute(Integer minute) {
       this.minute = minute;
   }

    //public boolean setSunday(boolean sunday){
    //    this.sunday = sunday;
    //}
//
    //public boolean setMonday(boolean monday){
    //    this.sunday = sunday;
    //}
//
    //public boolean setTuesday(boolean tuesday){
    //    return tuesday;
    //}
//
    //public boolean setWednesday(boolean wednesday){
    //    return wednesday;
    //}
//
    //public boolean setThrusday(boolean thursday){
    //    return thursday;
    //}
//
    //public boolean setFriday(boolean friday){
    //    return friday;
    //}
//
    //public boolean setSaturday(boolean saturday){
    //    return saturday;
    //}

}
