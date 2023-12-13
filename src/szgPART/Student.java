package szgPART;

import model.Faculty;
import model.Schedule;
import model.Transcript;

import java.util.Vector;

public class Student extends User {
    public Student(){
        super();
    }
    private Faculty faculty;
    //TODO
    //private Organization organization;
    private int yearOfStudy;
    private Vector<Transcript> transcript;
    private int creditsTaken;
    private Schedule schedule;

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
}
