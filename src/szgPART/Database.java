package szgPART;

import java.io.*;
import java.util.Vector;

public class Database implements Serializable {

    public static void main(String[] args) {

        News news = new News("Title", "Text");
        String fileName = "src/assets/news.ser";
        saveToFile(news, fileName);
        System.out.println(loadNewsFromFile(fileName));
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
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
        } catch (IOException ioe) {
            System.out.println("Error saving object to file: " + filename);
            ioe.printStackTrace();
        }
    }
    public static News loadNewsFromFile(String filename) {
        News news = null;
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            news = (News) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error reading file: " + filename);
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading object from file: " + filename);
            cnfe.printStackTrace();
        }
        return news;
    }
    public static Student loadStudentFromFile(String filename) {
        Student student = null;
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            student = (Student) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error reading file: " + filename);
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading object from file: " + filename);
            cnfe.printStackTrace();
        }
        return student;
    }
    public static Teacher loadTeacherFromFile(String filename) {
        Teacher teacher = null;
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            teacher = (Teacher) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error reading file: " + filename);
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading object from file: " + filename);
            cnfe.printStackTrace();
        }
        return teacher;
    }
    public static Employee loadEmployeeFromFile(String filename) {
        Employee employee = null;
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            employee = (Employee) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error reading file: " + filename);
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading object from file: " + filename);
            cnfe.printStackTrace();
        }
        return employee;
    }

    public static Researcher loadResearcherFromFile(String filename) {
        Researcher researcher = null;
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            researcher = (Researcher) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error reading file: " + filename);
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading object from file: " + filename);
            cnfe.printStackTrace();
        }
        return researcher;
    }

    public static Organization loadOrganizationFromFile(String filename) {
        Organization organization = null;
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            organization = (Organization) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error reading file: " + filename);
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading object from file: " + filename);
            cnfe.printStackTrace();
        }
        return organization;
    }

    public static Request loadRequestFromFile(String filename) {
        Request request = null;
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            request = (Request) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error reading file: " + filename);
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading object from file: " + filename);
            cnfe.printStackTrace();
        }
        return request;
    }

    public static Report loadReportFromFile(String filename) {
        Report report = null;
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            report = (Report) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error reading file: " + filename);
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading object from file: " + filename);
            cnfe.printStackTrace();
        }
        return report;
    }

    public static Admin loadAdminFromFile(String filename) {
        Admin admin = null;
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            admin = (Admin) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error reading file: " + filename);
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading object from file: " + filename);
            cnfe.printStackTrace();
        }
        return admin;
    }
    public static Manager loadManagerFromFile(String filename) {
        Manager manager = null;
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            manager = (Manager) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error reading file: " + filename);
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading object from file: " + filename);
            cnfe.printStackTrace();
        }
        return manager;
    }

    public static ResearchPaper loadResearchPaperFromFile(String filename) {
        ResearchPaper researchPaper = null;
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            researchPaper = (ResearchPaper) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error reading file: " + filename);
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading object from file: " + filename);
            cnfe.printStackTrace();
        }
        return researchPaper;
    }

    public static ResearchProject loadResearchProjectFromFile(String filename) {
        ResearchProject researchProject = null;
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            researchProject = (ResearchProject) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error reading file: " + filename);
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading object from file: " + filename);
            cnfe.printStackTrace();
        }
        return researchProject;
    }

    public static User loadUserFromFile(String filename) {
        User user = null;
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            user = (User) ois.readObject();
        } catch (IOException ioe) {
            System.out.println("Error reading file: " + filename);
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading object from file: " + filename);
            cnfe.printStackTrace();
        }
        return user;
    }

    public Vector<Student> getStudents() {
        return students;
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