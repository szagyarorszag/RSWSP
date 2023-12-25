package szgPART;

import model.Mark;
import model.Course;
import model.RegisteredCourse;

import model.Transcript;

public abstract class Manager extends Employee {
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

    public void approveRegistration(RegisteredCourse registeredCourse, int numberOfStudents, int credits, int semester, String id, Course prereq) {
        registeredCourse.setNumberOfStudents(numberOfStudents);
        registeredCourse.setCredits(credits);
        registeredCourse.setSemester(semester);
        try {
            registeredCourse.setPrereq(prereq);
        } catch ()
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
