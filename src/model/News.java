package model;


import java.util.*;
import java.time.LocalDate;

public class News {
    private String title;
    private String text;
    private LocalDate date;

    public News(String title, String topic, String text, LocalDate date) {
        this.title = title;
        this.text = text;
        this.date = date;
    }
    public String getTitle() {
        return title;
    }

    // Setter for 'title'
    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    // Setter for 'text'
    public void setText(String text) {
        this.text = text;
    }
    // Getter for 'date'
    public LocalDate getDate() {
        return date;
    }

    // Setter for 'date'
    public void setDate(LocalDate date) {
        this.date = date;
    }

}
