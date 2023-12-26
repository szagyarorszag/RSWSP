package model;

import java.util.*;

public class RegisteredCourse extends Course implements Subject{
    public RegisteredCourse(){}
    private int year;
    private int semester;

    protected Vector<Teacher> teachers;
    private int numberOfStudents;
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
    public int getNumberOfStudents(){
        return this.numberOfStudents;
    }
    public void setNumberOfStudents(int numberOfStudents){
        this.numberOfStudents=numberOfStudents;
    }
    public int getYear(){
        return this.year;
    }
    public void setYear(int year){
        this.year = year;
    }
    public int getSemester(){
        return this.semester;
    }
    public void setSemester(int semester){
        this.semester=semester;
    }
    public String getStudentsInfo(){
        StringBuilder result = new StringBuilder();
        for (Student student : students) {
            result.append(student.toString()).append("\n");
        }
        return result.toString();
    }

    public void addCourseTeacher(Teacher teacher){
        teachers.add(teacher);
    }


    public Student getStudent(String id){
        for(Student s:students){
            if(s.getId().equals(id)) return s;
        }
        return null;
    }
    public Vector<Student> getStudents(){
        return students;
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
    //since w only notify students, observer was Replaced by Student
    public void registerStudent(Student student) {
        students.add(student);
        notifyStudent(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void notifyStudent(Student student) {
        for (Student s : students) {
            if(s.equals(student)) s.update();
        }
    }

    @Override
    public String toString(){
        return "Year: "+ year + " semester: " + semester+ super.toString()+" number of students: "+numberOfStudents;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        RegisteredCourse course= (RegisteredCourse) o;
        return super.equals(course) && year==course.year && numberOfStudents == course.numberOfStudents && semester==course.semester;
    }



}
