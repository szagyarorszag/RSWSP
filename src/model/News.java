package model;


import java.util.*;
import java.time.LocalDate;

public class News {
    private String title;
    private String topic;
    private String text;
    private Vector<String> comments;
    private LocalDate date;

    public News(String title, String topic, String text, LocalDate date) {
        this.title = title;
        this.topic = topic;
        this.text = text;
        this.date = date;
        this.comments = new Vector<>();
    }
    public String getTitle() {
        return title;
    }

    // Setter for 'title'
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for 'topic'
    public String getTopic() {
        return topic;
    }

    // Setter for 'topic'
    public void setTopic(String topic) {
        this.topic = topic;
    }

    // Getter for 'text'
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
    public void addComment(String comment) {
        comments.add(comment);
    }


    public int compareTo(News news){
        if(news.getTopic().equals("Research")) return 1;
        else return 0;
    }



}
