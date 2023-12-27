package model;

import assets.Gender;

import java.time.LocalDate;
import java.util.Vector;

public class TechSupport extends Employee {
    public TechSupport(String name, String surname, LocalDate birthDate, String id, String login, String password, String phoneNumber, String address, Gender gender, double salary, int workExperience){
        super(name, surname, birthDate, id, login, password, phoneNumber, address, gender, workExperience);
    }



    public void acceptReport(Report report){
        Vector<Report> reports = Database.reports;
        if(!reports.isEmpty()){
            for(Report rep:reports){
                rep.setHandle();
                reports.remove(rep);
                super.update();
            }

        }else{
            System.out.println("All reports are done");
        }
    }





}
