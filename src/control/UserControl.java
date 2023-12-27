package control;
import model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Vector;
import model.Student;
import assets.Gender;
import assets.Faculty;
public class UserControl {
    public static void main(String [] args) throws IOException {
        UserControl.login();
    }
    public static void zakinutStudentov() throws IOException {

        Student st = new Student("Alpha", "Beta",
                LocalDate.now() , "GAMMA",
                2, "admin",
                "admin", "800",
                Gender.QUASO,
                "GAMMAK",
                "TOLEBI59",Faculty.FIT);
        Student st2 = new Student("Alphe", "Bete",
                LocalDate.now() , "GAMME",
                2, "adminn",
                "SCHTRICHE", "80",
                Gender.QUASO,

                "GAMMAKE",
                "TOLEBI59E",Faculty.FIT);
        Vector<Object> stObjects = new Vector<Object>();
        Vector<Object> usObjects = new Vector<Object>();
        stObjects.add(st);
        stObjects.add(st2);
        User user1 = (User) st;
        User user2 = (User) st2;
        usObjects.add(st);
        usObjects.add(st2);
        Database.saveToFile(usObjects, "src/assets/users.ser");
        Database.saveToFile(stObjects, "src/assets/students.ser");
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void saveEnterLog(User user) throws IOException {
        Log log = new Log(user.getId(),"SUCCESFUL ENTER");
        Vector<Object> objects = new Vector<Object>();
        objects.add(log);
        Database.saveToFile(objects,"src/assets/logs.ser");
    }
    public static Vector<Object> getNews() {
        return Database.loadObjectsFromFile("src/assets/news.ser");
    }
    public static User isLoginAndPasswordCorrect(String login, String password){
        for ( Object o : Database.loadObjectsFromFile("src/assets/users.ser")) {
            User user = (User)o;
            if( user.getLogin().equals(login) && user.getPassword().equals(password)) return user;
        }
        return null;
    }
    public static void login() throws IOException {
        System.out.println("Welcome to RSWSP\n");
        while(true) {
            System.out.println("Enter login");
            String login = br.readLine();
            System.out.println("Enter password");
            String password = br.readLine();
            zakinutStudentov();
            User user = isLoginAndPasswordCorrect(login, password);
            if (user == null) {
                System.out.println("Wrong password or login .Try again");
                continue;
            }

            for( Object o : getNews()) {
                News news = (News) o;
                System.out.println(news.toString());
            }

            UserControl.saveEnterLog(user);

            if (user instanceof Student) {
                StudentControl.viewMenu((Student) user);
            }
            if (user instanceof Teacher) {
                /*teacher control*/
            }
            if (user instanceof Manager) {
                /*manager control*/
            }
            if (user instanceof Researcher) {
                /*researcher control*/
            }
            else {
                System.out.println("Do u want to exit ?Y/N");
                String mode = br.readLine();
                if(mode.equals("Y")) break;
            }
        }
    }
}
