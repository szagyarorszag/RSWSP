package model;
import assets.Faculty;
import assets.Gender;

import java.time.LocalDate;
import java.util.Date;
import java.util.Vector;
public class GraduateStudent extends Student{
    private Researcher supervisor;
    private Vector<ResearchPaper> diploma;
    private boolean isInstructor;
    public GraduateStudent(){

    }
    public GraduateStudent(String name, String surname, LocalDate birthDate, String id, int yearOfStudy, String login, String password, String phoneNumber, Gender gender, String studentId, String address, Faculty faculty, Researcher supervisor){
        super(name, surname, birthDate, id, yearOfStudy, login, password, phoneNumber, gender, address, faculty);
        this.supervisor = supervisor;
    }

    public void setSupervisor(Researcher supervisor) {
        ResearcherDecorator decoratorSupervisor = (ResearcherDecorator) supervisor;
        if(decoratorSupervisor.calculateHIndex()<3)System.out.println("h-index of " + decoratorSupervisor.getName() +" lower than 3!");
        this.supervisor = supervisor;

    }

    public Researcher getSupervisor(){
        return this.supervisor;
    }

    public void addResearchToDiploma(ResearchPaper researchPaper){
        this.diploma.add(researchPaper);
    }
    public String viewDiploma(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("List of research papers: \n");
        for(ResearchPaper researchPaper:diploma){
            stringBuilder.append(researchPaper.toString()).append("\n");

        }
        return stringBuilder.toString();
    }

}
