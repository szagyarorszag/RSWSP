package szgPART;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Chat implements Serializable {
    private String chatId;
    private List<Message> messages;

    public Chat(User user1, User user2) {
        this.chatId = generateChatId(user1, user2);
        this.messages = new ArrayList<>();
    }

    private String generateChatId(User user1, User user2) {
        String sumId = user1.getId() + user2.getId();
        return Integer.toString(Objects.hash(sumId));
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public List<Message> getMessages() {
        return messages;
    }
    public void serialize(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("chat.ser"))) {
            oos.writeObject(this);
        }
    }
    public static Chat deserialize(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("chat.ser"))) {
            return (Chat) ois.readObject();
        }
    }
    @Override
    public String toString() {
        return "Chat{" +
                "chatId='" + chatId + '\'' +
                ", messages=" + messages +
                '}';
    }
}



