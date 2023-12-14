package szgPART;

import model.Mark;
import model.RegisteredCourse;

import model.Transcript;

public class Dean extends Manager{

    public double createStatisticalReport(RegisteredCourse course){
        double averageMark = 0;
        int count = 0;

        for (Student student : Database.students) {
            if (course.isStudentOfCourse(student)) {
                averageMark += student.getTranscript().
                        getCourseMark(course).
                        getGPA();
                count++;
            }
        }
        return averageMark/count;
    }
}
