package Model;

import java.sql.Date;

public class Sign {
    private int id;
    private String name;
    private Date date;
    private String message;

    public Sign(int id, String name, Date date, String message) {
        this.id = id;
        this.name = name;
        this.date = date;
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
}
