package szgPART;

import java.util.Vector;

public class Database {
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
    public static Vector<OR> ors;
    public static Vector<Dean> deans;
    public static Vector<News> newss;


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

    public static Vector<OR> getOrs() {
        return ors;
    }

    public static Vector<Dean> getDeans() {
        return deans;
    }

    public static void setDeans(Vector<Dean> deans) {
        Database.deans = deans;
    }

    public static void setOrs(Vector<OR> ors) {
        Database.ors = ors;
    }

    public static void setNewss(Vector<News> newss) {
        Database.newss = newss;
    }

    public void setUsers(Vector<User> users) {
        this.users = users;
    }

    public void setResearchProjects(Vector<ResearchProject> researchProjects) {
        this.researchProjects = researchProjects;
    }

    public void setResearchPapers(Vector<ResearchPaper> researchPapers) {
        this.researchPapers = researchPapers;
    }

    public void setManagers(Vector<Manager> managers) {
        this.managers = managers;
    }

    public void setAdmins(Vector<Admin> admins) {
        this.admins = admins;
    }

    public void setReports(Vector<Report> reports) {
        this.reports = reports;
    }

    public void setRequests(Vector<Request> requests) {
        this.requests = requests;
    }

    public void setOrganizations(Vector<Organization> organizations) {
        this.organizations = organizations;
    }

    public void setResearchers(Vector<Researcher> researchers) {
        this.researchers = researchers;
    }

    public void setEmployees(Vector<Employee> employees) {
        this.employees = employees;
    }

    public void setTeachers(Vector<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void setStudents(Vector<Student> students) {
        this.students = students;
    }
}