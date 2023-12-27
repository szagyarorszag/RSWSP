package model;


import java.io.Serializable;
import java.util.*;
import java.time.LocalDate;

public class News implements Serializable {
    private String title;
    private String text;
    private LocalDate date;

    public News(String title,String text) {
        this.title = title;
        this.text = text;
        this.date = LocalDate.now();
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

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
