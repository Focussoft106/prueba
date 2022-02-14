package com.jm.object;

public class Talk {

    private int durationInMinutes;
    private String title;

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public String getTitle() {
        return title;
    }

    public Talk(String title, int durationInMinutes)
    {
        this.durationInMinutes = durationInMinutes;
        this.title = title;
    }

}
