package control;

import assets.Faculty;
import assets.Gender;
import model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Vector;

public class AdminControl {
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
                    +"2. Add Student\n"
                    +"3. Add Teacher\n"
                    +"4. Add Manager\n"
                    +"5. Add Admin\n"
                    +"6. Add Researcher\n"
                    +"7. Add TechSupport\n"
                    +"8. \n"
                    +"9. News\n"
                    +"0. Log Out");

            String choose = bufferedReader.readLine();
            switch (choose){
                case "1":
                    System.out.println(student.toString());
                    break;
                case "2":
                    /* String name,
                    String surname,
                    LocalDate birthDate,
                    String id,
                    int yearOfStudy,
                    String login,
                    String password,
                    String phoneNumber,
                    Gender gender,
                    String studentId,
                    String address,
                    Faculty faculty*/
                    System.out.print("Enter name : ");
                    String name = bufferedReader.readLine();
                    System.out.print("Enter surname : ");
                    String surname = bufferedReader.readLine();
                    System.out.println("Imagine that u were born now " + LocalDate.now());
                    LocalDate date = LocalDate.now();
                    System.out.print("Enter id : ");
                    String id = bufferedReader.readLine();
                    System.out.print("Enter year of study : ");
                    Integer course = bufferedReader.read();
                    System.out.print("Enter login : ");
                    String login = bufferedReader.readLine();
                    System.out.print("Enter password : ");
                    String password = bufferedReader.readLine();
                    System.out.print("Enter phoneNumber : ");
                    String phoneNumber = bufferedReader.readLine();
                    System.out.print("Enter Gender M/F/QUASO : ");
                    String genderr = bufferedReader.readLine();
                    Gender gender = null;
                    switch(genderr) {
                        case "M":
                            gender = Gender.MALE;
                            break;
                        case "F":
                            gender = Gender.FEMALE;
                            break;
                        case "QUASO":
                            gender = Gender.QUASO;
                            break;
                    }
                    break;
                case "3":
                    System.out.println(student.viewTranscript());
                    break;
                case "4":

                    for(Object n: Database.loadObjectsFromFile("src/assets/news.ser")){
                        News news = (News) n;
                        System.out.println(news.toString()+'\n');
                    }
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
