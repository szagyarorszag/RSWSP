package model;

public class Course {

    private  String id;
    private String title;
    private int credits;
    private Course prereq;
    private Faculty faculty;
    public Course(){}
    public Course(String id, String title, int credits, Faculty faculty) {
        this.id = id;
        this.title = title;
        this.credits = credits;
        this.faculty = faculty;
    }
    //overloading constructor for course variability
    //course may have not prereq
    public Course(String id, String title, int credits, Faculty faculty, Course prereq) {
        this(id, title, credits, faculty);
        this.prereq = prereq;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for credits
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    // Getter and Setter for prereq
    public Course getPrereq() throws Exception{
        return prereq;
    }

    public void setPrereq(Course prereq) throws Exception{
        this.prereq = prereq;
    }

    // Getter and Setter for faculty
    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Course: "+"id = '"+id+'\''+", title = '"+title+'\''+", credits = "+credits);
        if(this.prereq!=null) return stringBuilder.append(", prerequisite = "+this.prereq).toString();
        return stringBuilder.toString();
    }



}
