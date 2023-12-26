package model;

import java.util.Objects;

public class Report {
    private String sender;
    private String title;
    private String text;
    private boolean isHandled;

    public Report() {}

    public Report(String sender, String title, String text){
        this.sender = sender;
        this.title = title;
        this.text = text;
        isHandled=false;
    }

    public String getSender() {
        return sender;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Report report)) return false;
        return Objects.equals(getSender(), report.getSender()) && Objects.equals(getTitle(), report.getTitle()) && Objects.equals(getText(), report.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSender(), getTitle(), getText());
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
    public void setHandle(){
        this.isHandled=true;

    }

    @Override
    public String toString() {
        return "Report{" +
                "sender='" + sender + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}