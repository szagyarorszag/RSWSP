package model;

import assets.Faculty;
import assets.Gender;
import assets.TeacherType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
public class Teacher extends Employee{
    private Vector<RegisteredCourse> courses;
    private Faculty faculty;
    private double rate;
    private TeacherType teacherType;
    public Teacher(){
        super();

    }
    public Teacher(String name, String surname, LocalDate birthDate, String id, String login, String password, String phoneNumber, String address, Gender gender, int workExperience, Faculty faculty, TeacherType teacherType){
        super(name,surname, birthDate, id, login, password, phoneNumber, address, gender,workExperience);
        this.faculty = faculty;
        this.teacherType = teacherType;
        this.rate = 0;
    }

    public void addCourse(RegisteredCourse course){
        courses.add(course);
    }

    public Vector<RegisteredCourse> getCourses(){
        return courses;
    }

    public void setFaculty(Faculty faculty){
        this.faculty=faculty;
    }

    public void setRate(double rate){
        this.rate=rate;
    }

    public void setTeacherType(TeacherType type) {
        this.teacherType = type;
    }

    public double getRate(){
        return this.rate;
    }

    public Faculty getFaculty(){
        return this.faculty;
    }

    public TeacherType getTeacherType(){
        return this.teacherType;
    }



    public void putMark(Student student, Mark mark, RegisteredCourse course){
        for(RegisteredCourse c: courses){
            if(c.equals(course) && student.isEnrolledInCourse(course)){
                student.getTranscript().setCourseMark(course,mark);
                return;
            }
        }
        System.out.println("Something gone wrong, check your information again!");
    }

    public Message createComplaint(Message message, Teacher teacher/*Manager manager*/){
        String complaint = LocalDateTime.now().getMonth() +" "+ LocalDateTime.now().getDayOfMonth()+ ", " +LocalDateTime.now().getYear() + '\n' + super.getName();
        //if(manager.getGender() == Gender.MALE) complaint+="Dear Mr.";
        if(teacher.getGender() == Gender.MALE) complaint+="Dear Mr.";
        else complaint+="Dear Mrs.";
        //complaint+=manager.getSurname()+'\n';
        complaint+=teacher.getSurname()+'\n';
        complaint+=message.getMessage();
       // return new Message(this, manager, complaint, LocalDate.now());
        return new Message(this, teacher, complaint, LocalDate.now());

    }
    public String viewStudents(RegisteredCourse course){
        return course.getStudentsInfo();
    }







}
