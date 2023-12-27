package control;

import assets.Faculty;
import assets.Gender;
import assets.TeacherType;
import model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Vector;

public class AdminControl {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void doResearchLog(Student student) throws IOException {
        Log log = new Log(student.getId(),"SUCCESFUL RESEARCH");
        Vector<Object> objects = new Vector<Object>();
        objects.add(log);
        Database.saveToFile(objects,"src/assets/logs.ser");
    }

    public static User getGeneralUserInfo() throws IOException {
        System.out.print("Enter name : ");
        String name = bufferedReader.readLine();
        System.out.print("Enter surname : ");
        String surname = bufferedReader.readLine();
        System.out.println("Imagine that u were born now " + LocalDate.now());
        LocalDate date = LocalDate.now();
        System.out.print("Enter id : ");
        String id = bufferedReader.readLine();
        System.out.print("Enter login : ");
        String login = bufferedReader.readLine();
        System.out.print("Enter password : ");
        String password = bufferedReader.readLine();
        System.out.print("Enter phoneNumber : ");
        String phoneNumber = bufferedReader.readLine();
        System.out.print("Enter address : ");
        String address = bufferedReader.readLine();
        System.out.print("Enter Gender (M/F/QUASO) : ");
        String genderr = bufferedReader.readLine();
        Gender gender = null;
        switch(genderr) {
            case "M":
                gender = Gender.MALE;
                break;
            case "F":
                gender = Gender.FEMALE;
                break;
            case "QUASO":
                gender = Gender.QUASO;
                break;

        }

        return new User(name, surname, date, id, login, password, phoneNumber, address, gender);
    }
    public static Teacher makeTeacher() throws IOException {
        User user = getGeneralUserInfo();

        System.out.print("Enter work expirience : ");
        int workExpirience = bufferedReader.read();
        System.out.print("Enter Faculty (FIT/MCM/ISE/BS/KMA): ");
        String facultyCase = bufferedReader.readLine();
        Faculty faculty = null;
        switch (facultyCase) {
            case "FIT":
                faculty = Faculty.FIT;
                break;
            case "MCM":
                faculty = Faculty.MCM;
                break;
            case "ISE":
                faculty = Faculty.ISE;
                break;
            case "BS":
                faculty = Faculty.BS;
                break;
            case "KMA":
                faculty = Faculty.KMA;
                break;
        }
        System.out.print("Enter Type (TUTOR/LECTOR/PROFESSOR): ");
        String typeCase = bufferedReader.readLine();
        TeacherType type = null;
        switch (typeCase) {
            case "TUTOR":
                type = TeacherType.TUTOR;
                break;
            case "LECTOR":
                type = TeacherType.LECTOR;
                break;
            case "PROFESSOR":
                type = TeacherType.PROFESSOR;
                break;
        }
        Teacher teacher = (Teacher) user;
        teacher.setFaculty(faculty);
        teacher.setWorkExperience(workExpirience);
        teacher.setTeacherType(type);
        return teacher;
    }
    public static Student makeStudent() throws IOException {
        User user = getGeneralUserInfo();
        System.out.print("Enter year of study : ");
        int yearOfStudy = bufferedReader.read();

        System.out.print("Enter Faculty (FIT/MCM/ISE/BS/KMA): ");
        String facultyCase = bufferedReader.readLine();
        Faculty faculty = null;
        switch (facultyCase) {
            case "FIT":
                faculty = Faculty.FIT;
                break;
            case "MCM":
                faculty = Faculty.MCM;
                break;
            case "ISE":
                faculty = Faculty.ISE;
                break;
            case "BS":
                faculty = Faculty.BS;
                break;
            case "KMA":
                faculty = Faculty.KMA;
                break;
        }
        Student student = (Student) user;
        student.setYearOfStudy(yearOfStudy);
        student.setFaculty(faculty);
        return student;
    };

    public static boolean viewMenu(User user) throws IOException {
        while(true) {
            System.out.println("\nMenu: \n"+ "1. My details\n"
                    +"2. Add Student\n"
                    +"3. Add Teacher\n"
                    +"9. News\n"
                    +"0. Log Out");

            String choose = bufferedReader.readLine();
            switch (choose){
                case "1":
                    System.out.println(user.toString());
                    break;
                case "2":
                    Vector<Object> students = Database.loadObjectsFromFile("src/assets/students.ser");
                    students.add(makeStudent());
                    Database.saveToFile(students,"src/assets/students.ser") ;
                    break;
                case "3":
                    Vector<Object> teachers = Database.loadObjectsFromFile("src/assets/teachers.ser");
                    teachers.add(makeTeacher());
                    Database.saveToFile(teachers,"src/assets/teachers.ser");
                    break;
                case "4":

                    for(Object n: Database.loadObjectsFromFile("src/assets/news.ser")){
                        News news = (News) n;
                        System.out.println(news.toString()+'\n');
                    }
                    break;
                case "5":
                    System.out.println("Do u want to exit ?Y/N");
                    String mode = bufferedReader.readLine();
                    if(mode.equals("Y")) {
                        UserControl.login();
                        break;
                    }
            }
        }
    }
}
