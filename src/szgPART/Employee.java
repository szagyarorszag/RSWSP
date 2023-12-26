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
    public Employee(String name, String surname, Date birthDate, String id, String login, String password, String phoneNumber, String address, Gender gender, int workExperience) {
        super(name,surname, birthDate, id, login, password, phoneNumber, address, gender);
        this.chats = new ArrayList<>();
        this.salary=0;
        this.workExperience=workExperience;
        this.hireDate=LocalDate.now();
    }

    public Employee(String name, String surname, Date birthDate, String id, String login, String password, String phoneNumber, String address, Gender gender,  double salary, int workExperience) {
        super(name,surname, birthDate, id, login, password, phoneNumber, address, gender);
        this.chats = new ArrayList<>();
        this.salary=salary;
        this.workExperience=workExperience;
        this.hireDate=LocalDate.now();
    }
    // Getter method for salary
    public double getSalary() {
        return salary;
    }

    // Setter method for salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Getter method for workExperience
    public int getWorkExperience() {
        return workExperience;
    }

    // Setter method for workExperience
    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }
    public LocalDate getHireDate() {
        return hireDate;
    }

    // Setter method for hireDate
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
    // Getter method for department
    /**
     * Create a new chat with another employee.
     *
     * @param otherEmployee The other employee to start the chat with.
     */
    public void createChat(Employee otherEmployee) {
        Chat newChat = new Chat(this, otherEmployee);
        chats.add(newChat);
    }

    /**
     * Send a message to a specific chat.
     *
     * @param chat           The chat to send the message to.
     * @param messageContent The content of the message.
     */
    public void sendMessage(Chat chat, String messageContent) {
        if (chats.contains(chat)) {
            chat.addMessage(new Message(this, (Employee) chat.getOtherParticipant(this), messageContent, LocalDate.now()));
        } else {
            throw new IllegalArgumentException("Employee is not part of the specified chat.");
        }
    }

    /**
     * Get all chats involving this employee.
     *
     * @return The list of chats.
     */
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
