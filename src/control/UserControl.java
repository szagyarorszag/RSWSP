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
        int choiceLanguage = 1;
        Language language = Language.EN; // Default language

        System.out.println("Choose language\n1. English\n2. Russian\n3. Kazakh\n ");
        choiceLanguage = Integer.parseInt(br.readLine());

        if (choiceLanguage == 1) {
            language = Language.EN;
        } else if (choiceLanguage == 2) {
            language = Language.RU;
        } else if (choiceLanguage == 3) {
            language = Language.KZ;
        }

        if (language == Language.EN) {
            System.out.println("Welcome to RSWSP\n");
        } else if (language == Language.RU) {
            System.out.println("Добро пожаловать в RSWSP");
        } else if (language == Language.KZ) {
            System.out.println("RSWSP-ға қош келдіңіз!");
        }

        if(language == Language.EN){
            while (true) {
                System.out.print("Enter login : ");
                String login = br.readLine();
                System.out.print("Enter password : ");
                String password = br.readLine();

                User user = isLoginAndPasswordCorrect(login, password);

                if (user == null) {
                    System.out.println("Wrong password or login. Try again.");
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

        else if(language == Language.RU){
            while (true) {
                System.out.print("Введите логин : ");
                String login = br.readLine();
                System.out.print("Введите пароль : ");
                String password = br.readLine();

                User user = isLoginAndPasswordCorrect(login, password);

                if (user == null) {
                    System.out.println("Введен неверный пароль и логин пользователя. Попробуйте еще раз.");
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

        else if(language == Language.KZ){
            while (true) {
                System.out.print("Логинді енгізіңіз : ");
                String login = br.readLine();
                System.out.print("Құпиясөзді енгізіңіз : ");
                String password = br.readLine();

                User user = isLoginAndPasswordCorrect(login, password);

                if (user == null) {
                    System.out.println("Енгізілген құпиясөз немесе қолданушы логиі қате. Қайтадан енгізіп көріңіз.");
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

        else{
            while (true) {
                System.out.print("Enter login : ");
                String login = br.readLine();
                System.out.print("Enter password : ");
                String password = br.readLine();

                User user = isLoginAndPasswordCorrect(login, password);

                if (user == null) {
                    System.out.println("Wrong password or login. Try again");
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
}