package model;
import java.util.*;
import java.time.LocalDate;
import java.io.*;

public class StudentControl {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void doResearchLog(Student student) throws IOException {
        Log log = new Log(student.getId(),"SUCCESFUL RESEARCH");
        Vector<Object> objects = new Vector<Object>();
        objects.add(log);
        Database.saveToFile(objects,"src/assets/logs.ser");
    }

    public static boolean viewMenu(Student student) throws IOException {
        while(true) {
            System.out.println("\nMenu: \n"+ "1. My details\n"
                                        +"2. Research\n"
                                        +"3. View Transcript\n"
                                        +"4. News\n"
                                        +"5. Log Out");

            String choose = bufferedReader.readLine();
            switch (choose){
                case "1":
                    System.out.println(student.toString());
                    break;
                case "2":
                    ResearcherDecorator studentResearcher = new ResearcherDecorator(student);
                    studentResearcher.conductResearch();
                    doResearchLog(student);
                    break;
                case "3":
                    System.out.println(student.viewTranscript());
                    break;
                case "4":

                    for(Object n: Database.loadObjectsFromFile("src/assets/newss.ser")){
                        News news = (News) n;
                        System.out.println(news.toString()+'\n');
                    }
                    break;
                case "5":
                    System.out.println("Do u want to exit ?Y/N");
                    String mode = bufferedReader.readLine();
                    if(mode.equals("Y")) break;

                }
            }


        }

    }




}
