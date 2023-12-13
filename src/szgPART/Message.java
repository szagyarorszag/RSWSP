package szgPART;

import java.util.Date;
import java.util.Objects;

public class Message {
    private Employee sender;
    private Employee recipient;
    private String message;
    private Date sendTime;

    public Message() {}

    public Message(Employee sender, Employee recipient, String message, Date sendTime) {
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
        this.sendTime = sendTime;
    }

    public Employee getSender() {
        return sender;
    }

    public Employee getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRecipient(Employee recipient) {
        this.recipient = recipient;
    }

    public void setSender(Employee sender) {
        this.sender = sender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message message1)) return false;
        return Objects.equals(getSender(), message1.getSender()) && Objects.equals(getRecipient(), message1.getRecipient()) && Objects.equals(getMessage(), message1.getMessage()) && Objects.equals(getSendTime(), message1.getSendTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSender(), getRecipient(), getMessage(), getSendTime());
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender=" + sender.getId() + ' ' + sender.getName() +
                ", recipient=" + recipient.getId() + ' ' + recipient.getName() +
                ", message='" + message + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
