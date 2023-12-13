package szgPART;

import java.util.Vector;

public class Database {
    private static Vector<Student> students;
    private static Vector<Teacher> teachers;
    private static Vector<Employee> employees;
    private static Vector<Researcher> researchers;
    private static Vector<Organization> organizations;
    private static Vector<Request> requests;
    private static Vector<Report> reports;
    private static Vector<Admin> admins;
    private static Vector<Manager> managers;
    private static Vector<ResearchPaper> researchPapers;
    private static Vector<ResearchProject> researchProjects;
    private static Vector<User> users;


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
