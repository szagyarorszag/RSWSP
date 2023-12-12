package model;

import java.util.*;

public class RegisteredCourse extends Course{
    public RegisteredCourse(){}
    public int year;
    public int semester;
    //TODO
    //protected Vector<Teacher> teachers;
    public int numberOfStudents;
    private Vector<Student> students;
    public RegisteredCourse(String id, String title, int credits, Faculty faculty, int year, int semester, int numberOfStudents){
        super(id,title,credits,faculty);
        this.year=year;
        this.numberOfStudents=numberOfStudents;
        this.semester = semester;
    }
    public RegisteredCourse(String id, String title, int credits, Faculty faculty,Course prereq, int year, int semester, int numberOfStudents){
        super(id,title,credits,faculty,prereq);
        this.year=year;
        this.numberOfStudents=numberOfStudents;
        this.semester = semester;
    }
    public String getStudentsInfo(){
        StringBuilder result = new StringBuilder();
        for (Student student : students) {
            result.append(student.toString()).append("\n");
        }
        return result.toString();
    }

    public boolean isStudentOfCourse(Student student){
        for (Student s : students) {
            if(s.equals(student)) return true;
        }
        return false;
    }
    public String getStudentInfo(Student student){
        for (Student s : students) {
            if(s.equals(student)) return s.toString();
        }
        return "Student isn't found";
    }

    @Override
    public String toString(){
        return "Year: "+ year + " semester: " + semester+ super.toString()+" number of students: "+numberOfStudents;
    }

}