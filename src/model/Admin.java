package model;

import assets.Faculty;
import assets.Gender;
import model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Vector;

public class Admin {

    public Admin() {
    }

    public void addStudent(Student student) {
        Database.students.add(student);
    }

    public void addResearcher(Researcher researcher) {
        Database.researchers.add(researcher);
    }

    public void addTeacher(Teacher teacher) {
        Database.teachers.add(teacher);
    }

    public void changeUser(User user, User user2) {
        user = user2;
    }

    public void deleteStudent(String studentId) {
        Database.students.remove(studentId);
    }

    public void deleteEmployee(String employeeId) {
        Database.students.remove(employeeId);
    }

    public void deleteResearcher(String researcherId) {
        Database.researchers.remove(researcherId);
    }

    public Vector<Object> getLogs() {
        return Database.loadObjectsFromFile("src/assets/logs.ser");
    }

    public static void zakinutVse() throws IOException {

        Student st = new Student("Alpha", "Beta",
                LocalDate.now(), "GAMMA",
                2, "admin",
                "admin", "800",
                Gender.QUASO,
                "GAMMAK",
                "TOLEBI59", Faculty.FIT);
        Student st2 = new Student("Alphe", "Bete",
                LocalDate.now(), "GAMME",
                2, "adminn",
                "SCHTRICHE", "80",
                Gender.QUASO,

                "GAMMAKE",
                "TOLEBI59E", Faculty.FIT);
        News news = new News("Deadline is over", "Deadline of OOP project is over");
        News news2 = new News("Oral exam is little soon", "Zhaniya and Sultan should pass exam at 5PM");
        Vector<Object> nwObjects = new Vector<Object>();
        Vector<Object> stObjects = new Vector<Object>();
        Vector<Object> usObjects = new Vector<Object>();
        User user1 = (User) st;
        User user2 = (User) st2;
        stObjects.add(st);
        stObjects.add(st2);
        usObjects.add(user1);
        usObjects.add(user2);
        nwObjects.add(news);
        nwObjects.add(news2);
        Database.saveToFile(usObjects, "src/assets/users.ser");
        Database.saveToFile(stObjects, "src/assets/students.ser");
        Database.saveToFile(nwObjects, "src/assets/news.ser");
    }
}
