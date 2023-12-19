package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
class AllClassesTest {

    @Test
    void testAllClasses() {
        // Test Student class
        Student student = new Student();
        student.setYearOfStudy(2); // Setting the year of study

        assertEquals(2, student.getYearOfStudy());

        // Test Mark class

        //test mark overload
        //Mark mark = new Mark(75, LocalDateTime.of(2023,7,22,11,12));
        Mark mark = new Mark(75);

        assertNotNull(mark);
        assertEquals(75, mark.getTotal());

        // Test Course class
        Course course = new Course("CS101", "Introduction to Programming", 3, Faculty.CS);

        assertEquals("CS101", course.id);
        assertEquals("Introduction to Programming", course.title);
        assertEquals(3, course.credits);
        assertEquals(Faculty.CS, course.faculty);

        // Test RegisteredCourse class
        RegisteredCourse regCourse = new RegisteredCourse("CS201", "Advanced Programming", 4, Faculty.CS, 2023, 1, 50);

        assertEquals("CS201", regCourse.id);
        assertEquals("Advanced Programming", regCourse.title);
        assertEquals(4, regCourse.credits);
        assertEquals(Faculty.CS, regCourse.faculty);
        assertEquals(2023, regCourse.getYear());
        assertEquals(1, regCourse.getSemester());
        assertEquals(50, regCourse.getNumberOfStudents());

        // Test Transcript class
        Transcript transcript = new Transcript(student);

        transcript.setCourseMark(regCourse, mark);

        assertEquals(0, transcript.getNumOfRetakes());
        assertEquals(mark, transcript.getCourseMark(regCourse));
        assertNotNull(transcript.getSameSemesterCourses(2023, 1));
        assertNotNull(transcript.getSameSemesterMarks(2023, 1));
        assertNotNull(transcript.viewTranscript());
        //assertTrue(transcript.getGPA() >= 0); // Check if GPA is a non-negative value
    }
}
