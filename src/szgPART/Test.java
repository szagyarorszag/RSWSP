package szgPART;

import java.time.LocalDate;
import java.util.Date;

public class Test {
    public static void main(String [] args) {

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
