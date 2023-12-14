package model;
import java.time.LocalDateTime;
import java.util.*;
public class Mark {
    private double examPoints;
    private double firstAtt;
    private double secondAtt;
    private double GPA;
    private String markLetter;
    private Map<String, Double> map;
    private double total;
    public Mark() {
        this.map = createLetterToGPA();
    }
    public Mark(double points) {
        this.map = createLetterToGPA();
        try{
            this.addPoints(points);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public Mark(double points,LocalDateTime localDateTime) {
        this.map = createLetterToGPA();
        try{
            this.addPoints(points,localDateTime);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void addPoints(double points) throws Exception {

        int month = LocalDateTime.now().getMonthValue();

        if ((month >= 1 && month <= 2) || (month >= 9 && month <= 10)) {
            this.firstAtt += points;
        } else if ((month >= 3 && month <= 4) || (month == 11)) {
            this.secondAtt += points;
        } else if (month == 5 || month == 12) {
            this.examPoints += points;
        } else {
            throw new Exception("We're on vacation");
        }
    }
    public void addPoints(double points, LocalDateTime localDateTime) throws Exception {
        int month = localDateTime.getMonthValue();

        if ((month >= 1 && month <= 2) || (month >= 9 && month <= 10)) {
            this.firstAtt += points;
        } else if ((month >= 3 && month <= 4) || (month == 11)) {
            this.secondAtt += points;
        } else if (month == 5 || month == 12) {
            this.examPoints += points;
        } else {
            throw new Exception("We're on vacation");
        }
    }

    //creates convenient dictionary to store gpa by letter
    private static Map<String, Double> createLetterToGPA() {
        Map<String, Double> map = new HashMap<>();
        map.put("A", 4.0);
        map.put("A-", 3.7);
        map.put("B+", 3.3);
        map.put("B", 3.0);
        map.put("B-", 2.7);
        map.put("C+", 2.3);
        map.put("C", 2.0);
        map.put("C-", 1.7);
        map.put("D+", 1.3);
        map.put("D", 1.0);
        map.put("F", 0.0);
        return map;
    }
    private void calculateTotal(){
        this.total= examPoints + firstAtt + secondAtt;
    }
    public double getTotal() {
        calculateTotal();
        return this.total;
    }
    public String getMarkLetter() {
        if (getTotal() >= 95) {
            return "A";
        } else if (getTotal() >= 90) {
            return "A-";
        } else if (getTotal() >= 85) {
            return "B+";
        } else if (getTotal() >= 80) {
            return "B";
        } else if (getTotal() >= 75) {
            return "B-";
        } else if (getTotal() >= 70) {
            return "C+";
        } else if (getTotal() >= 65) {
            return "C";
        } else if (getTotal() >= 60) {
            return "C-";
        } else if (getTotal() >= 55) {
            return "D+";
        } else if (getTotal() >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
    public double getGPA(){
        return map.get(getMarkLetter());
    }
}
