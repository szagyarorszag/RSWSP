package model;

import assets.Faculty;
import assets.Gender;
import assets.TeacherType;
import model.*;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Vector;

public class Admin extends User implements Serializable {

    public Admin() {
    }
    public Admin(String name, String surname, LocalDate birthDate, String id, String login, String password, String phoneNumber, String address, Gender gender) {
        super(name, surname, birthDate, id, login, password, phoneNumber,  address, gender)
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
                2, "student1",
                "student1", "800",
                Gender.QUASO,

                "TOLEBI59", Faculty.FIT);
        Student st2 = new Student("Alphe", "Bete",
                LocalDate.now(), "GAMME",
                2, "student2",
                "student2",
                "80",
                Gender.QUASO,
                "TOLEBI59E", Faculty.FIT);
        Teacher teacher1 = new Teacher("Alphe", "Bete",
                LocalDate.now(), "GAMME",
                "teacher1", "teacher1",
                "SCHTRICHE",
                "80",
                Gender.QUASO,
                15, Faculty.FIT, TeacherType.PROFESSOR);
        Teacher teacher2 = new Teacher("Deta", "Teta",
                LocalDate.now(), "SAMME",
                "teacher2", "teacher2",
                "SCHTRICHE",
                "80",
                Gender.MALE,
                15, Faculty.FIT, TeacherType.PROFESSOR);

        Admin ad1 = new Admin("Alphe", "Bete",
                LocalDate.now(), "GAMME",
                "admin1", "admin1",
                "787845",
                "80",
                Gender.QUASO);
        Admin ad2= new Admin("Alphe", "Bete",
                LocalDate.now(), "GAMME",
                "admin1", "admin1",
                "787845",
                "80",
                Gender.QUASO);
        News news = new News("Deadline is over", "Deadline of OOP project is over");
        News news2 = new News("Oral exam is little soon", "Zhaniya and Sultan should pass exam at 5PM");
        Vector<Object> nwObjects = new Vector<Object>();
        Vector<Object> stObjects = new Vector<Object>();
        Vector<Object> usObjects = new Vector<Object>();
        Vector<Object> tcObjects = new Vector<Object>();
        Vector<Object> adObjects = new Vector<Object>();
        User user1 = (User) st;
        User user2 = (User) st2;
        User user3 = (User) teacher1;
        User user4 = (User) teacher2;
        tcObjects.add(teacher1);
        tcObjects.add(teacher2);
        stObjects.add(st);
        stObjects.add(st2);
        usObjects.add(user1);
        usObjects.add(user2);
        usObjects.add(user3);
        usObjects.add(user4);
        nwObjects.add(news);
        nwObjects.add(news2);
        adObjects.add(ad1);
        adObjects.add(ad2);
        Database.saveToFile(usObjects, "src/assets/users.ser");
        Database.saveToFile(stObjects, "src/assets/students.ser");
        Database.saveToFile(nwObjects, "src/assets/news.ser");
        Database.saveToFile(tcObjects, "src/assets/teachers.ser");
        Database.saveToFile(tcObjects, "src/assets/admins.ser");
    }
}
