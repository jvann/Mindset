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
    private int picture;

    public Event() {
        this.id = 0;
        this.date = null;
        this.hour = null;
        this.name = null;
        this.picture = 0;
    }

    public Event (String date, String hour, String name, int picture) {
        this.date = date;
        this.hour = hour;
        this.name = name;
        this.picture = picture;
    }

    public Event (long id, String date, String hour, String name, int picture) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.name = name;
        this.picture = picture;
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

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
