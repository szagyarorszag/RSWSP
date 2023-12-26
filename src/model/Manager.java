package model;

import java.util.*;
import java.time.LocalDate;

public class Manager extends Employee {

    private ManagerType managerType;

    public Manager(){
        super();
    }
    public Manager(String name, String surname, LocalDate birthDate, String id, String login, String password, String phoneNumber, String address, Gender gender,  double salary, int workExperience){
        super(name, surname, birthDate, id, login, password, phoneNumber, address, gender, workExperience);

    }


    public void addNews(News news){
        Database.newss.add(news);
    }
    public void deleteNews(News news) {
        Database.newss.remove(news);
    }
    public void changeNews(News news, News news2) {
        news = news2;
    }

    public void addCourse(Course course) {
        Database.courses.add(course);
    }
    public void deleteCourse(Course course) {
        Database.courses.remove(course);
    }
    public void changeCourse(Course course, Course course2){
        course = course2;
    }
    // Getter method for managerType
    public ManagerType getManagerType() {
        return managerType;
    }

    // Setter method for managerType
    public void setManagerType(ManagerType managerType) {
        this.managerType = managerType;
    }

    public RegisteredCourse registerCourse(Course course, int year, int numberOfStudents, int semester){
        RegisteredCourse registeredCourse=(RegisteredCourse) course;
        registeredCourse.setYear(year); registeredCourse.setSemester(semester); registeredCourse.setNumberOfStudents(numberOfStudents);
        return registeredCourse;
    }

    public void deleteFromCourse(RegisteredCourse course, Student student){
        course.removeStudent(student);
    }
    public void registerStudent(RegisteredCourse course, Student student){
        course.registerStudent(student);
    }

    public double createStatisticalReport(RegisteredCourse course){
        double averageMark = 0;
        int count = 0;

        for (Student student : Database.students) {
            if (course.isStudentOfCourse(student)) {
                averageMark += student.getTranscript().getCourseMark(course).
                        getGPA();
                count++;
            }
        }
        return averageMark/count;
    }
}