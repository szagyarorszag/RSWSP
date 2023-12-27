package control;
import assets.Language;
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
        Admin.zakinutVse();
        UserControl.login();
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
        Language language = Language.EN;
        if (language == Language.EN) {
            System.out.println("Welcome to RSWSP\n");
        } else if ( language == Language.RU ) {
            System.out.println("Добро пожаловать в RSWSP");
        }
        while(true) {
            System.out.println("Enter login");
            String login = br.readLine();
            System.out.println("Enter password");
            String password = br.readLine();

            User user = isLoginAndPasswordCorrect(login, password);
            if (user == null) {
                System.out.println("Wrong password or login .Try again");
                continue;
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

        }
    }
}
