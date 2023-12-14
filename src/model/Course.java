package model;

public class Course {
    public Course(){}
    public  String id;
    public String title;
    public int credits;
    public Course prereq;
    public Faculty faculty;
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
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Course: "+"id = '"+id+'\''+", title = '"+title+'\''+", credits = "+credits);
        if(this.prereq!=null) return stringBuilder.append(", prerequisite = "+this.prereq).toString();
        return stringBuilder.toString();
    }


}
