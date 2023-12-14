package szgPART;

import java.util.Date;
import java.util.Objects;

public class Message {
    private String sender;
    private String recipient;
    private String message;
    private Date sendTime;

    public Message() {}

    public Message(User sender, User recipient, String message, Date sendTime) {
        this.sender = sender.getId();
        this.recipient = recipient.getId();
        this.message = message;
        this.sendTime = sendTime;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
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

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setSender(String sender) {
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
                "sender=" + sender +
                ", recipient=" + recipient +
                ", message='" + message + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }
}
