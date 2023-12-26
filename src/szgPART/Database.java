package szgPART;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Database implements Serializable {
    public static void main(String[] args) throws IOException {
        String filename = "src/assets/news.ser";

        News news1 = new News("Title", "Text");
        News news3 = new News("Mainn", "Info");

        Vector<Object> newss = loadObjectsFromFile(filename);

        newss.add(news1);
        newss.add(news3);
        saveToFile(newss, filename);
        for (Object obj : loadObjectsFromFile(filename)) {
            News news = (News) obj;
            System.out.println(news.toString());
        }

    }

    public static Vector<Log> logs;
    public static Vector<Student> students;
    public static Vector<Teacher> teachers;
    public static Vector<Employee> employees;
    public static Vector<Researcher> researchers;
    public static Vector<Organization> organizations;
    public static Vector<Request> requests;
    public static Vector<Report> reports;
    public static Vector<Admin> admins;
    public static Vector<Manager> managers;
    public static Vector<ResearchPaper> researchPapers;
    public static Vector<ResearchProject> researchProjects;
    public static Vector<User> users;
    public static Vector<News> newss;
    public static Vector<Course> courses;

    public static void removeObjectFromFile(String filename, Object objToRemove) throws IOException {
        // Load all objects from the file
        Vector<Object> objects = (Vector<Object>) loadObjectsFromFile(filename);

        // Remove the desired object
        objects.remove(objToRemove);

        // Overwrite the file with the modified list
        saveToFile(objects, filename);
    }


    public static void clearFile(String filename) throws  IOException {
        FileOutputStream fos = new FileOutputStream(filename);
    }


    public static void saveToFile(Vector<Object> objects, String filename) throws IOException  {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(objects);
        oos.close();
    }


    public static <T> Vector<T> loadObjectsFromFile(String filename) {
        Vector<T> objects = new Vector<>();
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            objects = (Vector<T>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objects;
    }
}