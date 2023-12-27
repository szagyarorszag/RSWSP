package model;

import assets.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Vector;

public class Test {
    public static void main(String [] args) {
        User user = new User("Alpha",
                "Beta",
                LocalDate.now() ,
                "GAMMA",
                "GAMMA",
                "SCHTRICH",
                "800",
                "989",
                Gender.QUASO);
        User user2 = new User("Alpha",
                "Beta",
                LocalDate.now() ,
                "GAMMA",
                "GAMMA",
                "SCHTRICH",
                "800",
                "989",
                Gender.QUASO);
        Vector<Object> objects = null;
        objects.add(user);
        objects.add(user2);
        /*Database.saveToFile(objects, "src/assets/users.ser");*/

        Employee e1 = new Employee("A",
                "B",
                LocalDate.now(),
                "588756",
                "588756B",
                "VROTVSEEBAL",
                "8800555555",
                "PushkinStrKolotushkinHos",
                Gender.QUASO,
                54849848.3,
                15);
        Employee e2 = new Employee("C",
                "D",
                LocalDate.now(),
                "46846",
                "458648B",
                "MENYAVSEEBALI",
                "8800555554",
                "UnderTheBridge",
                Gender.QUASO,
                54849848.3,
                15);
        Chat chat = e1.createChat(e2);
        e1.createChat(e2);
        e1.sendMessage(chat, "LOH");
        e1.sendMessage(chat, "LOH2");
        e2.sendMessage(chat, "SAM TAKOY");
        System.out.println(e1.getChats().toString());
    }
}
