package model;

public class Lesson {
    private RegisteredCourse course;
    private Week day;
    private int startHour;
    private int endHour;
    private String room;
    private Format format;
    private LessonType lessonType;
    private int numberOfStudents;
    private Teacher teacher;

    public Lesson() {
        // Default constructor
    }

    public Lesson(RegisteredCourse course, Week day, int startHour, int endHour, Teacher teacher, String room, Format format, LessonType lessonType, int numberOfStudents) {
        this.course = course;
        this.day = day;
        this.startHour = startHour;
        this.endHour = endHour;
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

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
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

    public LessonType getLessonType() {
        return lessonType;
    }

    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }
}

