package szgPART;

import java.time.LocalDate;

public class Log implements Comparable<Log> {
    public enum Level {
        INFO, DEBUG, ERROR
    }

    private LocalDate date;
    private String userId;
    private String action;
    private Level level;
    private String message;

    {
        this.date = LocalDate.now();
    }

    public Log(String userId, String action, Level level, String message) {
        this.userId = userId;
        this.action = action;
        this.level = level;
        this.message = message;
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

    public Level getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public int compareTo(Log other) {
        return this.date.compareTo(other.date);
    }

    @Override
    public String toString() {
        return this.date + " " + this.level + " " + this.userId + " " + this.action + " " + this.message;
    }
}
