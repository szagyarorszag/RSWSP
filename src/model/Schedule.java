package model;
import java.util.*;

public class Schedule {
    private Vector<Lesson> lessons;

    public Schedule() {
        this.lessons = new Vector<>();
    }

    public Vector<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Vector<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public boolean checkCollision(Lesson newLesson) {
        for (Lesson existingLesson : lessons) {
            if (existingLesson.getDay() == newLesson.getDay() &&
                    existingLesson.overlaps(newLesson)) {
                return true; // Collision detected
            }
        }
        return false; // No collision found
    }
}

