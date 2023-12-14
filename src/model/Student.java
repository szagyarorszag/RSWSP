package model;

import java.util.*;
import java.time.LocalDateTime;
import java.util.*;

public class Student extends User{
    private String name;
    private String surname;
    private Date birthDate;
    private String corporativeEmail;
    private String login;
    private String password;
    private String id;
    private String phoneNumber;
    private Gender gender;


    private Faculty faculty;
    private int yearOfStudy;
    private Transcript transcript;
    private Vector<Course> enrolledCourses;
    private Vector<RegisteredCourse> registeredCourses;
    //TODO: private Vector<Organization> organizations;

    //Default Constructor
    public Student()
    {

    }

    // Constructor
    public Student(String name, String surname, Date birthDate,String id, int yearOfStudy,  String login, String password, String phoneNumber, Gender gender, String studentId, String address, Faculty faculty) {
        super(name,surname, birthDate, id, login, password, phoneNumber, address, gender);
        this.corporativeEmail = this.name.substring(0, 1).toLowerCase() + "_" + this.surname.toLowerCase() + "@rswsp.kz";
        this.transcript = new Transcript(this);
        this.enrolledCourses = new Vector<>();
        this.registeredCourses = new Vector<>();
        this.faculty=faculty;
        this.yearOfStudy=yearOfStudy;
        //TODO: this.organizations = new Vector<>();
    }

    // Accessors and Mutators for personal information
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCorporativeEmail() {
        return corporativeEmail;
    }
    public int getYearOfStudy(){
        return yearOfStudy;
    }
    public void setYearOfStudy(int yearOfStudy){
        this.yearOfStudy=yearOfStudy;
    }


    // Setters for personal information
    public void setName(String firstName) {
        this.name = firstName;
    }

    public void setSurname(String lastName) {
        this.surname = lastName;
    }



    // Academic operations
    public void registerForCourse(Course course) {
        //TODO: Admin
        // Logic to register the student for a course
    }

    public void dropCourse(RegisteredCourse registeredCourse) {
        //TODO: Admin
        // Logic to drop a course
    }

    public int calculateTotalCredits() {
        // Logic to calculate total credits based on enrolled courses
        return 0;
    }

    public double getGPA() {
        // Logic to fetch the overall GPA from the transcript
        return 0.0;
    }

    public String viewTranscript() {
        // Logic to display the student's transcript
        return "";
    }

    public Mark getCourseGrade(RegisteredCourse registeredCourse) {
        return this.transcript.getCourseMark(registeredCourse);
    }

    public void updateAddress(String newAddress) {
        // Logic to update the student's address
    }

    public boolean isEnrolledInCourse(RegisteredCourse course) {
        // Logic to check if the student is enrolled in a specific course
        return false;
    }

    // Additional interactions
    public void joinOrganization(Organization organization) {
        // Logic to allow a student to join an organization
    }

    public String viewOrganizations() {
        // Logic to display the organizations a student is part of
        return "";
    }

    public void requestMeetingWithTeacher(Teacher teacher) {
        // Logic to send a meeting request to a teacher
    }
    public void addPointsToTranscript(RegisteredCourse course, double points) {
        this.transcript.setCourseMark(course,new Mark(points));
    }
    public void addPointsToCourse(RegisteredCourse course, double points, LocalDateTime localDateTime) {
        this.transcript.setCourseMark(course,new Mark(points,localDateTime));
    }

}

