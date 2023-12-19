package model;

import szgPART.ResearchPaper;
import szgPART.Researcher;

import java.util.Date;
import java.util.Vector;

public class GraduateStudent extends Student{
    private Researcher supervisor;
    private Vector<ResearchPaper> diploma;
    private boolean isInstructor;
    public GraduateStudent(){

    }
    public GraduateStudent(String name, String surname, Date birthDate, String id, int yearOfStudy, String login, String password, String phoneNumber, Gender gender, String studentId, String address, Faculty faculty, Researcher supervisor){
        super(name, surname, birthDate, id, yearOfStudy, login, password, phoneNumber, gender, studentId, address, faculty);
        this.supervisor = supervisor;
    }

    public void setSupervisor(Researcher supervisor) {
        //TODO: if(supervisor.getHIndex()<3){throw new lowQualificationException("h-index of " + supervisor.getName() +" lower than 3!)}
        //else
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
