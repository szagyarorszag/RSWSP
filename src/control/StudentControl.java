package control ;
import java.util.*;
import java.io.*;

import assets.Language;
import model.*;
public class StudentControl {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void doResearchLog(Student student) throws IOException {
        Log log = new Log(student.getId(), "SUCCESSFUL RESEARCH");
        Vector<Object> objects = new Vector<Object>();
        objects.add(log);
        Database.saveToFile(objects, "src/assets/logs.ser");
    }

    public static boolean viewMenu(Student student) throws IOException {
        Language language = UserControl.getLanguage();

        while (true) {
            System.out.println(getMenuText(language));

            String choose = bufferedReader.readLine();
            switch (choose) {
                case "1":
                    System.out.println(student.toString());
                    break;
                case "2":
                    Researcher studentResearcher = new ResearcherDecorator(student);
                    System.out.println(studentResearcher.conductResearch());
                    doResearchLog(student);
                    break;
                case "3":
                    System.out.println(student.viewTranscript());
                    break;
                case "4":
                    displayNews();
                    break;
                case "5":
                    System.out.println(getExitMessage(language));
                    String mode = bufferedReader.readLine();
                    if (mode.equalsIgnoreCase("Y") || mode.equalsIgnoreCase("Д") || mode.equalsIgnoreCase("И")) {
                    UserControl.login();
                    return true; // or break if necessary
                } else {
                    continue;
                }
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static String getMenuText(Language language) {
        switch (language) {
            case EN:
                return "\nMenu: \n" + "1. My details\n" + "2. Research\n" + "3. View Transcript\n" + "4. News\n" + "5. Log Out";
            case RU:
                return "\nМеню: \n" + "1. Мои данные\n" + "2. Исследования\n" + "3. Просмотреть Транскрипт\n" + "4. Новости\n" + "5. Выйти";
            case KZ:
                return "\nМеню: \n" + "1. Менің ақпаратым\n" + "2. Зерттеулер\n" + "3. Транскриптті көру\n" + "4. Жаңалықтар\n" + "5. Шығу";
            default:
                return "\nMenu: \n" + "1. My details\n" + "2. Research\n" + "3. View Transcript\n" + "4. News\n" + "5. Log Out";
        }
    }

    private static void displayNews() {
        for (Object n : Database.loadObjectsFromFile("src/assets/news.ser")) {
            News news = (News) n;
            System.out.println(news.toString() + '\n');
        }
    }

    private static String getExitMessage(Language language) {
        switch (language) {
            case EN:
                return "Do you want to exit? Y/N";
            case RU:
                return "Вы хотите выйти? Д/Н";
            case KZ:
                return "Жүйеден шыққыңыз келеді ме? И/Ж";
            default:
                return "";
        }
    }
}