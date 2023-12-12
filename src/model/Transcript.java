package model;

import java.util.*;

public class Transcript {
    private Vector<Map<RegisteredCourse,Mark> >marks;
    private int numOfRetakes;
    private double gpa;
    private Student owner;

    public Transcript(){

    }
    public Transcript(Student owner){
        this.owner = owner;
    }

    public void setCourseMark(RegisteredCourse course, Mark mark) {
        for (Map<RegisteredCourse, Mark> markMap : marks) {
            if (markMap.containsKey(course)) {
                numOfRetakes+=1;
            }
            markMap.put(course, mark);
            return;
        }

    }

    public int getNumOfRetakes() {
        return numOfRetakes;
    }
    public Mark getCourseMark(RegisteredCourse course){
        for (Map<RegisteredCourse,Mark> markMap : marks) {
            for (RegisteredCourse c : markMap.keySet()) {
                if(c.equals(course)) return markMap.get(course);
            }
        }
        return null;
    }
    public Vector<RegisteredCourse> getSameSemesterCourses(int year, int semester){
        Vector<RegisteredCourse> currentYearCourses = new Vector<>();
        for (Map<RegisteredCourse,Mark> markMap : marks) {
            for (RegisteredCourse course : markMap.keySet()) {
                if(course.year == year && course.semester == semester) currentYearCourses.add(course);

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
                if(course.year == year && course.semester == semester) currentYearMarks.add(mark);
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
                result.append(course.title+": "+mark.getMarkLetter()).append("\n");
            }
        }
        return result.toString();
    }
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (Map<RegisteredCourse,Mark> markMap : marks) {
            for (Map.Entry<RegisteredCourse, Mark> entry : markMap.entrySet()) {
                RegisteredCourse course = entry.getKey();
                Mark mark = entry.getValue();
                result.append(course.title+": "+mark.getMarkLetter()).append("\n");
            }
        }
        return result.toString();
    }

}
