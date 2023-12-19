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
    private Vector<Map<Organization, OrganizationRole> > organizations;

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
        this.organizations = new Vector<>();
    }

    // Accessors and Mutators for personal information

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


    // Academic operations
    public void registerForCourseRequest(Course course) {
        //TODO: Admin
        // Logic to register the student for a course
    }

    public void dropCourseRequest(RegisteredCourse registeredCourse) {
        //TODO: Admin
        // Logic to drop a course
    }

    public int calculateTotalCredits() {
        return this.transcript.getTotalCredits();
    }
    public int calculateThisSemesterCredits(int semester) {
        int totalCreditsOfThisSemester = 0;
        for(RegisteredCourse course:transcript.getCurrentSemesterCourses(semester)){
            totalCreditsOfThisSemester+=course.credits;
        }
        return totalCreditsOfThisSemester;
    }

    public double getGPA() {
        return this.transcript.getGPA();
    }

    public String viewTranscript() {

        return this.transcript.viewTranscript();
    }
    public Transcript getTranscript() {

        return this.transcript;
    }

    public Mark getCourseGrade(RegisteredCourse registeredCourse) {
        return this.transcript.getCourseMark(registeredCourse);
    }



    public boolean isEnrolledInCourse(RegisteredCourse course) {

        return course.isStudentOfCourse(this);
    }

    // Additional interactions
    public void joinOrganization(Map<Organization,OrganizationRole> organization) {
        this.organizations.add(organization);
    }

    public String viewOrganizations() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Map<Organization,OrganizationRole> organization:organizations){
            stringBuilder.append(organization.toString()).append('\n');
        }
        return stringBuilder.toString();
    }


    public void addPointsToTranscript(RegisteredCourse course, double points) {
        this.transcript.setCourseMark(course,new Mark(points));
    }
    public void addPointsToCourse(RegisteredCourse course, double points, LocalDateTime localDateTime) {
        this.transcript.setCourseMark(course,new Mark(points,localDateTime));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return super.equals((User) student) && this.faculty==student.faculty && this.yearOfStudy==student.yearOfStudy && this.transcript==student.transcript;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, id);
    }

}

