package szgPART;

import java.io.*;
import java.util.*;

public class Chat implements Serializable {
    private Integer chatId;
    private List<Message> messages;
    private String filename;
    private Employee participant1;
    private Employee participant2;

    {
        filename = "chat.ser";
    }

    public Chat() {}

    public Chat(Employee employee1, Employee employee2) {
        this.chatId = generateChatId(employee1, employee2);
        this.messages = new ArrayList<>();
        this.participant1 = employee1;
        this.participant2 = employee2;
    }

    private Integer generateChatId(Employee employee1, Employee employee2) {
        Integer sumId = employee1.getId().hashCode() * employee2.getId().hashCode();
        return Objects.hash(sumId);
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public Employee getOtherParticipant(Employee currentParticipant) {
        if (participant1.equals(currentParticipant)) {
            return participant2;
        } else if (participant2.equals(currentParticipant)) {
            return participant1;
        } else {
            throw new IllegalArgumentException("The provided participant is not part of the chat.");
        }
    }

    public void serialize(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Chat deserialize(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Chat) ois.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        StringBuilder allMessages = new StringBuilder();
        for (Message message : messages) {
            allMessages.append(message.toString()).append('\n');
        }
        return chatId + " " + allMessages + '\n';
    }
}
