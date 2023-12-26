package model;
import java.util.*;
import java.time.LocalDate;
public class ResearchPaper implements Comparable<ResearchPaper>{
    private String name;
    private Vector<ResearcherDecorator> authors;
    private String journal;
    private int pages;
    private LocalDate date;
    private int citations;

    public ResearchPaper(String name, Vector<ResearcherDecorator> authors, String journal, int pages, LocalDate date) {
        this.name = name;
        this.authors = authors;
        this.journal = journal;
        this.pages = pages;
        this.date = date;
        this.citations = 0;
    }
    public void addCitation(){
        this.citations++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for 'authors'
    public Vector<ResearcherDecorator> getAuthors() {
        return authors;
    }

    public void setAuthors(Vector<ResearcherDecorator> authors) {
        this.authors = authors;
    }

    // Getter and Setter for 'journal'
    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    // Getter and Setter for 'pages'
    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    // Getter and Setter for 'date'
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Getter and Setter for 'citations'
    public int getCitations() {
        return citations;
    }

    public void setCitations(int citations) {
        this.citations = citations;
    }

    @Override
    public int compareTo(ResearchPaper paper){
        return this.getDate().compareTo(paper.getDate());
    }



}