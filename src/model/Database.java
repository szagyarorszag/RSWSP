package model;


import java.io.*;
//singleton

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Database implements Serializable {

    //public static Vector<Log> logs;
    public static Vector<Student> students;
    public static Vector<Teacher> teachers;
    public static Vector<Employee> employees;
    public static Vector<Researcher> researchers;
    public static Vector<Organization> organizations;
    public static Vector<Report> reports;
    //public static Vector<Admin> admins;
    public static Vector<Manager> managers;
    public static Vector<ResearchPaper> researchPapers;

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