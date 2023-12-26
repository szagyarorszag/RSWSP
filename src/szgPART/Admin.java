package szgPART;

public class Admin {
    public Admin() {}
    public void addStudent(Student student){
        Database.students.add(student);
    }
    public void addResearcher(Researcher researcher){
        Database.researchers.add(researcher);
    }
    public void addTeacher(Teacher teacher){
        Database.teachers.add(teacher);
    }
    public void changeUser(User user, User user2){
        user = user2;
    }
    public void deleteStudent(String studentId){
        Database.students.remove(studentId);
    }
    public void deleteEmployee(String employeeId){
        Database.students.remove(employeeId);
    }
    public void deleteResearcher(String researcherId){
        Database.researchers.remove(researcherId);
    }



}
