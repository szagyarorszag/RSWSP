package szgPART;

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

}
