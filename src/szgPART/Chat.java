package szgPART;


import java.io.*;
import java.util.*;


public class Chat implements Serializable {
    private String chatId;
    private List<Message> messages;
    private String filename;
    public Chat(){}

    public Chat(Employee employee1, Employee employee2) {
        this.chatId = generateChatId(employee1, employee2);
        this.messages = new ArrayList<>();
    }

    private String generateChatId(Employee employee1, Employee employee2) {
        String sumId = employee1.getId() + employee2.getId();
        return Integer.toString(Objects.hash(sumId));
    }

    public void addMessage(Message message) {
        messages.add(message);
    }
    public User getOtherParticipant(User currentParticipant) {
        for (Message message : messages) {
            User sender = message.getSender();
            User recipient = message.getRecipient();

            if (sender.equals(currentParticipant)) {
                return recipient;
            } else if (recipient.equals(currentParticipant)) {
                return sender;
            }
        }

        throw new IllegalArgumentException("The provided participant is not part of the chat.");
    }


    /**
     * Serialize the Chat object to a specified file.
     *
     * @param filename The name of the file to serialize the chat to.
     * @throws IOException            If an I/O error occurs during serialization.
     */
    public void serialize (String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Deserialize a Chat object from a specified file.
     *
     * @param filename The name of the file to deserialize the chat from.
     * @return The deserialized Chat object.
     * @throws IOException            If an I/O error occurs during deserialization.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found.
     */
    public static Chat deserialize (String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Chat) ois.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString () {
        String allMessages = "";
        for (Message message : messages) {
            allMessages.concat(message.toString() + '\n');}
        return chatId + ' ' + allMessages;
    }

}



