package model;

import java.time.LocalDateTime;
import java.util.*;


public class Transcript{
    private Vector<Map<RegisteredCourse,Mark> >marks;
    private int numOfRetakes;
    private double gpa;
    private Student owner;

    public Transcript(){
        numOfRetakes=0;
    }
    public Transcript(Student owner){

        this.owner = owner;
        this.marks = new Vector<>();
    }

    public void setCourseMark(RegisteredCourse course, Mark mark) {
        boolean courseFound = false;

        for (Map<RegisteredCourse, Mark> markMap : marks) {
            if (markMap.containsKey(course)) {
                numOfRetakes += 1;
                markMap.put(course, mark);
                courseFound = true;
                break; // No need to continue once course is found and updated
            }
        }

        if (!courseFound) {
            Map<RegisteredCourse, Mark> newMarkMap = new HashMap<>();
            newMarkMap.put(course, mark);
            marks.add(newMarkMap);
        }
    }

    public int getNumOfRetakes() {
        return numOfRetakes;
    }
    public Mark getCourseMark(RegisteredCourse course) {
        for (Map<RegisteredCourse, Mark> markMap : marks) {
            Mark mark = markMap.get(course);
            if (mark != null) {
                return mark;
            }
        }
        return null;
    }
    public Vector<RegisteredCourse> getSameSemesterCourses(int year, int semester){
        Vector<RegisteredCourse> currentYearCourses = new Vector<>();
        for (Map<RegisteredCourse,Mark> markMap : marks) {
            for (RegisteredCourse course : markMap.keySet()) {
                if(course.getYear() == year && course.getSemester() == semester) currentYearCourses.add(course);

            }
        }
        return currentYearCourses;
    }
    public Vector<Mark> getSameSemesterMarks(int year, int semester){
        Vector<Mark> currentYearMarks = new Vector<>();
        for (Map<RegisteredCourse,Mark> markMap : marks) {
            for (Map.Entry<RegisteredCourse, Mark> entry : markMap.entrySet()) {
                RegisteredCourse course = entry.getKey();
                Mark mark = entry.getValue();
                if(course.getYear() == year && course.getSemester() == semester) currentYearMarks.add(mark);
            }
        }
        return currentYearMarks;
    }
    public double getGPA(){
        Vector<Double> allGPA = new Vector<>();
        for(int i=1; i<=owner.getYearOfStudy();i++){
            for(int j =1; j<=2; j++) {
                double tempGPA = 0;
                Vector<Mark> tempMarks = getSameSemesterMarks(i, j);
                for (Mark m : tempMarks)
                    tempGPA += m.getGPA();
                allGPA.add(tempGPA / tempMarks.size());
            }
        }
        double result = 0;
        for(Double d:allGPA){
            result+=d;
        }
        return result/allGPA.size();

    }
    public String viewTranscript(){
        StringBuilder result = new StringBuilder();
        for (Map<RegisteredCourse,Mark> markMap : marks) {
            for (Map.Entry<RegisteredCourse, Mark> entry : markMap.entrySet()) {
                RegisteredCourse course = entry.getKey();
                Mark mark = entry.getValue();
                result.append(course.getTitle()+": "+mark.getMarkLetter()).append("\n");
            }
        }
        return result.toString();
    }
    public int getTotalCredits(){
        int total = 0;
        for(Map<RegisteredCourse,Mark> markMap: marks){
            for(RegisteredCourse course:markMap.keySet()){
                total+=course.getCredits();
            }
        }
        return total;
    }
    public Vector<RegisteredCourse> getCurrentSemesterCourses(int semester){
        Vector<RegisteredCourse> currentSemesterCourses= new Vector<>();
        for(Map<RegisteredCourse,Mark> markMap: marks){
            for(RegisteredCourse course:markMap.keySet()){
                if(LocalDateTime.now().getYear() == course.getYear() && course.getSemester() == semester){
                    currentSemesterCourses.add(course);
                }

            }
        }
        return currentSemesterCourses;
    }
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (Map<RegisteredCourse,Mark> markMap : marks) {
            for (Map.Entry<RegisteredCourse, Mark> entry : markMap.entrySet()) {
                RegisteredCourse course = entry.getKey();
                Mark mark = entry.getValue();
                result.append(course.getTitle()+": "+mark.getMarkLetter()).append("\n");
            }
        }
        return result.toString();
    }

}
