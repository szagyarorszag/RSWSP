package model;
import java.time.*;
public class Lesson {
    private RegisteredCourse course;
    private Week day;
    private LocalTime startTime;
    private LocalTime endTime;
    private String room;
    private Format format;
    private LessonType lessonType;
    private int numberOfStudents;
    private Teacher teacher;

    public Lesson() {
        // Default constructor
    }

    public Lesson(RegisteredCourse course, Week day, LocalTime startTime, LocalTime endTime, Teacher teacher, String room, Format format, LessonType lessonType, int numberOfStudents) {
        this.course = course;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teacher=teacher;
        this.room = room;
        this.format = format;
        this.lessonType = lessonType;
        this.numberOfStudents=numberOfStudents;
    }

    // Getters and Setters for all fields

    public RegisteredCourse getCourse() {
        return course;
    }

    public void setCourse(RegisteredCourse course) {
        this.course = course;
    }

    public Week getDay() {
        return day;
    }

    public void setDay(Week day) {
        this.day = day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartHour(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndHour() {
        return endTime;
    }

    public void setEndHour(LocalTime endTime) {
        this.endTime = endTime;
    }
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Format getFormat() {
        return format;
    }
    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setRoom(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public void setFormat(Format format) {
        this.format = format;
        //set room available if lesson online
        if(format==Format.ONLINE){
            setRoom("0");
        }
    }
    public boolean overlaps(Lesson lesson) {
        return !(this.endTime.isBefore(lesson.startTime) || lesson.endTime.isBefore(this.startTime));
    }
    public LessonType getLessonType() {
        return lessonType;
    }

    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }
}

