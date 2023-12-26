package szgPART;

import java.time.LocalDate;

public class Log implements Comparable<Log> {
    LocalDate date;
    String userId;
    String action;
    {
        this.date = LocalDate.now();
    }
    public Log(String userId, String action) {
        this.userId = userId;
        this.action = action;
    }
    @Override
    public int compareTo(Log other) {
        return this.date.compareTo(other.date);
    }
    @Override
    public String toString() {
        return this.date + " " + this.userId + " " + this.action ;
    }
}