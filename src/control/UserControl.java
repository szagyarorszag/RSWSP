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

    private static Language language;

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
        System.out.println("Choose language\n1. English\n2. Russian\n3. Kazakh\n ");
        int choiceLanguage = Integer.parseInt(br.readLine());

        switch (choiceLanguage) {
            case 1:
                language = Language.EN;
                break;
            case 2:
                language = Language.RU;
                break;
            case 3:
                language = Language.KZ;
                break;
            default:
                language = Language.EN;
                break;
        }

        while (true) {
            System.out.print("Enter login : ");
            String login = br.readLine();
            System.out.print("Enter password : ");
            String password = br.readLine();

            User user = isLoginAndPasswordCorrect(login, password);

            if (user == null) {
                System.out.println(getErrorMessage(language));
                continue;
            }

            UserControl.saveEnterLog(user);

            if (user instanceof Student) {
                StudentControl.viewMenu((Student) user);
            }
            else if (user instanceof Admin) {
                /*teacher control*/
            }
            else if (user instanceof Teacher) {
                /*teacher control*/
            }
            else if (user instanceof Manager) {
                /*manager control*/
            }
            else if (user instanceof Researcher) {
                /*researcher control*/
            }
        }
    }

    private static String getErrorMessage(Language language) {
        switch (language) {
            case EN:
                return "Wrong password or login. Try again.";
            case RU:
                return "Введен неверный пароль или логин. Попробуйте еще раз.";
            case KZ:
                return "Енгізілген құпиясөз немесе қолданушы логині қате. Қайтадан енгізіп көріңіз.";
            default:
                return "Wrong password or login. Try again.";
        }
    }

    // Getter and Setter for language
    public static Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}