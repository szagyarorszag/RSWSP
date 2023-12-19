package szgPART;

import model.RegisteredCourse;


public class OR extends Manager {
    public void addCourse(Course course) {
        Database.courses.add(course);
    }
    public void deleteCourse(Course course) {
        Database.courses.remove(course);
    }
    public void changeCourse(Course course, Course course2){
        course = course2;
    }

    public void approveRegistration(RegisteredCourse registeredCourse, int numberOfStudents, int credits, int semester, String id, Course prereq) {
        registeredCourse.numberOfStudents = numberOfStudents;
        registeredCourse.credits = credits;
        registeredCourse.semester = semester;
        registeredCourse.prereq = prereq;
    }


}
