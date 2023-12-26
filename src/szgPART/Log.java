package szgPART;

import java.time.LocalDate;

public class Log implements Comparable<Log> {
    public enum Level {
        INFO, DEBUG, ERROR
    }

    private LocalDate date;
    private String userId;
    private String action;

    {
        this.date = LocalDate.now();
    }

    public Log(String userId, String action) {
        this.userId = userId;
        this.action = action;
    }

    // getters and setters
    public LocalDate getDate() {
        return date;
    }

    public String getUserId() {
        return userId;
    }

    public String getAction() {
        return action;
    }

    @Override
    public int compareTo(Log other) {
        return this.date.compareTo(other.date);
    }

    @Override
    public String toString() {
        return this.date + " " + this.userId + " " + this.action + " ";
    }
}
