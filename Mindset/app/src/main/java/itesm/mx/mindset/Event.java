package itesm.mx.mindset;

import java.sql.Timestamp;

/**
 * Created by Jibril on 11/9/17.
 */

public class Event {

    private long id;
    private String date;
    private String hour;
    private String name;
    private String description;
    private int duration;
    private boolean completed;

    public Event() {
        this.id = 0;
        this.date = null;
        this.hour = null;
        this.name = null;
        this.description = null;
        this.duration = 0;
        this.completed = false;
    }

    public Event (String date, String hour, String name, String description, int duration, boolean completed) {
        this.date = date;
        this.hour = hour;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.completed = completed;
    }

    public Event (long id, String date, String hour, String name, String description, int duration, boolean completed) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.completed = completed;
    }

    public long getID() {
        return id;
    }

    public void setID(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() { return hour; }

    public void setHour(String hour) { this.hour = hour; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean getCompleted() {
        return completed;
    }

}
