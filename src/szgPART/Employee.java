package szgPART;

import java.util.*;
import java.time.LocalDate;
public class Employee extends User {
    private LocalDate hireDate;
    private double salary;
    private int workExperience;

    private List<Chat> chats;
    public Employee(){
        super();
    }
    public Employee(String name, String surname, LocalDate birthDate, String id, String login, String password, String phoneNumber, String address, Gender gender, int workExperience) {
        super(name,surname, birthDate, id, login, password, phoneNumber, address, gender);
        this.chats = new ArrayList<>();
        this.salary=0;
        this.workExperience=workExperience;
        this.hireDate=LocalDate.now();
    }

    public Employee(String name, String surname, LocalDate birthDate, String id, String login, String password, String phoneNumber, String address, Gender gender,  double salary, int workExperience) {
        super(name,surname, birthDate, id, login, password, phoneNumber, address, gender);
        this.chats = new ArrayList<>();
        this.salary=salary;
        this.workExperience=workExperience;
        this.hireDate=LocalDate.now();
    }

    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public int getWorkExperience() {
        return workExperience;
    }
    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }
    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Chat createChat(Employee otherEmployee) {
        Chat newChat = new Chat(this, otherEmployee);
        this.chats.add(newChat);
        otherEmployee.chats.add(newChat);
        return newChat;
    }


    public void sendMessage(Chat chat, String messageContent) {
        if (chats.contains(chat)) {
            chat.addMessage(new Message(this, chat.getOtherParticipant(this), messageContent, LocalDate.now()));
        } else {
            throw new IllegalArgumentException("Employee is not part of the specified chat.");
        }
    }
    public List<Chat> getChats() {
        return chats;
    }
    @Override
    public int compareTo(User o) {
        Employee employee = (Employee) o;
        if(super.compareTo(employee) == 0) {
            if(this.workExperience > employee.workExperience) {
                return 1;
            }
            else if(this.workExperience < employee.workExperience) {
                return -1;
            }
            return 0;
        }
        return super.compareTo(employee);
    }

}
