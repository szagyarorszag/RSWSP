package control;

import java.time.LocalDate;
import java.util.*;
import java.io.*;

import model.*;
public class TeacherControl {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void doResearchLog(Teacher teacher) throws IOException {
        Log log = new Log(teacher.getId(),"SUCCESFUL RESEARCH");
        Vector<Object> objects = new Vector<Object>();
        objects.add(log);
        Database.saveToFile(objects,"src/assets/logs.ser");
    }
    public static void createChatLog(Teacher teacher) throws IOException {
        Log log = new Log(teacher.getId(),"SUCCESFUL CHAT CREATION");
        Vector<Object> objects = new Vector<Object>();
        objects.add(log);
        Database.saveToFile(objects,"src/assets/logs.ser");
    }

    public static boolean viewMenu(Teacher teacher) throws IOException {
        while(true) {
            System.out.println("\nMenu: \n"+ "1. My details\n"
                    +"2. Research\n"
                    +"3. Create complaint\n"
                    +"4. View my rate\n"
                    +"5. News\n"
                    +"6. Log Out");

            String choose = bufferedReader.readLine();
            switch (choose){
                case "1":
                    System.out.println(teacher.toString() + "\n Faculty: " + teacher.getFaculty() + "\n Teacher Type " + teacher.getTeacherType());
                    break;
                case "2":
                    ResearcherDecorator studentResearcher = new ResearcherDecorator(teacher);
                    studentResearcher.conductResearch();
                    doResearchLog(teacher);
                    break;
                case "3":
                    System.out.println("Paste recipient's (must be teacher) id: ");
                    String recipientId = bufferedReader.readLine();
                    boolean recipientIsFound=false;
                    for(Object o:Database.loadObjectsFromFile("src/assets/employee.ser")){
                        Teacher t = (Teacher) o;
                        if(teacher.getId().equals(recipientId)){
                            recipientIsFound=true;
                            System.out.println("Paste complaint text: \n");
                            String complaintText = bufferedReader.readLine();
                            Chat chat = teacher.createChat(t);
                            createChatLog(teacher);
                            Message message = new Message(teacher,t,complaintText, LocalDate.now());
                            teacher.sendMessage(chat,teacher.createComplaint(message,t).getMessage());
                            break;
                        }
                    }
                    if(!recipientIsFound){
                        System.out.println("Recipient is not found, please try again");
                        break;
                    }else{
                        System.out.println("Complaint successfully sent");
                        break;
                    }
                case "4":
                    System.out.println(teacher.getRate());
                    break;
                case "5":
                    System.out.println("Do u want to exit ?Y/N");
                    String mode = bufferedReader.readLine();
                    if(mode.equals("Y")) {
                        UserControl.login();
                        break;
                    }

            }
        }
    }
}

