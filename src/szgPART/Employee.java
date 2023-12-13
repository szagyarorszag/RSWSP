package szgPART;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee extends User {
    private List<Chat> chats;
    public Employee() {
        super();
        this.chats = new ArrayList<>();
    }

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
            chat.addMessage(new Message(this, (Employee) chat.getOtherParticipant(this), messageContent, new Date()));
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
}
