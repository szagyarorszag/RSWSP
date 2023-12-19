package szgPART;

import model.Faculty;

import java.util.Objects;

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
    public Course(String id, String title, int credits, Faculty faculty, Course prereq) {
        this(id,title,credits,faculty);
        this.prereq=prereq;
    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public Course getPrereq() {
        return prereq;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setPrereq(Course prereq) {
        this.prereq = prereq;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return getCredits() == course.getCredits()
                && Objects.equals(getId(), course.getId())
                && Objects.equals(getTitle(), course.getTitle())
                && Objects.equals(getPrereq(), course.getPrereq())
                && getFaculty() == course.getFaculty();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getCredits(), getPrereq(), getFaculty());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Course: "+"id = '"+id+'\''+", title = '"+title+'\''+", credits = "+credits);
        if(this.prereq!=null) return stringBuilder.append(", prerequisite = "+this.prereq).toString();
        return stringBuilder.toString();
    }



}
