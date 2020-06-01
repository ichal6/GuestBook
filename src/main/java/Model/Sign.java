package Model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Sign {
    private int id;
    private String name;
    private Date date;
    private Time time;
    private String message;

    public Sign(int id, String name, Date date, Time time, String message) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.message = message;
    }

    public Sign(String name, Date date, Time time, String message) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public int getId(){
        return id;
    }

    public Time getTime() {
        return time;
    }
}
