package model;

import assets.Faculty;
import assets.Gender;
import assets.OrganizationRole;

import java.util.*;
import java.time.LocalDate;

public class Student extends User implements Observer{
    private String corporativeEmail;

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
    public Student(String name, String surname, LocalDate birthDate, String id, int yearOfStudy, String login, String password, String phoneNumber, Gender gender, String address, Faculty faculty) {
        super(name,surname, birthDate, id, login, password, phoneNumber, address, gender);

        this.transcript = new Transcript(this);
        this.enrolledCourses = new Vector<>();
        this.registeredCourses = new Vector<>();
        this.faculty=faculty;
        this.yearOfStudy=yearOfStudy;
        this.organizations = new Vector<>();
    }

    // Accessors and Mutators for personal information
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
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
    public void generateCorporativeEmail(){
        this.corporativeEmail = getName().substring(0, 1).toLowerCase() + "_" + getSurname().toLowerCase() + "@rswsp.kz";
    }

    public Vector<Course> getCourses(){
        return this.enrolledCourses;
    }
    // Setters for personal information


    // Academic operations
    public void registerForCourseRequest(RegisteredCourse registeredCourse) {
        if(calculateTotalCredits()>21){
            System.out.println("You cannot access to this course due to credits limit on your account!");
            return;
        }
        for(Course c : enrolledCourses){
            if(c.getId().equals(registeredCourse.getId())){
                System.out.println("Cannot register. Already registered for the course.");
                return;
            }
        }




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
            totalCreditsOfThisSemester+=course.getCredits();
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
    public void addPointsToCourse(RegisteredCourse course, double points, LocalDate localDate) {
        this.transcript.setCourseMark(course,new Mark(points,localDate));
    }
    @Override
    public void update() {
        System.out.println("A new course has been added!");
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
        return Objects.hash(corporativeEmail, faculty, yearOfStudy,transcript);
    }
    @Override
    public String toString() {
        StringBuilder profile = new StringBuilder();
        profile.append("My Profile:\n");
        profile.append("Name: ").append(getName()).append("\n");
        profile.append("Surname: ").append(getSurname()).append("\n");
        profile.append("Birth Date: ").append(getBirthDate()).append("\n");
        profile.append("ID: ").append(getId()).append("\n");
        profile.append("Year of Study: ").append(getYearOfStudy()).append("\n");
        profile.append("Corporative Email: ").append(getCorporativeEmail()).append("\n");
        profile.append("Phone Number: ").append(getPhoneNumber()).append("\n");
        profile.append("Gender: ").append(getGender()).append("\n");
        profile.append("Student ID: ").append(getId()).append("\n");
        profile.append("Address: ").append(getAddress()).append("\n");



        // Append organizations
        profile.append("Organizations:\n");
        for (Map<Organization, OrganizationRole> orgMap : organizations) {
            for (Map.Entry<Organization, OrganizationRole> entry : orgMap.entrySet()) {
                profile.append("Organization: ").append(entry.getKey()).append("\n");
                profile.append("Role: ").append(entry.getValue()).append("\n");
            }
        }

        return profile.toString();
    }

}

