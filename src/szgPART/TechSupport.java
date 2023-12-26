package szgPART;

import java.util.Vector;

public class TechSupport {
    public Vector<Report> getReports() {
        return Database.reports;
    }
    public void completeReport() {
        Database.reports.remove(Database.reports.lastElement());
    }
}
