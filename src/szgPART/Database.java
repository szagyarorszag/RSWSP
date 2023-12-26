package szgPART;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Database implements Serializable {

    public static void main(String[] args) {

        News news1 = new News("Title", "Text");
        News news2 = new News("Заголовок", "Текст");
        News news3 = new News("Main", "Info");
        String fileName = "src/assets/news.ser";
        saveToFile(news1, fileName);
        saveToFile(news2, fileName);
        saveToFile(news3, fileName);
        for( News news : loadObjectsFromFile(fileName, News.class)) {
            System.out.println(news);
        }
        clearFile(fileName);

    }
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

    /*public static void removeObjectFromFile(String filename, Object objToRemove) {
        // Load all objects from the file
        Vector<Object> objects = (Vector<Object>) loadObjectFromFile(filename);

        // Remove the desired object
        objects.remove(objToRemove);

        // Overwrite the file with the modified list
        saveObjectToFile(objects, filename);
    }*/


    public static void clearFile(String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            // This will clear the file
        } catch (IOException ioe) {
            System.out.println("Error clearing file: " + filename);
            ioe.printStackTrace();
        }
    }
    public static void saveToFile(Object obj, String filename) {
        try {
            boolean exists = new File(filename).exists();
            FileOutputStream fos = new FileOutputStream(filename, true);
            ObjectOutputStream oos = exists ?
                    new AppendableObjectOutputStream(fos) :
                    new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
        } catch (IOException ioe) {
            System.out.println("Error saving object to file: " + filename);
            ioe.printStackTrace();
        }
    }

    private static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            // do not write a header
        }
    }

    public static <T> List<T> loadObjectsFromFile(String filename, Class<T> clazz) {
        List<T> objects = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (fis.available() > 0) {
                T object = clazz.cast(ois.readObject());
                objects.add(object);
            }
        } catch (IOException ioe) {
            System.out.println("Error reading file: " + filename);
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading object from file: " + filename);
            cnfe.printStackTrace();
        }
        return objects;
    }




    public Vector<Student> getStudents() {
        return students ;
    }

    public Vector<Teacher> getTeachers() {
        return teachers;
    }

    public Vector<Employee> getEmployees() {
        return employees;
    }

    public Vector<Researcher> getResearchers() {
        return researchers;
    }

    public Vector<Organization> getOrganizations() {
        return organizations;
    }

    public Vector<Request> getRequests() {
        return requests;
    }

    public Vector<Report> getReports() {
        return reports;
    }

    public Vector<Admin> getAdmins() {
        return admins;
    }

    public Vector<Manager> getManagers() {
        return managers;
    }

    public Vector<ResearchPaper> getResearchPapers() {
        return researchPapers;
    }

    public Vector<ResearchProject> getResearchProjects() {
        return researchProjects;
    }

    public Vector<User> getUsers() {
        return users;
    }

    public static Vector<News> getNewss() {
        return newss;
    }

}